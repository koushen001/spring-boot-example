package com.cike.service.impl;

import com.cike.common.MusicConst;
import com.cike.entity.MusicSheet;
import com.cike.music.MusicProcesser;
import com.cike.music.MyDbPipeline;
import com.cike.music.PageSizePipeline;
import com.cike.service.MusicService;
import com.cike.service.MusicSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-13 15:00
 **/
@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicProcesser musicProcesser;
    @Autowired
    private PageSizePipeline pageSizePipeline;
    @Autowired
    private MyDbPipeline myDbPipeline;
    @Autowired
    private MusicSheetRepository musicSheetRepository;


    @Override
    public int getPageSize() {
        Spider.create(musicProcesser).addUrl(MusicConst.MUSIC_SONG_SHEET_URL)
                .addPipeline(pageSizePipeline).run();
        int pageSize = PageSizePipeline.pageSize;
        return pageSize;
    }

    @Override
    public void saveMusicSheet() {
        musicSheetRepository.deleteAll();
        int pageSize = getPageSize();
        for (int i = 0; i < pageSize; i = i + 35) {
            Spider.create(musicProcesser).addUrl(MusicConst.MUSIC_SONG_SHEET_URL + "?limit=35&offset=" + i)
                    .addPipeline(myDbPipeline).run();
        }

    }

    @Override
    public Page<MusicSheet> getAll() {
        Sort sort = new Sort(Sort.Direction.DESC, "playNum");
        Pageable pageable = new PageRequest(1, 100, sort);
        Page<MusicSheet> page = musicSheetRepository.findAll(pageable);
        return page;
    }
}

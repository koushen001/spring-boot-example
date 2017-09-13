package com.cike.music;

import com.alibaba.fastjson.JSON;
import com.cike.common.MusicConst;
import com.cike.entity.MusicSheet;
import com.cike.service.MusicSheetRepository;
import com.cike.utils.StringNumUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-13 10:26
 **/
@Component
public class MyDbPipeline implements Pipeline {

    private static final Logger log = LoggerFactory.getLogger(MyDbPipeline.class);

    @Autowired
    private MusicSheetRepository musicSheetRepository;


    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> sheetNameList = resultItems.get(MusicConst.SHEET_NAME);
        List<String> sheetUserList = resultItems.get(MusicConst.SHEET_USER);
        List<String> playNumList = resultItems.get(MusicConst.PLAY_NUM);
        List<String> sheetUrlList = resultItems.get(MusicConst.SHEET_URL);
        log.info("歌单列表：" + JSON.toJSONString(sheetNameList));
        log.info("用户列表：" + JSON.toJSONString(sheetUserList));
        log.info("播放数量列表：" + JSON.toJSONString(playNumList));
        log.info("歌单链接列表：" + JSON.toJSONString(sheetUrlList));
        List<MusicSheet> musicSheetList = new ArrayList<>();
        for (int i = 0; i < sheetNameList.size(); i++) {
            MusicSheet musicSheet = new MusicSheet();
            musicSheet.setSheetName(sheetNameList.get(i));
            musicSheet.setSheetUser(sheetUserList.get(i));
            musicSheet.setPlayNum(StringNumUtil.convertNum(playNumList.get(i)));
            musicSheet.setSheetUrl(sheetUrlList.get(i));
            musicSheet.setCreateTime(new Date());
            musicSheet.setUpdateTime(new Date());
            musicSheetList.add(musicSheet);
        }
        musicSheetRepository.save(musicSheetList);
    }
}

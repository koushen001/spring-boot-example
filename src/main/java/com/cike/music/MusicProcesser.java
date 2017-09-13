package com.cike.music;

import com.cike.common.MusicConst;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-13 14:58
 **/
@Component
public class MusicProcesser implements PageProcessor {

    private Site site = Site.me().setDomain(MusicConst.DO_MAIN);

    @Override
    public void process(Page page) {
        page.putField(MusicConst.SHEET_NAME, page.getHtml().$("a.s-fc0", "text").all());
        page.putField(MusicConst.SHEET_URL, page.getHtml().$("a.s-fc0", "href").all());
        page.putField(MusicConst.SHEET_USER, page.getHtml().$("a.s-fc3", "text").all());
        page.putField(MusicConst.PLAY_NUM, page.getHtml().$("span.nb", "text").all());
        page.putField(MusicConst.PAGE_SIZE, page.getHtml().$("a.zpgi", "href").all());
    }

    @Override
    public Site getSite() {
        return site;

    }

    public static void main(String[] args) {
        Spider.create(new MusicProcesser()).addUrl("http://music.163.com/discover/playlist?limit=35&offset=0")
                .addPipeline(new MyDbPipeline()).run();
        int pageSize = PageSizePipeline.pageSize;
        System.out.println(pageSize);
        for (int i = 0; i < pageSize; i = i + 35) {
            Spider.create(new MusicProcesser()).addUrl("http://music.163.com/discover/playlist?limit=35&offset=" + i)
                    .addPipeline(new MyDbPipeline()).run();
        }

    }
}

package com.cike.music;

import com.cike.common.MusicConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author CIKE
 * @desc 得到网易云音乐歌单总页数
 * @create 2017-09-13 10:26
 **/
@Component
public class PageSizePipeline implements Pipeline {

    public static int pageSize = 0;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String s = resultItems.get(MusicConst.PAGE_SIZE).toString();
        s = s.substring(s.lastIndexOf("=") + 1, s.length() - 1);
        if (StringUtils.isNotBlank(s)) {
            pageSize = Integer.parseInt(s);
        }
    }
}

package com.cike.music;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-13 10:26
 **/
@Component
public class MyConsolePipeline implements Pipeline {


    @Override
    public void process(ResultItems resultItems, Task task) {
        //遍历所有结果，输出到控制台，上面例子中的"author"、"name"、"readme"都是一个key，其结果则是对应的value
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            value = value.substring(1, value.length() - 1);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>" + key + ":\t" + value);
        }
    }
}

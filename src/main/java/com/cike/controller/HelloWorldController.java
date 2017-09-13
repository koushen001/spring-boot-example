package com.cike.controller;

import com.cike.entity.MusicSheet;
import com.cike.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-12 14:38
 **/
@Controller
@RequestMapping("/music")
public class HelloWorldController {

    @Autowired
    private MusicService musicService;

    @RequestMapping("/listJson")
    @ResponseBody
    public Page<MusicSheet> listJson() {
        Page<MusicSheet> page = musicService.getAll();
        return page;
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        Page<MusicSheet> page = musicService.getAll();
        map.put("page", page);
        return "index";
    }

    @RequestMapping("/pageSize")
    @ResponseBody
    public Integer pageSize() {
        return musicService.getPageSize();
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        musicService.saveMusicSheet();
        return "SUCCESS";
    }
}

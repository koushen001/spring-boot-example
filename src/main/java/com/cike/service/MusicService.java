package com.cike.service;

import com.cike.entity.MusicSheet;
import org.springframework.data.domain.Page;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-13 15:00
 **/
public interface MusicService {

    int getPageSize();

    void saveMusicSheet();

    Page<MusicSheet> getAll();

}

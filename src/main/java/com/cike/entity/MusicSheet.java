package com.cike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-12 14:49
 **/
@Entity
public class MusicSheet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String sheetName;

    @Column
    private String sheetUser;

    @Column
    private Integer playNum;

    @Column
    private String sheetUrl;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getSheetUser() {
        return sheetUser;
    }

    public void setSheetUser(String sheetUser) {
        this.sheetUser = sheetUser;
    }

    public Integer getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Integer playNum) {
        this.playNum = playNum;
    }

    public String getSheetUrl() {
        return sheetUrl;
    }

    public void setSheetUrl(String sheetUrl) {
        this.sheetUrl = sheetUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "MusicSheet{" +
                "id=" + id +
                ", sheetName='" + sheetName + '\'' +
                ", sheetUser='" + sheetUser + '\'' +
                ", playNum=" + playNum +
                ", sheetUrl='" + sheetUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

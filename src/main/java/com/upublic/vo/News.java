package com.upublic.vo;

import java.util.Date;

public class News {
    private Integer nid;
    private Integer uid;
    private String ncontent;
    private Integer nstatus;
    private Date time;

    public News() {
    }

    public News(Integer uid, String ncontent) {
        this.uid = uid;
        this.ncontent = ncontent;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Integer getNstatus() {
        return nstatus;
    }

    public void setNstatus(Integer nstatus) {
        this.nstatus = nstatus;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

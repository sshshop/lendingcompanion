package com.upublic.vo;

import java.util.Date;

/**
 * Created by SJ on 2017/5/6.
 */
public class Bookcomment {
    private Integer uid;
    private Integer bid;
    private Date bctime;
    private String inf;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Date getBctime() {
        return bctime;
    }

    public void setBctime(Date bctime) {
        this.bctime = bctime;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }
}

package com.upublic.vo;

import java.util.Date;

/**
 * Created by Rabit on 2017/5/23.
 */
public class Msg {
    private Integer mid;
    private String msg;
    private Date time;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

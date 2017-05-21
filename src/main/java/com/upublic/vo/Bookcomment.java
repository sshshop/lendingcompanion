package com.upublic.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by SJ on 2017/5/6.
 */
public class Bookcomment {
    private Integer uid;
    private List<User> user;
    private String username;
    private Integer bid;
    private List<Book> list;
    private Date bctime;
    private String inf;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
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

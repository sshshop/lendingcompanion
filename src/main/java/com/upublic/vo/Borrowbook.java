package com.upublic.vo;

import java.util.Date;
import java.util.List;

public class Borrowbook {
    private Integer bbid;
    private Integer uid;
    private List<User> userList;
    private Integer bid;
    private Book book;
    private List<Book> list;
    private Date btime;
    private Date rtime;
    private Integer bstatus; //借书状态，1为提交信息（包括交押金）借书未取书，2为已取书未还书，3为已还书
    private Date ttime;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getBbid() {
        return bbid;
    }

    public void setBbid(Integer bbid) {
        this.bbid = bbid;
    }

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

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public Integer getBstatus() {
        return bstatus;
    }

    public void setBstatus(Integer bstatus) {
        this.bstatus = bstatus;
    }

    public Date getTtime() {
        return ttime;
    }

    public void setTtime(Date ttime) {
        this.ttime = ttime;
    }
}

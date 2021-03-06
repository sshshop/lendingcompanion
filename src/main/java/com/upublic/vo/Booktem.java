package com.upublic.vo;

import java.util.Date;

public class Booktem {
    private Integer btid;
    private Integer cid;
    private String btname;
    private String adr;
    private String num;
    private String cover;
    private String sequence;
    private String btcontent;
    private String idt;
    private Integer cobn;
    private String btauthor;
    private Date time;
    private double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getBtid() {
        return btid;
    }

    public void setBtid(Integer btid) {
        this.btid = btid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getBtname() {
        return btname;
    }

    public void setBtname(String btname) {
        this.btname = btname;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getBtcontent() {
        return btcontent;
    }

    public void setBtcontent(String btcontent) {
        this.btcontent = btcontent;
    }

    public String getIdt() {
        return idt;
    }

    public void setIdt(String idt) {
        this.idt = idt;
    }

    public Integer getCobn() {
        return cobn;
    }

    public void setCobn(Integer cobn) {
        this.cobn = cobn;
    }

    public String getBtauthor() {
        return btauthor;
    }

    public void setBtauthor(String btauthor) {
        this.btauthor = btauthor;
    }

    @Override
    public String toString() {
        return getBtid() + getBtname() + getBtauthor() + getAdr() + getNum() + (getBtname().equals(""));
    }
}

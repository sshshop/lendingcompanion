package com.upublic.vo;

import java.util.Date;

public class Book {
    private Integer bid;
    private Integer cid;
    private Category category;
    private String bname;
    private String badr;
    private String bnum;
    private String bcover;
    private String bsequence;
    private String bcontent;
    private String bidt;
    private Integer bcobn;
    private Integer nborrowed;
    private String bauthor;
    private Integer hborrowed;
    private String initials;
    private String fight;
    private Date time;
    private Integer comment;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBadr() {
        return badr;
    }

    public void setBadr(String badr) {
        this.badr = badr;
    }

    public String getBnum() {
        return bnum;
    }

    public void setBnum(String bnum) {
        this.bnum = bnum;
    }

    public String getBcover() {
        return bcover;
    }

    public void setBcover(String bcover) {
        this.bcover = bcover;
    }

    public String getBsequence() {
        return bsequence;
    }

    public void setBsequence(String bsequence) {
        this.bsequence = bsequence;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBidt() {
        return bidt;
    }

    public void setBidt(String bidt) {
        this.bidt = bidt;
    }

    public Integer getBcobn() {
        return bcobn;
    }

    public void setBcobn(Integer bcobn) {
        this.bcobn = bcobn;
    }

    public Integer getNborrowed() {
        return nborrowed;
    }

    public void setNborrowed(Integer nborrowed) {
        this.nborrowed = nborrowed;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public Integer getHborrowed() {
        return hborrowed;
    }

    public void setHborrowed(Integer hborrowed) {
        this.hborrowed = hborrowed;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getFight() {
        return fight;
    }

    public void setFight(String fight) {
        this.fight = fight;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

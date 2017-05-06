package com.upublic.vo;

public class Borrowbook {
  private Integer bbid;
  private Integer uid;
  private Integer bid;
  private java.sql.Date btime;
  private java.sql.Date rtime;
  private Integer bstatus;
  private java.sql.Date ttime;

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

  public java.sql.Date getBtime() {
    return btime;
  }

  public void setBtime(java.sql.Date btime) {
    this.btime = btime;
  }

  public java.sql.Date getRtime() {
    return rtime;
  }

  public void setRtime(java.sql.Date rtime) {
    this.rtime = rtime;
  }

  public Integer getBstatus() {
    return bstatus;
  }

  public void setBstatus(Integer bstatus) {
    this.bstatus = bstatus;
  }

  public java.sql.Date getTtime() {
    return ttime;
  }

  public void setTtime(java.sql.Date ttime) {
    this.ttime = ttime;
  }
}

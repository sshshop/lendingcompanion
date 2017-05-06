package com.upublic.vo;

public class Borrowbook {
  private Long bbid;
  private Long uid;
  private Long bid;
  private java.sql.Date btime;
  private java.sql.Date rtime;
  private Long bstatus;
  private java.sql.Date ttime;

  public Long getBbid() {
    return bbid;
  }

  public void setBbid(Long bbid) {
    this.bbid = bbid;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public Long getBid() {
    return bid;
  }

  public void setBid(Long bid) {
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

  public Long getBstatus() {
    return bstatus;
  }

  public void setBstatus(Long bstatus) {
    this.bstatus = bstatus;
  }

  public java.sql.Date getTtime() {
    return ttime;
  }

  public void setTtime(java.sql.Date ttime) {
    this.ttime = ttime;
  }
}

package com.upublic.vo;

import java.util.Date;

public class Borrowbook {
  private Integer bbid;
  private Integer uid;
  private Integer bid;
  private Date btime;
  private Date rtime;
  private Integer bstatus;
  private Date ttime;

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

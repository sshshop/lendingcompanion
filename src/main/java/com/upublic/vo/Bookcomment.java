package com.upublic.vo;

public class Bookcomment {
  private Long uid;
  private Long bid;
  private java.sql.Date bctime;
  private String inf;

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

  public java.sql.Date getBctime() {
    return bctime;
  }

  public void setBctime(java.sql.Date bctime) {
    this.bctime = bctime;
  }

  public String getInf() {
    return inf;
  }

  public void setInf(String inf) {
    this.inf = inf;
  }
}

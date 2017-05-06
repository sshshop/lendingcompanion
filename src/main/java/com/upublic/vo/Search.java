package com.upublic.vo;

public class Search {
  private Long sid;
  private Long uid;
  private String scontent;
  private java.sql.Date stime;

  public Long getSid() {
    return sid;
  }

  public void setSid(Long sid) {
    this.sid = sid;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public String getScontent() {
    return scontent;
  }

  public void setScontent(String scontent) {
    this.scontent = scontent;
  }

  public java.sql.Date getStime() {
    return stime;
  }

  public void setStime(java.sql.Date stime) {
    this.stime = stime;
  }
}

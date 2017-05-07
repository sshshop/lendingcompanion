package com.upublic.vo;

public class Search {
  private Integer sid;
  private Integer uid;
  private String scontent;
  private java.sql.Date stime;

  public Integer getSid() {
    return sid;
  }

  public void setSid(Integer sid) {
    this.sid = sid;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
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

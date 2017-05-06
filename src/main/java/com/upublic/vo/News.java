package com.upublic.vo;

public class News {
  private Long nid;
  private Long uid;
  private String ncontent;
  private Long nstatus;

  public Long getNid() {
    return nid;
  }

  public void setNid(Long nid) {
    this.nid = nid;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public String getNcontent() {
    return ncontent;
  }

  public void setNcontent(String ncontent) {
    this.ncontent = ncontent;
  }

  public Long getNstatus() {
    return nstatus;
  }

  public void setNstatus(Long nstatus) {
    this.nstatus = nstatus;
  }
}

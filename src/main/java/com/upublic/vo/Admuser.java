package com.upublic.vo;

public class Admuser {
  private Long auid;
  private String auname;
  private String apwd;
  private Long authority;

  public Long getAuid() {
    return auid;
  }

  public void setAuid(Long auid) {
    this.auid = auid;
  }

  public String getAuname() {
    return auname;
  }

  public void setAuname(String auname) {
    this.auname = auname;
  }

  public String getApwd() {
    return apwd;
  }

  public void setApwd(String apwd) {
    this.apwd = apwd;
  }

  public Long getAuthority() {
    return authority;
  }

  public void setAuthority(Long authority) {
    this.authority = authority;
  }
}

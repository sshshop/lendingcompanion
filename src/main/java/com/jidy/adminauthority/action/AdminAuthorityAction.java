package com.jidy.adminauthority.action;

import com.jidy.adminauthority.service.AdminAuthorityService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.Admuser;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jidy on 2017/5/23.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class AdminAuthorityAction{
    @Resource(name = "adminAuthorityService")
    AdminAuthorityService adminAuthorityService;
    Admuser admuser=new Admuser();

    private Integer authority;

    public Integer getAuthority() {
        return authority;
    }
    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
    private Integer auid;

    public Integer getAuid() {
        return auid;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    @Action(value = "adminUser_login",results = {
            @Result(name = "findAdmin",location = "admin.jsp")
    })
    public String findAllAdUser(){
        System.out.println(authority);
        List<Admuser> list=new ArrayList<Admuser>();
        list.addAll(adminAuthorityService.findAllAdmUser());
        ActionContext.getContext().getValueStack().set("list",list);
        adminAuthorityService.changAuthority(auid,authority);
        return "findAdmin";
    }

}

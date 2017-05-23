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

import static com.opensymphony.xwork2.Action.SUCCESS;

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
            @Result(location = "admin.jsp")
    })
    public String findAllAdUser(){
        List<Admuser> list=new ArrayList<Admuser>();
        list.addAll(adminAuthorityService.findAllAdmUser());
        System.out.println(authority);
        adminAuthorityService.changAuthority(auid,authority);
        ActionContext.getContext().getValueStack().set("list",list);
        return SUCCESS;
    }

}

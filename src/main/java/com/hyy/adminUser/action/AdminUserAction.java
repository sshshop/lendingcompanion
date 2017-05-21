package com.hyy.adminUser.action;

import com.hyy.adminUser.service.AdminUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.Admuser;
import org.apache.struts2.convention.annotation.*;
import org.springframework.ui.Model;

import javax.annotation.Resource;

/**
 * Created by Scream on 2017/5/20.
 */

/***
 * 后台主页的跳转
 *
 * */
@ParentPackage( value = "struts-default")
@Namespace("")
public class AdminUserAction extends ActionSupport {
    private String auname;
    private String apwd;

    public void setAuname(String auname) {
        this.auname = auname;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public void setAdminUserService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @Resource(name = "adminUserService")
    private AdminUserService adminUserService;


    @Action( value = "adminUser" ,
            results = {
                    @Result(name = "success",location = "adminindex.jsp")
            })

    public String adminUser(){
        return SUCCESS;
    }

    @Action( value = "adminUser_login",
            results = {
                    @Result(name = "loginSuccess",location = "admin.jsp"),
                    @Result(name = "loginFailed",location = "adminindex.jsp")
            }
    )

    /**
     *
     * 用户登录功能模块
     * 根据Action封装的动态数据auname以及apwd进行查询用户
     *
     *
     * */
    public String adminUserLogin(){
        Admuser admuser = adminUserService.findAdminUser(auname,apwd);
        System.out.println(admuser.getAuname()+","+admuser.getApwd());
        /**
         * 判断admuser是否为空，
         * 如果为空则登录失败，
         * 否则登陆成功
         *
         * */
        if (admuser==null){
            this.addActionError("用户不存在或用户名密码错误");
            return "loginFailed";
        }else {
            return "loginSuccess";
        }
    }


}

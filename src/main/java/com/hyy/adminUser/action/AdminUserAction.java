package com.hyy.adminUser.action;

import com.hyy.adminUser.service.AdminUserService;
import com.jidy.adminauthority.service.AdminAuthorityService;
import com.lj.booktemp.service.BooktemService;
import com.lj.category.service.CategoryService;
import com.lj.msg.service.MsgService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.Admuser;
import com.upublic.vo.Booktem;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.ui.Model;

import javax.annotation.Resource;

/**
 *
 * Created by Scream on 2017/5/20.
 */

/***
 * 后台主页的跳转
 *
 * */
@ParentPackage(value = "struts-default")
@Namespace("")
public class AdminUserAction extends ActionSupport {
    private String auname;
    private String apwd;
    private Integer uid;

    public void setUid(Integer uid) {
        this.uid = uid;
    }

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
    @Resource(name = "categoryService")
    private CategoryService categoryService;
    @Resource(name = "booktemService")
    private BooktemService booktemService;
    @Resource(name = "msgService")
    private MsgService msgService;

    @Action(value = "adminUser",
            results = {
                    @Result(name = "success", location = "adminindex.jsp")
            })

    public String adminUser() {
        return SUCCESS;
    }

    @Action(value = "adminUser_login",
            results = {
                    @Result(location = "admin.jsp"),
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

    public String adminUserLogin() {
        Admuser a = (Admuser) ActionContext.getContext().getSession().get("adminUser");
        if(a!=null){
            ActionContext.getContext().getValueStack().set("allUser",adminUserService.findUserAll());
            return SUCCESS;
        }
        Admuser admuser = adminUserService.findAdminUser(auname, apwd);
        ActionContext.getContext().getSession().put("adminUser", admuser);
        ActionContext.getContext().getValueStack().set("allUser", adminUserService.findUserAll());
        ActionContext.getContext().getValueStack().set("allBook", booktemService.findBookAll());
        ActionContext.getContext().getValueStack().set("allmsg", msgService.findAllMsg());
        ActionContext.getContext().getSession().put("category", categoryService.findCategoryAll());
        /**
         *
         * 判断admuser是否为空，
         * 如果为空则登录失败，
         * 否则登陆成功
         *
         * */
        if (admuser == null) {
            this.addActionError("用户不存在或用户名密码错误");
            return "loginFailed";
        }else {
            return SUCCESS;
        }
    }

    /**
     *
     * 编辑用户模块，根据用户ID查询到用户的所有信息并反馈回前台页面进行编辑
     * @author Scream
     *
     * */
    @Action( value = "adminUserEdit",
            results = {
                @Result(location = "editUser.jsp")
            }
    )

    public String adminUserEdit(){
        ActionContext.getContext().getValueStack().set("allUserById",adminUserService.findUserById(uid));
        return SUCCESS;
    }
    @Action( value = "adminUserDel",
            results = {
                @Result(type = "redirect",location = "adminUser_login.action")
            }
    )
    public String adminUserDel(){
        adminUserService.deleteUser(uid);
        return SUCCESS;
    }

}

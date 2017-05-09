package com.lyj.action;

import com.lyj.dao.UserDao;
import com.opensymphony.xwork2.ModelDriven;
import com.lyj.service.UserService;
import com.upublic.vo.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.List;

import static com.opensymphony.xwork2.Action.LOGIN;

/**
 * Created by 盖世太保 on 2017/5/7.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class UserAction implements ModelDriven<User>{

    // 模型驱动使用的对象
    private User user = new User();

    public User getModel() {
        return user;
    }

    // 注入UserService
    @Resource(name = "userService")
    private UserService userService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Action(value = "userLogin",

            results = @Result(name = "loginSuccess",location = "index.jsp")
    )
    public String login(){

        List<User> list =userService.findUserAll(user);
        if (list.isEmpty()){

            //登录失败

           return LOGIN;
        } else {


            ServletActionContext.getRequest().getSession().setAttribute("loginedUser",list.get(0));
            return  "loginSuccess";
        }

    }
    @Action(value = "loginS",results = @Result(name = "login",location = "login.jsp"))
    public String loginS() {
        return "login";
    }

    @Action(value = "registerS",results = @Result(name = "register",location = "register.jsp"))
    public String registerS() {
        return "register";
    }
}

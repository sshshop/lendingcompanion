package com.lj.action;

import com.lj.service.UserService;
import com.lj.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;

/**
 * Created by Rabit on 2017/5/6.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "/")
@Action(
        value = "userAction",
        results = {
                @Result(name = "success", location = "index.jsp")
        }
)
public class UserAction extends ActionSupport {

    @Resource(name = "UserService")
    private UserService userService;


    public String test() {
        System.out.println("进入了action");
        String id="lj";
        System.out.println("useService是否为空1111："+(userService==null));
        User user=userService.selectPwdById(id);
        System.out.println("查到的密码是:"+user.getPwd());
        return SUCCESS;
    }
}

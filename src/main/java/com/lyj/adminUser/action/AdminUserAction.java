package com.lyj.adminUser.action;

import com.lyj.city.service.CityService;
import com.lyj.province.service.ProvinceService;
import com.lyj.user.service.UserService;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;


import javax.annotation.Resource;

import static com.opensymphony.xwork2.Action.NONE;

/**
 * Created by 盖世太保 on 2017/5/22.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class AdminUserAction implements ModelDriven<User>
{
    private String province1;
    private String city1;
    private String dob;
    private String sex1;
    private User user = new User();
    public User getModel(){
        return user;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setSex1(String sex1) {
        this.sex1 = sex1;
    }

    public void setProvince1(String province1) {
        this.province1 = province1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "provinceService")
    private ProvinceService provinceService;

    @Resource(name = "cityService")
    private CityService cityService;
    @Action(value="addUser",results = @Result(name = "addSuccess",type = "redirect",location = "adminUserforward.action"))
    public String addUser(){

        if (sex1.equals("man")) {
            user.setSex(1);
        } else {
            user.setSex(0);
        }

        user.setPid(provinceService.selectPid(province1));
        user.setCid(cityService.selectCid(city1));
        String i="admin";
        userService.sava(user,i);
        return "addSuccess";
    }
}

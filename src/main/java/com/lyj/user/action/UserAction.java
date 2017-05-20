package com.lyj.user.action;

import com.lyj.city.service.CityService;
import com.lyj.province.action.ProvinceAction;
import com.lyj.province.service.ProvinceService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.lyj.user.service.UserService;
import com.upublic.vo.City;
import com.upublic.vo.Province;
import com.upublic.vo.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.opensymphony.xwork2.Action.LOGIN;
import static com.opensymphony.xwork2.Action.NONE;

/**
 * Created by 盖世太保 on 2017/5/7.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class UserAction extends ActionSupport implements ModelDriven<User>{

    // 模型驱动使用的对象
    private User user = new User();
    private String province;
    private  String city;
    private String dob;
    private String sex1;

    public void setSex1(String sex1) {
        this.sex1 = sex1;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public User getModel() {
        return user;
    }


    // 注入UserService
    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "provinceService")
    private ProvinceService provinceService;

    @Resource(name ="cityService")
    private CityService cityService;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //用户登录跳转
    @Action(value = "userLogin", results ={
                    @Result(name = "loginSuccess",location = "index.jsp")
            }
    )
    public String login(){

        List<User> list =userService.findUserAll(user);

      /*  System.out.print(list.get(0).getUsername());*/

        if (list.isEmpty()){

            //登录失败

           return LOGIN;
        } else {
            ServletActionContext.getRequest().getSession().setAttribute("existedUser",list.get(0));
            return  "loginSuccess";
        }

    }
    //用户登录
    @Action(value = "loginS",results = @Result(name = "login",location = "login.jsp"))
    public String loginS() {
        return "login";
    }

    //用户注册
    @Action(value = "registerS",results = @Result(name = "register",location = "register.jsp"))
    public String registerS() {
        return "register";
    }


    //用户名校验是否存在
    @Action(value = "registerU")
    public String findByName() throws IOException {
        /**
         * 调用service进行查询
         */
  //      System.out.println(user.getUsername());
        List<User> list =userService.findUsernameAll(user);
        /*System.out.println(list.get(0).getUsername());*/
        //获得rresponse对象，向页面输出
        HttpServletResponse response= ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");

        if (list.isEmpty()||list.size()<1){
            //没有查询到该用户：用户名可以使用
            response.getWriter().println("<font color='green'>用户名可以使用</font>");
        } else {
            //查询到该用户：用户名已存在
            response.getWriter().println("<font color='red'>用户名已存在</font>");

        }
        return NONE;
    }

    //用户注册方法
    @Action(value = "registerPost",results = @Result(name = "registerSuccess",location = "login.jsp"))
    public  String register(){
        if (sex1=="man"){
            user.setSex(1);
        }else {
            user.setSex(0);
        }

        /*System.out.println(user.getSex());*/
        user.setPid(provinceService.selectPid(province));
       /* System.out.println(user.getPid());*/
        user.setCid(cityService.selectCid(city));
       /* System.out.println(user.getCid());*/
        userService.sava(user);
        //注册成功返回页面
        return  "registerSuccess";
    }

    //用户激活方法
    @Action(value = "active",
            results = @Result(name = "registerSuccess",location = "login.jsp")
    )
    public String active(){
        User existUser=userService.findBycode(user.getCode());
        if (existUser==null){
            // 激活失败
           this.addActionMessage("激活失败：激活码错误！");
            // 激活失败返回页面
            return "registerSuccess";
        }else {

            // 激活成功
            // 修改用户的状态
          /*  existUser.setCode(null);
            existUser.setState(1);*/

            userService.update(existUser);
            // 激活成功返回页面
            return NONE;
        }

    }
}

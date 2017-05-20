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
public class UserAction extends ActionSupport implements ModelDriven<User> {

    // 模型驱动使用的对象
    private User user = new User();
    private String province;
    private String city;
    private String dob;
    private String sex1;
    private int bid;//图书bid
    private int status=0;//用户跳转状态，默认值为0；1为详情页跳转，2未搜索页跳转

    public void setBid(int bid) {
        this.bid = bid;
    }

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

    @Resource(name = "cityService")
    private CityService cityService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 用户登录跳转
     * 前台传入值驱动模型然后获取登录
     * 登录以后的值存入session，
     * 成功跳转至首页，登录失败跳转至登录页
     */
    @Action(value = "userLogin", results = {
            @Result(name = "loginSuccess", location = "index.action", type = "redirect"),
            @Result(name = LOGIN, location = "login.jsp"),
            @Result(name = ERROR, location = "index.action", type = "redirect")
    }
    )
    public String login() {
        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser == null) {
            List<User> list = userService.findUserAll(user);
            if (list.isEmpty()) {
                //登录失败
                this.addActionError("密码或者用户名错误");
                return LOGIN;
            } else {
                System.out.println("登录成功");

                ServletActionContext.getRequest().getSession().setAttribute("existedUser", list.get(0));
                return "loginSuccess";
            }
        } else {
            return ERROR;
        }
    }

    //用户登录
    @Action(value = "loginS", results = {@Result(name = LOGIN, location = "login.jsp"),
            @Result(name = ERROR, location = "index.action", type = "redirect")
    })
    public String loginS() {
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (user == null) {
            return LOGIN;
        } else {
            return ERROR;
        }
    }

    //用户注册
    @Action(value = "registerS", results = @Result(name = "register", location = "register.jsp"))
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
        List<User> list = userService.findUsernameAll(user);
        /*System.out.println(list.get(0).getUsername());*/
        //获得rresponse对象，向页面输出
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");

        if (list.isEmpty() || list.size() < 1) {
            //没有查询到该用户：用户名可以使用
            response.getWriter().println("<font color='green'>用户名可以使用</font>");
        } else {
            //查询到该用户：用户名已存在
            response.getWriter().println("<font color='red'>用户名已存在</font>");

        }
        return NONE;
    }

    //用户注册方法
    @Action(value = "registerPost", results = @Result(name = "registerSuccess", location = "login.jsp"))
    public String register() {
        if (sex1 == "man") {
            user.setSex(1);
        } else {
            user.setSex(0);
        }

        /*System.out.println(user.getSex());*/
        user.setPid(provinceService.selectPid(province));
       /* System.out.println(user.getPid());*/
        user.setCid(cityService.selectCid(city));
       /* System.out.println(user.getCid());*/
        userService.sava(user);
        //注册成功返回页面
        return "registerSuccess";
    }

    //用户激活方法
    @Action(value = "active",
            results = @Result(name = "registerSuccess", location = "login.jsp")
    )
    public String active() {
        User existUser = userService.findBycode(user.getCode());
        if (existUser == null) {
            // 激活失败
            this.addActionMessage("激活失败：激活码错误！");
            // 激活失败返回页面
            return "registerSuccess";
        } else {

            // 激活成功
            // 修改用户的状态
          /*  existUser.setCode(null);
            existUser.setState(1);*/

            userService.update(existUser);
            // 激活成功返回页面
            return NONE;
        }
    }

    /**
     * 用户退出登录，销毁用户session，重定向到主页
     *
     * @return 返回用户session成功
     */
    @Action(value = "loginOut", results = {
            @Result(name = SUCCESS, location = "index.action", type = "redirect"),
    }
    )
    public String loginOut() {
        ServletActionContext.getRequest().getSession().removeAttribute("existedUser");
        ServletActionContext.getRequest().getSession().invalidate();
        return SUCCESS;
    }

    /**
     * 用于用户前台在非首页登录跳转到当前页面
     * @return
     */
    @Action(value = "loginJumpThis",

            results = {
                    @Result(type = "redirect", location = "findBookBybid.action"),
                    @Result(name = ERROR, type = "redirect", location = "index.action"),
                    @Result(name = LOGIN,location = "login.jsp")
            }
    )
    public String loginJumpThis() {
        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser != null) {
            System.out.println("已经登录过了");
            return ERROR;
        }
        System.out.println("进入登录了，书名是：" + bid+"状态是："+status);
        ServletActionContext.getRequest().getSession().setAttribute("bid", bid);
        System.out.println(user.getUsername() + "--" + user.getUpassword());
        List<User> list = userService.findUserAll(user);
        if (list.isEmpty()) {
        this.addActionError("用户名或者密码错误");
            //登录失败
            return LOGIN;
        } else {
            System.out.println("登录成功--------------");
            ServletActionContext.getRequest().getSession().setAttribute("existedUser", list.get(0));
            ServletActionContext.getResponse().setStatus(1);
            return SUCCESS;
        }

    }
}

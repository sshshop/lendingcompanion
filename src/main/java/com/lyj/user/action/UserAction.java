package com.lyj.user.action;

import com.lj.bookcomment.service.BookCommentService;
import com.lj.borrowbook.service.BorrowbookService;
import com.lj.news.service.NewsService;
import com.lj.subcription.service.SubscriptionService;
import com.lyj.city.service.CityService;
import com.lyj.province.service.ProvinceService;
import com.lyj.user.utils.SendMailUnitl;
import com.lyj.user.utils.UUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.lyj.user.service.UserService;
import com.upublic.vo.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * 用户相关操作
 * Created by 盖世太保 on 2017/5/7.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class UserAction extends ActionSupport implements ModelDriven<User> {

    // 模型驱动使用的对象
    private User user = new User();
    private String province1;
    private String city1;
    private String dob;
    private String sex1;


    private String upassword1;

    private String number1;
    private int bid;//图书bid
    private int status = 0;//用户跳转状态，默认值为0；1为详情页跳转，2未搜索页跳转
    // 注入UserService
    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "provinceService")
    private ProvinceService provinceService;

    @Resource(name = "cityService")
    private CityService cityService;
    @Resource(name = "borrowbookService")
    private BorrowbookService borrowbookService;
    @Resource(name = "subscriptionService")
    private SubscriptionService subscriptionService;
    @Resource(name = "bookCommentService")
    private BookCommentService bookCommentService;
    @Resource(name = "newsService")
    private NewsService newsService;


    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setSex1(String sex1) {
        this.sex1 = sex1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
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

    public void setUpassword1(String upassword1) {
        this.upassword1 = upassword1;
    }

    public User getModel() {
        return user;
    }

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
                this.addActionMessage("登录");
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
            this.addActionMessage("登录");
            return LOGIN;
        } else {
            return ERROR;
        }
    }

    //用户注册
    @Action(value = "registerS", results = {@Result(name = "register", location = "register.jsp"),
            @Result(name = SUCCESS, location = "index.jsp", type = "redirect")
    })
    public String registerS() {
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (user == null) {
            this.addActionMessage("注册");
            return "register";
        } else {
            this.addActionMessage("登录");
            return SUCCESS;
        }
    }


    //用户名校验是否存在
    @Action(value = "registerU")
    public String findByName() throws IOException {
        /**
         * 调用service进行查询
         */

        List<User> list = userService.findUsernameAll(user);

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

    @Action(value = "findPassword")
    public String findByName2() throws IOException {
        /**
         * 调用service进行查询
         */

        List<User> list = userService.findUsernameAll(user);

        //获得rresponse对象，向页面输出
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");

        if (list.isEmpty() || list.size() < 1) {
            //没有查询到该用户：用户名可以使用
            response.getWriter().println("<font color='red'>用户名不存在</font>");
        } else {
            //查询到该用户：用户名已存在
            response.getWriter().println("");

        }
        return NONE;
    }

    //用户注册方法
    @Action(value = "registerPost", results = {@Result(name = "registerSuccess", location = "registersucee.jsp"),
            @Result(name = ERROR, location = "registermsg.jsp")

    }

    )
    public String register() {
        //获取性别按钮的值
        if (sex1.equals("man")) {
            user.setSex(1);
        } else {
            user.setSex(0);
        }

        try {
            //查询pid,cid的方法
            user.setPid(provinceService.selectPid(province1));
            user.setCid(cityService.selectCid(city1));
        } catch (Exception e) {
            this.addActionError("注册失败，请重新注册");
            return ERROR;
        }

        String i = "user";
        userService.sava(user, i);
        //注册成功返回页面
        this.addActionError("请去邮箱激活账号！");
        return "registerSuccess";
    }

    //用户激活方法
    @Action(value = "active",
            results = {@Result(name = ERROR, location = "registerFalse.jsp"),
                    @Result(location = "registersucee.jsp"),
            @Result(name = "registerSuccess",location = "registerSuccess2.jsp")}
    )
    public String active() {
        User existUser = userService.findBycode(user.getCode());
        this.addActionMessage("信息提示");
        if (existUser == null) {
            // 激活失败
            this.addActionError("激活失败：激活码错误！");
            // 激活失败注册页面
            return ERROR;
        } else {

            // 激活成功
            // 修改用户的状态
            userService.update(existUser);
            this.addActionError("激活成功，请登录！");
            // 激活成功返回登录页面
            return "registerSuccess";
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
     *
     * @return
     */
    @Action(value = "loginJumpThis",

            results = {
                    @Result(type = "redirect", location = "findBookBybid.action"),
                    @Result(name = ERROR, type = "redirect", location = "index.action"),
                    @Result(name = LOGIN, location = "loginS.action", type = "redirect")
            }
    )
    public String loginJumpThis() {
        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser != null) {
            System.out.println("已经登录过了");
            return ERROR;
        }
        System.out.println("进入登录了，书名是：" + bid + "状态是：" + status);
        ServletActionContext.getRequest().getSession().setAttribute("bid", bid);
        System.out.println(user.getUsername() + "--" + user.getUpassword());
        List<User> list = userService.findUserAll(user);
        if (list.isEmpty()) {
            this.addActionError("用户名或者密码错误");
            //登录失败
            this.addActionMessage("登录");
            return LOGIN;
        } else {
            System.out.println("登录成功--------------");
            ServletActionContext.getRequest().getSession().setAttribute("existedUser", list.get(0));
            ServletActionContext.getResponse().setStatus(1);
            return SUCCESS;
        }

    }


    /**
     * 用户信息中心跳转
     *
     * @return
     */
    @Action(value = "userMessage", results = {
            @Result(location = "userMessage1.jsp"),
            @Result(name = LOGIN, location = "loginS.action", type = "redirect")
    })


    public String userMessage() {

        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser == null) {
            //用户未登录
            return LOGIN;
        }
        ServletActionContext.getRequest().getSession().setAttribute("existedUser", userService.findUserByUid(loginuser));
        //   ServletActionContext.getRequest().getSession().setAttribute("mysub", subscriptionService.findSubBooks(loginuser));  //我的订阅跳转
        //   ServletActionContext.getRequest().getSession().setAttribute("mycomment", bookCommentService.findCommentByUId(loginuser));//我的评价跳转
        // ServletActionContext.getRequest().getSession().setAttribute("myborrow", borrowbookService.findBorrowedBookByUid(loginuser));  //我的借书信息
        //      ServletActionContext.getRequest().getSession().setAttribute("mynews", newsService.findNewsByUid(loginuser));  //我的消息
        this.addActionMessage("个人中心");
        return SUCCESS;
    }

    /**
     * 借书信息跳转
     *
     * @return
     */
    @Action(value = "BorrowInfo", results = {
            @Result(location = "userMessage2.jsp"),
            @Result(name = LOGIN, location = "loginS.action", type = "redirect")
    })


    public String BorrowInfo() {

        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser == null) {
            //用户未登录
            return LOGIN;
        }
        ServletActionContext.getRequest().getSession().setAttribute("existedUser", userService.findUserByUid(loginuser));
        //   ServletActionContext.getRequest().getSession().setAttribute("mysub", subscriptionService.findSubBooks(loginuser));  //我的订阅跳转
        //   ServletActionContext.getRequest().getSession().setAttribute("mycomment", bookCommentService.findCommentByUId(loginuser));//我的评价跳转
        ServletActionContext.getRequest().getSession().setAttribute("myborrow", borrowbookService.findBorrowedBookByUid(loginuser));  //我的借书信息
        //   ServletActionContext.getRequest().getSession().setAttribute("mynews", newsService.findNewsByUid(loginuser));  //我的消息
        this.addActionMessage("个人中心");
        return SUCCESS;
    }

    /**
     * 订阅信息
     *
     * @return
     */
    @Action(value = "SubscriptionInfo", results = {
            @Result(location = "userMessage3.jsp"),
            @Result(name = LOGIN, location = "loginS.action", type = "redirect")
    })


    public String SubscriptionInfo() {

        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser == null) {
            //用户未登录
            return LOGIN;
        }
        ServletActionContext.getRequest().getSession().setAttribute("existedUser", userService.findUserByUid(loginuser));
        ServletActionContext.getRequest().getSession().setAttribute("mysub", subscriptionService.findSubBooks(loginuser));  //我的订阅跳转
        //   ServletActionContext.getRequest().getSession().setAttribute("mycomment", bookCommentService.findCommentByUId(loginuser));//我的评价跳转
        // ServletActionContext.getRequest().getSession().setAttribute("myborrow", borrowbookService.findBorrowedBookByUid(loginuser));  //我的借书信息
        //   ServletActionContext.getRequest().getSession().setAttribute("mynews", newsService.findNewsByUid(loginuser));  //我的消息
        this.addActionMessage("个人中心");
        return SUCCESS;
    }


    /**
     * 评价信息跳转
     *
     * @return
     */
    @Action(value = "appraise", results = {
            @Result(location = "userMessage4.jsp"),
            @Result(name = LOGIN, location = "loginS.action", type = "redirect")
    })


    public String appraise() {

        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser == null) {
            //用户未登录
            return LOGIN;
        }
        ServletActionContext.getRequest().getSession().setAttribute("existedUser", userService.findUserByUid(loginuser));
        //   ServletActionContext.getRequest().getSession().setAttribute("mysub", subscriptionService.findSubBooks(loginuser));  //我的订阅跳转
        ServletActionContext.getRequest().getSession().setAttribute("mycomment", bookCommentService.findCommentByUId(loginuser));//我的评价跳转
        // ServletActionContext.getRequest().getSession().setAttribute("myborrow", borrowbookService.findBorrowedBookByUid(loginuser));  //我的借书信息
        //   ServletActionContext.getRequest().getSession().setAttribute("mynews", newsService.findNewsByUid(loginuser));  //我的消息
        this.addActionMessage("个人中心");
        return SUCCESS;
    }

    /**
     * 系统消息跳转
     *
     * @return
     */
    @Action(value = "systemmsg", results = {
            @Result(location = "userMessage5.jsp"),
            @Result(name = LOGIN, location = "loginS.action", type = "redirect")
    })

    public String systemmsg() {

        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser == null) {
            //用户未登录
            return LOGIN;
        }
        ServletActionContext.getRequest().getSession().setAttribute("existedUser", userService.findUserByUid(loginuser));
        //   ServletActionContext.getRequest().getSession().setAttribute("mysub", subscriptionService.findSubBooks(loginuser));  //我的订阅跳转
        //   ServletActionContext.getRequest().getSession().setAttribute("mycomment", bookCommentService.findCommentByUId(loginuser));//我的评价跳转
        // ServletActionContext.getRequest().getSession().setAttribute("myborrow", borrowbookService.findBorrowedBookByUid(loginuser));  //我的借书信息
        ServletActionContext.getRequest().getSession().setAttribute("mynews", newsService.findNewsByUid(loginuser));  //我的消息
        this.addActionMessage("个人中心");
        return SUCCESS;
    }


    @Action(value = "updateUser", results = {
            @Result(type = "redirect", location = "userMessage.action"),
            @Result(name = ERROR, location = "userMessage1.jsp"),
            @Result(name = LOGIN, location = "loginS.action", type = "redirect")
    })
    public String updateUser() {
        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser == null) {
            //用户未登录
            return LOGIN;
        }

        //System.out.println(province1 + city1 + sex1);
        if ("man".equals(sex1)) {
            user.setSex(1);
        } else {
            user.setSex(0);
        }
        //修改了提交省份城市空值报错的BUG
        if (!"请选择".equals(province1)) {
            user.setPid(provinceService.selectPid(province1));
        }
        if (!"请选择".equals(city1)) {
            user.setCid(cityService.selectCid(city1));
        }
        //修改BUG END
        user.setUid(loginuser.getUid());
        if (userService.updateUser(user) != 1) {
            this.addActionMessage("信息修改失败");
            return ERROR;
        }
        System.out.println("修改成功");
        return SUCCESS;
    }


    /*//忘记密码页面跳转
    @Action(value = "findPassword1" ,results = @Result(name = ERROR, location = "findPassword1.jsp"))
    public String findPassword1(){
        return ERROR;
    }*/


    @Action(value = "findP", results = {@Result(name = "find1", location = "findPassword1.jsp"),
            @Result(name = "find2", location = "findPassword2.jsp"),
            @Result(name = "find3", location = "findPassword3.jsp")})
    //用户找回密码的方法1
    public String findPassword() throws IOException {
        //判断用户名邮箱是否匹配
        System.out.println(user.getUsername());
        User u = userService.findByemail(user.getUsername());
        // System.out.println(email.getEmail()+"----------------");
        if (u == null) {
            System.out.println("用户名不存在");
            this.addActionError("用户名不存在");
            return "find1";
        } else {
            String i = "findUser";
            String number = UUIDUtils.getNumber();
            ActionContext.getContext().getSession().put("email", u.getEmail());
            ActionContext.getContext().getSession().put("finduser", u.getUsername());
            ActionContext.getContext().getSession().put("code", number);
            //发送验证码邮件
            SendMailUnitl.senMail(u.getEmail(), number, i);
            //跳转到填写验证码页面
            return "find2";

        }

    }


    //用户找回密码的方法2
    @Action(value = "findNumber", results = {@Result(name = "find3", location = "findPassword3.jsp"),
            @Result(name = "find2", location = "findPassword2.jsp")})
    public String findNumber() throws IOException {

        String number = (String) ActionContext.getContext().getSession().get("code");
      /*  System.out.println(number);
        System.out.println(number1);*/
        if (number1.trim().equals(number)) {

            ActionContext.getContext().getSession().remove("code");
            //验证码正确，跳转到修改密码页面
            return "find3";

        } else {

            System.out.println("验证码不正确！");
            this.addActionError("验证码不正确");

            return "find2";
        }

    }

    ////用户找回密码的方法
    @Action(value = "updatePassword", results = @Result(name = "find4", location = "findPassword4.jsp"))
    public String updatePassword() {
        String c = (String) ActionContext.getContext().getSession().get("finduser");
        // System.out.println(c+upassword1);
        userService.updatePassword(c, upassword1);
        return "find4";
    }


}

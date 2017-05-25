package com.hyy.adminUser.action;

import com.hyy.adminUser.service.AdminUserService;
import com.jidy.adminauthority.service.AdminAuthorityService;
import com.lj.booktemp.service.BooktemService;
import com.lj.category.service.CategoryService;
import com.lj.msg.service.MsgService;
import com.lyj.city.service.CityService;
import com.lyj.province.service.ProvinceService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.*;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scream on 2017/5/20.
 */

/***
 * 后台主页的跳转
 *
 * */
@ParentPackage(value = "struts-default")
@Namespace("")
public class AdminUserAction extends ActionSupport implements ModelDriven<User> {
    private String auname;
    private String apwd;
    private int mid;
    private String msg;
    private Integer auid;
    private Integer authority;

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    private String city1;
    private String province1;

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public void setProvince1(String province1) {
        this.province1 = province1;
    }


    //  private Integer uid;
    private User user = new User();

    public User getModel() {
        return user;
    }
// //   public void setUid(Integer uid) {
//        this.uid = uid;
//    }

    public void setAuname(String auname) {
        this.auname = auname;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public void setAdminUserService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @Resource(name = "cityService")
    private CityService cityService;
    @Resource(name = "provinceService")
    private ProvinceService provinceService;
    @Resource(name = "adminUserService")
    private AdminUserService adminUserService;
    @Resource(name = "categoryService")
    private CategoryService categoryService;
    @Resource(name = "booktemService")
    private BooktemService booktemService;
    @Resource(name = "msgService")
    private MsgService msgService;
    @Resource(name = "adminAuthorityService")
    private AdminAuthorityService adminAuthorityService;

    @Action(value = "adminUser",
            results = {
                    @Result(name = "success", location = "adminlogin.jsp")
            })

    public String adminUser() {
        return SUCCESS;
    }

    @Action(value = "adminUserLogin",
            results = {
                    @Result(location = "admin.jsp"),
                    @Result(name = "loginFailed", location = "adminindex.jsp")
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

//        Admuser a = (Admuser) ActionContext.getContext().getSession().get("adminUser");
//        if (a != null) {
//            ActionContext.getContext().getValueStack().set("allUser", adminUserService.findUserAll());
//            ActionContext.getContext().getValueStack().set("allBook", booktemService.findBookAll());
//            ActionContext.getContext().getValueStack().set("allmsg", msgService.findAllMsg());
//            ActionContext.getContext().getValueStack().set("list",adminAuthorityService.findAllAdmUser());
//            return SUCCESS;
//        }
        Admuser admuser = adminUserService.findAdminUser(auname, apwd);
//        ActionContext.getContext().getValueStack().set("borrowedbook", adminUserService.findBorrowedALLByBid());
//        ActionContext.getContext().getValueStack().set("list",adminAuthorityService.findAllAdmUser());
//        ActionContext.getContext().getValueStack().set("allUser", adminUserService.findUserAll());
//        ActionContext.getContext().getValueStack().set("allBook", booktemService.findBookAll());
//        ActionContext.getContext().getValueStack().set("allmsg", msgService.findAllMsg());
    //    ActionContext.getContext().getSession().put("category", categoryService.findCategoryAll());
        /**
         * 判断admuser是否为空，
         * 如果为空则登录失败，
         * 否则登陆成功
         * */
        if (admuser == null) {
            this.addActionError("用户不存在或用户名密码错误");
            return "loginFailed";
        } else {
            ActionContext.getContext().getSession().put("adminUser", admuser);
            return SUCCESS;
        }
    }

    @Action(value = "adminUserforward",
            results = {
                    @Result(name = "success", location = "admin1.jsp"),
                    @Result(name = LOGIN, type = "redirect", location = "adminUser.action")
            }
    )
    public String adminUserforward() {
        Admuser a = (Admuser) ServletActionContext.getRequest().getSession().getAttribute("adminUser");
        if (a == null) {
            return LOGIN;
        }
        ActionContext.getContext().getValueStack().set("allUser", adminUserService.findUserAll());

        return SUCCESS;
    }

    /**
     * 公告管理跳转
     *
     * @author Scream
     */
    @Action(value = "adminMsgforward",
            results = {
                    @Result(location = "admin2.jsp"),
                    @Result(name = LOGIN, type = "redirect", location = "adminUser.action")
            }
    )

    public String adminMsgforward() {

        Admuser a = (Admuser) ActionContext.getContext().getSession().get("adminUser");
        if (a == null) {
            return LOGIN;
        }
        ActionContext.getContext().getValueStack().set("allmsg", msgService.findAllMsg());
        ActionContext.getContext().getSession().put("category", categoryService.findCategoryAll());
        return SUCCESS;
    }

    /**
     * 图书管理跳转Action
     *
     * @author Scream
     */
    @Action(value = "adminBookforward",
            results = {
                    @Result(location = "admin3.jsp"),
                    @Result(name = "loginFailed", location = "adminindex.jsp"),
                    @Result(name = LOGIN, type = "redirect", location = "adminUser.action")

            }
    )

    public String adminBookforward() {

        Admuser a = (Admuser) ActionContext.getContext().getSession().get("adminUser");
        if (a == null) {
            return LOGIN;
        }
        ActionContext.getContext().getValueStack().set("allBook", booktemService.findBookAll());
        ActionContext.getContext().getSession().put("category", categoryService.findCategoryAll());
        return SUCCESS;
    }

    /**
     * 权限管理跳转页面
     *
     * @author Scream
     */
    @Action(value = "adminAuthorityforward",
            results = {
                    @Result(location = "admin4.jsp"),
                    @Result(name = "loginFailed", location = "adminindex.jsp"),
                    @Result(name = LOGIN, type = "redirect", location = "adminUser.action")
            }
    )

    public String adminAuthorityforward() {

        Admuser a = (Admuser) ActionContext.getContext().getSession().get("adminUser");
        if (a == null) {
            return LOGIN;
        }
        ActionContext.getContext().getValueStack().set("list", adminAuthorityService.findAllAdmUser());
        ActionContext.getContext().getSession().put("category", categoryService.findCategoryAll());
        return SUCCESS;
    }

    /**
     * 借书管理跳转
     *
     * @author Scream
     */
    @Action(value = "adminBorrowforward",
            results = {
                    @Result(location = "admin5.jsp"),
                    @Result(name = "loginFailed", location = "adminindex.jsp"),
                    @Result(name = LOGIN, type = "redirect", location = "adminUser.action")
            }
    )

    public String adminBorrowforward() {
        Admuser a = (Admuser) ActionContext.getContext().getSession().get("adminUser");
        if (a == null) {
            return LOGIN;
        }
       /* List<Borrowbook> list = ((List<Borrowbook>) ActionContext.getContext().getSession().get("findborrowed") == null ? new ArrayList<Borrowbook>() : (List<Borrowbook>) ActionContext.getContext().getSession().get("findborrowed"));
        if (!list.isEmpty()) {
            ActionContext.getContext().getSession().put("category", categoryService.findCategoryAll());
            ActionContext.getContext().getValueStack().set("borrowedbook", list);

            return SUCCESS;
        }*/
        ActionContext.getContext().getValueStack().set("borrowedbook", adminUserService.findBorrowedALLByBid());
        ActionContext.getContext().getSession().put("category", categoryService.findCategoryAll());
        return SUCCESS;
    }

    /**
     * 用户退出功能模块
     * 销毁Session
     *
     * @author Scream
     */
    @Action(value = "adminloginOut",
            results = {
                    @Result(name = "success", location = "adminindex.jsp")
            }
    )
    public String adminloginOut() {
        ServletActionContext.getRequest().getSession().removeAttribute("adminUser");
        ServletActionContext.getRequest().getSession().invalidate();
        return SUCCESS;
    }


    /**
     * 编辑用户模块，根据用户ID查询到用户的所有信息并反馈回前台页面进行编辑
     *
     * @author Scream
     */
    @Action(value = "adminUserEdit",
            results = {
                    @Result(location = "editUser.jsp")
            }
    )
    public String adminUserEdit() {
        ActionContext.getContext().getValueStack().set("allUserById", adminUserService.findUserById(user.getUid()));
        return SUCCESS;
    }

    /**
     * 进入编辑页面后提交修改表单中的数据进行修改
     *
     * @author Scream
     */
    @Action(value = "editUser",
            results = {
                    @Result(type = "redirect", location = "adminUserforward.action"),
                    @Result(name = "error", location = "msg.jsp")
            }
    )

    public String editUser() {
//        System.out.println(city1+","+province1);
        user.setUid(adminUserService.findUserByName(user.getUsername()));
        if (adminUserService.updataUser(user) != 1) {
            this.addActionMessage("修改失败");
            return ERROR;
        } else {
            this.addActionMessage("修改成功");
            return SUCCESS;
        }
    }

    /**
     * 删除用户的模块，根据用户ID进行删除
     */
    @Action(value = "adminUserDel",
            results = {
                    @Result(type = "redirect", location = "adminUserforward.action")
            }
    )
    public String adminUserDel() {
        adminUserService.deleteUser(user.getUid());
        return SUCCESS;
    }

    /**
     * 根据Mid删除公告
     */
    @Action(value = "msgDelete",
            results = {
                    @Result(name = "success", type = "redirect", location = "adminMsgforward.action"),
                    @Result(name = "error", location = "msg.jsp")
            }
    )
    public String msgDelete() {
        msgService.deleteMsg(mid);
        return SUCCESS;
    }

    /**
     * 公告发布功能的Action层
     *
     * @author Scream
     */
    @Action(value = "publishMsg",
            results = {
                    @Result(name = "success", type = "redirect", location = "adminMsgforward.action"),
                    @Result(name = "error", location = "msg.jsp")
            }
    )
    public String publishMsg() {
        if (msgService.saveMsg(msg) != 1) {
            this.addActionMessage("发布失败");
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    /**
     * 管理员用户的升权操作
     *
     * @author Scream
     */
    @Action(value = "changeUp",
            results = {
                    @Result(name = "success", type = "redirect", location = "adminAuthorityforward.action"),
                    @Result(name = "error", location = "msg.jsp")
            }
    )

    public String changeUp() {
        Admuser admuser = (Admuser) ActionContext.getContext().getSession().get("adminUser");
        if (admuser.getAuthority() > (authority - 1)) {
            adminAuthorityService.changAuthority(auid, authority);
            return SUCCESS;
        } else {
            this.addActionMessage("您没有权限操作该用户");
            return ERROR;
        }
    }

    /**
     * 管理员用户的降权操作
     *
     * @author Scream
     **/
    @Action(value = "changeDown",
            results = {
                    @Result(name = "success", type = "redirect", location = "adminAuthorityforward.action"),
                    @Result(name = "error", location = "msg.jsp")
            }
    )

    public String changeDown() {
        Admuser admuser = (Admuser) ActionContext.getContext().getSession().get("adminUser");
        if (admuser.getAuthority() > (authority + 1)) {
            adminAuthorityService.changAuthority(auid, authority);
            return SUCCESS;
        } else {
            this.addActionMessage("您没有权限操作该用户");
            return ERROR;
        }
    }
}

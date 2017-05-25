package com.lj.borrowbook.action;

import com.jidy.searchbook.service.BookService;
import com.lj.borrowbook.service.BorrowbookService;
import com.opensymphony.xwork2.*;
import com.upublic.vo.Admuser;
import com.upublic.vo.Borrowbook;
import com.upublic.vo.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rabit on 2017/5/9.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class BorrowbookAction extends ActionSupport implements ModelDriven<Borrowbook> {
    @Resource(name = "borrowbookService")
    private BorrowbookService borrowbookService;
    @Resource(name = "bookService")
    private BookService bookService;
    private Borrowbook borrowbook = new Borrowbook();
    private String username="";  //用于后台用户借书管理的用户名搜索用户id接受参数,并查询借书信息
    private String bname="";  //用于后台管理员管理图书名字查询图书的id并查询借书信息
    //  private int bid; //图书id


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBorrowbookService(BorrowbookService borrowbookService) {
        this.borrowbookService = borrowbookService;
    }

    /**
     * 将借书信息添加到数据库
     *
     * @return 返回信息
     */
    @Action(
            value = "addBorrowBook",
            results = {
                    @Result(location = "msg.jsp"),
                    @Result(name = LOGIN, location = "login.jsp"),
                    @Result(name = ERROR, location = "msg.jsp")
            }, exceptionMappings = {
            //映射映射声明
            @ExceptionMapping(exception = "java.lang.Exception", result = ERROR)
    }
    )
    public String addBorrowBook() {
        System.out.println("添加图书的id:==" + borrowbook.getBid());
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (user == null) {
            return LOGIN;
        }
        if (borrowbookService.isOverBorrored(user)) {
            if (borrowbookService.existBorrMsg(user, borrowbook)) {
                //可以借阅时
                borrowbookService.insertBorrowdbook(user, borrowbook);
                System.out.println(borrowbook.getBid() + borrowbook.getRtime().toString() + borrowbook.getTtime());
                borrowbookService.updateBookNborrow(borrowbook);
                this.addActionMessage("借书成功");
                return SUCCESS;
            } else {
                this.addActionMessage("借书失败，同一本书不能借阅两次！");
                return ERROR;
            }

        } else {
            this.addActionMessage("借书失败，因为您现在还有两本书未归还！");
            return ERROR;
        }

    }

    /**
     * 跳转到借书详情页
     *
     * @return
     */
    @Action(
            value = "jumpBorrowdBook",
            results = @Result(location = "borroweBook.jsp")
    )
    public String jumpBorrowBook() {
        System.out.println("跳转到页面成功,获取到的图书id是：" + borrowbook.getBid());
        ServletActionContext.getRequest().getSession().setAttribute("addBook", bookService.findBookById(borrowbook.getBid()));
        return SUCCESS;
    }

    @Action(value = "findBorrowedBookMSG", results = {
            @Result(location = "admin5.jsp"),
            @Result(name = LOGIN, location = "adminUserLogin.action", type = "redirect"),
            @Result(name = "info", location = "adminBorrowforward.action", type = "redirect")
    })
    public String findBorrowedBookMSG() {
        Admuser a = (Admuser) ActionContext.getContext().getSession().get("adminUser");
        if (a == null) {
            return LOGIN;
        }
        if (username.trim().equals("")&&bname.trim().equals("")){
            return "info";
        }
        System.out.println(username + "-" + bname);
        if (!username.equals("") && username != null) {
            username = reString(username);
        }
        if (!bname.equals("") && bname != null) {
            bname = reString(bname);
        }
     //   ActionContext.getContext().getSession().put("findborrowed", borrowbookService.findBorrowedBookMSG(username, bname));
        ActionContext.getContext().getValueStack().set("borrowedbook", borrowbookService.findBorrowedBookMSG(username, bname));
        System.out.println("准备跳转");
        return SUCCESS;
    }

    @Action(value = "updatBorrowedStatus", results = {
            @Result(location = "adminBorrowforward.action", type = "redirect"),
            @Result(name = ERROR, location = "msg.jsp")
    })
    public String updatBorrowedStatus() {
        System.out.println("进入updatBorrowedStatus");
        if (borrowbookService.updatBorrowedStatus(borrowbook) == 1) {
            if (borrowbook.getBstatus() == 3) {
                borrowbookService.insertNew(borrowbook.getBbid());
            }
            return SUCCESS;
        }
        this.addActionMessage("修改借书状态错误");
        return ERROR;
    }

    public Borrowbook getModel() {
        return borrowbook;
    }

    /**
     * 搜索字段的优化，防止sql注入
     *
     * @param temp
     * @return
     */
    public String reString(String temp) {
        temp = temp.replace(" ", "");
        temp =temp.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
        String re = "[\u4e00-\u9fa5a-zA-Z0-9]+";
        Pattern reg = Pattern.compile(re, Pattern.CASE_INSENSITIVE);
        Matcher m = reg.matcher(temp);
        while (m.find()) {
            temp = m.group();
        }
        System.out.println("最终结果" + temp);
        return temp;
    }
}

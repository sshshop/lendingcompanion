package com.lj.borrowbook.action;

import com.jidy.searchbook.service.BookService;
import com.lj.borrowbook.service.BorrowbookService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.Borrowbook;
import com.upublic.vo.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;

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
  //  private int bid; //图书id

    public void setBorrowbookService(BorrowbookService borrowbookService) {
        this.borrowbookService = borrowbookService;
    }

    /**
     * 将借书信息添加到数据库
     * @return
     */
    @Action(
            value = "addBorrowBook",
            results = {
                    @Result(name =SUCCESS, location = "msg.jsp"),
                    @Result(name = LOGIN,location ="login.jsp" )
            }
    )
    public String addBorrowBook() {
        System.out.println("添加图书的id:=="+borrowbook.getBid());
    User user=(User)ServletActionContext.getRequest().getSession().getAttribute("existedUser");
    if (user==null){
        return LOGIN;
    }
        borrowbookService.insertBorrowdbook(user,borrowbook);
        System.out.println(borrowbook.getBid()+borrowbook.getRtime().toString()+borrowbook.getTtime());
        addActionMessage("借书成功");
        return SUCCESS;
    }

    /**
     * 跳转到借书详情页
     * @return
     */
    @Action(
            value = "jumpBorrowdBook",
            results = @Result(location = "borroweBook.jsp" )
    )
    public  String jumpBorrowBook(){
        System.out.println("跳转到页面成功,获取到的图书id是："+borrowbook.getBid());
        ServletActionContext.getRequest().getSession().setAttribute("addBook",bookService.findBookById(borrowbook.getBid()));
        return SUCCESS;
    }

    public Borrowbook getModel() {
        return borrowbook;
    }
}

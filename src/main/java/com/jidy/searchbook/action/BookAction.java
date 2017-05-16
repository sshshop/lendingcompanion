package com.jidy.searchbook.action;


import com.jidy.searchbook.service.BookService;
import com.lj.bookcomment.service.BookCommentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.utils.PageBean;
import com.upublic.vo.Book;
import com.upublic.vo.Bookcomment;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jidy on 2017/5/8.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class BookAction extends ActionSupport implements ModelDriven<Book> {
    //获取前台页面的值
    private String inputInfo;
    //注入Service
    @Resource(name = "bookService")
    private BookService bookService;
    @Resource(name = "bookCommentService")
    private BookCommentService bookCommentService;
    private int page=1;//分页查询当前页数

    public void setPage(int page) {
        this.page = page;
    }

    public String getInputInfo() {
        return inputInfo;
    }

    public void setInputInfo(String inputInfo) {
        this.inputInfo = inputInfo;
    }

    //将前台页面获取的值转换为对象
    Book book = new Book();

    /**
     * 返回驱动模型
     * @return
     */
    public Book getModel() {
        return book;
    }

    //查询页面
    @Action(value = "search",
            results = @Result(name = "searchbook", location = "search.jsp"))
    public String searchBook() {
        return "searchbook";
    }

    //跳转页面
    @Action(value = "searchBookInfo",
            results = {
                    @Result(name = "searchBookFail", location = "search.jsp"),
                    @Result(name = "searchBookSuccess", location = "index.jsp")
            })
    public String searchBookInfo() {
        /*关键字、拼音全拼、首字母、图书编号、出版社、作者等搜索书籍
        bname、initials、fight、bnum、badr、bauthor*/
        book.setBname(inputInfo);
        book.setInitials(inputInfo);
        book.setFight(inputInfo);
        book.setBnum(inputInfo);
        book.setBauthor(inputInfo);
        book.setBadr(inputInfo);
        List<Book> list = bookService.searchBookInfo(book);
        for (Book book : list) {
            System.out.print("书名：" + book.getBname() + "  作者：");
            System.out.println(book.getBauthor());
        }
        if (list != null || list.size() > 0) {
            ActionContext.getContext().put("list", list);
            ActionContext.getContext().getValueStack().set("Booklist", list);
            return "searchBookSuccess";
        } else {
            this.addActionError("没有查询到图书信息");
            return "searchBookFail";

        }
    }

    /**
     * 通过图书bid查询图书的详细信息。此action用于构建图书详情页
     *
     * @return 返回不同页面
     */
    @Action(
            value = "findBookBybid",
            results = {
                    @Result(name = "findfail", location = "notFind.jsp"),
                    @Result(name = "findsuccess", location = "bookdetail.jsp"),
                    @Result(name = "login", location = "login.jsp")
            }
    )
    public String findBookByBid() {
        System.out.println(book.getBid());
        book = bookService.findBookById(book.getBid());
        ActionContext.getContext().getValueStack().set("bookcommentPageBean",bookCommentService.findCommentByBId(book.getBid(),page));
        PageBean<Bookcomment> bookcommentPageBean=bookCommentService.findCommentByBId(book.getBid(),page);
        System.out.println(bookcommentPageBean.getList().get(0).getInf());
        if (book == null) {
            return "findfail";
        } else {
            this.addActionMessage("书籍详情");
            return "findsuccess";
        }

    }


}

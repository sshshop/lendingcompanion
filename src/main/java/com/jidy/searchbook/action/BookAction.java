package com.jidy.searchbook.action;


import com.jidy.searchbook.service.BookService;
import com.jidy.searchbook.utils.SearchRegex;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.utils.PageBean;
import com.upublic.vo.Book;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.lj.bookcomment.service.BookCommentService;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by jidy on 2017/5/8
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class BookAction extends ActionSupport implements ModelDriven<Book> {
    //注入Service
    @Resource(name = "bookService")
    private BookService bookService;
    //注入bookCommentService
    @Resource(name = "bookCommentService")
    private BookCommentService bookCommentService;

    //将前台页面获取的值转换为对象
    Book book = new Book();
    //获取前台页面的值
    private String inputInfo;
    private Integer page = 1;
    //将字符串匹配
    SearchRegex searchRegex = new SearchRegex();

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }

    public String getInputInfo() {
        return inputInfo;
    }

    public void setInputInfo(String inputInfo) {
        this.inputInfo = inputInfo;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }



    @Action(value = "search", results = {
            @Result(name = "searchBook", location = "search.jsp")
    })
    public String searchBook() {
        return "searchBook";
    }

    @Action(value = "searchBookInfo",
            results = {
                    @Result(name = "searchBookFail", location = "search.jsp"),
                    @Result(name = "searchBookSuccess", location = "search.jsp")
            })
    public String searchBookInfo() {
        /*关键字、拼音全拼、首字母、图书编号、出版社、作者等搜索书籍
        bname、initials、fight、bnum、badr、bauthor
        */
        //跳转页面
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("inputInfo", inputInfo);//将输入信息传至前端
        List<Book> list = new ArrayList<Book>();
        List<Book> bookList = new ArrayList<Book>();
        Map map = new HashMap();
        String search = searchRegex.searchMaster(inputInfo);//第一次匹配
        //如果输入不为空进行第一次查询
        if (search.length() != 0) {
            book = bookInfo(search);//获取book对象
            PageBean<Book> pageBean = bookService.findByPage(book, page);
            list.addAll(pageBean.getList());
            //如果查询为空进行第二次查询
            if (list == null || list.size() <= 0) {
                book = bookInfo(searchRegex.searchFinal(inputInfo));//第二次匹配
                pageBean = bookService.findByBname(book, page);
                list.addAll(pageBean.getList());
            }
            bookList = uniq(list);//去重并保持排序
            System.out.println(bookList.get(0).getBid());
            ActionContext.getContext().getValueStack().set("pageBean", pageBean);
            if (bookList != null && bookList.size() > 0) {
                ActionContext.getContext().getValueStack().set("BookList", bookList);
                return "searchBookSuccess";
            } else {
                this.addActionMessage("没有查询到图书信息");
                return "searchBookFail";
            }

        }
        this.addActionMessage("请输入查询数据");
        return "searchBookFail";
    }

    //初始化book，给book赋值
    private Book bookInfo(String search) {
        book.setBname(search);
        book.setInitials(search);
        book.setFight(search);
        book.setBnum(search);
        book.setBauthor(search);
        book.setBadr(search);
        return book;
    }

    //去重
    private List<Book> uniq(List<Book> list) {
        List<Book> listWithoutDup = new ArrayList(new LinkedHashSet(list));
        return listWithoutDup;
    }

    //第二次判断,初始化book，给book赋值
    private Book bookInfo(String[] search) {
        book.setBname(search[0]);
        book.setInitials(search[1]);
        book.setBauthor(search[2]);
        book.setFight(search[3]);
        book.setBadr(search[4]);
        book.setBnum(search[5]);
        return book;
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
        book = bookService.findBookById(book.getBid());
        ActionContext.getContext().getValueStack().set("pageBean", bookCommentService.findCommentByBId(book.getBid()));
        //差一个功能
        if (book == null) {
            return "findfail";
        } else {
            this.addActionMessage("书籍详情");
            return "findsuccess";
        }

    }


    public Book getModel() {
        return book;
    }
}

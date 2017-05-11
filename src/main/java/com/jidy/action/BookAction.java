package com.jidy.action;


import com.jidy.service.BookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.upublic.vo.Book;
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
public class BookAction extends ActionSupport{
    //获取前台页面的值
    private String bname;
    public String getBname() {
        return bname;
    }
    public void setBname(String bname) {
        this.bname = bname;
    }
    //注入Service
    @Resource(name = "bookService")
    private BookService bookService;

    //查询页面
    @Action(value = "search",
            results = @Result(name = "searchBook",location = "search.jsp"))
    public String searchBook(){
        return "searchBook";
    }

    //跳转页面
    @Action(value="searchBookInfo",
            results={
            @Result(name="searchBookFail",location = "login.jsp"),
            @Result(name="searchBookSuccess",location = "index.jsp")
            })
    public String searchBookInfo(){
        List<Book> list=bookService.searchBookInfo(bname);
        if (list==null||list.size()<=0){
            return "searchBookFail";
        } else{
            ActionContext.getContext().put("list", list);
           return "searchBookSuccess";
        }
    }
}

package com.jidy.searchbook.action;


import com.jidy.searchbook.service.BookService;
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
    private String inputInfo;
    public String getInputInfo() {
        return inputInfo;
    }
    public void setInputInfo(String inputInfo) {
        this.inputInfo = inputInfo;
    }

    //将前台页面获取的值转换为对象
    Book book =new Book();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    //注入Service
    @Resource(name = "bookService")
    private BookService bookService;

    //查询页面
    @Action(value = "search",
            results = @Result(name = "searchbook",location = "search.jsp"))
    public String searchBook(){
        return "searchbook";
    }

    //跳转页面
    @Action(value="searchBookInfo",
            results={
            @Result(name="searchBookFail",location = "search.jsp"),
            @Result(name="searchBookSuccess",location = "index.jsp")
            })
    public String searchBookInfo(){
        /*关键字、拼音全拼、首字母、图书编号、出版社、作者等搜索书籍
        bname、initials、fight、bnum、badr、bauthor*/
        book.setBname(inputInfo);
        book.setInitials(inputInfo);
        book.setFight(inputInfo);
        book.setBnum(inputInfo);
        book.setBauthor(inputInfo);
        book.setBadr(inputInfo);
        List<Book> list=bookService.searchBookInfo(book);
        for (Book book:list) {
            System.out.print("书名："+book.getBname()+"  作者：");
            System.out.println(book.getBauthor());
        }
        if (list!=null||list.size()>0){
            ActionContext.getContext().put("list", list);
            ActionContext.getContext().getValueStack().set("Booklist", list);
            return "searchBookSuccess";
        }
        else{
            this.addActionError("没有查询到图书信息");
            return "searchBookFail";

        }
    }

}

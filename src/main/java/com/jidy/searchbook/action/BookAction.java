package com.jidy.searchbook.action;


import com.jidy.recentsearch.service.RecentSearchService;
import com.jidy.searchbook.service.BookService;
import com.jidy.utils.HashCode;
import com.jidy.utils.KeyWord;
import com.jidy.utils.KeyWordRed;
import com.jidy.utils.SearchRegex;
import com.lj.category.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.utils.PageBean;
import com.upublic.vo.Book;
import com.upublic.vo.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;

import com.lj.bookcomment.service.BookCommentService;

import javax.annotation.Resource;
import java.util.*;

import static com.jidy.utils.HashCode.findMaxString;

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
    //注入分类categoryService
    @Resource(name = "categoryService")
    private CategoryService categoryService;
    //将用户搜索信息插入搜索表
    @Resource(name = "recentSearchService")
    private RecentSearchService recentSearchService;
    //将前台页面获取的值转换为对象
    Book book = new Book();
    //获取前台页面的值
    private String inputInfo;
    private Integer page = 1;
    //匹配字符串
    SearchRegex searchRegex = new SearchRegex();
    //关键字标红
    KeyWordRed<Book> keyWordRed=new KeyWordRed<Book>();
    //获取查询的关键字
    KeyWord keyWord=new KeyWord();

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

    /*
    *  关键字、拼音全拼、首字母、图书编号、出版社、作者等搜索书籍
    * bname、initials、fight、bnum、badr、bauthor
    * 跳转页面
    *
    * */

    @Action(value = "searchBookInfo",
            results = {
                    @Result(name = "searchBookFail", location = "search.jsp"),
                    @Result(name = "searchBookSuccess", location = "search.jsp")
            })
    public String searchBookInfo() {
        List<Book> list = new ArrayList<Book>();//接收搜索结果
        List<Book> bookList = new ArrayList<Book>();//返回结果到页面
        List<Book> recentSearch=new ArrayList<Book>();//接收最近搜索结果
        String search = searchRegex.searchMaster(inputInfo);//第一次匹配
        if (search.length() == 0) {
            this.addActionMessage("请输入查询数据");
            return "searchBookFail";
        }else{
            //如果输入不为空进行第一次查询
            book = keyWord.bookInfoMaster(inputInfo);
            PageBean<Book> pageBean = bookService.findByPage(book, page);
            if (pageBean.getList().size() <= 0 || pageBean.getList() == null) {
                book = keyWord.bookInfoMaster(search);//获取book对象
                pageBean = bookService.findByPage(book, page);
                //如果查询为空进行第二次查询
                if (pageBean.getList().size() <= 0 || pageBean.getList() == null) {
                    String string[] = searchRegex.searchFinal(inputInfo);
                    book = keyWord.bookInfoFinal(string);//第二次匹配
                    pageBean = bookService.findByBname(book, page);
                }
            }
            /*
            * 将关键字加粗标红
            * */
            list.addAll(keyWordRed.replaceList(pageBean.getList(), inputInfo));
            bookList = keyWord.uniq(list);//去重并保持排序
            //将登陆用户搜索数据插入搜索表
            if (bookList != null && bookList.size() > 0) {
                User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
                if (user != null) {
                    int uid = user.getUid();
                    if (!inputInfo.equals(" ")&&inputInfo!=null){
                        recentSearchService.insertSearchKeyword(uid, inputInfo);
                    }
                    List<String> strings = recentSearchService.findSearchKeyword(uid);
                    for (String string : strings) {
                        recentSearch.addAll(recentSearchService.recentSearchBookMaster(searchRegex.searchMaster(string)));
                    }
                    Set<Book> books = new HashSet<Book>();
                    books.addAll(recentSearch);
                    ActionContext.getContext().getValueStack().set("recentSearchBook", books);
                } else {
                    HashCode hashCode=new HashCode();
                    List<String> listA=recentSearchService.findAllKeyword();
                    List<String> listB=new ArrayList<String>();
                    listB.add("");
                    listA.removeAll(listB);
                    String[] strings=new String[listA.size()];
                    for (int i = 0; i < listA.size(); i++) {
                        strings[i]=listA.get(i);
                    }
                    String s[]=hashCode.findMaxString(strings);
                    recentSearch.addAll(recentSearchService.recentSearchBookFinal(s[s.length-1]));
                    if (recentSearch.size()<6){
                        recentSearch.addAll(recentSearchService.recentSearchBookFinal(s[s.length-2]));
                        if (recentSearch.size()<8){
                            recentSearch.addAll(recentSearchService.recentSearchBookFinal(s[s.length-3]));
                        }
                    }
                    Set<Book> books = new HashSet<Book>();
                    books.addAll(recentSearch);
                    ActionContext.getContext().getValueStack().set("recentSearchBook", books);
                }
                ActionContext.getContext().getValueStack().set("BookList", bookList);
                ActionContext.getContext().getValueStack().set("pageBean", pageBean);
                return "searchBookSuccess";
            }else {
                this.addActionMessage("没有查询到图书信息");
                return "searchBookFail";}
        }
    }

    /*
    * 根据作者名查询图书信息
    *
    *参数为作者名
    * */
    @Action(value = "findAuthor",results = {
            @Result(name = "find",location = "search.jsp")
    })
    public String findAuthor(){
        System.out.println("作者的搜索"+book.getBauthor());
        List<Book> recentSearch=new ArrayList<Book>();
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (user != null) {
            int uid = user.getUid();
            List<String> strings = recentSearchService.findSearchKeyword(uid);
            for (String string : strings) {
                recentSearch.addAll(recentSearchService.recentSearchBookMaster(searchRegex.searchMaster(string)));
            }
            Set<Book> books = new HashSet<Book>();
            books.addAll(recentSearch);
            ActionContext.getContext().getValueStack().set("recentSearchBook", books);
        } else {
            HashCode hashCode=new HashCode();
            List<String> listA=recentSearchService.findAllKeyword();
            String[] strings=new String[listA.size()];
            List<String> listB=new ArrayList<String>();
            listB.add("");
            listA.removeAll(listB);
            for (int i = 0; i < listA.size(); i++) {
                strings[i]=listA.get(i);
            }
            Set<Book> books = new HashSet<Book>();
            String s[]=hashCode.findMaxString(strings);
            recentSearch.addAll(recentSearchService.recentSearchBookFinal(s[s.length-1]));
            if (recentSearch.size()<6){
                recentSearch.addAll(recentSearchService.recentSearchBookFinal(s[s.length-2]));
                if (recentSearch.size()<8){
                    recentSearch.addAll(recentSearchService.recentSearchBookFinal(s[s.length-3]));
                }
            }
            books.addAll(recentSearch);
            ActionContext.getContext().getValueStack().set("recentSearchBook", books);
        }
        String ss=searchRegex.splitRed(book.getBauthor());
        List<Book> list=keyWordRed.replaceListB(bookService.findAuthor(ss),ss);
        ActionContext.getContext().getValueStack().set("BookList",list);
        return "find";
    }

    /**
     * 通过图书bid查询图书的详细信息。此action用于构建图书详情页
     *
     * @return 返回不同页面
     */
    @Action(
            value = "findBookBybid",
            results = {
                    @Result(name = ERROR, location = "index.action", type = "redirect"),
                    @Result(location = "bookdetail.jsp"),
            },
            exceptionMappings = {
                    //映射映射声明
                    @ExceptionMapping(exception="java.lang.Exception",result=ERROR)
            }
    )
    public String findBookByBid() {
        Integer bid= (Integer) ServletActionContext.getRequest().getSession()
                .getAttribute("bid");
        if (bid!=null){
            book.setBid(bid);
            ServletActionContext.getRequest().getSession().removeAttribute("bid");
            // ServletActionContext.getRequest().getSession().setAttribute("bid",null);
        }
        book = bookService.findBookById(book.getBid());
        ActionContext.getContext().getValueStack().set("pageBean", bookCommentService.findCommentByBId(book.getBid()));
        ActionContext.getContext().getValueStack().set("category",categoryService.findBookByCidSome(book.getCid()) );
        if (book == null) {
            return ERROR;
        } else {
            this.addActionMessage("书籍详情");
            return SUCCESS;
        }

    }
    public Book getModel() {
        return book;
    }
}

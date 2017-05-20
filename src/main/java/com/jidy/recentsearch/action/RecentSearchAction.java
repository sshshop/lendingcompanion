package com.jidy.recentsearch.action;

import com.jidy.recentsearch.service.RecentSearchService;
import com.jidy.searchbook.service.BookService;
import com.jidy.utils.SearchRegex;
import com.opensymphony.xwork2.ActionContext;
import com.upublic.vo.Book;
import com.upublic.vo.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jidy on 2017/5/19.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class RecentSearchAction {
    @Resource(name = "recentSearchService")
    RecentSearchService recentSearchService;
    SearchRegex searchRegex=new SearchRegex();


    /*
    * 插入搜索表
    *
    * 返回值为空
    * */
     public void insertSearchKeyword(Integer uid, String scontent){
      //  User user= (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
       //  ServletActionContext.getRequest().getSession().getAttribute("scontent");
       /// System.out.println("插入:"+user.getUid());
       //  System.out.println("插入:"+scontent);
         recentSearchService.insertSearchKeyword(uid,scontent);
     }

    /*
    * 读取历史查询书籍,通过用户id获取search表搜索关键字
    * 关键字 scontent
    *
    * 返回值为book集合的列表
    *
    * */
    @Action(value = "rececnt",results = {
            @Result(name = "recentSearch",location = "search.jsp")
    })
    public String recentSearchBook(Integer uid){
        List<Book> list=new ArrayList<Book>();
        User user= (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if(user!=null){
            String str[]=recentSearchService.findSearchKeyword( user.getUid());
            for (int i = 0; i <str.length ; i++) {
             list.addAll(recentSearchService.recentSearchBook(searchRegex.searchMaster(str[i])));
                if (list.size()<6){
                    list.addAll(recentSearchService.recentSearchBook(searchRegex.searchFinal(str[i])));
                }
            }
            ActionContext.getContext().getValueStack().set("recentSearchBook",list);
        }
        return "recentSearch";

    }
}

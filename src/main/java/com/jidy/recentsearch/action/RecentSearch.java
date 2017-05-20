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

public class RecentSearch {
    //注入资源
    @Resource(name = "recentSearchService")
    RecentSearchService recentSearchService;
    SearchRegex searchRegex=new SearchRegex();

    /*
    * 插入搜索表
    *
    * 返回值为空
    * */
     public void insertSearchKeyword(Integer uid, String scontent){
         recentSearchService.insertSearchKeyword(uid,scontent);
     }


}

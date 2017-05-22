package com.jidy.recentsearch.service;

import com.jidy.recentsearch.dao.RecentSearchDao;
import com.jidy.utils.HashCode;
import com.jidy.utils.SearchRegex;
import com.upublic.vo.Book;
import org.springframework.stereotype.Service;
import com.jidy.utils.SearchRegex;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jidy on 2017/5/19.
 */
@Service(value = "recentSearchService")
public class RecentSearchService {
    //注入资源
    @Resource(name = "recentSearchDao")
    RecentSearchDao recentSearchDao;

    SearchRegex searchRegex=new SearchRegex();
    /**
     * 将用户搜索关键字插入用户搜索表
     *
     * 返回值为空
     * */
    public void insertSearchKeyword(Integer uid, String scontent) {
        recentSearchDao.insertSearchBook(uid,scontent);
    }

    /*
    * 查询关键字
    *
    * 返回值为关键字数组
    * */
    public List<String> findSearchKeyword(Integer uid) {
        return recentSearchDao.findSearchKeyword(uid);
    }

    /*
    * 关键字查询
    *
    * 返回最近搜索的图书列表
    * */
    public List<Book> recentSearchBookMaster(String keyWord) {
        return recentSearchDao.recentSearchBookMaster(keyWord);
    }

    /*
    * 关键字查询
    *
    * 返回最近搜索的图书列表
    * */
    public List<Book> recentSearchBookFinal(String keyword) {
        return recentSearchDao.recentSearchBookFinal(keyword);

    }

    /*
    * 查询关键字
    *
    * 返回所有用户所有搜索关键字
    *
    * */
    public List<String> findAllKeyword(){
        return recentSearchDao.findAllKeyword();
    }


}

package com.jidy.recentsearch.service;

import com.jidy.recentsearch.dao.RecentSearchDao;
import com.upublic.vo.Book;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jidy on 2017/5/19.
 */
@Service(value = "recentSearchService")
public class RecentSearchService {
    @Resource(name = "recentSearchDao")
    RecentSearchDao recentSearchDao;
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
    public String[] findSearchKeyword(Integer uid) {
        return recentSearchDao.findSearchKeyword(uid);
    }

    /*
    * 关键字查询<第一次查询>
    *
    * 返回最近搜索的图书列表
    * */
    public List<Book> recentSearchBook(String keyWord) {
        return recentSearchDao.recentSearchBook(keyWord);
    }

    /*
    * 关键字查询<第二次查询>
    *
    * 返回最近搜索的图书列表
    * */
    public List<Book> recentSearchBook(String keyWord[]) {
        return recentSearchDao.recentSearchBook(keyWord);
    }


}

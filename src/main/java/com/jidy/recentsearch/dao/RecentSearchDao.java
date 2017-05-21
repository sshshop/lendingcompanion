package com.jidy.recentsearch.dao;

import com.jidy.utils.SearchBookSqlProvider;
import com.upublic.vo.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jidy on 2017/5/19.
 */

public interface RecentSearchDao {
    /*
    * 插入用户搜索关键字
    * */
    @Insert("insert into search(uid,scontent,stime) values(#{uid},#{scontent},now())")
    void insertSearchBook(@Param("uid") Integer uid,@Param("scontent") String scontent);

    /*
    * 查询用户搜索关键字
    *
    * 最多查询五条，按时间排序
    *
    * 返回关键字数组
    * */
    @Select("select scontent from search where uid=#{uid} order by stime desc LIMIT 5")
    List<String> findSearchKeyword(Integer uid);

    /*
    * 搜索图书列表<第一次>
    * */
    @Select("select * from book where bname REGEXP #{bname}  order by bname LIMIT 6")
    public List<Book> recentSearchBookMaster(@Param("bname") String keyWord);

    /*
    * 搜索图书列表<第二次>
    * */
    //@SelectProvider(type = SearchBookSqlProvider.class ,method = "")
    @Select("select * from book where bname REGEXP #{bname}  order by bname LIMIT 6")
    public List<Book> recentSearchBookFinal(@Param("bname") String keyWord);
}

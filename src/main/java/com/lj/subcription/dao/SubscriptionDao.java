package com.lj.subcription.dao;

import com.upublic.vo.Book;
import com.upublic.vo.Subscription;
import com.upublic.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by SJ on 2017/5/6.
 */
public interface SubscriptionDao {
    /**
     * 通过用户id和图书id查询在订阅表的数量信息
     * @param user 用户实体类，提供用户uid
     * @param subscription 收藏实体类，提供图书bid
     * @return 返回该本书的收藏数量，若有收藏基本返回1，无收藏返回0
     */
    @Select("select COUNT(*) from subscription where uid=#{user.uid} and bid=#{subscription.bid}")
    int selectSubAll(@Param("user") User user, @Param("subscription") Subscription subscription);

    /**
     * 插入收藏信息
     * @param user 用户实体类，提供用户uid
     * @param subscription 收藏实体类，提供图书bid
     * @return 返回一个整形，插入成功返回1，失败返回0
     */
    @Insert("INSERT INTO subscription VALUES(#{user.uid},#{subscription.bid})")
    int addSubscrition(@Param("user") User user, @Param("subscription") Subscription subscription);


    /**
     * 通过用户id查询用户收藏的书籍信息，图书的详细信息
     * @param user user 用户实体类，提供用户uid
     * @return 返回的是收藏的实体封装集合，subscription属性list是图书的封装
     */
    @Select("SELECT * FROM subscription WHERE uid=#{user.uid}")
    @Results(value = {
            @Result(column = "bid", property = "bid"),
            @Result(column = "bid", property = "list", many = @Many(select = "com.jidy.searchbook.dao.BookDao.findBookById"))
    }
    )
    List<Subscription> findSubBooks(@Param("user") User user);
}

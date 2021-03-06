package com.lj.borrowbook.dao;

import com.upublic.utils.sqlFactory;
import com.upublic.vo.Book;
import com.upublic.vo.Borrowbook;
import com.upublic.vo.User;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.util.List;

/**
 * Created by CD on 2017/5/7.
 */
public interface BorrowbookDao {

    /**
     * 插入借书的信息，借书状态初始化为1，为已交押金未取书
     *
     * @param borrowbook 图书id封装
     */
    @Insert("INSERT INTO borrowbook(uid,bid,btime,rtime,bstatus,ttime,money)values(#{borrowbook.uid},#{borrowbook.bid},now(),#{borrowbook.rtime},1,#{borrowbook.ttime},0)")
    void insertBorrowdbook(@Param("borrowbook") Borrowbook borrowbook);

    /**
     * 查询用户现在正在借书的状态的数量，即用户的现在正在借阅的书籍数量
     *
     * @param user 用户实体类封装，提供用户id
     * @return 返回整形数据
     */
    @Select("SELECT COUNT(*) FROM borrowbook WHERE uid=#{user.uid} AND bstatus<3 ")
    int selectCountBorrowBook(@Param("user") User user);

    /**
     * 更新图书表的字段，将未借阅量减1，历史借阅量加1
     *
     * @param borrowbook 图书id的封装
     * @return 返回更新的条数，一般是1
     */
    @Select("UPDATE book SET nborrowed=nborrowed-1,hborrowed=hborrowed+1 WHERE bid=#{borrowbook.bid}")
    void updateBookNborrow(@Param("borrowbook") Borrowbook borrowbook);

    /**
     * 查询用户当前书籍的借阅数量
     *
     * @param user       用户id封装
     * @param borrowbook 图书id封装
     * @return 返回数量
     */
    @Select("SELECT COUNT(*) FROM borrowbook WHERE bstatus<3 AND uid=#{user.uid} AND bid=#{borrowbook.bid}")
    int existBorrMsg(@Param("user") User user, @Param("borrowbook") Borrowbook borrowbook);

    /**
     * 通过用户id差询用户的借书的信息，其中包括书籍的信息等
     *
     * @param user 用户的书籍信息封装
     * @return 返回封装的用户借书的信息
     */
    @Select("SELECT * FROM borrowbook WHERE uid=#{user.uid} ORDER BY btime DESC")
    @Results(value = {
            @Result(column = "bid", property = "bid"),
            @Result(column = "bid", property = "list", many = @Many(select = "com.jidy.searchbook.dao.BookDao.findBookById"))
    }
    )
    List<Borrowbook> findBorrowedBookByUid(@Param("user") User user);

    @Select("SELECT * FROM borrowbook WHERE uid=#{uid}")
    List<Borrowbook> findborrowedBookByUid(@Param("uid") Integer uid);

    @Delete("DELETE FROM borrowbook WHERE uid=#{uid}")
    void deleteUser(@Param("uid") Integer uid);

    /**
     * 根据用户id查询用户借书的信息，级联查询图书详情，用于后台,
     *
     * @param user 用户的uid
     * @return
     */
    @Select("SELECT * FROM borrowbook WHERE uid=#{user.uid} ORDER BY btime DESC")
    @Results(value = {
            @Result(column = "uid", property = "uid"),
            @Result(column = "uid", property = "userList", many = @Many(select = "com.lyj.user.dao.UserDao.findBoorUserByUid")),
            @Result(column = "bid", property = "bid"),
            @Result(column = "bid", property = "list", many = @Many(select = "com.jidy.searchbook.dao.BookDao.findBookById"))
    }
    )
    List<Borrowbook> findBorroewByUid(@Param("user") User user);

    /**
     * 根据图书id查询图书的借书信息，包括显示用户个人信息
     *
     * @param book 图书的bid
     * @return
     */
    @Select("SELECT * FROM borrowbook WHERE bid=#{book.bid} ORDER BY btime DESC")
    @Results(value = {
            @Result(column = "uid", property = "uid"),
            @Result(column = "uid", property = "userList", many = @Many(select = "com.lyj.user.dao.UserDao.findBoorUserByUid")),
            @Result(column = "bid", property = "bid"),
            @Result(column = "bid", property = "list", many = @Many(select = "com.jidy.searchbook.dao.BookDao.findBookById"))
    }
    )
    List<Borrowbook> findBorrowedByBid(@Param("book") Book book);

    @Select("SELECT * FROM borrowbook ORDER BY btime DESC")
    @Results(value = {
            @Result(column = "uid", property = "uid"),
            @Result(column = "uid", property = "userList", many = @Many(select = "com.lyj.user.dao.UserDao.findBoorUserByUid")),
            @Result(column = "bid", property = "bid"),
            @Result(column = "bid", property = "list", many = @Many(select = "com.jidy.searchbook.dao.BookDao.findBookById"))
    }
    )
    List<Borrowbook> findBorrowedALLByBid();

    @UpdateProvider(type = sqlFactory.class, method = "updateBorrSql")
    int updatBorrowedStatus(Borrowbook borrowbook);

    @Select("SELECT bid FROM borrowbook WHERE bbid=#{bbid}")
    @Results(value = {
            @Result(column = "bid",property = "bid"),
            @Result(column = "bid",property = "book",one = @One(select = "com.jidy.searchbook.dao.BookDao.findBookById"))
    })
    Borrowbook findbook(Integer bbid);
}

package com.lj.bookcomment.dao;

import com.upublic.utils.PageParents;
import com.upublic.vo.Bookcomment;
import com.upublic.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by SJ on 2017/5/6.
 * 书评的dao
 */
public interface BookcommentDao extends PageParents<Bookcomment> {
    /**
     * 根据书籍id查询图书的书评的总量
     *
     * @param id 图书的主键bid
     * @return 书评的数量
     */
    @Select("SELECT COUNT(*) FROM bookcomment WHERE bid=#{id}")
    int findCountByid(Integer id);

    /**
     * 根据图书id查询所有用户的书评信息
     * @param bid 图书id
     * @return 返回集合
     */
    @Select("SELECT uid,bctime,inf,username FROM bookcomment WHERE bid=#{bid} ORDER BY bctime DESC")
    List<Bookcomment> findCommentByBId(@Param("bid") Integer bid);

    /**
     * 通过用户id查询用户评价的信息和书籍信息
     * @param user user 用户实体类，提供用户uid
     * @return 返回的是评价Bookcomment的实体封装集合，subscription属性list是图书的封装
     */
    @Select("SELECT * FROM bookcomment WHERE uid=#{user.uid}")
    @Results(value = {
            @Result(column = "bid", property = "bid"),
            @Result(column = "bid", property = "list", many = @Many(select = "com.jidy.searchbook.dao.BookDao.findBookById"))
    }
    )
    List<Bookcomment> findCommentByUId(@Param("user") User user);
}

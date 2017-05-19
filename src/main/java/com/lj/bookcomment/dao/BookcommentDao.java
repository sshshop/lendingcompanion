package com.lj.bookcomment.dao;

import com.upublic.utils.PageParents;
import com.upublic.vo.Bookcomment;
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
    List<Bookcomment> findCommentByBId(Integer bid);
}

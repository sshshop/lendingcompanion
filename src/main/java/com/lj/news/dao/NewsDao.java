package com.lj.news.dao;

import com.upublic.vo.News;
import com.upublic.vo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 消息dao类
 * Created by Rabit on 2017/5/22.
 */
public interface NewsDao {
    /**
     * 通过用户id查询用户当前的所有消息
     * @param user 用户实体类的封装，提供uid
     * @return 消息的集合
     */
    @Select("SELECT * FROM news WHERE uid=#{user.uid}")
    List<News> findNewByUid(@Param("user") User user);
}

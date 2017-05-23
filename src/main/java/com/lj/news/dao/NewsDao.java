package com.lj.news.dao;

import com.upublic.vo.News;
import com.upublic.vo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 根据消息id删除消息
     * @param news 消息实体类，提供消息id
     */
    @Delete("DELETE FROM news WHERE nid=#{news.nid}")
    void delNew(@Param("news") News news);

    /**
     * 更新消息阅读状态
     * @param news
     */
    @Update("UPDATE news SET nstatus=1 WHERE nid=#{news.nid}")
    void updatStatus(@Param("news") News news);


    @Select("SELECT * FROM news WHERE uid=#{uid}")
    List<News> findNewsByUid(@Param("uid") Integer uid);

    @Delete("DELETE FROM news WHERE uid=#{uid}")
    void deleteUser(@Param("uid") Integer uid);
}

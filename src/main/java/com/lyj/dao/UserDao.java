package com.lyj.dao;


import com.upublic.vo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by 盖世太保 on 2017/5/7.
 * 用户登录的方法
 */

public interface UserDao   {
    @Select("select * FROM user WHERE state=1 AND username=#{username} AND upassword=#{upassword}")
    List<User> findUserAll(@Param("username") String username, @Param("upassword") String upassword);

    /**
     * 根据用户id查询用户名，用户书评表的关联查询rabit
     * @param uid 用户主键uid
     * @return  用户实例
     */
    @Select("SELECT username FROM `user` WHERE uid=#{uid}")
    User findUserNameByid(@Param("uid") Integer uid);




}

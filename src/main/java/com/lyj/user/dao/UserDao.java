package com.lyj.user.dao;


import com.upublic.vo.Province;
import com.upublic.vo.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.Date;
import java.util.List;

/**
 * Created by 盖世太保 on 2017/5/7.
 * 用户登录的方法
 */

public interface UserDao  {
    //登录用户名密码校验
    @Select("select * FROM user WHERE state=1 AND username=#{username} AND upassword=#{upassword}"  )
    List<User> findUserAll(@Param("username") String username, @Param("upassword") String upassword);

    //注册用户名校验存在
    @Select("select username FROM user WHERE username=#{username}")
    List<User> findUsernameAll(@Param("username") String username);

    //用户注册数据插入
    @Insert("INSERT INTO user(username,upassword,sex,dob,phone,pid,cid,addr,email,code)" +
            "VALUES(#{username},#{upassword},#{sex},#{dob},#{phone},#{pid},#{cid},#{addr},#{email},#{code})")
    void save(@Param("username") String username,
              @Param("upassword") String upassword,
              @Param("sex") int sex,
              @Param("dob") Date dob,
              @Param("phone") String phone,
              @Param("pid") int pid,
              @Param("cid") int cid,
              @Param("addr") String addr,
              @Param("email") String email,
              @Param("code") String code);

    //注册激活码查询
    @Select("select * FROM user WHERE code=#{code}")
    User findBycode(@Param("code") String code);
    @Update("UPDATE user SET state=1,code='' WHERE uid=#{existUser.uid}")
    void update(@Param("existUser") User existUser);

    /*@Insert("INSERT INTO user(username,upassword,sex,dob,phone,pid,cid,addr,email)" +
            "VALUES(#{user.username},#{user.upassword},#{user.sex},#{user.dob},#{user.phone},#{user.pid},#{user.cid},#{user.addr},#{user.email})")
    void savetest(@Param("user") User user);*/
}

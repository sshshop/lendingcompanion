package com.lyj.user.dao;


import com.upublic.utils.sqlFactory;
import com.upublic.vo.User;

import org.apache.ibatis.annotations.*;


import java.util.Date;
import java.util.List;

/**
 * Created by 盖世太保 on 2017/5/7.
 * 用户登录的方法
 */

public interface UserDao {
    //登录用户名密码校验
    @Select("select * FROM user WHERE state=1 AND username=#{username} AND upassword=#{upassword}")
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

    @Select("select * FROM user WHERE uid=#{user.uid}")
    @Results(value = {
            @Result(column = "cid", property = "cid"),
            @Result(column = "pid", property = "pid"),
            @Result(column = "cid", property = "city", one = @One(select = "com.lyj.city.dao.CityDao.findNameBycid")),
            @Result(column = "pid", property = "province", one = @One(select = "com.lyj.province.dao.ProvinceDao.findNameByPid"))
    })
    User findUserByUid(@Param("user") User user);

    /**
     * 动态sql修改用户邮箱或者电话号码的测试
     * @param user 用户的实例化对象：邮箱、电话号码二者传其一或者全部传入即可
     * @return 返回修改的结果，成功是1，失败是0
     */
    @UpdateProvider(type = sqlFactory.class, method = "updateSql")
    int updateUser(User user);
}

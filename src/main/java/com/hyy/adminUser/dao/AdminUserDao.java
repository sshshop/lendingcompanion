package com.hyy.adminUser.dao;

import com.upublic.vo.Admuser;
import com.upublic.vo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Scream on 2017/5/20.
 */

@Service(value = "adminUserDao" )
public interface AdminUserDao {
    /**
     *
     * 根据管理员名以及管理员密码查询Admuser中是否有该用户
     * @param auname   管理员名
     * @param apwd  管理员密码
     * @return 管理员对象
     *
     * **/
    @Select("SELECT * FROM admuser WHERE auname=#{auname} AND apwd=#{apwd}")
    List<Admuser> findAdminUser(@Param("auname") String auname, @Param("apwd") String apwd);


    /**
     * 查询所有用户信息
     * @return用户对象
     *
     * */
    @Select("SELECT * FROM user WHERE state = 1")
    List<User> findUserAll();

    /**
     *
     * 根据用户id查询所有用户
     *
     * */
    @Select("SELECT * FROM user WHERE uid=#{uid}")
    User findUserById(@Param("uid") Integer uid);


    @Delete("Delete * From user Where uid=#{uid}")
    void deleteUser(@Param("uid") Integer uid);
}

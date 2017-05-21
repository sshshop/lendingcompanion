package com.hyy.adminUser.dao;

import com.upublic.vo.Admuser;
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

}

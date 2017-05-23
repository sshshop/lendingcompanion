package com.upublic.utils;

import com.upublic.vo.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * 动态sql生成器
 * Created by Rabit on 2017/5/22.
 */
public class sqlFactory {
    /**
     * 动态sql构建方法
     * @param user 传入需要修改的动态sql参数对象，此处为user实例化的类
     * @return 返回的是一个sql语句
     */
    public String updateSql( final User user) {
        return new SQL() {{
            UPDATE("user");
            if (user.getSex() != null) {
                SET("sex=#{sex}");
            }
            if (user.getDob() != null) {
                SET("dob=#{dob}");
            }
            if (user.getAddr() != null) {
                SET("addr=#{addr}");
            }
            if (user.getPid() != null) {
                SET("pid=#{pid}");
            }
            if (user.getCid() != null) {
                SET("cid=#{cid}");
            }
            if (user.getEmail() != null) {
                SET("email=#{email}");
            }
            if (user.getPhone() != null) {
                SET("phone=#{phone}");
            }
            WHERE("uid=#{uid}");
        }}.toString();
    }

    public String saveUsersql( final User user) {
        return new SQL() {{
            INSERT_INTO("user");
            VALUES("username","#{username}");
            VALUES("upassword","#{upassword}");
            VALUES("pid","#{pid}");
            VALUES("email","#{email}");
            VALUES("phone","#{phone}");
            VALUES("state","1");

            if (user.getSex() != null) {
                VALUES("sex","#{sex}");
            }

            if (user.getDob() != null) {
                VALUES("dob","#{dob}");

            }
            if (user.getAddr() != null) {
                VALUES("addr","#{addr}");

            }

            if (user.getCid() != null) {
                VALUES("cid","#{cid}");

            }


        }}.toString();
    }
}

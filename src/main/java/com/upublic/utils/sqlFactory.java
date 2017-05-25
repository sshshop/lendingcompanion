package com.upublic.utils;

import com.upublic.vo.Booktem;
import com.upublic.vo.Borrowbook;
import com.upublic.vo.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * 动态sql生成器
 * Created by Rabit on 2017/5/22.
 */
public class sqlFactory {
    /**
     * 动态sql构建方法
     *
     * @param user 传入需要修改的动态sql参数对象，此处为user实例化的类
     * @return 返回的是一个sql语句
     */
    public String updateSql(final User user) {
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


    public String adminupdateBook(final Booktem booktem) {
        return new SQL() {{
            UPDATE("booktem");
            if (booktem.getBtname() != null) {
                SET("btname=#{btname}");
            }
            if (booktem.getCid() != null) {
                SET("cid=#{cid}");
            }
            if (booktem.getBtauthor() != null) {
                SET("btauthor=#{btauthor}");
            }
            if (booktem.getAdr() != null) {
                SET("adr=#{adr}");
            }
            if (booktem.getNum() != null) {
                SET("num=#{num}");
            }
            if (booktem.getCover() != null) {
                SET("cover=#{cover}");
            }
            if (booktem.getSequence() != null) {
                SET("sequence=#{sequence}");
            }
            if (booktem.getBtcontent() != null) {
                SET("btcontent=#{btcontent}");
            }
            if (booktem.getIdt() != null) {
                SET("idt=#{idt}");
            }
            if (booktem.getCobn() != null) {
                SET("cobn=#{cobn}");
            }
            if (booktem.getMoney() != 0) {
                SET("money=#{money}");
            }
            if (booktem.getTime() != null) {
                SET("time=#{time}");
            }
            WHERE("btid=#{btid}");
        }}.toString();
    }

    public String saveUsersql(final User user) {
        return new SQL() {{
            INSERT_INTO("user");
            VALUES("username", "#{username}");
            VALUES("upassword", "#{upassword}");
            VALUES("pid", "#{pid}");
            VALUES("email", "#{email}");
            VALUES("phone", "#{phone}");
            VALUES("state", "1");

            if (user.getSex() != null) {
                VALUES("sex", "#{sex}");
            }

            if (user.getDob() != null) {
                VALUES("dob", "#{dob}");

            }
            if (user.getAddr() != null) {
                VALUES("addr", "#{addr}");

            }

            if (user.getCid() != null) {
                VALUES("cid", "#{cid}");
            }


        }}.toString();
    }

    public String updateBorrSql(final Borrowbook borrowbook) {
        return new SQL() {{
            UPDATE("borrowbook");
            if (borrowbook.getBstatus() == 2) {
                SET("bstatus=2");
            }
            if (borrowbook.getBstatus() == 3) {
                SET("bstatus=3");
            }
            if (borrowbook.getBstatus() == 4) {
                SET("bstatus=4");
            }
            WHERE("bbid=#{bbid}");
        }}.toString();
    }
}

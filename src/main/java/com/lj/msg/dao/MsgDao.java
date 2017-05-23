package com.lj.msg.dao;

import com.upublic.vo.Msg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * MsgDao类
 * Created by Rabit on 2017/5/23.
 */
public interface MsgDao {
    @Select("select * from msg")
    List<Msg> findMsg();

    @Select("SELECT * FROM msg ORDER BY time DESC LIMIT 1")
    Msg findNewMsg();

    @Delete("delete from msg where mid=#{mid}")
    void deleteMsg(@Param("mid") int mid);
}

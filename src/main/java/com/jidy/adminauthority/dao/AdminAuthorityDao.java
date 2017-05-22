package com.jidy.adminauthority.dao;

import com.upublic.vo.Admuser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by jidy on 2017/5/23.
 */

public interface AdminAuthorityDao {

    @Select("select * from admuser")
    List<Admuser> findAllAdmUser();
    @Update("update admuser set authority=#{authority} where auid=#{auid}")
    void changAuthority(@Param("auid") Integer auid,@Param("authority") Integer authority);
}

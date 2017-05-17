package com.lyj.province.dao;

import com.upublic.vo.Province;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 盖世太保 on 2017/5/11.
 */
public interface ProvinceDao {
    @Select("select pid FROM province WHERE pname=#{pname}")
    Province findPidAll(@Param("pname") String pname);
    @Select("select pid FROM province WHERE pname=#{pname}")
    int selectPid(String pname);
}

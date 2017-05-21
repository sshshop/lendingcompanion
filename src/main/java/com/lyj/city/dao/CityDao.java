package com.lyj.city.dao;

import com.upublic.vo.City;
import com.upublic.vo.Province;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 盖世太保 on 2017/5/11.
 */
public interface CityDao {
    @Select("select cid FROM city WHERE cname=#{cname}")
    City findCidAll(@Param("cname") String cname);

    @Select("select cid FROM city WHERE cname=#{cname}")
    int findCid(String cname);

    @Select("select * FROM city WHERE cid=#{cid}")
    City findNameBycid(Integer cid);
}

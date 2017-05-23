package com.upublic.dao;

import com.upublic.vo.Search;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6.
 */
public interface SearchDao {

    @Select("SELECT * FROM search WHERE uid=#{uid}")
    List<Search> findSearchByUid(@Param("uid") Integer uid);

    @Delete("delete from search where uid=#{uid}")
    void deleteUser(@Param("uid") Integer uid);
}

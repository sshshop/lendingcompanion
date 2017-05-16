package com.upublic.utils;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分页封装所用的父类，在dao层继承复写父类方法即可
 * Created by Rabit on 2017/5/16.
 * @author Rabit
 */
public interface PageParents<T> {

   // List<T> findAll(@Param("begin") Integer begin, @Param("limit") Integer limit);

    int finsCountALL();

    List<T> findAll(@Param("bid") Integer bid, @Param("begin")Integer begin, @Param("limit") Integer limit);

    int findCountByid(Integer id);

}

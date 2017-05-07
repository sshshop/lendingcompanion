package com.lj.category.dao;

import com.upublic.vo.Category;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 盖世太保 on 2017/5/6.
 */
@Service(value = "categoryDao")
public interface CategoryDao {
    @Select("select cid,cname from category")
    List<Category> findCategoryAll();
}

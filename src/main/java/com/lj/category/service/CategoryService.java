package com.lj.category.service;

import com.lj.category.dao.CategoryDao;
import com.upublic.vo.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Rabit on 2017/5/7.
 */
@Service(value = "categoryService")
public class CategoryService {
    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;
    public List<Category> findCategoryAll() {
        return categoryDao.findCategoryAll();
    }
}

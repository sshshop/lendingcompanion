package com.lj.category.service;

import com.lj.category.dao.CategoryDao;
import com.upublic.vo.Book;
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

    /**
     *查询所有分类信息
     * @return 返回分类封装的集合
     */
    public List<Category> findCategoryAll() {
        return categoryDao.findCategoryAll();
    }

    /**
     * 根据分类id查询所有分类下面的图书
     * @return 返回图书的集合
     */
    public List<Book> findBookByCid(Integer cid){
        return categoryDao.findBookByCid(cid);
    }

    public List<Book> findBookByCidSome(Integer cid) {
        return categoryDao.findBookByCidSome(cid);
    }
}

package com.lj.category.dao;

import com.upublic.vo.Book;
import com.upublic.vo.Category;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 盖世太保 on 2017/5/6.
 */
@Service(value = "categoryDao")
public interface CategoryDao {
    /**
     * 查询图书的分类
     * @return
     */
    @Select("select cid,cname from category")
    List<Category> findCategoryAll();

    /**
     *  通过分类的id查询分类的名字，此处用于详情页显示图书分类所用，属于关联查询
     */
    @Select("select * from category where cid=#{cid}")
    @Results(
            {
                    @Result(id = true,column = "cid",property = "cid"),
                    @Result(column = "cname",property = "cname")
            }
    )
    Category findCategoryById(Integer cid);

    /**
     * 根据图书分类id查询所有的该分类下面的图书
     * @param cid 图书的分类id
     * @return  封装图书分类的集合
     */
    @Select("SELECT * FROM book WHERE cid=#{cid} ORDER BY time desc;")
    List<Book> findBookByCid(Integer cid);

    /**
     * 根据图书查询该分类下面的热门书籍
     * @param cid 图书分类主键cid
     * @return 返回图书的集合
     */
    @Select("SELECT bid,cid,bcover,bname,bauthor FROM book WHERE cid=#{cid} ORDER BY hborrowed desc,bid asc limit 8;")
    List<Book> findBookByCidSome(Integer cid);
}

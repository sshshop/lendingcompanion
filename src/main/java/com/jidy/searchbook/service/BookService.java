package com.jidy.searchbook.service;

import com.upublic.utils.PageBean;
import org.springframework.stereotype.Service;
import com.jidy.searchbook.dao.BookDao;
import javax.annotation.Resource;
import com.upublic.vo.Book;
import java.util.List;

/**
 * Created by jidy on 2017/5/8.
 */
@Service(value = "bookService")
public class BookService{
    @Resource(name = "bookDao")
    private BookDao bookDao;
    //第一次查询
    public PageBean<Book> findByPage(Book book, Integer page) {
        PageBean<Book> pageBean=new PageBean<Book>();
        pageBean.setPage(page); //设置当前页数
        int limit = 5; //设置当前页面显示的条数
        pageBean.setLimit(limit);
        int totalCount =bookDao.findByCount(book.getBname(),
                book.getInitials(),
                book.getFight(),
                book.getBadr(),
                book.getBauthor());  //获取总的记录数

        pageBean.setTotalCount(totalCount);
        int totalPage=0;//设置总的页数
        if(totalCount%limit==0){
            totalPage=totalCount/limit;
        }else{
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        int begin=(page-1)*limit;
        pageBean.setBegin(begin);   //设置每页显示的数据结合
        List<Book> list = bookDao.findByPage(book.getBname(),
                book.getInitials(),
                book.getFight(),
                book.getBadr(),
                book.getBauthor(),
                pageBean.getBegin(),
                pageBean.getLimit());
        pageBean.setList(list);
        return pageBean;
    }
    //第二次查询
    public PageBean<Book> findByBname(Book book, Integer page) {
        PageBean<Book> pageBean=new PageBean<Book>();
        pageBean.setPage(page); //设置当前页数
        int limit = 5; //设置当前页面显示的条数
        pageBean.setLimit(limit);
        int totalCount =bookDao.findByBnameCount(book.getBname(),
                book.getInitials(),
                book.getFight(),
                book.getBadr(),
                book.getBauthor());  //获取总的记录数
        pageBean.setTotalCount(totalCount);
        int totalPage=0;//设置总的页数
        if(totalCount%limit==0){
            totalPage=totalCount/limit;
        }else{
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        int begin=(page-1)*limit;
        pageBean.setBegin(begin);   //设置每页显示的数据结合
        List<Book> list = bookDao.findByBname(book.getBname(),
                book.getInitials(),
                book.getFight(),
                book.getBadr(),
                book.getBauthor(),
                pageBean.getBegin(),
                pageBean.getLimit());
        pageBean.setList(list);
        return pageBean;
    }

    /**
     * 查询最新书籍
     * @return 返回书籍集合
     */
    public List<Book> findNewBook() {
        return bookDao.findNewBook();
    }

    /**
     * 查询最热门书籍
     * @return 返回书籍集合
     */
    public List<Book> findHotBook() {
        return bookDao.findHotBook();
    }



    /**
    * 通过书籍主键查询图书详情
    * @param bid 图书主键id
    * @return 返回唯一的图书实体类
    */
   public Book findBookById(Integer bid) {
       return bookDao.findBookById(bid);
   }

    public List<Book> findAuthor(String bauthor) {
      return bookDao.findAuthor(bauthor);
    }


}

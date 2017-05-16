package com.jidy.searchbook.service;

import org.springframework.stereotype.Service;
import com.jidy.searchbook.dao.BookDao;
import javax.annotation.Resource;
import com.upublic.vo.Book;
import java.util.List;

/**
 * Created by jidy on 2017/5/8.
 */
@Service(value = "bookService")
public class BookService {
    @Resource(name = "bookDao")
    //bname、initials、fight、bnum、badr、bauthor
    private BookDao bookDao;
    public List<Book> searchBookInfo(Book book){
        List<Book> list=bookDao.searchBookInfo(book.getBname(),
                book.getInitials(),
                book.getFight(),
                book.getBnum(),
                book.getBadr(),
                book.getBauthor());
        return list;
    }


    public List<Book> findNewBook() {
        return bookDao.findNewBook();
    }

    public List<Book> findHotBook() {
        return bookDao.findHotBook();
    }

    /**
     * 通过书籍主键查询图书详情
     *
     * @param bid
     * @return
     */
    public Book findBookById(Integer bid) {
        return bookDao.findBookById(bid);
    }
}

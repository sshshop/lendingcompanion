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
    private BookDao bookDao;
    public List<Book> searchBookInfo(String bname){
        List<Book> list=bookDao.searchBookInfo(bname);
        return list;
    }
}

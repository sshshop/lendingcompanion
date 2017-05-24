package com.lj.booktemp.service;

import com.lj.booktemp.dao.BooktemDao;
import com.upublic.vo.Book;
import com.upublic.vo.Booktem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台图书表的操作
 * Created by Rabit on 2017/5/22.
 */
@Service(value = "booktemService")
public class BooktemService {
    @Resource(name = "booktemDao")
    private BooktemDao booktemDao;

    public int addBooktem(Booktem booktem) {
        booktem.setMoney(50.0);
        return booktemDao.addBooktem(booktem);
    }

    public List<Book> findBookAll() {
        return booktemDao.findBookALL();
    }

    public void delBook(Booktem booktem) {
        Integer temp = booktem.getBtid();
        if (booktemDao.countSub(temp) > 0)
            booktemDao.delSub(temp);
        if (booktemDao.countComment(temp) > 0)
            booktemDao.delComment(temp);
        if (booktemDao.countBorrowed(temp) > 0)
            booktemDao.delBorrowed(temp);
        if (booktemDao.countbooktem(temp) > 0)
            booktemDao.delBook(temp);
    }

    public List<Booktem> findBookByBtid(Integer btid) {
        return booktemDao.findBookByBtid(btid);
    }

    public int updateBook(Booktem booktem) {
        return booktemDao.updateBook(booktem);
    }
}

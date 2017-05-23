package com.lj.bookcomment.service;

import com.lj.bookcomment.dao.BookcommentDao;
import com.lj.borrowbook.dao.BorrowbookDao;
import com.upublic.utils.PageBean;
import com.upublic.vo.Book;
import com.upublic.vo.Bookcomment;
import com.upublic.vo.Borrowbook;
import com.upublic.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Rabit on 2017/5/16.
 */
@Service("bookCommentService")
public class BookCommentService {
    @Resource(name = "bookCommentDao")
private BookcommentDao bookcommentDao;
    @Resource(name = "borrowbookDao")
    private BorrowbookDao borrowbookDao;

    public List<Bookcomment> findCommentByBId(Integer bid) {
        return bookcommentDao.findCommentByBId(bid);
    }

    public List<Bookcomment> findCommentByUId(User user) {
        return bookcommentDao.findCommentByUId(user);
    }

    public int addBookcomment(Integer uid, String username, Integer bid, String inf) {
        return bookcommentDao.addBookcomment(uid,username,bid,inf);
    }

    public void updateBstatus(Borrowbook borrowbook) {
        borrowbookDao.updatBorrowedStatus(borrowbook);
    }
}

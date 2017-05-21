package com.lj.bookcomment.service;

import com.lj.bookcomment.dao.BookcommentDao;
import com.upublic.utils.PageBean;
import com.upublic.vo.Book;
import com.upublic.vo.Bookcomment;
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

    public List<Bookcomment> findCommentByBId(Integer bid) {
        return bookcommentDao.findCommentByBId(bid);
    }

    public List<Bookcomment> findCommentByUId(User user) {
        return bookcommentDao.findCommentByUId(user);
    }
}

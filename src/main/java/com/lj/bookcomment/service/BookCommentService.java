package com.lj.bookcomment.service;

import com.lj.bookcomment.dao.BookcommentDao;
import com.upublic.utils.PageBean;
import com.upublic.vo.Bookcomment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by Rabit on 2017/5/16.
 */
@Service("bookCommentService")
public class BookCommentService {
    @Resource(name = "bookCommentDao")
private BookcommentDao bookcommentDao;

    public PageBean<Bookcomment> findCommentByBId(Integer bid,Integer page) {
        return new PageBean<Bookcomment>(page,7,bookcommentDao,bid);
    }
}

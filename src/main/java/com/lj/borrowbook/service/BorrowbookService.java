package com.lj.borrowbook.service;

import com.lj.borrowbook.dao.BorrowbookDao;
import com.upublic.vo.Borrowbook;
import com.upublic.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Rabit on 2017/5/9.
 */
@Service(value = "borrowbookService")
public class BorrowbookService {
    @Resource(name = "borrowbookDao")
    private BorrowbookDao borrowbookDao;

    public void insertBorrowdbook(User user, Borrowbook borrowbook) {
        borrowbook.setUid(user.getUid());
        borrowbookDao.insertBorrowdbook(borrowbook);
    }

}

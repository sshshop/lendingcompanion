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

    /**
     * 当用户借书年大于2等于2时。返回一个对应的bool值
     *
     * @param user 用户id封装的实体类
     * @return 返回布尔值，当数字大于等于2返回false，反之返回true
     */
    public boolean isOverBorrored(User user) {
        return borrowbookDao.selectCountBorrowBook(user) >= 2 ? false : true;
    }

    public void updateBookNborrow(Borrowbook borrowbook) {
        borrowbookDao.updateBookNborrow(borrowbook);
    }

}

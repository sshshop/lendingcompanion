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

    /**
     * 插入借书信息
     * @param user 用户id
     * @param borrowbook 图书id
     */
    public void insertBorrowdbook(User user, Borrowbook borrowbook) {
        borrowbook.setUid(user.getUid());
        borrowbookDao.insertBorrowdbook(borrowbook);
    }

    /**
     * 当用户借书年大于2等于2时。返回一个对应的bool值
     * @param user 用户id封装的实体类
     * @return 返回布尔值，当数字大于等于2返回false，反之返回true
     */
    public boolean isOverBorrored(User user) {
        return borrowbookDao.selectCountBorrowBook(user) >= 2 ? false : true;
    }

    /**
     * 更新书籍的借阅信息
     * @param borrowbook 提供书籍的id
     */
    public void updateBookNborrow(Borrowbook borrowbook) {
        borrowbookDao.updateBookNborrow(borrowbook);
    }

    /**
     * 查询同一本书用户是否是二次借阅
     * @param user 用户uid封装
     * @param borrowbook 图书bid封装
     * @return 返回存在返回false，不存在返回true
     */
    public boolean existBorrMsg(User user,Borrowbook borrowbook){
            return borrowbookDao.existBorrMsg(user,borrowbook)>=1?false:true;
    }

}

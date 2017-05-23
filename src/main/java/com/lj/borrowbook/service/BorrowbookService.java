package com.lj.borrowbook.service;

import com.jidy.searchbook.dao.BookDao;
import com.lj.borrowbook.dao.BorrowbookDao;
import com.lyj.user.dao.UserDao;
import com.upublic.vo.Book;
import com.upublic.vo.Borrowbook;
import com.upublic.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rabit on 2017/5/9.
 */
@Service(value = "borrowbookService")
public class BorrowbookService {
    @Resource(name = "borrowbookDao")
    private BorrowbookDao borrowbookDao;
    @Resource(name = "userDao")
    private UserDao userDao;
    @Resource(name = "bookDao")
    private BookDao bookDao;

    /**
     * 插入借书信息
     *
     * @param user       用户id
     * @param borrowbook 图书id
     */
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

    /**
     * 更新书籍的借阅信息
     *
     * @param borrowbook 提供书籍的id
     */
    public void updateBookNborrow(Borrowbook borrowbook) {
        borrowbookDao.updateBookNborrow(borrowbook);
    }

    /**
     * 查询同一本书用户是否是二次借阅
     *
     * @param user       用户uid封装
     * @param borrowbook 图书bid封装
     * @return 返回存在返回false，不存在返回true
     */
    public boolean existBorrMsg(User user, Borrowbook borrowbook) {
        return borrowbookDao.existBorrMsg(user, borrowbook) >= 1 ? false : true;
    }

    /**
     * 通过用户id差询用户的借书的信息，其中包括书籍的信息等
     *
     * @param user 用户的书籍信息封装
     * @return 返回封装的用户借书的信息
     */
    public List<Borrowbook> findBorrowedBookByUid(User user) {
        return borrowbookDao.findBorrowedBookByUid(user);
    }

    /**
     * 传入用户名或者图书名查询订单信息
     * @param username
     * @param bname
     * @return
     */
    public List<Borrowbook> findBorrowedBookMSG(String username, String bname) {
        List<Borrowbook> borrowbookList = new ArrayList<Borrowbook>();
        System.out.println("进入servicefindBorrowedBookMSG");
        if (username != null && username != "") {
            List<User> ulist = userDao.findUserByRe(username.trim());
            System.out.println(ulist.size()+"进入用户名搜索");
            for (int i = 0; i < ulist.size(); i++) {
                List<Borrowbook> tlist = borrowbookDao.findBorroewByUid(ulist.get(i));
                for (int j = 0; j < tlist.size(); j++) {
                    borrowbookList.add(tlist.get(j));
                }
            }
        }
        if (bname != null && bname != "") {
            List<Book> btem = bookDao.findBookByRe(bname);
            System.out.println(btem.size() +"进入图书名搜索");
            for (int i = 0; i < btem.size(); i++) {
                List<Borrowbook> blist = borrowbookDao.findBorrowedByBid(btem.get(i));
                for (int j = 0; j < blist.size(); j++) {
                    borrowbookList.add(blist.get(j));
                }
            }
        }
        return borrowbookList;
    }

    public int updatBorrowedStatus(Borrowbook borrowbook) {
        return borrowbookDao.updatBorrowedStatus(borrowbook);
    }
}

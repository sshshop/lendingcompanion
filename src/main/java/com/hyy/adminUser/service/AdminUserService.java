package com.hyy.adminUser.service;

import com.hyy.adminUser.dao.AdminUserDao;
import com.lj.bookcomment.dao.BookcommentDao;
import com.lj.borrowbook.dao.BorrowbookDao;
import com.lj.news.dao.NewsDao;
import com.lj.subcription.dao.SubscriptionDao;
import com.upublic.dao.SearchDao;
import com.upublic.vo.Admuser;
import com.upublic.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Scream on 2017/5/20.
 */
@Service(value = "adminUserService")
public class AdminUserService {
    @Resource(name = "adminUserDao")
    private AdminUserDao adminUserDao;
    @Resource(name = "newsDao")
    private NewsDao newsDao;
    @Resource(name = "searchDao")
    private SearchDao searchDao;
    @Resource(name = "subscriptionDao")
    private SubscriptionDao subscriptionDao;
    @Resource(name = "bookCommentDao")
    private BookcommentDao bookcommentDao;
    @Resource(name = "borrowbookDao")
    private BorrowbookDao borrowbookDao;

    /***
     *
     * 用户登录模块的Service层代码
     *根据用户名密码查询用户
     *
     */
    public Admuser findAdminUser(String auname, String apwd) {
        List<Admuser> list = adminUserDao.findAdminUser(auname,apwd);
        if (list != null && list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    /**
     *
     * 用户管理模块Service层代码
     * 查询所有的User信息
     *
     * */
    public List<User> findUserAll() {
        List<User> list = adminUserDao.findUserAll();
        return list;

    }

    public User findUserById(Integer uid) {
        return adminUserDao.findUserById(uid);
    }

    public void deleteUser(Integer uid) {
        if (!newsDao.findNewsByUid(uid).isEmpty()){
            System.out.println("1");
             newsDao.deleteUser(uid);
            System.out.println("1");
        }
        if (!subscriptionDao.findSubscriptionByUid(uid).isEmpty()){
            System.out.println("2");
            subscriptionDao.deleteUser(uid);
            System.out.println("2");
        }
        if (!bookcommentDao.findBookCommentByUId(uid).isEmpty()){
            System.out.println("3");
             bookcommentDao.deleteUser(uid);
            System.out.println("3");
        }
        if(!borrowbookDao.findborrowedBookByUid(uid).isEmpty()){
            System.out.println("4");
             borrowbookDao.deleteUser(uid);
            System.out.println("4");
        }
        if(!searchDao.findSearchByUid(uid).isEmpty()){
            System.out.println("5");
            searchDao.deleteUser(uid);
            System.out.println("5");
        }
        adminUserDao.deleteUser(uid);





    }
}

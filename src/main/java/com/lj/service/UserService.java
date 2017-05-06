package com.lj.service;

import com.lj.dao.UserDao;
import com.lj.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Rabit on 2017/5/6.
 */
@Service(value = "UserService")
public class UserService {
    @Resource(name = "userDao")
    private UserDao userDao;
    public void test() {
        System.out.println("测试spring");
    }

    public User selectPwdById(String id) {
        return userDao.selectById(id);
    }
}

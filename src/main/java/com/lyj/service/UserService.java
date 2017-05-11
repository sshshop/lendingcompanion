package com.lyj.service;

import com.lyj.dao.UserDao;
import com.upublic.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Rabit on 2017/5/6.
 */
@Resource(name = "userDao")
@Service("userService")
public class UserService {

    // 注入UserDao

    private UserDao userDao;

    public List<User> findUserAll(User user) {

        return userDao.findUserAll( user.getUsername(),user.getUpassword());
    }
}




package com.hyy.adminUser.service;

import com.hyy.adminUser.dao.AdminUserDao;
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
        adminUserDao.deleteUser(uid);
    }
}

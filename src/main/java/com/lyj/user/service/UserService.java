package com.lyj.user.service;

import com.lyj.user.action.UserAction;
import com.lyj.user.dao.UserDao;
import com.lyj.user.utils.SendMailUnitl;
import com.lyj.user.utils.UUIDUtils;
import com.lyj.province.dao.ProvinceDao;
import com.upublic.vo.City;
import com.upublic.vo.Province;
import com.upublic.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Rabit on 2017/5/6.
 */
@Service("userService")
public class UserService {

    // 注入UserDao
    @Resource(name = "userDao")
    private UserDao userDao;

    public List<User> findUserAll(User user) {

        return userDao.findUserAll( user.getUsername(),user.getUpassword());
    }
    public List<User> findUsernameAll(User user) {

        return userDao.findUsernameAll( user.getUsername());
    }




    public void sava(User user,String i) {

        String code= UUIDUtils.getUUID()+UUIDUtils.getUUID();
        user.setCode(code);
        //判断是用户添加或者管理员添加
        if ("user".equalsIgnoreCase(i)){
            SendMailUnitl.senMail(user.getEmail(),code,i);
            userDao.save(user.getUsername(),user.getUpassword(),user.getSex(),user.getDob(),user.getPhone(),user.getPid(),user.getCid(),user.getAddr(),user.getEmail(),user.getCode());
        }else if("admin".equalsIgnoreCase(i))
        {
            user.setState(1);
          //  userDao.adminsave(user.getUsername(),user.getUpassword(),user.getSex(),user.getDob(),user.getPhone(),user.getPid(),user.getCid(),user.getAddr(),user.getEmail(),user.getState());
            userDao.adminAdduser(user);
        }


        //System.out.println(user.getUsername()+"+"+user.getUpassword()+"+"+user.getSex()+"+"+user.getDob()+"+"+user.getPhone()+"+"+user.getPid()+"+"+user.getCid()+"+"+user.getAddr()+"+"+user.getEmail()+"+"+user.getCode());


    }


    public User findBycode(String code) {
        return userDao.findBycode(code);


    }

    public void update(User existUser) {
        userDao.update(existUser);
    }

    public User findUserByUid(User user){
        return userDao.findUserByUid(user);
    }

    /**
     * 更改用户信息
     * @param user 实现用户的信息封装
     * @return 返回修改的行数，一般是1
     */
    public int updateUser(User user) {
            return userDao.updateUser(user);
    }


    public User findByemail(String username) {
        return userDao.findByEmail(username);
    }

    public void updatePassword(String username,String upassword) {
        //System.out.println(username+upassword);
        userDao.updatePassword(username,upassword);

    }

    public String findUsername(User user) {
        return userDao.findUsername(user.getEmail());
    }
}




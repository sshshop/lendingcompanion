package com.lj.subcription.service;

import com.lj.subcription.dao.SubscriptionDao;
import com.upublic.vo.Subscription;
import com.upublic.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Rabit on 2017/5/9.
 */
@Service(value = "subscriptionService")
public class SubscriptionService {
    @Resource(name = "subscriptionDao")
    private SubscriptionDao subscriptionDao;

    /**
     * 通过用户id和图书id查询在订阅表是否存在相同的信息
     * @param subscription  图书封装类bid，与订阅表的id一致
     * @param user  用户封装类
     * @return 存在相同信息返回true，不存在返回false
     */
    public boolean selectSubExist(Subscription subscription, User user){
        return selectSubAll(subscription,user)==1?true:false;
    }
    /**
     * 通过用户id和图书id查询在订阅表的数量信息
     * @param subscription  图书封装类bid，与订阅表的id一致
     * @param user  用户封装类
     * @return 存在相同信息返回true，不存在返回false
     */
  public int selectSubAll(Subscription subscription, User user){
        return subscriptionDao.selectSubAll(user,subscription);
  }

    /**
     * 根据图书id和用户id插入注册表
     * @param user  封装用户id的类
     * @param subscription  封装图书id的类
     */
    public void addSubscrition(User user, Subscription subscription) {
        subscriptionDao.addSubscrition(user,subscription);
    }

    /**
     * 查询用的所有订阅信息，包括书籍的详情
     * @param user 用户的实体类封装，提供uid
     * @return 返回用户的订阅信息封装信息
     */

    public List<Subscription> findSubBooks(User user) {
        return subscriptionDao.findSubBooks(user);
    }
}

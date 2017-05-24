package com.lj.subcription.action;

import com.lj.subcription.service.SubscriptionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.Subscription;
import com.upublic.vo.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;


/**
 * 收藏信息表action
 * Created by Rabit on 2017/5/9.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class SubscriptionAction extends ActionSupport implements ModelDriven<Subscription>{
    @Resource(name = "subscriptionService")
    private SubscriptionService subscriptionService;
    private Subscription subscription= new Subscription();

    @Action(
            value = "addSubscription",
            results = {
                    @Result(location = "msg.jsp"),
                    @Result(name = "addfail",location = "msg.jsp")
            }
    )
    /**
     *
     * 将书籍添加到收藏夹，书的现存量大于0是收藏失败，否则收藏失败
     *跳转到信息提示页
     */
    public String addSubscription(){
       User user= (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        System.out.println(subscription.getBid());
        if (subscriptionService.selectSubExist(subscription,user)){
            this.addActionMessage("该书你已经收藏了，请等候我们的通知");
            return "addfail";
        }else {
            System.out.println("信息不存在");
            subscriptionService.addSubscrition(user,subscription);
            this.addActionMessage("收藏成功！！");
            return SUCCESS;
        }
    }

    /**
     *
     * 根绝bid取消订阅，也就是删除订阅表中的数据
     * @author Scream
     *
     * */
    @Action(value = "deleteSub",
            results = {
                    @Result(type = "redirect",location = "SubscriptionInfo.action"),
                    @Result(name = "error",location = "msg.jsp")
            }
    )
    public String deleteSub(){
        User user = (User) ActionContext.getContext().getSession().get("existedUser");
        System.out.println(user.getUid());
        if(subscriptionService.deleteSub(subscription.getBid(),user.getUid())!=1){
            this.addActionMessage("取消失败");
            return ERROR;
        }
        return SUCCESS;
    }

    public Subscription getModel() {
        return subscription;
    }
}

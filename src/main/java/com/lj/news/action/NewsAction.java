package com.lj.news.action;

import com.lj.news.dao.NewsDao;
import com.lj.news.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.News;
import com.upublic.vo.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;

/**
 * 消息的dao
 * Created by Rabit on 2017/5/24.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class NewsAction extends ActionSupport implements ModelDriven<News>{
    @Resource(name = "newsService")
    private NewsService newsService;
    private  News news=new News();

    public News getModel() {
        return news;
    }

    /**
     * 删除消息
     * @return
     */
    @Action(value = "delNews",results = {
            @Result(location = "systemmsg.action",type = "redirect"),
            @Result(name = LOGIN,location = "loginS.action",type = "redirect")
    })
    public String delNews(){
        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser == null) {
            //用户未登录
            return LOGIN;
        }
        newsService.delNewsById(news);
        return SUCCESS;
    }

    /**
     * 更新消息阅读状态
     * @return
     */
    @Action(value = "updateStatus",results = {
            @Result(location = "systemmsg.action",type = "redirect"),
            @Result(name = LOGIN,location = "loginS.action",type = "redirect")
    })
    public String updateStatus(){
        User loginuser = (User) ServletActionContext.getRequest().getSession().getAttribute("existedUser");
        if (loginuser == null) {
            return LOGIN;
        }
        newsService.updateStatus(news);
        return SUCCESS;
    }
}

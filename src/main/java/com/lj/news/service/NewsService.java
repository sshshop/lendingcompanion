package com.lj.news.service;

import com.lj.news.dao.NewsDao;
import com.upublic.vo.News;
import com.upublic.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消息类业务类
 * Created by Rabit on 2017/5/22.
 */
@Service(value = "newsService")
public class NewsService {
    @Resource(name = "newsDao")
   private NewsDao newsDao;

    public List<News> findNewsByUid(User user) {
        return newsDao.findNewByUid(user);
    }

    public void delNewsById(News news) {
        newsDao.delNew(news);
    }

    public void updateStatus(News news) {
        newsDao.updatStatus(news);
    }
}

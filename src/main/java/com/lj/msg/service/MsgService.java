package com.lj.msg.service;

import com.lj.msg.dao.MsgDao;
import com.upublic.vo.Msg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公告
 * Created by Rabit on 2017/5/23.
 */
@Service(value = "msgService")
public class MsgService {
    @Resource(name = "msgDao")
    private MsgDao msgDao;

    public List<Msg> findAllMsg(){
        return msgDao.findMsg();
    }

    public Msg findNewMsg(){
        return msgDao.findNewMsg();
    }


    /**
     *
     * 根据MID删除公告的Service层代码
     *
     * */
    public void deleteMsg(int mid) {
        msgDao.deleteMsg(mid);
    }


    public int saveMsg(String msg) {
        return msgDao.saveMsg(msg);
    }
}

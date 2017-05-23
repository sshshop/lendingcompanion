package com.jidy.adminauthority.service;

import com.jidy.adminauthority.dao.AdminAuthorityDao;
import com.upublic.vo.Admuser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jidy on 2017/5/23.
 */
@Service("adminAuthorityService")
public class AdminAuthorityService {
    @Resource(name = "adminAuthorityDao")
    private AdminAuthorityDao adminAuthorityDao;

    public List<Admuser> findAllAdmUser(){
        return adminAuthorityDao.findAllAdmUser();
    }

    public void changAuthority(Integer auid, Integer authority) {
        System.out.println(authority);
        adminAuthorityDao.changAuthority(auid,authority);
    }
}

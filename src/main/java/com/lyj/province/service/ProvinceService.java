package com.lyj.province.service;

import com.lyj.province.dao.ProvinceDao;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.upublic.vo.Province;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 盖世太保 on 2017/5/11.
 */
@Service("provinceService")
public class ProvinceService {

    // 注入provinceDao
    @Resource(name = "provinceDao")
    private ProvinceDao provinceDao;
    /*public Province select(Province province) {
        System.out.println("+++++++++++++++++++");
         return provinceDao.findPidAll(province.getPname());
    }*/

    public int selectPid(String pname) {
        return provinceDao.selectPid(pname);
    }

    public List<Province> findALLp() {
        return provinceDao.findAll();
    }
}

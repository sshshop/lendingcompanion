package com.lyj.city.service;

import com.lyj.city.dao.CityDao;
import com.upublic.vo.City;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 盖世太保 on 2017/5/11.
 */
@Service("cityService")
public class CityService {
    // 注入cityDao
    @Resource(name = "cityDao")
    private CityDao cityDao;
    public int selectCid(String city) {
        return  cityDao.findCid(city);
    }


    public List<City> findCityByPid(int pid) {
        return cityDao.findNameBypid(pid);
    }
}

package com.lyj.city.action;

import com.lyj.city.service.CityService;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.City;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import javax.annotation.Resource;
import java.util.List;

import static com.opensymphony.xwork2.Action.NONE;

/**
 * Created by 盖世太保 on 2017/5/11.
 */

@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class CityAction implements ModelDriven<City>{
    private City city=new City();
    public City getModel() {
        return city;
    }
    @Resource(name ="cityService")

    private CityService cityService=new CityService();

    public CityService getCityService() {
        return cityService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }
    @Action(value ="registerCid")
    public void select(){
        /*System.out.println(city.getCname());*/
       /* city=cityService.select(city);*/

       /* System.out.println(city.getCid());*/
    }
}

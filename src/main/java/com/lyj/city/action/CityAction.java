package com.lyj.city.action;

import com.lyj.city.service.CityService;
import com.lyj.province.service.ProvinceService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.City;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.opensymphony.xwork2.Action.NONE;

/**
 * Created by 盖世太保 on 2017/5/11.
 */

@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class CityAction extends ActionSupport implements ModelDriven<City>{
    private City city=new City();
    private String pname;
    public City getModel() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Resource(name ="cityService")
    private CityService cityService=new CityService();
    @Resource(name ="provinceService")
    private ProvinceService provinceService;
    public CityService getCityService() {
        return cityService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }
    @Action(value ="selectCityBypid")
    public String select() throws IOException {
        System.out.println("进入执行了");
        System.out.println(pname);
      int c= provinceService.selectPid(pname);
    List<City> list= cityService.findCityByPid(c);
        HttpServletResponse response = ServletActionContext.getResponse();
    String city="";
    for (int i=0;i<list.size();i++){
       city+=list.get(i).getCname()+",";
    }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(city);
        System.out.println(city);
       return NONE;
    }
}

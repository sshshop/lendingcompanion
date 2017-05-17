package com.lyj.province.action;

import com.lyj.province.service.ProvinceService;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.Province;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.junit.Test;

import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import java.util.List;

import static com.opensymphony.xwork2.Action.NONE;

/**
 * Created by 盖世太保 on 2017/5/11.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class ProvinceAction implements ModelDriven<Province> {
    private  Province province=new Province();
    public Province getModel() {
        return province;
    }
    @Resource(name ="provinceService")
    private ProvinceService provinceService;

    public ProvinceService getProvinceService() {
        return provinceService;
    }

    public void setProvinceService(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }


    @Action(value ="registerPid")
    public void select(){
      /* System.out.println(province.getPname());*/
      /* province=provinceService.select(province);*/
       /*System.out.println(province.getPid());*/
      /* return province.getPid();*/
    }

}

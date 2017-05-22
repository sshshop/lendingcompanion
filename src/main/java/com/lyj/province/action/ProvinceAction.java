package com.lyj.province.action;

import com.lyj.province.service.ProvinceService;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.Province;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.junit.Test;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;

import java.io.IOException;
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
    public String select() throws IOException {
        System.out.println("省份查询");
     List<Province> provinceList=provinceService.findALLp();
        HttpServletResponse response = ServletActionContext.getResponse();
        String pnames="";
        for (int i=0;i<provinceList.size();i++){
            pnames+=provinceList.get(i).getPname()+",";
        }
        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().println(pnames);
        System.out.println(pnames);
        return NONE;
    }

}

package com.lj.category.action;

import com.lj.category.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.upublic.vo.Category;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Rabit on 2017/5/7.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
@Action(
        value = "categoryAction ")
public class CategoryAction extends ActionSupport {

    @Resource(name = "categoryService")
    private CategoryService categoryService;

    @Action( value = "cafindall" ,
            results = {
            /*多个返回值*/
            @Result(name = "success",location = "test.jsp")
    })
    public String findcategoryall() {
        System.out.println("进入一级分类表");
        List<Category> list = categoryService.findCategoryAll();
        System.out.println(list.get(0).getCname());
        return SUCCESS;
    }

    @Action(value = "din",
    /*一个返回值*/
    results = @Result(name = "suqqs",location = "index.jsp")
    )
    public String din(){
        System.out.println("din");
        return "suqqs";
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}

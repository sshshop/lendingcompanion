package com.lj.index.action;

import com.jidy.searchbook.service.BookService;
import com.lj.category.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.upublic.vo.Book;
import com.upublic.vo.Category;
import org.apache.struts2.convention.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 主页跳转
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
@Action
@Results(value = {@Result(name = "success",location = "index.jsp")})
public class index extends ActionSupport{
    @Resource(name = "bookService")
    private BookService bookService;
    @Resource(name = "categoryService")
    private CategoryService categoryService;

    @Action( value = "cafindall" ,
            results = {
            /*多个返回值*/
                    @Result(name = "success",location = "test.jsp")
            })
    public String findcategoryall() {

        return SUCCESS;
    }


    @Override
    public String execute() throws Exception {
        System.out.println("进入一级分类表");
        ActionContext.getContext().getSession().put("category",categoryService.findCategoryAll());
        ActionContext.getContext().getValueStack().set("nbook", bookService.findNewBook());
       ActionContext.getContext().getValueStack().set("hbook", bookService.findHotBook());

        return SUCCESS;
    }
}

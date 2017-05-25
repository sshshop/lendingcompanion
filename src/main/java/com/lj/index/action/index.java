package com.lj.index.action;

import com.jidy.searchbook.service.BookService;
import com.lj.category.service.CategoryService;
import com.lj.msg.service.MsgService;
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

@Results(value = {@Result(name = "success",location = "index.jsp")})
public class index extends ActionSupport{
    @Resource(name = "bookService")
    private BookService bookService;
    @Resource(name = "categoryService")
    private CategoryService categoryService;
    @Resource(name = "msgService")
    private MsgService msgService;

    @Action( value = "about" ,
            results = {
            /*多个返回值*/
                    @Result(name = "success",location = "aboutUs.jsp")
            })
    public String findcategoryall() {

        return SUCCESS;
    }


    @Override
    public String execute() throws Exception {
        this.addActionMessage("主页");
        ActionContext.getContext().getSession().put("category",categoryService.findCategoryAll());
        ActionContext.getContext().getSession().put("NewMsg",msgService.findNewMsg());
        ActionContext.getContext().getValueStack().set("nbook", bookService.findNewBook());
        ActionContext.getContext().getValueStack().set("hbook", bookService.findHotBook());

        return SUCCESS;
    }
}

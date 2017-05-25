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
                    @Result(name = "success1",location = "aboutUs.jsp")
            })
    public String findcategoryall() {

        return "success1";
    }

    @Action( value = "LagalStatement" ,
            results = {
            /*多个返回值*/
                    @Result(name = "success2",location = "LegalStatement.jsp")
            })
    public String LagalStatement() {

        return "success2";
    }

    @Action( value = "Recruitingtalents" ,
            results = {
            /*多个返回值*/
                    @Result(name = "success3",location = "Recruitingtalents.jsp")
            })
    public String Recruitingtalents() {

        return "success3";
    }

    @Action( value = "joinUs" ,
            results = {
            /*多个返回值*/
                    @Result(name = "success4",location = "joinUs.jsp")
            })
    public String joinUs() {

        return "success4";
    }

    @Action( value = "usuallyQuestion" ,
            results = {
            /*多个返回值*/
                    @Result(name = "success5",location = "usuallyQuestion.jsp")
            })
    public String usuallyQuestion() {

        return "success5";
    }

    @Action( value = "contactUs" ,
            results = {
            /*多个返回值*/
                    @Result(name = "success6",location = "contactUs.jsp")
            })
    public String contactUs() {

        return "success6";
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

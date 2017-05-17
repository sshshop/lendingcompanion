package com.lj.category.action;

import com.lj.category.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
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
public class CategoryAction extends ActionSupport {
    private int cid;

    @Resource(name = "categoryService")
    private CategoryService categoryService;

    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * 通过cid查询图书的分类
     * @return
     */
    @Action(value = "findBookByCid",
            results = @Result(name = SUCCESS, location = "index.jsp")
    )
    public String findBookByCid() {
        ActionContext.getContext().getValueStack().set("cbook",categoryService.findBookByCid(cid));
        return SUCCESS;
    }

}

package com.lj.bookcomment.action;

import com.lj.bookcomment.service.BookCommentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.vo.Bookcomment;
import com.upublic.vo.Borrowbook;
import com.upublic.vo.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scream on 2017/5/24.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class BookcommentAction extends ActionSupport implements ModelDriven<Bookcomment>{
    private Bookcomment bookcomment = new Bookcomment();
    private int bbid;

    public void setBbid(int bbid) {
        this.bbid = bbid;
    }

    public Bookcomment getModel() {
        return bookcomment;
    }

    @Resource(name = "bookCommentService")
    private BookCommentService bookCommentService;

    @Action(value = "addBookcomment",
            results = {
                    @Result(type = "redirect",location = "userMessage.action"),
                    @Result(name = "error",location = "msg.jsp")
            }
    )

    public String addBookcomment(){
        System.out.println(bbid+"评价成功？？？");
        User user = (User) ActionContext.getContext().getSession().get("existedUser");
        Borrowbook borrowbook = new Borrowbook();
        borrowbook.setBbid(bbid);
        borrowbook.setBstatus(4);
        bookCommentService.updateBstatus(borrowbook);
        //用户Session存在空指针异常
        if (bookCommentService.addBookcomment(user.getUid(),user.getUsername(),bookcomment.getBid(),bookcomment.getInf())!=1){
            this.addActionMessage("评论失败");
            return ERROR;
        }else {
            return SUCCESS;
        }
    }

    @Action(value = "postBid",
            results = {
                    @Result(location = "addBookcomment.jsp")
            }
    )
    public String postBid(){
        System.out.println(bbid+","+bookcomment.getBid());
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Borrowbook borrowbook = new Borrowbook();
        borrowbook.setBbid(bbid);
        borrowbook.setBid(bookcomment.getBid());
        ActionContext.getContext().getValueStack().set("BBBID",borrowbook);
        return SUCCESS;
    }

}

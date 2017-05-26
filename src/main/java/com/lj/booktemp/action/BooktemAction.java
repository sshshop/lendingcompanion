package com.lj.booktemp.action;

import com.lj.booktemp.service.BooktemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.upublic.utils.sqlFactory;
import com.upublic.vo.Booktem;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;


/**
 * 图书临时表的操作action
 * Created by Rabit on 2017/5/22.
 */
@ParentPackage(value = "struts-default")
@Namespace(value = "")
public class BooktemAction extends ActionSupport implements ModelDriven<Booktem> {
    @Resource(name = "booktemService")
    private BooktemService booktemService; //注入service
    private int tcid;
    private String bcobn;

    public void setBcobn(String bcobn) {
        this.bcobn = bcobn;
    }

    /*获取上传文件,名称必须和表单file控件名相同*/
    private File uploadfile;

    //  <!--获取上传文件名,命名格式：表单file控件名+FileName(固定)-->
    private String uploadfileFileName;

    //获取上传文件类型,命名格式：表单file控件名+ContentType(固定)
    private String uploadfileContentType;

    private Booktem booktem = new Booktem();

    public void setTcid(int tcid) {
        this.tcid = tcid;
    }

    public Booktem getModel() {
        return booktem;
    }

    public void setBooktemService(BooktemService booktemService) {
        this.booktemService = booktemService;
    }

    public void setUploadfile(File uploadfile) {
        this.uploadfile = uploadfile;
    }

    public void setUploadfileFileName(String uploadfileFileName) {
        this.uploadfileFileName = uploadfileFileName;
    }

    public void setUploadfileContentType(String uploadfileContentType) {
        this.uploadfileContentType = uploadfileContentType;
    }

    /**
     * 图书上传
     * @return
     * @throws IOException
     */
    @Action(value = "addBook", results = {
            @Result(name = SUCCESS, type = "redirect",location = "adminBookforward.action")
    })
    public String addBook() throws IOException {
        System.out.println("图书的值：" + tcid);
        booktem.setCid(tcid);
        String realpath = ServletActionContext.getServletContext().getRealPath("/image/1");
        System.out.println("文件的路径是：" + realpath);
        String path = "image/1/" + uploadfileFileName;
        System.out.println(path);
        //判断上传文件是否为空
        if (uploadfile != null) {
            //设置目标文件（根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例）
            File savefile = new File(realpath, uploadfileFileName);
            // 判断上传目录是否存在
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            //把文件uploadfile 拷贝到 savefile 里,FileUtils类需要commons-io-x.x.x.jar包支持
            FileUtils.copyFile(uploadfile, savefile);
            //设置request对象值
            //  this.addActionMessage("w文件上传成功");
            //  ActionContext.getContext().put("message", "上传成功！");
        }
        booktem.setCover(path);
        booktemService.addBooktem(booktem);
        System.out.println("图书添加成功");
        this.addActionMessage("图书添加成功！");
        return SUCCESS;
    }

    /**
     * 删除图书
     * @return
     */
    @Action(value = "delBook", results = {
            @Result(type = "redirect",location = "adminBookforward.action"),
            @Result(name = ERROR,location = "msg.jsp")
    })
    public String delBook(){
        try {
            System.out.println(booktem.getBtid());
            booktemService.delBook(booktem);
        } catch (Exception e) {
            this.addActionMessage("删除失败");
           return ERROR;
        }
        this.addActionMessage("删除成功");
        return SUCCESS;
    }

    /**
     *
     * 编辑图书
     * @author Scream
     *
     * */
    @Action(value = "editBook",
            results = {
                    @Result(location = "editBook.jsp")
            }
    )
    public String editBook(){
        ActionContext.getContext().getValueStack().set("bookitem",booktemService.findBookByBtid(booktem.getBtid()));
        return SUCCESS;
    }
    /**
     *
     * 修改图书信息
     * @author Scream
     *
     * */

    @Action(value = "editBookPost",
            results = {
                    @Result(type = "redirect",location = "adminBookforward.action"),
                    @Result(name = "error",location = "msg.jsp")
            }
    )
    public String editBookPost() throws IOException {
        System.out.println(booktem);
        System.out.println("--"+booktem.getBtname()+"--");
       if (uploadfileFileName!=null&&uploadfileFileName!="") {
           String realpath = ServletActionContext.getServletContext().getRealPath("/image/1");
           File savefile = new File(realpath, uploadfileFileName);
           String path = "image/1/" + uploadfileFileName;
           booktem.setCover(path);
           if (uploadfile != null) {
               if (!savefile.getParentFile().exists())
                   savefile.getParentFile().mkdirs();
               FileUtils.copyFile(uploadfile, savefile);
           }
       }
        System.out.println(booktem.getCobn());
        System.out.println(new sqlFactory().adminupdateBook(booktem));
        booktemService.updateBook(booktem);
        return SUCCESS;
    }
}

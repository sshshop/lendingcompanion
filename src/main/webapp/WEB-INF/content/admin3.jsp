<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>“无微不至”的借阅伴侣</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/user.css">
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="laydate/laydate.js"></script>
    <script src="js/booktem.js"></script>
    <script src="js/register.js"  type="text/javascript" charset="utf-8"></script>
    <script src="js/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
    <%--<script>--%>
    <%--window.onload = function(){--%>
    <%--if(location.search.indexOf("?")==-1){--%>
    <%--location.href += "?myurl";--%>
    <%--}--%>
    <%--else{--%>
    <%--if(location.search.indexOf("myurl")==-1) location.href += "&myurl";--%>
    <%--}--%>
    <%--}--%>
    <%--</script>--%>
</head>
<body onload="bookAdminPage(1,10)">
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg"
                                                                                          style="width: 100%;height: 100%;">
</div>
<!--头部页面-->
<div class="container header">
    <!-- 顶部信息 -->
    <div class="row header_title">
        <div class="col-md-2 header_title_left">

        </div>
        <div class="col-md-6 header_title_mid">
            <span>“无微不至”的借阅伴侣</span>
        </div>
        <div class="col-md-4 header_title_right">
            <s:if test="#session.adminUser==null">
                <a class="login" href="loginS.action">登录</a>
                <a class="register" href="registerS.action">注册</a>
            </s:if><s:else>
            <span style="display: block;float:left; color: dimgray;">欢迎您，<s:property value="#session.adminUser.auname"></s:property> 管理员</span>
            <a class="register" href="adminloginOut.action">退出</a>
        </s:else>
        </div>
    </div>
    <!-- logo以及搜索框 -->
    <div class="row header_main">
        <div class="col-md-5 logo">
            <img src="image/logo.png">
        </div>
        <div class="col-md-7" style="padding-top: 40px; text-align: center">
            <h2>欢迎进入“借阅伴侣”管理平台</h2>
        </div>

    </div>
    <!--导航栏-->
    <!--面包屑导航栏-->
    <div class="row header_smallNav">
        <div class="col-md-3">
            <span class="header_smallNav_text">您所在的位置:</span>
            <ol class="breadcrumb">
                <li><s:actionmessage/></li>
            </ol>
        </div>
    </div>
</div>
<%--中间部分--%>
<div class="container">
    <div class="row">
        <div class="col-md-12 adminnav" style="letter-spacing: 2px;">
            <ul class="nav nav-pills nav-stacked" style="text-align: center ">
                <li style="margin-top: 20px;"><a href="adminUserforward.action" id="adminUser_a">用户管理</a></li>
                <li style="margin-top: 20px;"><a href="adminMsgforward.action" id="adminNews_a">公告管理</a></li>
                <li class="active" style="margin-top: 20px;"><a href="adminBookforward.action" id="adminBook_a">图书管理</a></li>
                <li style="margin-top: 20px;"><a href="adminAuthorityforward.action" id="adminAuthority_a">权限管理</a></li>
                <li style="margin-top: 20px;"><a href="adminBorrowforward.action" id="adminBorrow_a">借书管理</a></li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tab-content">
                <%--图书管理--%>
                <div class="tab-pane fade in active" id="3" style="padding-top: 30px;letter-spacing: 2px;">
                    <div class="context_form" style="height:auto; ">
                        <div style="height:10%">
                            <ul class="nav nav-tabs">

                                <li class="active">
                                    <a href="#adminBook" data-toggle="tab"> 图书管理 </a>
                                </li>
                                <li>
                                    <a href="#addBook" data-toggle="tab"> 添加图书 </a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="adminBook">
                                <table class="table" style="text-align: center; letter-spacing: 2px;">
                                    <thead>
                                    <tr>
                                        <td>书籍名称</td>
                                        <td>作者</td>
                                        <td>出版社</td>
                                        <td>书籍编号</td>
                                        <td>书籍封面</td>
                                        <td>藏书量</td>
                                        <td>现存量</td>
                                        <td>添加时间</td>
                                        <td>编辑</td>
                                        <td>删除</td>
                                    </tr>
                                    </thead>
                                    <tbody id="bookAdminTable">
                                    <s:iterator var="book" value="allBook">
                                        <tr ng-repeat="data in datas">
                                            <td><s:property value="#book.bname" /></td>
                                            <td><s:property value="#book.bauthor" /></td>
                                            <td><s:property value="#book.badr" /></td>
                                            <td><s:property value="#book.bnum" /></td>
                                            <td><img src="<s:property value="#book.bcover" />" style="width: 20px;height: 20px" /></td>
                                            <td><s:property value="#book.bcobn"/></td>
                                            <td><s:property value="#book.nborrowed" /></td>
                                            <td><s:property value="#book.time" /></td>
                                            <td>
                                                <a href="editBook?btid=<s:property value="#book.bid"/>">
                                                    <img src="image/edit.png" border="0" style="CURSOR: hand;height: 20px;">
                                                </a>
                                            </td>
                                            <td><a href="delBook?btid=<s:property value="#book.bid"/> ">
                                                <img src="image/i_del.png" border="0" style="CURSOR: hand;height: 20px;">
                                            </a></td>
                                        </tr>
                                    </s:iterator>
                                    <tr>
                                        <ul class="pagination pagination-sm" id="adminBookPage">

                                        </ul>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <script>
                                var pageSize=0;//每页显示行数
                                var currentPage_=1;//当前页全局变量，用于跳转时判断是否在相同页，在就不跳，否则跳转。

                                function bookAdminPage(pno,psize){
                                    var itable = document.getElementById("bookAdminTable");
                                    var num = itable.rows.length;
                                    pageSize = psize;//每页显示行数
                                    //总共分几页
                                    if(num/pageSize > parseInt(num/pageSize)){
                                        totalPage=parseInt(num/pageSize)+1;
                                    }else{
                                        totalPage=parseInt(num/pageSize);
                                    }
                                    var currentPage = pno;//当前页数
                                    currentPage_=currentPage;
                                    var startRow = (currentPage - 1) * pageSize+1;
                                    var endRow = currentPage * pageSize;
                                    endRow = (endRow > num)? num : endRow;
                                    //遍历显示数据实现分页
                                    for(var i=1;i<(num+1);i++){
                                        var irow = itable.rows[i-1];
                                        if(i>=startRow && i<=endRow){
                                            irow.style.display = "";
                                        }else{
                                            irow.style.display = "none";
                                        }
                                    }
                                    var tempLi="";
                                    for(var i=1;i<=totalPage;i++)

                                    {
                                        tempLi+='<li value='+i+'><a href="#adminBook" onclick="jumpAdminBookPage('+i+')"> '+i+'</a></li>'
                                    }
                                    $("#adminBookPage").html(tempLi);
                                    $("#adminBookPage").val(currentPage);
                                }


                                function jumpAdminBookPage(i)
                                {
                                    var num=parseInt(i);
                                    console.log(pageSize);
                                    if(num!=currentPage_)
                                    {
                                        bookAdminPage(num,pageSize);
                                    }
                                }
                            </script>
                            <div class="tab-pane fade" id="addBook">
                                <div class="context">
                                    <div class="row">
                                        <div class="col-md-2"></div>
                                        <div class="col-md-8">
                                            <!--注册表单-->
                                            <h2 id="msg" style="color: red"></h2>
                                            <div>
                                                <form class="form-horizontal register" id="addBook_item"
                                                      enctype="multipart/form-data" method="post" name="addbook"
                                                      action="addBook.action">
                                                    <!--用户名-->
                                                    <div class="form-group">

                                                        <label class="control-label col-md-4">书籍名称：</label>
                                                        <input type="text" name="btname"
                                                               class="form-control col-md-4 username" id="btname"
                                                               onblur="checkbtname()"/>


                                                    </div>
                                                    <!--密码-->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">作者：</label>
                                                        <input type="text" name="btauthor"
                                                               class="form-control col-md-4 " id="author" onblur="checkauthor()"
                                                               placeholder=""/>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">分类：</label>
                                                        <select name="tcid" id="tcid" onblur="checkbtcid()">
                                                            <s:iterator var="c" value="#session.category">
                                                                <option value="<s:property value="#c.cid"/> ">
                                                                    <s:property value="#c.cname"/></option>
                                                            </s:iterator>
                                                        </select>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">出版社：</label>
                                                        <input type="text" name="adr" class="form-control col-md-4 adr"
                                                               id="adr" placeholder="" onblur="checkbadr()"/>

                                                    </div>
                                                    <!--出生年月-->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">书籍编号：</label>

                                                        <input type="text" id="num" name="num" onblur="checkbnum()"
                                                               class="form-control col-md-4 num" id="num"/>

                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">书籍封面:</label>
                                                        <input type="file" name="uploadfile" onblur="checkbcover()"
                                                               class="form-control col-md-4 cover" id="cover"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">序:</label>
                                                        <textarea class="form-control col-md-4" id="sequence" name="sequence" rows="5"
                                                                  onblur="checksequence()"       cols="50"></textarea>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">导读:</label>
                                                        <textarea class="form-control col-md-4" name="idt" id="idt" rows="5"
                                                                  onblur="checkidt()" cols="50"></textarea>
                                                    </div>
                                                    <!--邮箱-->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">内容:</label>
                                                        <textarea class="form-control col-md-4" id="btcontent" name="btcontent"
                                                                  onblur="checkbbtcontent()" rows="5" cols="50"></textarea>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">藏书量:</label>
                                                        <input type="text" id="cobn" name="cobn" id="cobn"
                                                               onblur="checkbcobn()"  class="form-control col-md-4 cobn"/>
                                                    </div>
                                                    <!--使用协议-->

                                                    <!--提交按钮-->
                                                    <div class="form-group submit_btn">
                                                        <div class="col-md-offset-5 col-sm-10">
                                                            <button type="submit" class="btn btn-default" id="addsumbit" onmousemove="checkbsubmit();">添加</button>
                                                            <p id="mmsg" ></p>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <h4 id="msgsu" style="color:red;"></h4>
                                        </div>
                                        <div class="col-md-2"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!--底部页面-->
<div style="margin-top: 100px;">
    <%@include file="footer.jsp" %>
</div>
</body>
</html>
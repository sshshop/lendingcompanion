<%--
  Created by IntelliJ IDEA.
  User: Scream
  Date: 2017/5/23
  Time: 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
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
    <script src="js/register.js"></script>
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="laydate/laydate.js"></script>
    <script src="js/laydate/laydate.js"  type="text/javascript" charset="utf-8"></script>
</head>
<body>
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
            <%--  <a class="login" href="#"><s:property value="#session.existedUser.username" /></a>--%>
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

<div class="container">
    <div id="editUser">
        <div class="context" >
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8" >
                    <!--注册表单-->
                    <div >
                        <s:iterator var="b" value="bookitem">
                        <form class="form-horizontal register" id="addBook_item"
                              enctype="multipart/form-data" method="post" name="addbook"
                              action="editBookPost.action?btid=<s:property value="#b.btid"/>">
                            <!--用户名-->

                            <div class="form-group">

                                <label class="control-label col-md-4">书籍名称：</label>
                                <input type="text" name="btname" value="<s:property value="#b.btname"/>"  class="form-control col-md-4 username" id="btname"/>


                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4">作者：</label>
                                <input type="text" name="btauthor" value="<s:property value="#b.btauthor"/>" class="form-control col-md-4 " id="author"/>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4">出版社：</label>
                                <input type="text" name="adr" value="<s:property value="#b.adr"/>" class="form-control col-md-4 adr" id="adr"  onblur="checkbadr()"/>

                            </div>
                            <!--出生年月-->
                            <div class="form-group">
                                <label class="control-label col-md-4">书籍编号：</label>

                                <input type="text" id="num" name="num" class="form-control col-md-4 num" value="<s:property value="#b.num"/>" />

                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4">书籍封面:</label>
                                <input type="file" name="uploadfile"  class="form-control col-md-4 cover" id="cover"/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4">序:</label>
                                <textarea class="form-control col-md-4" id="sequence" name="sequence" rows="5"
                                                 cols="50" value="<s:property value="#b.sequence"/>"></textarea>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4">导读:</label>
                                <textarea class="form-control col-md-4" name="idt" id="idt" rows="5" cols="50" value="<s:property value="#b.idt"/>" ></textarea>
                            </div>
                            <!--邮箱-->
                            <div class="form-group">
                                <label class="control-label col-md-4">内容:</label>
                                <textarea class="form-control col-md-4" id="btcontent" name="btcontent"
                                           rows="5" cols="50" ></textarea>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4">藏书量:</label>
                                <input type="text" id="cobn" name="cobn" value="<s:property value="#b.cobn"/>"  class="form-control col-md-4"/>
                            </div>

                            <!--使用协议-->

                            <!--提交按钮-->
                            <div class="form-group submit_btn">
                                <div class="col-md-offset-5 col-sm-10">
                                    <button type="submit" class="btn btn-default" id="addsumbit">修改</button>
                                </div>
                            </div>
                        </form>
                        </s:iterator>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

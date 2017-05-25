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
<body onload="userAdminPage(1,10)">
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
                <a class="login" href="adminUser.action">登录</a>
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
<%--中间部分--%>
<div class="container">
    <div class="row">
        <div class="col-md-12 adminnav" style="letter-spacing: 2px;">
            <ul class="nav nav-pills nav-stacked" style="text-align: center ">
                <li style="margin-top: 20px;"><a href="adminUserforward.action" id="adminUser_a">用户管理</a></li>
                <li style="margin-top: 20px;"><a href="adminMsgforward.action" id="adminNews_a">公告管理</a></li>
                <li style="margin-top: 20px;"><a href="adminBookforward.action" id="adminBook_a">图书管理</a></li>
                <li style="margin-top: 20px;"><a href="adminAuthorityforward.action" id="adminAuthority_a">权限管理</a></li>
                <li style="margin-top: 20px;"><a href="adminBorrowforward.action" id="adminBorrow_a">借书管理</a></li>
            </ul>
        </div>
    </div>
</div>


<!--底部页面-->
<div style="margin-top: 100px;">
    <%@include file="footer.jsp" %>
</div>
</body>
</html>
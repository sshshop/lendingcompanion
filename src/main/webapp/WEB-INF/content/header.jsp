<%@ page language="java"
         pageEncoding="UTF-8"%>
<div class="container header">
    <!-- 顶部信息 -->
    <div class="row header_title">
        <div class="col-md-2 header_title_left">

        </div>
        <div class="col-md-6 header_title_mid">
            <span>“无微不至”的借阅伴侣</span>
        </div>
        <div class="col-md-4 header_title_right">
            <s:if test="#session.existedUser == null">
            <a class="login" href="loginS.action">登录</a>
            <a class="register" href="registerS.action">注册</a>
            </s:if><s:else>
          <%--  <a class="login" href="#"><s:property value="#session.existedUser.username" /></a>--%>
            <a class="login" href="userMessage.action">个人中心</a>
            <a class="register" href="loginOut.action">退出</a>
        </s:else>
            <a class="collect">收藏本站</a>
        </div>
    </div>
    <!-- logo以及搜索框 -->
    <div class="row header_main">
        <div class="col-md-5 logo">
            <img src="image/logo.png">
        </div>
        <div class="col-md-7 header_search">
            <form class="nameSearch_form" id="nameSearch_form" method="post" action="searchBookInfo.action">
                <span class="header_search_text">书名或作者名</span>
                <input class="nameSearch" id="inputInfo" name="inputInfo" type="text" placeholder="无微不至，搜你想搜..." style="padding-left:10px;"  <s:if test="inputInfo!=null"> value="<%=request.getParameter("inputInfo")%>"</s:if>/>
                <button type="submit"><img src="image/search.png" style="height:25px;width: 25px;"> </button>
            </form>
            <div class="header_search_title">
            </div>
        </div>
    </div>
    <!--导航栏-->
    <div class="row header_nav" id="header_nav">
        <div class="col-md-12">
            <a  href="index.action">主页</a>
            <a  href="#">热门推荐</a>
            <a  href="#">借书排行榜</a>
            <a  href="about.action">网站简介</a>
            <a  href="#">网站公告</a>
            <a  href="#">联系我们</a>
        </div>
    </div>
    <!--面包屑导航栏-->
    <div class="row header_smallNav">
        <div class="col-md-3">
            <span class="header_smallNav_text">您所在的位置:</span>
            <ol class="breadcrumb">
                <li><s:actionmessage/></li>
            </ol>
        </div>
        <div class="col-md-9" style="padding-top: 10px; font-size: 16px;color:rgb(81,14,173);">
            <marquee behavior="scroll" direction="left" scrollamount="5"><img src="image/guangbo.png" alt="广播图标" style="width:20px; height: 20px; margin-right: 7px;">今日公告：<s:property value="#session.NewMsg.msg"/> </marquee>
        </div>
    </div>
</div>
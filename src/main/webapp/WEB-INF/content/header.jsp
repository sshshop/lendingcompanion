<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="container header">
    <!-- 顶部信息 -->
    <div class="row header_title">
        <div class="col-md-4 header_title_left">

        </div>
        <div class="col-md-6 header_title_mid">
            <span>“无微不至”的借阅伴侣</span>
        </div>
        <div class="col-md-2 header_title_right">
            <a class="login">登录</a>
            <a class="register" href="../html/register.html">注册</a>
            <a class="collect">收藏本站</a>
        </div>
    </div>
    <!-- logo以及搜索框 -->
    <div class="row header_main">
        <div class="col-md-5 logo">
            <img src="image/logo.png">
        </div>
        <div class="col-md-7 header_search">
            <form class="nameSearch_form" id="nameSearch_form" action="">
                <span class="header_search_text">书名或作者名</span>
                <input class="nameSearch" id="nameSearch" type="text" placeholder="请输入您要搜的书..." style="padding-left:10px;" />
                <button type="submit"><span class="glyphicon-search"></span></button>
            </form>
            <div class="header_search_title">
                无微不至，搜你想搜
            </div>
        </div>
    </div>
    <!--导航栏-->
    <div class="row header_nav" id="header_nav">
        <div class="col-md-12">
            <a  href="#">主页</a>
            <a  href="#">热门推荐</a>
            <a  href="#">借书排行榜</a>
            <a  href="#">网站简介</a>
            <a  href="#">网站公告</a>
            <a  href="#">联系我们</a>
        </div>
    </div>
    <!--面包屑导航栏-->
    <div class="row header_smallNav">
        <div class="col-md-12">
            <span class="header_smallNav_text">您所在的位置:</span>
            <ol class="breadcrumb">
                <li><a href="#">主页</a></li>
                <li class="active">注册</li>
            </ol>
        </div>
    </div>
</div>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Scream
  Date: 2017/5/24

  Time: 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>“无微不至”的借阅伴侣</title>
    <link rel="stylesheet" href="css/register.css" />
    <link rel="stylesheet" href="css/header.css"/>
    <link rel="stylesheet" href="css/footer.css"/>
    <link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="laydate/skins/default/laydate.css" id="LayDateSkin"/>
    <link type="text/css" rel="stylesheet" href="laydate/need/laydate.css"/>
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="laydate/laydate.js"></script>
</head>
<body>
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg" style="width: 100%;height: 100%;"></div>
<!-- 头部页面 -->
<%@include file="header.jsp"%>

    <%--<s:property value="#session.existedUser.uid"/>
    <form class="loginform form-horizontal" id="loginform" method="post" action="addBookcomment.action?bid=<s:property value="BBBID.bid"/>&bbid=<s:property value="BBBID.bbid"/>">
        <textarea rows="5" cols="60" name="inf" id="bookcomment"></textarea>
        <button type="submit" class="btn btn-primary">提交</button>
    </form>--%>

<div    id="3" style="padding-top: 30px;letter-spacing: 2px;margin:0 auto;width: 50%" >
    <div  class="context_form" style="height: 50%" >
        <div style="height:10%">
            <ul  class="nav nav-tabs">

                <li class="active">
                    <a> 正在评价  </a>
                </li>
            </ul>
        </div>
        <div style="margin-top: 10%;margin-left: 17%">
            <%--<s:property value="#session.existedUser.uid"/>--%>
            <form    class="loginform form-horizontal" id="loginform" method="post" action="addBookcomment.action?bid=<s:property value="BBBID.bid"/>&bbid=<s:property value="BBBID.bbid"/>">
                <textarea  class="context_form"  rows="5" cols="60" name="inf" id="bookcomment" placeholder="快来评价吧~"></textarea><br>

                <button class="btn btn-primary col-md-offset-8" type="submit" style="width: 15%;margin-top: 3%;" >提&nbsp;&nbsp;交</button>
            </form>
        </div>
    </div>
</div>

<!-- 中间部分 -->

<!-- 底部页面 -->
<%@include file="footer.jsp"%>

</body>
</html>
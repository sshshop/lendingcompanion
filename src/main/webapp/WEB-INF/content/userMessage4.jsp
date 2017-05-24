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
    <script src="js/register.js"  type="text/javascript" charset="utf-8"></script>
    <script src="js/laydate/laydate.js"  type="text/javascript" charset="utf-8"></script>
    <script src="js/pageJS.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg"
                                                                                          style="width: 100%;height: 100%;">
</div>
<!--头部页面-->
<%@include file="header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-2 " style="letter-spacing: 2px;margin-top: 30px;">
            <ul class="nav nav-pills nav-stacked" style="text-align: center ">
                <li style="margin-top: 20px;"><a href="userMessage.action">用户信息</a></li>
                <li style="margin-top: 20px;"> <a href="SubscriptionInfo.action" >我的订阅</a></li>
                <li class="active"><a href="appraise.action" >我的评价</a></li>
                <li style="margin-top: 20px;"><a href="BorrowInfo.action" >借阅信息</a></li>
                <li style="margin-top: 20px;"><a href="systemmsg.action" >系统消息</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="tab-content" >
                <div class="tab-pane fade in active"   id="4" style="padding-top: 30px;letter-spacing: 2px;" onload="goPage(1,10)">
                    <div  class="context_form" style="height:auto ">
                        <div style="height:10%">
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a> 我的评价  </a>
                                </li>
                            </ul>
                        </div>
                        <table class="table" style="text-align: center; letter-spacing: 2px;">
                            <thead>
                            <tr>
                                <td>书籍名称</td>
                                <td>评价内容</td>
                                <td>评价时间</td>

                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator var="myc" value="#session.mycomment">
                            <tr  ng-repeat="data in datas">
                                <s:iterator var="book" value="#myc.list">
                                <td><a href="findBookBybid.action?bid=<s:property value="#book.bid"/>">《<s:property value="#book.bname"  />》</a> </td>
                                </s:iterator>
                                <td><s:property value="#myc.inf"  /></td>
                                <td><s:property value="#myc.bctime" /></td>

                            </tr>
                            </s:iterator>
                            <tr>
                                <ul class="pagination pagination-sm" id="jumpWhere2">

                                </ul>
                            </tr>
                            </tbody>
                        </table>
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
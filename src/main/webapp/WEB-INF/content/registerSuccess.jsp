<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>“无微不至”的借阅伴侣</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg" style="width: 100%;height: 100%;"></div>
<!--头部页面-->
<%@include file="header.jsp"%>
<div class="container context">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <!--注册表单-->
            <div >
                <label style="margin-left: 39%"  ><img src="image/OK.png" height="100px"></label><br>
                <label style="margin-left: 45%;font-size: 18px;" >完成</label>
            </div>
            <div class="context_form" style="background-color:rgba(112,128,144,0.8);">

                <form class="form-horizontal register"  >

                    <div class="form-group " style="text-align: center">
                        <%--<label><img src="image/background.jpg"></label>--%>
                        <label class="control-label " ><img src="image/tishi2.png" height="27px">&nbsp;注册成功，请返回您的邮箱激活</label>
                        <label><a href="loginS.action">返回登录</a></label>
                    </div>




                </form>

            </div>
            <div class="col-md-3"></div>
        </div>
    </div>
</div>
</body>
</html>

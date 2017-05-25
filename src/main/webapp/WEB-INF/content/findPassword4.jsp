<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
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

<!-- 中间部分 -->
<div class="container context">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <!--注册表单-->
            <div >
                <label style="margin-left: 39%"  ><img src="image/yanzheng3.png" height="100px"></label><br>
                <label style="margin-left: 45%;font-size: 18px;" >完成</label>
            </div>
            <div class="context_form" style="background-color:rgba(112,128,144,0.8);">

                <form class="form-horizontal register"  >

                    <div class="form-group " style="text-align: center">
                        <%--<label><img src="image/background.jpg"></label>--%>
                        <label class="control-label " ><img src="image/tishi2.png" height="27px">&nbsp;重置成功，请牢记新的登录密码</label>
                        <label><a href="loginS.action">重新登录</a></label>
                    </div>
                    <!--邮箱-->

                    <!--密码-->



                </form>

            </div>
            <div class="col-md-3"></div>
        </div>
    </div>
</div>
<!-- 底部页面 -->
<%@include file="footer.jsp"%>

</body>
</html>
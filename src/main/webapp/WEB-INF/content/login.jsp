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
            <div class="context_form" style="background-color:rgba(112,128,144,0.8);">
                <form class="form-horizontal register" id="register" action="userLogin.action" method="post">
                    <div class="form-group">
                        <s:actionerror/>
                    </div>
                    <!--用户名-->
                    <div class="form-group">
                        <label class="control-label col-md-4">用户名</label>
                        <input type="text" name="username" class="form-control col-md-4 username" id="username" placeholder="用户名" />
                        <span style="color: red; font-size: 22px; margin-left: 4px; padding-top: 3px;">*</span>

                    </div>
                    <!--密码-->
                    <div class="form-group">
                        <label class="control-label col-md-4">密码</label>
                        <input type="password" name="upassword" class="form-control col-md-4 password" id="password" placeholder="密码" />
                        <span style="color: red; font-size: 22px; margin-left: 4px; padding-top: 3px;">*</span>
                        <span style="font-size: 13px;letter-spacing: 2px;"><a href="findPassword1.action" style="display:inline">忘记密码</a></span>
                    </div>
                    <!--提交按钮-->
                    <div class="form-group submit_btn">
                        <div class="col-md-offset-5 col-sm-10">
                            <button type="submit" class="btn btn-default">登录</button>
                        </div>
                    </div>
                </form>
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
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
            <label style="margin-left: 39%"  ><img src="image/yanzheng1.png" height="100px"></label><br>
                <label style="margin-left: 41%;font-size: 18px;" >验证身份</label>
            </div>
            <div class="context_form" style="background-color:rgba(112,128,144,0.8);">

                <form class="form-horizontal register"  action="findNumber.action" method="post">

                    <div class="form-group ">
                        <%--<label><img src="image/background.jpg"></label>--%>
                        <label class="control-label "><img src="image/tishi.png" height="27px">&nbsp;邮箱验证码验证账户 请确认是你本人操作，请完成以下验证</label>
                    </div>
                    <!--邮箱-->
                    <div class="form-group">
                        <label class="control-label col-md-4">邮箱</label>
                        <input readonly class="form-control col-md-4 username" value="<s:property value="#session.email"/>"  />

                    </div>
                    <!--密码-->
                    <div class="form-group">
                        <label class="control-label col-md-4">验证码</label>
                        <input type="text" name="number1" class="form-control col-md-2 password"  />
                        <span id="number" style="font-size: 12px; color: red;" ><s:actionerror/></span>
                    </div>

                    <!--提交按钮-->
                    <div class="form-group submit_btn">
                        <div class="col-md-offset-7 ">
                            <button type="submit" class="btn btn-default" style="width: 28%" onclick="return checkNumber()">确定</button>
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

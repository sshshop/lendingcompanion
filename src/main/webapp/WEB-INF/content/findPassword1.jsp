<%--
  Created by IntelliJ IDEA.
  User: Rabit
  Date: 2017/5/7
  Time: 16:34
<form method="post" action="findP.action">
用户名：<input name="username" /><br>

 <button type="submit"  style="height: 30px;">下一步</button>
  To change this template use File | Settings | File Templates.
--%>
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
                <form class="form-horizontal register "  action="findP.action" method="post" name="findPassword">
                    <div class="form-group ">
                        <%--<label><img src="image/background.jpg"></label>--%>
                        <label class="control-label "><img src="image/tishi.png" height="27px">&nbsp;请输入你需要找回登录密码的账户名</label>
                      </div>
                    <!--用户名-->
                    <div class="form-group">
                        <label class="control-label col-md-4">用户名</label>
                        <input type="text" id="username" name="username" class="form-control col-md-4 username"  placeholder="用户名" onblur="checkUsername()" />

                        <span id="username2" style="font-size: 10px; color: red " ><s:actionerror/></span>
                    </div>
                    <%--<script>
                        function checkUsername() {
                            //检验用户名：
                            //获得用户名文本框的值：
                            var username = document.getElementById("username").value;
                            var username2 = document.getElementById("username2");
                            if (username == null || username == '') {
                                username2.innerHTML= "用户名不能为空";
                                return false;
                            }else if (username.length<5||username.length>20){
                                username2.innerHTML="用户名长度为6-19位";
                                return false;
                            }else {
                                username2.innerHTML= "";
                                var username = document.getElementById("username").value;
                                // 1.创建异步交互对象
                                var xhr = createXmlHttp();
                                // 2.设置监听
                                xhr.onreadystatechange = function() {
                                    if(xhr.readyState == 4){
                                        if(xhr.status == 200){
                                            document.getElementById("username2").innerHTML = xhr.responseText;
                                            return false;
                                        }
                                    }

                                }

                            }
                            // 3.打开连接
                            xhr.open("GET","${pageContext.request.contextPath}/findPassword.action?time="+new Date().getTime()+"&username="+username,true);
                            // 4.发送
                             xhr.send(null);
                            return true;
                        }
                        function checkPost() {
                            var a=checkUsername();
                            /*var b=checkUpassword();
                             var c=checkRepassword();
                             var d=checkPhone();
                             var e=checkProvince();
                             var f=checkEmail();
                             var g=checkedXieyi();*/
                            if(a==true/*&&b==true&&c==true&&d==true&&e==true&&f==true&&g==true*/){
                                document.findPassword.submit();
                            }else{
                                return false;}

                        }
                    </script>--%>
                    <!--提交按钮-->
                    <div class="form-group submit_btn">
                        <div class="col-md-offset-7 ">
                            <button type="submit" class="btn btn-default" style="width: 28%" onclick="checkPost();return false;">确定</button>
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
<%--
  Created by IntelliJ IDEA.
  User: Rabit
  Date: 2017/5/7<form method="post" action="updatePassword.action">

    新密码 <input type="text"  name="upassword1"  />

    <br>
    确认输入密码：<input type="text"  name="repassword"  /><br>
    <button type="submit"  style="height: 30px;">修改</button>

</form>
  Time: 16:34
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
            <div >
                <label style="margin-left: 39%"  ><img src="image/yanzheng2.png" height="100px"></label><br>
                <label style="margin-left: 41%;font-size: 18px;" >修改密码</label>
            </div>
            <div class="context_form" style="background-color:rgba(112,128,144,0.8);">

                <form class="form-horizontal register"  action="updatePassword.action" method="post" name="findPassword">

                    <div class="form-group ">
                        <%--<label><img src="image/background.jpg"></label>--%>
                        <label class="control-label "><img src="image/tishi.png" height="27px">&nbsp;邮箱验证码验证账户 请确认是你本人操作，请完成以下验证</label>
                    </div>
                    <!--邮箱-->
                    <div class="form-group">
                        <label class="control-label col-md-4">新密码</label>
                        <input type="password" class="form-control col-md-4 username"id="upassword1" name="upassword1"onblur="return checkUsername()"  />
                        <span id="upassword2" style="font-size: 10px; color: red " ></span>
                    </div>
                    <!--密码-->
                    <div class="form-group">
                        <label class="control-label col-md-4">确认密码</label>
                        <input type="password"id="number1" name="number1" class="form-control col-md-2 password" onblur="return checkUsername()"  />
                        <span id="username2" style="font-size: 10px; color: red " ></span>
                    </div>
                    <script>
                        function checkUsername() {
                            var upassword = document.getElementById("upassword1").value;
                            var upassword2 = document.getElementById("upassword2");
                            var repassword = document.getElementById("number1").value;
                            var repassword2 = document.getElementById("username2");
                            if (upassword == null || upassword == '') {

                                upassword2.innerHTML= "密码不能为空";

                                return false;
                            }else  if (upassword.length<5||upassword.length>20){

                                upassword2.innerHTML="密码长度为6-19位";
                                return false;
                            }else if (repassword!=upassword){

                                repassword2.innerHTML="两次输入密码不一致";
                                return false;
                            }else {
                                upassword2.innerHTML ="";
                                repassword2.innerHTML="";
                                return true;
                            }
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

                    </script>
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
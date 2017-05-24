<%--
  Created by IntelliJ IDEA.
  User: Scream
  Date: 2017/5/23
  Time: 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
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
    <script src="js/register.js"></script>
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="laydate/laydate.js"></script>
    <script src="js/laydate/laydate.js"  type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg"
                                                                                          style="width: 100%;height: 100%;">
</div>
<!--头部页面-->
<div class="container header">
    <!-- 顶部信息 -->
    <div class="row header_title">
        <div class="col-md-2 header_title_left">

        </div>
        <div class="col-md-6 header_title_mid">
            <span>“无微不至”的借阅伴侣</span>
        </div>
        <div class="col-md-4 header_title_right">
            <s:if test="#session.adminUser==null">
                <a class="login" href="loginS.action">登录</a>
                <a class="register" href="registerS.action">注册</a>
            </s:if><s:else>
            <%--  <a class="login" href="#"><s:property value="#session.existedUser.username" /></a>--%>
            <span style="display: block;float:left; color: dimgray;">欢迎您，<s:property value="#session.adminUser.auname"></s:property> 管理员</span>
            <a class="register" href="loginOut.action">退出</a>
        </s:else>
        </div>
    </div>
    <!-- logo以及搜索框 -->
    <div class="row header_main">
        <div class="col-md-5 logo">
            <img src="image/logo.png">
        </div>
        <div class="col-md-7" style="padding-top: 40px; text-align: center">
            <h2>欢迎进入“借阅伴侣”管理平台</h2>
        </div>

    </div>
    <!--导航栏-->
    <!--面包屑导航栏-->
    <div class="row header_smallNav">
        <div class="col-md-3">
            <span class="header_smallNav_text">您所在的位置:</span>
            <ol class="breadcrumb">
                <li><s:actionmessage/></li>
            </ol>
        </div>
    </div>
</div>

<div class="container">
    <div id="editUser">
        <div class="context" >
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8" >
                    <!--注册表单-->
                    <div >
                        <form class="form-horizontal register" action="editUser.action" >
                            <!--用户名-->
                            <div class="form-group">

                                <label class="control-label col-md-4">用户名</label>

                                <input type="text"  value="<s:property value="allUserById.username"/>" readonly  name="username" class="form-control col-md-4 username" />


                            </div>
                            <%--<!--重复密码-->--%>
                            <%--<div class="form-group">--%>
                            <%--<label class="control-label col-md-4">重复密码</label>--%>
                            <%--<input type="password" name="repassword" class="form-control col-md-4 repassword" id="repassword" placeholder="重复密码" onblur="checkRepassword()" />--%>

                            <%--</div>--%>
                            <!--性别-->
                            <!--出生年月-->
                            <div class="form-group" >
                                <label class="control-label col-md-4">出生年月</label>

                                <input type="text" value="<s:property value="allUserById.dob"/>" name="dob" class="form-control col-md-4 borth laydate-icon" id="editborth" style="height: 30px;" onclick="laydate()" />



                            </div>


                            <script>
                                laydate({
                                    elem: '#editborth',
                                    format: 'YYYY/MM', // 分隔符可以任意定义，该例子表示只显示年月
                                    festival: true, //显示节日
                                    choose: function(datas) { //选择日期完毕的回调
                                        alert('得到：' + datas);
                                    }})
                            </script>
                            <!--电话-->
                            <div class="form-group" >
                                <label class="control-label col-md-4">电话</label>
                                <input type="text" name="phone" class="form-control col-md-4 phone" value="<s:property value="allUserById.phone"/> " />
                            </div>
                            <!--省份----城市-->
                            <div class="form-group" >
                                <label class="control-label col-md-4">省份</label>
                                <span>
                                                            <select name="province1" id="s1" style="width: 98px"  >
                                                                <option id="pname2"></option>
                                                            </select>
                                                            <select name="city1" id="s2"  style="width: 98px">
                                                                <option id="cname1"></option>
                                                            </select>

                                                            <SCRIPT language="javascript">
                                                                setup()
                                                            </SCRIPT>
                                                        </span>
                            </div>

                            <div class="form-group" >
                                <label class="control-label col-md-4">详细地址</label>
                                <input type="text" name="addr" class="form-control col-md-4 addr" value="<s:property value="allUserById.addr"/>"  />
                            </div>
                            <!--邮箱-->
                            <div class="form-group" >
                                <label class="control-label col-md-4">邮箱地址</label>
                                <input type="text"  name="email" class="form-control col-md-4 email"   value="<s:property value="allUserById.email"/>" />
                            </div>
                            <!--使用协议-->

                            <!--提交按钮-->
                            <div class="form-group submit_btn" >
                                <div class="col-md-offset-5 col-sm-10">
                                    <button type="submit" class="btn btn-default">修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

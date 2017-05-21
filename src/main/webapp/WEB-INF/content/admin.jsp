<%--
  Created by IntelliJ IDEA.
  User: Scream
  Date: 2017/5/21
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
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
            <s:if test="#session.existedUser == null">
                <a class="login" href="loginS.action">登录</a>
                <a class="register" href="registerS.action">注册</a>
            </s:if><s:else>
            <%--  <a class="login" href="#"><s:property value="#session.existedUser.username" /></a>--%>
            <a class="login" href="#">个人中心</a>
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
<%--中间部分--%>
<div class="container">
    <div class="row">
        <div class="col-md-12 adminnav" style="letter-spacing: 2px;">
            <ul class="nav nav-pills nav-stacked" style="text-align: center ">
                <li class="active" style="margin-top: 20px;"><a href="#1" data-toggle="tab">用户管理</a></li>
                <li style="margin-top: 20px;"><a href="#2" data-toggle="tab">公告管理</a></li>
                <li style="margin-top: 20px;"> <a href="#3" data-toggle="tab">图书管理</a></li>
                <li style="margin-top: 20px;"><a href="#4" data-toggle="tab">权限管理</a></li>
                <%--<li style="margin-top: 20px;"><a href="#5" data-toggle="tab">消息管理</a></li>--%>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tab-content" >
                <%--用户管理--%>
                <div class="tab-pane fade in active " style="padding-top: 30px;letter-spacing: 2px;align-content: center; " id="1">
                    <div  class="context_form" style=" height:auto; ">
                        <div style="height:10%">
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a href="#adminUser" data-toggle="tab"> 用户管理  </a>
                                </li>
                                <li>
                                    <a href="#addUser" data-toggle="tab">添加用户</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="adminUser">
                                <table class="table" style="text-align: center; ">
                                    <thead>
                                    <tr>
                                        <td>用户名</td>
                                        <td>密码</td>
                                        <td>出生年月</td>
                                        <td>电话</td>
                                        <td>地址</td>
                                        <td>邮箱</td>
                                        <td>编辑</td>
                                        <td>删除</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr  ng-repeat="data in datas">
                                        <td><s:property value="" default="null" /> </td>
                                        <td><s:property value="" default="null" /></td>
                                        <td><s:property value="" default="null" /></td>
                                        <td><s:property value="" default="null" /></td>
                                        <td><s:property value="" default="null" /></td>
                                        <td><s:property value="" default="null" /></td>
                                        <td>
                                            <a href="#">
                                                <img src="image/edit.png" style="CURSOR: hand;height: 20px;">
                                            </a>
                                        </td>
                                        <td><a href="#"><img src="image/i_del.png" style="CURSOR: hand;height: 20px;"></a></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane fade" id="addUser">
                                <div class="context" >
                                    <div class="row">
                                        <div class="col-md-2"></div>
                                        <div class="col-md-8" >
                                            <!--注册表单-->
                                            <div >
                                                <form class="form-horizontal register" id="register" action="" >
                                                    <!--用户名-->
                                                    <div class="form-group">

                                                        <label class="control-label col-md-4">用户名</label>
                                                        <input type="text"  value="null"   name="username" class="form-control col-md-4 username" id="username" onblur="checkUsername()" />


                                                    </div>
                                                     <!--密码-->
                                                     <div class="form-group">
                                                         <label class="control-label col-md-4">密码</label>
                                                         <input type="password" name="upassword" class="form-control col-md-4 password" id="upassword" placeholder="密码" onblur="checkUpassword()" />

                                                     </div>
                                                     <%--<!--重复密码-->--%>
                                                     <%--<div class="form-group">--%>
                                                         <%--<label class="control-label col-md-4">重复密码</label>--%>
                                                         <%--<input type="password" name="repassword" class="form-control col-md-4 repassword" id="repassword" placeholder="重复密码" onblur="checkRepassword()" />--%>

                                                     <%--</div>--%>
                                                    <!--性别-->
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">性别:</label>
                                                        <span>
                                                            <input type="radio" name="sex1" class="sex" id="man"  value="man" checked />男
                                                            <input type="radio" name="sex1" class="sex" id="woman"  value="woman" />女
                                                        </span>
                                                    </div>
                                                    <!--出生年月-->
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">出生年月</label>

                                                        <input type="text" id="borth" name="dob" class="form-control col-md-4 borth laydate-icon" id="borth" placeholder="出生年月" onclick="laydate()" />



                                                    </div>


                                                    <script>
                                                        laydate({
                                                            elem: '#test1',
                                                            format: 'YYYY/MM', // 分隔符可以任意定义，该例子表示只显示年月
                                                            festival: true, //显示节日
                                                            choose: function(datas) { //选择日期完毕的回调
                                                                alert('得到：' + datas);
                                                            }})
                                                    </script>
                                                    <!--电话-->
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">电话</label>
                                                        <input type="text" name="phone" class="form-control col-md-4 phone" id="phone" placeholder="电话" onblur="checkPhone()" />
                                                        <span id="phone2" style="font-size: 10px; color: red " ></span>
                                                    </div>
                                                    <!--省份----城市-->
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">省份</label>
                                                        <span>
                                                            <select name="province" id="s1" style="width: 98px" onblur="checkProvince()" >
                                                                <option id="pname1"></option>
                                                            </select>
                                                            <select name="city" id="s2"  style="width: 98px"onblur="checkCity()">
                                                                <option id="cname"></option>
                                                            </select>

                                                            <SCRIPT language="javascript">
                                                                setup()
                                                            </SCRIPT>
                                                        </span>
                                                    </div>

                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">详细地址</label>
                                                        <input type="text" name="addr" class="form-control col-md-4 addr" id="addr" placeholder="详细地址"  />
                                                    </div>
                                                    <!--邮箱-->
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">邮箱地址</label>
                                                        <input type="text" id="email" name="email" class="form-control col-md-4 email"   placeholder="邮箱" onblur="return checkEmail()" />
                                                        <span id="email2" style="font-size: 10px; color: red " ></span>
                                                    </div>
                                                    <!--使用协议-->

                                                    <!--提交按钮-->
                                                    <div class="form-group submit_btn" >
                                                        <div class="col-md-offset-5 col-sm-10">
                                                            <button type="submit" class="btn btn-default">添加</button>
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
                    </div>
                </div>
                <%--公告管理--%>
                <div class="tab-pane fade"   id="2" style="padding-top: 30px; letter-spacing: 2px;">
                    <div  class="context_form" style=" height:auto; ">
                        <div style="height:10%">
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a href="#send" data-toggle="tab"> 公告管理 </a>
                                </li>
                                <li>
                                    <a href="#look" data-toggle="tab"> 历史公告记录 </a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="send">
                                <form>
                                <div class="row" style="padding-left: 30px;">
                                    <textarea class="col-md-8" placeholder="请填写不超过30字的公告" rows="3" cols="20" maxlength="60"></textarea>
                                </div>
                                <div class="row" style="padding-left:30px;margin-top: 30px;">
                                    <div class="col-md-6" style="float: right;">
                                        <button type="submit">发布公告</button>
                                    </div>
                                </div>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="look">
                                <table class="table" style="text-align: center; ">
                                    <thead>
                                    <tr>
                                        <td>管理员用户</td>
                                        <td>发布时间</td>
                                        <td>发布内容</td>
                                        <td>删除</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr  ng-repeat="data in datas">
                                        <td><s:property value="" default="null" /> </td>
                                        <td><s:property value="" default="null" /></td>
                                        <td><s:property value="" default="null" /></td>
                                        <td>
                                            <a href="#">
                                                <img src="image/i_del.png" style="CURSOR: hand;height: 20px;">
                                            </a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <%--图书管理--%>
                <div class="tab-pane fade"   id="3" style="padding-top: 30px;letter-spacing: 2px;">
                    <div  class="context_form" style="height:auto; ">
                        <div style="height:10%">
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a href="#adminBook" data-toggle="tab"> 图书管理 </a>
                                </li>
                                <li>
                                    <a href="#addBook" data-toggle="tab"> 添加图书 </a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="adminBook">
                                <table class="table" style="text-align: center; letter-spacing: 2px;">
                                    <thead>
                                    <tr>
                                        <td>书籍名称</td>
                                        <td>作者</td>
                                        <td>出版社</td>
                                        <td>书籍编号</td>
                                        <td>书籍封面</td>
                                        <td>藏书量</td>
                                        <td>添加时间</td>
                                        <td>编辑</td>
                                        <td>删除</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr  ng-repeat="data in datas">
                                        <td><s:property value="" default="null" /> </td>
                                        <td><s:property value="" default="null" /> </td>
                                        <td><s:property value="" default="null" /> </td>
                                        <td><s:property value="" default="null" /> </td>
                                        <td><s:property value="" default="null" /> </td>
                                        <td><s:property value="" default="null" /> </td>
                                        <td><s:property value="" default="null" /> </td>
                                        <td>
                                           <a href="#">
                                               <img src="image/edit.png" border="0" style="CURSOR: hand;height: 20px;">
                                           </a>
                                        </td>
                                        <td><a href="">
                                            <img src="image/i_del.png" border="0" style="CURSOR: hand;height: 20px;">
                                        </a></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane fade" id="addBook">
                                <div class="context" >
                                    <div class="row">
                                        <div class="col-md-2"></div>
                                        <div class="col-md-8" >
                                            <!--注册表单-->
                                            <div >
                                                <form class="form-horizontal register" id="addBook_item" action="" >
                                                    <!--用户名-->
                                                    <div class="form-group">

                                                        <label class="control-label col-md-4">书籍名称：</label>
                                                        <input type="text"  value="null"   name="btname" class="form-control col-md-4 username" id="btname"  />


                                                    </div>
                                                    <!--密码-->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">作者：</label>
                                                        <input type="text" name="author" class="form-control col-md-4 " id="author" placeholder=""  />

                                                    </div>
                                                    <%--<!--重复密码-->--%>
                                                    <%--<div class="form-group">--%>
                                                    <%--<label class="control-label col-md-4">重复密码</label>--%>
                                                    <%--<input type="password" name="repassword" class="form-control col-md-4 repassword" id="repassword" placeholder="重复密码" onblur="checkRepassword()" />--%>

                                                    <%--</div>--%>
                                                    <!--性别-->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">出版社：</label>
                                                        <input type="text" name="adr" class="form-control col-md-4 adr" id="adr" placeholder=""  />

                                                    </div>
                                                    <!--出生年月-->
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">书籍编号：</label>

                                                        <input type="text" id="num" name="num" class="form-control col-md-4 num" id="num" />

                                                    </div>
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">书籍封面:</label>
                                                        <input type="text" name="cover" class="form-control col-md-4 cover" id="cover" />
                                                    </div>
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">序:</label>
                                                        <textarea class="form-control col-md-4" name="sequence" rows="5" cols="50" ></textarea>
                                                    </div>

                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">导读:</label>
                                                        <textarea class="form-control col-md-4" name="idt" rows="5" cols="50" ></textarea>
                                                    </div>
                                                    <!--邮箱-->
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">内容:</label>
                                                        <textarea class="form-control col-md-4" name="btcontent" rows="5" cols="50" ></textarea>
                                                    </div>
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">藏书量:</label>
                                                        <input type="text" id="cobn" name="cobn" class="form-control col-md-4 cobn" />
                                                    </div>
                                                    <!--使用协议-->

                                                    <!--提交按钮-->
                                                    <div class="form-group submit_btn" >
                                                        <div class="col-md-offset-5 col-sm-10">
                                                            <button type="submit" class="btn btn-default">添加</button>
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
                    </div>
                </div>
                <%--权限管理--%>
                <div class="tab-pane fade"   id="4" style="padding-top: 30px;letter-spacing: 2px;">
                    <div  class="context_form" style="height:auto ">
                        <div style="height:10%">
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a> 权限管理  </a>
                                </li>
                            </ul>
                        </div>
                        <table class="table" style="text-align: center; letter-spacing: 2px;">
                            <thead>
                            <tr>
                                <td>管理员编号</td>
                                <td>管理员用户名</td>
                                <td>权限等级</td>
                                <td>升级权限</td>
                                <td>降低权限</td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr  ng-repeat="data in datas">
                                <td><s:property value="" default="null" /> </td>
                                <td><s:property value="" default="null" /></td>
                                <td><s:property value="" default="null" /></td>
                                <td>
                                    <a href="#">
                                        <img src="image/up.png" style="CURSOR: hand;height: 20px;">
                                    </a>
                                </td>
                                <td>
                                    <a href="#">
                                        <img src="image/down.png" style="CURSOR: hand;height: 20px;">
                                    </a>
                                </td>

                            </tr>
                            </tbody>
                        </table>

                    </div>
                </div>
                <%--&lt;%&ndash;消息管理&ndash;%&gt;--%>
                <%--<div class="tab-pane fade"   id="5" style="padding-top: 30px;letter-spacing: 2px;">--%>
                    <%--<div  class="context_form" style="height:auto;">--%>
                        <%--<div style="height:10%">--%>
                            <%--<ul  class="nav nav-tabs">--%>

                                <%--<li class="active">--%>
                                    <%--<a> 系统消息  </a>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                        <%--<table class="table" style="text-align: center; letter-spacing: 2px;">--%>
                            <%--<thead>--%>
                            <%--<tr style="font-size: 70px;">--%>
                                <%--<s:property value="" default="没有取到消息内容"/>--%>
                            <%--</tr>--%>
                            <%--</thead>--%>
                            <%--<tbody>--%>
                            <%--<tr  ng-repeat="data in datas" style="float: right">--%>
                                <%--<td ><s:property value="" default="系统本地时间" /></td>--%>
                            <%--</tr>--%>
                            <%--</tbody>--%>
                        <%--</table>--%>

                    <%--</div>--%>
                <%--</div>--%>
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
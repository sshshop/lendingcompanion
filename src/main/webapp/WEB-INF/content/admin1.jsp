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
    <script src="js/booktem.js"></script>
    <script src="js/register.js"  type="text/javascript" charset="utf-8"></script>
    <script src="js/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
    <%--<script>--%>
    <%--window.onload = function(){--%>
    <%--if(location.search.indexOf("?")==-1){--%>
    <%--location.href += "?myurl";--%>
    <%--}--%>
    <%--else{--%>
    <%--if(location.search.indexOf("myurl")==-1) location.href += "&myurl";--%>
    <%--}--%>
    <%--}--%>
    <%--</script>--%>
</head>
<body onload="userAdminPage(1,10)">
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
            <a class="register" href="adminloginOut.action">退出</a>
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
                <li class="active" style="margin-top: 20px;"><a href="adminUserforward.action" id="adminUser_a">用户管理</a></li>
                <li style="margin-top: 20px;"><a href="adminMsgforward.action" id="adminNews_a">公告管理</a></li>
                <li style="margin-top: 20px;"><a href="adminBookforward.action" id="adminBook_a">图书管理</a></li>
                <li style="margin-top: 20px;"><a href="adminAuthorityforward.action" id="adminAuthority_a">权限管理</a></li>
                <li style="margin-top: 20px;"><a href="adminBorrowforward.action" id="adminBorrow_a">借书管理</a></li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tab-content">
                <%--用户管理--%>
                <div class="tab-pane fade in active "
                     style="padding-top: 30px;letter-spacing: 2px;align-content: center; " id="1">
                    <div class="context_form" style=" height:auto; ">
                        <div style="height:10%">
                            <ul class="nav nav-tabs">

                                <li class="active">
                                    <a href="#adminUser" data-toggle="tab"> 用户管理 </a>
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
                                    <tbody id="adminUserTable">
                                    <s:iterator var="auser" value="allUser">
                                        <tr ng-repeat="data in datas">
                                            <td><s:property value="#auser.username"/></td>
                                            <td><s:property value="#auser.upassword"/></td>
                                            <td><s:property value="#auser.dob"/></td>
                                            <td><s:property value="#auser.phone"/></td>
                                            <td><s:property value="#auser.addr"/></td>
                                            <td><s:property value="#auser.email"/></td>
                                            <td>
                                                <a href="adminUserEdit.action?uid=<s:property value="#auser.uid" />">
                                                    <img src="image/edit.png" style="CURSOR: hand;height: 20px;">
                                                </a>
                                            </td>
                                            <td><a href="adminUserDel.action?uid=<s:property value="#auser.uid" /> "><img src="image/i_del.png" style="CURSOR: hand;height: 20px;"></a></td>
                                        </tr>
                                    </s:iterator>
                                    <tr>
                                        <ul class="pagination pagination-sm" id="adminUserPage">

                                        </ul>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <script>
                                var pageSize=0;//每页显示行数
                                var currentPage_=1;//当前页全局变量，用于跳转时判断是否在相同页，在就不跳，否则跳转。

                                function userAdminPage(pno,psize){
                                    var itable = document.getElementById("adminUserTable");
                                    var num = itable.rows.length;
                                    pageSize = psize;//每页显示行数
                                    //总共分几页
                                    if(num/pageSize > parseInt(num/pageSize)){
                                        totalPage=parseInt(num/pageSize)+1;
                                    }else{
                                        totalPage=parseInt(num/pageSize);
                                    }
                                    var currentPage = pno;//当前页数
                                    currentPage_=currentPage;
                                    var startRow = (currentPage - 1) * pageSize+1;
                                    var endRow = currentPage * pageSize;
                                    endRow = (endRow > num)? num : endRow;
                                    //遍历显示数据实现分页
                                    for(var i=1;i<(num+1);i++){
                                        var irow = itable.rows[i-1];
                                        if(i>=startRow && i<=endRow){
                                            irow.style.display = "";
                                        }else{
                                            irow.style.display = "none";
                                        }
                                    }
                                    var tempLi="";
                                    for(var i=1;i<=totalPage;i++)

                                    {
                                        tempLi+='<li value='+i+'><a href="#adminUser" onclick="jumpAdminUserPage('+i+')"> '+i+'</a></li>'
                                    }
                                    $("#adminUserPage").html(tempLi);
                                    $("#adminUserPage").val(currentPage);
                                }


                                function jumpAdminUserPage(i)
                                {
                                    var num=parseInt(i);
                                    console.log(pageSize);
                                    if(num!=currentPage_)
                                    {
                                        userAdminPage(num,pageSize);
                                    }
                                }
                            </script>
                            <div class="tab-pane fade" id="addUser">
                                <div class="context">
                                    <div class="row">
                                        <div class="col-md-2"></div>
                                        <div class="col-md-8">
                                            <!--注册表单-->
                                            <div>
                                                <form class="form-horizontal register" id="register" action="addUser.action">
                                                    <!--用户名-->
                                                    <div class="form-group">

                                                        <label class="control-label col-md-4">用户名</label>
                                                        <input type="text"  name="username"
                                                               class="form-control col-md-4 username" id="username"
                                                               onblur="checkUsername()"/>
                                                        <span style="color: red; font-size: 22px; margin-left: 4px; padding-top: 3px;">*</span>
                                                        <span id="username2" style="font-size: 10px; color: red " ></span>

                                                    </div>
                                                    <!--密码-->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">密码</label>
                                                        <input type="password" name="upassword" class="form-control col-md-4 password" id="upassword" placeholder="密码" onblur="checkUpassword()" />
                                                        <span style="color: red; font-size: 22px; margin-left: 4px; padding-top: 3px;">*</span>
                                                        <span id="upassword2" style="font-size: 10px; color: red " ></span>
                                                    </div>
                                                    <%--<!--重复密码-->--%>
                                                    <%--<div class="form-group">--%>
                                                    <%--<label class="control-label col-md-4">重复密码</label>--%>
                                                    <%--<input type="password" name="repassword" class="form-control col-md-4 repassword" id="repassword" placeholder="重复密码" onblur="checkRepassword()" />--%>

                                                    <%--</div>--%>
                                                    <!--性别-->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">性别:</label>
                                                        <span>
                                                            <input type="radio" name="sex1" class="sex" id="man"
                                                                   value="man" checked/>男
                                                            <input type="radio" name="sex1" class="sex" id="woman"
                                                                   value="woman"/>女
                                                        </span>
                                                    </div>
                                                    <!--出生年月-->
                                                    <div class="form-group">
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
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">电话</label>
                                                        <input type="text" name="phone" class="form-control col-md-4 phone" id="phone" placeholder="电话" onblur="checkPhone()" />
                                                        <span style="color: red; font-size: 22px; margin-left: 4px; padding-top: 3px;">*</span>
                                                        <span id="phone2" style="font-size: 10px; color: red " ></span>
                                                    </div>
                                                    <!--省份----城市-->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">省份</label>
                                                        <span>
                                                            <select name="province1" id="s1" style="width: 98px"
                                                                    onblur="checkProvince()">
                                                                <option id="pname1"></option>
                                                            </select>
                                                            <select name="city1" id="s2"  style="width: 98px"onblur="checkCity()">
                                                                <option id="cname"></option>
                                                            </select>

                                                            <SCRIPT language="javascript">
                                                                setup()
                                                            </SCRIPT>
                                                        </span>
                                                        <span style="color: red; font-size: 22px; margin-left: 4px; padding-top: 3px;">*</span>
                                                        <span id="city" style="font-size: 10px; color: red " ></span>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">详细地址</label>
                                                        <input type="text" name="addr" class="form-control col-md-4 addr" id="addr" placeholder="详细地址"  />
                                                    </div>
                                                    <!--邮箱-->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">邮箱地址</label>
                                                        <input type="text" id="email" name="email" class="form-control col-md-4 email"   placeholder="邮箱" onblur="return checkEmail()" />
                                                        <span style="color: red; font-size: 22px; margin-left: 4px; padding-top: 3px;">*</span>
                                                        <span id="email2" style="font-size: 10px; color: red " ></span>
                                                    </div>
                                                    <!--使用协议-->

                                                    <!--提交按钮-->
                                                    <div class="form-group submit_btn">
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
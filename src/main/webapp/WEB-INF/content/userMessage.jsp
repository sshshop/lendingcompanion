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
    <link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="laydate/laydate.js"></script>
    <script src="js/register.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>


</head>
<body>
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg" style="width: 100%;height: 100%;">
</div>
<!--头部页面-->
<%@include file="header.jsp" %>
<div style="width:80%;margin-top: 30px;align-content: center;">

    <div class="col-md-9 navigation" style="margin-left:25%;width:12%; letter-spacing: 2px;">

        <ul class="nav nav-pills nav-stacked" style="text-align: center ">
            <li class="active"><a href="#usermessage" data-toggle="tab">用户信息</a></li>
            <li style="margin-top: 20px;"><a href="#3" data-toggle="tab">我的订阅</a></li>
            <li style="margin-top: 20px;"><a href="#4" data-toggle="tab">我的评价</a></li>
            <li style="margin-top: 20px;"><a href="#2" data-toggle="tab">借阅信息</a></li>
            <li style="margin-top: 20px;"><a href="#5" data-toggle="tab">系统消息</a></li>

        </ul>

    </div>
    <div class="tab-content">
        <div class="tab-pane fade in active " style="padding-top: 30px;letter-spacing: 2px;align-content: center; "
             id="usermessage">
            <div class="context_form" style="width: 50%; margin-left: 43%; height:auto;">
                <div style="height:10%">

                    <ul class="nav nav-tabs">

                        <li class="active">
                            <a href="#bcontent" data-toggle="tab">
                                资&nbsp;料
                            </a>
                        </li>

                        <li><a href="#comment" data-toggle="tab">设&nbsp;置</a></li>
                    </ul>
                </div>
                <div class="tab-content">
                    <%--用户资料界面--%>
                    <div class="tab-pane fade in active " id="bcontent"
                         style="font-size: 15px;margin-top: 20px; margin-left: 35%">
                        <div class="form-group">

                            <label>用户名:</label>&nbsp;&nbsp;&nbsp;
                            <s:property value="#session.existedUser.username"/>
                        </div>

                        <div class="form-group" style=" ;padding-top: 30px">

                            <label>性别:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <s:if test="#session.existedUser.sex==1">男</s:if><s:else>女</s:else>
                        </div>

                        <div class="form-group" style=" ;padding-top: 30px">

                            <label>出生年月:</label>
                            <s:property value="#session.existedUser.dob"/>
                        </div>

                        <div class="form-group" style=" ;padding-top: 30px">

                            <label>联系电话:</label>
                            <s:property value="#session.existedUser.phone"/>
                        </div>

                        <div class="form-group" style=" ;padding-top: 30px">

                            <label>所属地址:</label>
                            <s:property value="#session.existedUser.province.pname"/>
                            <s:property value="#session.existedUser.city.cname"/>
                            <s:property value="#session.existedUser.addr"/>
                        </div>
                        <div class="form-group" style=" ;padding-top: 30px">

                            <label>邮箱地址:</label>
                            <s:property value="#session.existedUser.email"/>
                        </div>
                    </div>

                    <%--修改用户界面--%>
                    <div class="tab-pane fade " id="comment" style="padding-left: 6%;">

                        <div class="container context">
                            <div class="row">

                                <div class="col-md-6">
                                    <!--注册表单-->
                                    <div>
                                        <div class="form-horizontal register" id="register" action="">
                                            <!--用户名-->
                                            <div class="form-group" style=" padding-top: 10px">

                                                <label class="control-label col-md-4">用户名</label>
                                                <input type="text" value="<s:property value="#session.existedUser.username"/>" readonly name="username"
                                                       class="form-control col-md-4 username" id="username"
                                                       onblur="checkUsername()"/>


                                            </div>
                                            <%-- <!--密码-->
                                             <div class="form-group">
                                                 <label class="control-label col-md-4">密码</label>
                                                 <input type="password" name="upassword" class="form-control col-md-4 password" id="upassword" placeholder="密码" onblur="checkUpassword()" />

                                             </div>
                                             <!--重复密码-->
                                             <div class="form-group">
                                                 <label class="control-label col-md-4">重复密码</label>
                                                 <input type="password" name="repassword" class="form-control col-md-4 repassword" id="repassword" placeholder="重复密码" onblur="checkRepassword()" />

                                             </div>--%>
                                            <!--性别-->
                                            <div class="form-group" style=" padding-top: 10px">
                                                <label class="control-label col-md-4">性别</label>
                                                <input type="radio" name="sex1" class="sex" id="man" value="man"
                                                       checked/>男
                                                <input type="radio" name="sex1" class="sex" id="woman" value="woman"/>女
                                            </div>
                                            <!--出生年月-->
                                            <div class="form-group" style=" padding-top: 10px">
                                                <label class="control-label col-md-4">出生年月</label>

                                                <input type="text" id="borth" name="dob"
                                                       class="form-control col-md-4 borth laydate-icon" id="borth"
                                                       placeholder="出生年月" onclick="laydate()"/>


                                            </div>


                                            <script>
                                                laydate({
                                                    elem: '#borth',
                                                    format: 'YYYY/MM', // 分隔符可以任意定义，该例子表示只显示年月
                                                    festival: true, //显示节日
                                                    choose: function (datas) { //选择日期完毕的回调
                                                        alert('得到：' + datas);
                                                    }
                                                })
                                            </script>
                                            <!--电话-->
                                            <div class="form-group" style=" padding-top: 10px">
                                                <label class="control-label col-md-4">电话</label>
                                                <input type="text" name="phone" class="form-control col-md-4 phone"
                                                       id="phone" placeholder="电话" onblur="checkPhone()"/>
                                                <span id="phone2" style="font-size: 10px; color: red "></span>
                                            </div>
                                            <!--省份----城市-->
                                            <div class="form-group" style=" padding-top: 10px">
                                                <label class="control-label col-md-4">省份</label>
                                                <td>

                                                    <select name="province" id="s1" style="width: 98px"
                                                            onblur="checkProvince()">
                                                        <option id="pname1"></option>
                                                    </select>


                                                    <select name="city" id="s2" style="width: 98px"
                                                            onblur="checkCity()">
                                                        <option id="cname"></option>
                                                    </select>

                                                    <SCRIPT language="javascript">
                                                        setup()
                                                    </SCRIPT>

                                                </td>

                                            </div>

                                            <div class="form-group" style=" padding-top: 10px">
                                                <label class="control-label col-md-4">详细地址</label>
                                                <input type="text" name="addr" class="form-control col-md-4 addr"
                                                       id="addr" placeholder="详细地址"/>
                                            </div>
                                            <!--邮箱-->
                                            <div class="form-group" style=" padding-top: 10px">
                                                <label class="control-label col-md-4">邮箱地址</label>
                                                <input type="text" id="email" name="email"
                                                       class="form-control col-md-4 email" placeholder="邮箱"
                                                       onblur="return checkEmail()"/>
                                                <span id="email2" style="font-size: 10px; color: red "></span>
                                            </div>
                                            <!--使用协议-->

                                            <!--提交按钮-->
                                            <div class="form-group submit_btn">
                                                <div class="col-md-offset-5 col-sm-10">
                                                    <button type="submit" class="btn btn-default">修改</button>
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
        </div>

        <div class="tab-pane fade" id="2" style="padding-top: 30px; letter-spacing: 2px;">
            <div class="context_form" style="width: 50%; margin-left: 43%; height:75%; ">
                <div style="height:10%">
                    <ul class="nav nav-tabs">

                        <li class="active">
                            <a> 历史记录 </a>
                        </li>
                    </ul>
                </div>
                <table class="table" style="text-align: center; ">
                    <thead>
                    <tr>
                        <td>书籍名称</td>
                        <td>借书时间</td>
                        <td>取书时间</td>
                        <td>还书截止时间</td>
                        <td>已归还</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="data in datas">
                        <td><s:property value="" default="null"/></td>
                        <td><s:property value="" default="null"/></td>
                        <td><s:property value="" default="null"/></td>
                        <td><s:property value="" default="null"/></td>
                        <td><s:property value="" default="null"/></td>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>


        <div class="tab-pane fade" id="3" style="padding-top: 30px;letter-spacing: 2px;">
            <div class="context_form" style="width: 50%; margin-left: 43%; height:75%; ">
                <div style="height:10%">
                    <ul class="nav nav-tabs">

                        <li class="active">
                            <a> 我的订阅 </a>
                        </li>
                    </ul>
                </div>
                <table class="table" style="text-align: center; letter-spacing: 2px;">
                    <thead>
                    <tr>
                        <td>书籍封面</td>
                        <td>书籍名称</td>
                        <td>现存余量</td>
                        <td>取消订阅</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="data in datas">
                        <td><s:property value="" default="null"/></td>
                        <td><s:property value="" default="null"/></td>
                        <td><s:property value="" default="null"/></td>
                        <td><a href="">
                            <img src="image/i_del.png" border="0" style="CURSOR: hand;height: 20px;">
                        </a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="tab-pane fade" id="4" style="padding-top: 30px;letter-spacing: 2px;">
            <div class="context_form" style="width: 50%; margin-left: 43%; height:75%; ">
                <div style="height:10%">
                    <ul class="nav nav-tabs">

                        <li class="active">
                            <a> 我的评价 </a>
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
                    <tr ng-repeat="data in datas">
                        <td><s:property value="" default="null"/></td>
                        <td><s:property value="" default="null"/></td>
                        <td><s:property value="" default="null"/></td>

                    </tr>
                    </tbody>
                </table>

            </div>
        </div>

        <div class="tab-pane fade" id="5" style="padding-top: 30px;letter-spacing: 2px;">
            <div class="context_form" style="width: 50%; margin-left: 43%; height:75%; ">
                <div style="height:10%">
                    <ul class="nav nav-tabs">

                        <li class="active">
                            <a> 系统消息 </a>
                        </li>
                    </ul>
                </div>
                <table class="table" style="text-align: center; letter-spacing: 2px;">
                    <thead>
                    <tr style="font-size: 70px;">
                        <s:property value="" default="没有取到消息内容"/>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="data in datas" style="float: right">
                        <td><s:property value="" default="系统本地时间"/></td>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>


</div>


<!--底部页面-->
<div style="margin-top: 100px;">
    <%@include file="footer.jsp" %>
</div>
</div>
</body>
</html>
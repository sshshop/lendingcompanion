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
    <script src="js/register.js"  type="text/javascript" charset="utf-8"></script>
    <script src="js/laydate/laydate.js"  type="text/javascript" charset="utf-8"></script>
    <script src="js/pageJS.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg"
                                                                                          style="width: 100%;height: 100%;">
</div>
<!--头部页面-->
<%@include file="header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-2 " style="letter-spacing: 2px;margin-top: 30px;">
            <ul class="nav nav-pills nav-stacked" style="text-align: center ">
                <li class="active" ><a href="#1" data-toggle="tab">用户信息</a></li>
                <li style="margin-top: 20px;"> <a href="#3" data-toggle="tab">我的订阅</a></li>
                <li style="margin-top: 20px;"><a href="#4" data-toggle="tab">我的评价</a></li>
                <li style="margin-top: 20px;"><a href="#2" data-toggle="tab">借阅信息</a></li>
                <li style="margin-top: 20px;"><a href="#5" data-toggle="tab">系统消息</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="tab-content" >
                <div class="tab-pane fade in active " style="padding-top: 30px;letter-spacing: 2px;align-content: center; " id="1">
                    <div class="context_form" style=" height:auto;">
                        <div>
                            <ul  class="nav nav-tabs">

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
                            <div class="tab-pane fade in active " id="bcontent" style="font-size: 15px;margin-top: 20px; ">
                                <div class="form-group">

                                    <label>用户名:</label>&nbsp;&nbsp;&nbsp;
                                    <s:property value="#session.existedUser.username" />
                                </div>

                                <div class="form-group">

                                    <label>性别:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                  <s:if test="#session.existedUser.sex==1">
                                      男
                                  </s:if><s:else>女</s:else>
                                </div>

                                <div class="form-group">

                                    <label>出生年月:</label>
                                    <s:property value="#session.existedUser.dob" />
                                </div>

                                <div class="form-group">

                                    <label>联系电话:</label>
                                    <s:property value="#session.existedUser.phone" />
                                </div>

                                <div class="form-group">

                                    <label>所属地址:</label>
                                    <s:property value="#session.existedUser.province.pname" />
                                    <s:property value="#session.existedUser.city.cname" />
                                    <s:property value="#session.existedUser.addr" />
                                </div>
                                <div class="form-group">

                                    <label>邮箱地址:</label>
                                    <s:property value="#session.existedUser.email" />
                                </div>
                            </div>

                            <%--修改用户界面--%>
                            <div class="tab-pane fade " id="comment">

                                <div class="context" >
                                    <div class="row">
                                        <div class="col-md-2"></div>
                                        <div class="col-md-8" >
                                            <!--注册表单-->
                                            <div >
                                                <form class="form-horizontal register" id="register" action="updateUser.action" method="post">
                                                    <!--用户名-->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-4">用户名</label>
                                                        <input type="text"  value="<s:property value="#session.existedUser.username" />"  readonly  name="username" class="form-control col-md-4 username" id="username" onblur="checkUsername()" />
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

                                                        <input type="text" id="borth" name="dob" value=" <s:property value="#session.existedUser.dob" />" class="form-control col-md-4 borth laydate-icon" id="borth" placeholder="出生年月" onclick="laydate()" />

                                                    </div>

                                                    <script>
                                                        laydate({
                                                            elem: '#test1',
                                                            format: 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月
                                                            festival: true, //显示节日
                                                            choose: function(datas) { //选择日期完毕的回调
                                                                alert('得到：' + datas);
                                                            }})
                                                    </script>
                                                    <!--电话-->
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">电话</label>
                                                        <input type="text" name="phone" value=" <s:property value="#session.existedUser.phone" />" class="form-control col-md-4 phone" id="phone" placeholder="电话" />
                                                        <span id="phone2" style="font-size: 10px; color: red " ></span>
                                                    </div>
                                                    <!--省份----城市-->
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">省份</label>
                                                        <span>
                                                            <select name="province1" id="s1" style="width: 98px" onblur="checkProvince()" >
                                                                <option id="pname1"selected="selected"><s:property value="#session.existedUser.province.pname"/> </option>
                                                            </select>
                                                            <select name="city1" id="s2"  style="width: 98px"onblur="checkCity()">
                                                                <option id="cname" selected><s:property value="#session.existedUser.city.cname"/> </option>
                                                            </select>

                                                            <SCRIPT language="javascript">
                                                                setup()
                                                            </SCRIPT>
                                                        </span>
                                                    </div>

                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">详细地址</label>
                                                        <input type="text" name="addr" value=" <s:property value="#session.existedUser.addr" />" class="form-control col-md-4 addr" id="addr" placeholder="详细地址"  />
                                                    </div>
                                                    <!--邮箱-->
                                                    <div class="form-group" >
                                                        <label class="control-label col-md-4">邮箱地址</label>
                                                        <input type="text" id="email" name="email" value="<s:property value="#session.existedUser.email" />" class="form-control col-md-4 email"   placeholder="邮箱" onblur="return checkEmail()" />
                                                        <span id="email2" style="font-size: 10px; color: red " ></span>
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
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="tab-pane fade"   id="2" style="padding-top: 30px; letter-spacing: 2px;" onload="goPage(1,10)">
                    <div  class="context_form" style=" height:auto; ">
                        <div style="height:10%">
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a> 历史记录  </a>
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
                                <td>归还状态</td>
                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator var="mb"  value="#session.myborrow">
                            <tr  ng-repeat="data in datas">
                                <s:iterator var="ml" value="#mb.list">
                                <td><s:property value="#ml.bname" default="null" /> </td>
                                </s:iterator>
                                <td><s:property value="#mb.btime" default="null" /></td>
                                <td><s:property value="#mb.ttime" default="null" /></td>
                                <td><s:property value="#mb.rtime" default="null" /></td>
                                <td><s:if test="#mb.bstatus==1">请尽快去取书</s:if><s:elseif test="#mb.bstatus==2">亲，记得还书哦！</s:elseif><s:else>已经归还</s:else>
                                        <%--<s:property value="#mb.bstatus" default="null" />--%></td>
                            </tr>
                            </s:iterator>
                            <tr>
                                    <ul class="pagination pagination-sm" id="jumpWhere">

                                    </ul>
                            </tr>
                            </tbody>
                        </table>

                    </div>
                </div>


                <div class="tab-pane fade"   id="3" style="padding-top: 30px;letter-spacing: 2px;" onload="goPage(1,10)">
                    <div  class="context_form" style="height:auto; ">
                        <div style="height:10%">
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a> 我的订阅  </a>
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
                            <s:iterator var="sub" value="#session.mysub">
                                <s:iterator var="b" value="#sub.list">
                            <tr  ng-repeat="data in datas">
                                <td> <a href="findBookBybid.action?bid=<s:property value="#b.bid"/>" target="_blank"><img src="<s:property value="#b.bcover" />" style="height: 50px;width: 50px"></a> </td>
                                <td><a href="findBookBybid.action?bid=<s:property value="#b.bid"/>" target="_blank"><s:property value="#b.bname" /></a></td>
                                <td><s:property value="#b.nborrowed" /></td>
                                <td><a href="">
                                    <img src="image/i_del.png" border="0" style="CURSOR: hand;height: 20px;">
                                </a></td>
                            </tr>
                                </s:iterator>
                            </s:iterator>
                            <tr>
                                <ul class="pagination pagination-sm" id="jumpWhere1">
                                </ul>
                            </tr>
                            </tbody>
                        </table>
                        </div>
                </div>

                <div class="tab-pane fade"   id="4" style="padding-top: 30px;letter-spacing: 2px;" onload="goPage(1,10)">
                    <div  class="context_form" style="height:auto ">
                        <div style="height:10%">
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a> 我的评价  </a>
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
                            <s:iterator var="myc" value="#session.mycomment">
                            <tr  ng-repeat="data in datas">
                                <s:iterator var="book" value="#myc.list">
                                <td><a href="findBookBybid.action?bid=<s:property value="#book.bid"/>" target="_blank"><s:property value="#book.bname"  /></a> </td>
                                </s:iterator>
                                <td><s:property value="#myc.inf"  /></td>
                                <td><s:property value="#myc.bctime" /></td>

                            </tr>
                            </s:iterator>
                            <tr>
                                <ul class="pagination pagination-sm" id="jumpWhere2">

                                </ul>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="tab-pane fade"   id="5" style="padding-top: 30px;letter-spacing: 2px;">
                    <div  class="context_form" style="height:auto;">
                        <div style="height:10%">
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a> 系统消息  </a>
                                </li>
                            </ul>
                        </div>
                        <table class="table" style="text-align: center; letter-spacing: 2px;">
                            <thead>
                            <s:iterator var="n" value="#session.mynews">
                            <td style="font-size: 70px;">
                                <td><s:property value="#n.ncontent" default="没有取到消息内容"/></td>
                                <td ><s:property value="#n.time" default="系统本地时间" /></td>
                            </tr>
                           <%-- <tr  ng-repeat="data in datas" style="float: right">

                            </tr>--%>
                            </thead>
                            <tbody>
                            </s:iterator>
                            </tbody>
                        </table>
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
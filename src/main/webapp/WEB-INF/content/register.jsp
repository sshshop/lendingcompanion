<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">


    <title>“无微不至”的借阅伴侣</title>
    
    <link type="text/css" rel="stylesheet" href="laydate/skins/default/laydate.css" id="LayDateSkin">
    <link type="text/css" rel="stylesheet" href="laydate/need/laydate.css">
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="laydate/laydate.js"></script>
    
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css">

    <link type="text/css" rel="stylesheet" href="laydate/need/laydate.css">
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="laydate/laydate.js"></script>
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="js/register.js"  type="text/javascript" charset="utf-8"></script>
    <script src="js/laydate/laydate.js"  type="text/javascript" charset="utf-8"></script>

</head>
<body>
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg" style="width: 100%;height: 100%;"></div>
    <!-- 头部页面 -->
<%@include file="header.jsp" %>
    <form method="post"  action="registerPost.action" onsubmit="return checkForm();" name="register">
    <!-- 中间部分 -->
    <div class="container context">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <!--注册表单-->
                <div class="context_form">
                    <div class="form-horizontal register" id="register" action="" method="post">
                        <!--用户名-->
                        <div class="form-group">

                            <label class="control-label col-md-4">用户名</label>
                           <input type="text" name="username" class="form-control col-md-4 username" id="username" placeholder="用户名" onblur="checkUsername()" />
                            <%--<s:text name=""></s:text>--%>
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
                        <!--重复密码-->
                        <div class="form-group">
                            <label class="control-label col-md-4">重复密码</label>
                            <input type="password" name="repassword" class="form-control col-md-4 repassword" id="repassword" placeholder="重复密码" onblur="checkRepassword()" />
                            <span style="color: red; font-size: 22px; margin-left: 4px; padding-top: 3px;">*</span>
                            <span id="repassword2" style="font-size: 10px; color: red " ></span>
                        </div>
                        <!--性别-->
                        <div class="form-group">
                            <label class="control-label col-md-4">性别</label>
                            <input type="radio" name="sex1" class="sex" id="man"  value="man" checked />男
                            <input type="radio" name="sex1" class="sex" id="woman"  value="woman" />女
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
                            <td  >

                                <select name="province1" id="s1" style="width: 98px" onblur="checkProvince()" >
                                    <option id="pname1"></option>
                                </select>


                                <select name="city1" id="s2"  style="width: 98px"onblur="checkCity()">
                                    <option id="cname"></option>
                                </select>

                                <SCRIPT language="javascript">
                                    setup()
                                </SCRIPT>

                            </td>
                            <span style="color: red; font-size: 22px; margin-left: 4px; padding-top: 3px;">*</span>
                            <span id="city" style="font-size: 10px; color: red " ></span>
                        </div>
                        <%--<!--城市-->
                        <div class="form-group">
                            <label class="control-label col-md-4">城市</label>
                            <input type="text" name="city" class="form-control col-md-4 city" id="city" placeholder="城市" />
                            <span style="color: red; font-size: 22px; margin-left: 4px; padding-top: 3px;">*</span>
                        </div>--%>
                        <!--详细地址-->
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
                        <div class="form-group">
                            <label class="control-label col-md-3"></label>
                            <input style="width: auto" type="checkbox" name="xieyi" onclick="return checkedXieyi();">已经阅读了并完全同意<a class="protocol_a" href="#">《使用协议》</a>中的全部条款
                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                            <span id="xieyi" style="font-size: 10px; color: red " ></span>
                        </div>
                        <!--提交按钮-->
                        <div class="form-group submit_btn">
                            <div class="col-md-offset-5 col-sm-10">
                                <button type="submit" class="btn btn-default" onclick="checkPost();return false;">注册</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        </div>
    </div>

    </form>
    <!-- 底部页面 -->
<%@include file="footer.jsp"%>
</body>
</html>
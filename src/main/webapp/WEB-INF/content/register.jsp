<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">


    <title>注册</title>
    
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
    <div class="container header">
        <!-- 顶部信息 -->
        <div class="row header_title">
            <div class="col-md-4 header_title_left">

            </div>
            <div class="col-md-6 header_title_mid">
                <span>“无微不至”的借阅伴侣</span>
            </div>
            <div class="col-md-2 header_title_right">
                <a class="login" href="loginS.action">登录</a>
                <a class="register">注册</a>
                <a class="collect">收藏本站</a>
            </div>
        </div>
        <!-- logo以及搜索框 -->
        <div class="row header_main">
            <div class="col-md-5 logo">
                <img src="image/logo.png">
            </div>
            <div class="col-md-7 header_search">
                <form class="nameSearch_form" id="nameSearch_form" action="">
                    <span class="header_search_text">书名或作者名</span>
                    <input class="nameSearch" id="nameSearch" type="text" placeholder="请输入您要搜的书..." />
                    <button type="submit" class="glyphicon-search"></button>
                </form>
                <div class="header_search_title">
                    无微不至，搜你想搜
                </div>
            </div>
        </div>
        <!--导航栏-->
        <div class="row header_nav" id="header_nav">
            <div class="col-md-12">
                <a  href="index.action">主页</a>
                <a  href="#">热门推荐</a>
                <a  href="#">借书排行榜</a>
                <a  href="#">网站简介</a>
                <a  href="#">网站公告</a>
                <a  href="#">联系我们</a>
            </div>
        </div>
        <!--面包屑导航栏-->
        <div class="row header_smallNav">
            <div class="col-md-12">
                <span class="header_smallNav_text">您所在的位置:</span>
                <ol class="breadcrumb">
                    <li><a href="index.action">主页</a></li>
                    <li class="active">注册</li>
                </ol>
            </div>
        </div>
    </div>
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

                            <input type="text" id="borth" name="dob1" class="form-control col-md-4 borth laydate-icon" id="borth" placeholder="出生年月" onclick="laydate()" />



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
    <div class="footer">
        <div class="row img_information">
            <div class="col-md-3 img_item">
                <img class="img1" src="image/service_items_1.png">
            </div>
            <div class="col-md-3 img_item">
                <img class="img2" src="image/service_items_2.png">
            </div>
            <div class="col-md-3 img_item">
                <img class="img3" src="image/service_items_3.png">
            </div>
            <div class="col-md-3 img_item">
                <img class="img4" src="image/service_items_4.png">
            </div>
        </div>
        <div id="footer-2013">
            <div class="links">

                <a href="article-5.html" target="_blank">关于我们</a>
                |

                <a href="article-1056.html" target="_blank">法律声明</a>
                |

                <a href="article-24.html" target="_blank">诚征英才</a>
                |

                <a href="article-9.html" target="_blank">商家入驻</a>
                |

                <a href="article-12.html" target="_blank">加盟我们</a>
                |

                <a href="article-14.html" target="_blank">广告服务</a>
                |

                <a href="article-1045.html" target="_blank">客服中心</a>


            </div>

            <div class="copyright">
                Copyright © 2010-2017 XX借书网 www.XXX.com 版权所有 | E-mail：651081143@qq.com<br>


















                <br>

                相关备案信息：京ICP备10218744号-1｜京ICP证070359号｜京公网安备11011202001572号｜新出发京零字第通100048号

            </div>
        </div>
    </div>
</body>
</html>
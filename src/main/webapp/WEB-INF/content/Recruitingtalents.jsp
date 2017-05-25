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
                <li  ><a href="about.action"  >关于我们</a></li>
                <li style="margin-top: 20px;"> <a href="LagalStatement.action">法律声明</a></li>
                <li  class="active" style="margin-top: 20px;"><a href="Recruitingtalents.action"  >诚招英才</a></li>
                <li style="margin-top: 20px;"><a href="joinUs.action" >加盟我们</a></li>
                <li style="margin-top: 20px;"><a href="usuallyQuestion.action">常见问题</a></li>
                <li style="margin-top: 20px;"><a href="contactUs.action" >联系我们</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="tab-content" >
                  <div class="tab-pane fade in active" style="padding-top: 30px;letter-spacing: 2px;align-content: center; "id="3" >
                    <div class="context_form" style=" height:auto;" >
                        <div>
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a > 诚征英才  </a>
                                </li>


                            </ul>
                        </div>
                        <div class="tab-content">
                            <%--用户资料界面--%>
                            <div class="tab-pane fade in active"  style="font-size: 15px;margin-top: 20px; ">
                                <div class="context_form" style="border: 0;">
                                   <h4> 人事行政经理-沈阳仓</h4><br>
                                   <h4> Java开发工程师（采销部）</h4><br>
                                    <h4> Java开发工程师（运作部）</h4><br>
                                    <h4>高级JAVA开发工程师（架构部）</h4><br>
                                    <h4>JAVA开发工程师（订单支付及结算）</h4><br>
                                    <h4> 推荐算法Leader（西安）</h4><br>
                                    <h4> 自动化测试工程师（西安）</h4><br>
                                    <h4> 测试工程师（西安）</h4><br>
                                    <h4>推荐算法工程师（西安）</h4><br>
                                    <h4>java开发经理（运作部）</h4><br>
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
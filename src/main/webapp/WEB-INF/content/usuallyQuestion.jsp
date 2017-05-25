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
                <li  ><a href="about.action"   >关于我们</a></li>
                <li style="margin-top: 20px;"> <a href="LagalStatement.action">法律声明</a></li>
                <li style="margin-top: 20px;"><a href="Recruitingtalents.action"  >诚招英才</a></li>
                <li style="margin-top: 20px;"><a href="joinUs.action" >加盟我们</a></li>
                <li class="active" style="margin-top: 20px;"><a href="usuallyQuestion.action">常见问题</a></li>
                <li style="margin-top: 20px;"><a href="contactUs.action" >联系我们</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="tab-content" >

                <div class="tab-pane fade in active" style="padding-top: 30px;letter-spacing: 2px;align-content: center;"id="5" >
                    <div class="context_form" style=" height:auto;float: left" >
                        <div>
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a > 常见问题  </a>
                                </li>


                            </ul>
                        </div>
                        <div class="tab-content">
                            <%--用户资料界面--%>
                            <div class="tab-pane fade in active"  style="font-size: 15px;margin-top: 20px; ">
                                <div  style="border: 0;float: left" class="context_form" >

                                    <div  style="width: 33%;float: left">
                                    <h3>金融问题</h3><br>
                                    什么是京东钱包？<br>
                                    想要咨询白条支付等金融问题怎么办？<br>
                                    如何进行实名认证？<br>
                                    什么是退换货运费险？<br>
                                    退换货运费险理赔成功，在哪里查看是否到账？<br>
                                    </div >
                                    <div  style="width: 33%;float: left">
                                    <h3>售后服务</h3><br>
                                    申请了退货，为什么一直没退款？<br>
                                    我提交的售后返修单何时能为我审核？<br>
                                    书籍使用有问题，该如何处理？<br>
                                    书借错了，怎么办？<br>
                                    取消订单/退货后怎么退款给我？<br>
                                    什么情况下可以退货/换货/维修？<br>
                                    </div>
                                    <div style="width: 33%;float: left">
                                   <h3> 配送查询</h3><br>
                                    如何查询物流信息？<br>
                                    商品一直没收到，怎么办？<br>
                                    不方便收货，怎么办？<br>
                                    <h3>运费收取标准</h3><br>
                                    订单怎么一直显示正在出库？<br>
                                    我的包裹现在到哪里了？<br>
                                    </div>
                                    <div  style="width: 33%;float: left">
                                    <h3>订单咨询</h3><br>
                                    订单如何取消？<br>
                                    无货商品几天可以到货？<br>
                                    我的退款会给我退到哪里？<br>
                                    下单后可以修改订单吗？<br>
                                    如何区分京东自营销售和第三方卖家销售的商品？<br>
                                    </div>
                                    <div style="width: 33%;float: left">
                                    <h3>财务问题</h3><br>
                                    在结算页为什么无法使用优惠券？<br>
                                    余额提现怎么操作？<br>
                                    余额提现以后，为什么一直没到账？<br>
                                    支付方式有哪些？如何支付？<br>
                                    退款多久可以到账？<br>
                                    可以开发票吗？<br>
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
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
                <li style="margin-top: 20px;"><a href="usuallyQuestion.action">常见问题</a></li>
                <li class="active"  style="margin-top: 20px;"><a href="contactUs.action" >联系我们</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="tab-content" >
                <div class="tab-pane fade in active" style="padding-top: 30px;letter-spacing: 2px;align-content: center; "id="6" >
                    <div class="context_form" style=" height:auto;" >
                        <div>
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a > 联系我们  </a>
                                </li>


                            </ul>
                        </div>
                        <div class="tab-content">
                            <%--用户资料界面--%>
                            <div class="tab-pane fade in active"  style="font-size: 15px;margin-top: 20px;">
                                <div class="context_form" style="border: 0;">
                                   <div>在线云客服</div>
                                    <table class="table">
                                        <tr  style="text-align: center;">
                                            <td></td>
                                            <td>服务入口</td>
                                            <td>服务时间</td>
                                            <td>简要说明</td>
                                        </tr>
                                        <tr  >
                                            <td style="text-align: center;  vertical-align: middle;">在线云客服</td>
                                            <td style="text-align: center;  vertical-align: middle;">服务入口</td>
                                            <td style="text-align: center;  vertical-align: middle;">8:00 - 23:00</td>
                                            <td  >在线云客服为会员提供以下业务的专业咨询。<br>
                                                卖家 - 开店设置、商品问题、订单管理、消保咨询<br>
                                                卖家 - 店铺管理工具、旺铺装修、营销工具咨询<br>
                                                买家 - 挑选商品、购买付款、交易查询、活动咨询<br>
                                                暂未开放：账户问题、评价、退款投诉、维权咨询</td>
                                        </tr>
                                    </table>
                                </div>

                                <div class="context_form" style="border: 0;">
                                    <div>电话联系方式</div>
                                    <table class="table">
                                          <tr  >
                                            <td >集市消费者热线</td>
                                            <td  >0571-88158198</td>
                                            <td >7*24小时</td>
                                            <td  >为淘宝买家提供各种业务咨询</td>
                                        </tr>

                                        <tr >
                                            <td >阿里旅行服务热线</td>
                                            <td  >国内:<br>400-1688-688 国际:<br>+86-571-56888688</td>
                                            <td >7*24小时</td>
                                            <td  >阿里旅行服务热线提供机票、旅游度假、景点门票、酒店客栈、航空意外险的业务咨询</td>
                                        </tr>
                                        <tr>
                                            <td >农资市场招商热线</td>
                                            <td  >农资业务提供在线咨询服务</td>
                                            <td >周一～周五 9:00-18:00</td>
                                            <td  >提供淘宝农资市场入驻、业务合作咨询</td>
                                        </tr>
                                        <tr>
                                            <td >阿里妈妈热线</td>
                                            <td  >0571-88157999</td>
                                            <td >周一～周五 9:00-18:00</td>
                                            <td  >提供淘宝直通车、钻展、淘宝联盟、网销宝推广相关业务咨询</td>
                                        </tr>

                                    </table>
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
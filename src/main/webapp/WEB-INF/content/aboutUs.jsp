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
                <li class="active" ><a href="about.action"  >关于我们</a></li>
                <li style="margin-top: 20px;"> <a href="LagalStatement.action">法律声明</a></li>
                <li style="margin-top: 20px;"><a href="Recruitingtalents.action"  >诚招英才</a></li>
                <li style="margin-top: 20px;"><a href="joinUs.action" >加盟我们</a></li>
                <li style="margin-top: 20px;"><a href="usuallyQuestion.action">常见问题</a></li>
                <li style="margin-top: 20px;"><a href="contactUs.action" >联系我们</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="tab-content" >
                <div class="tab-pane fade in active " style="padding-top: 30px;letter-spacing: 2px;align-content: center; "  id="1" >
                    <div class="context_form" style=" height:auto;" >
                        <div>
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a href="#bcontent" data-toggle="tab">
                                        关于我们
                                    </a>
                                </li>


                            </ul>
                        </div>
                        <div class="tab-content">

                            <div class="tab-pane fade in active " id="bcontent" style="font-size: 15px;margin-top: 20px; ">
                                <div class="context_form" style="border: 0;"> &nbsp;&nbsp;&nbsp;《“无微不至”的借阅伴侣》是中国深受欢迎的网上图书借阅平台，目前拥有近5亿的注册用户数，每天有超过6000万的固定访客，同时每天的在线图书数已经超过了8亿本，平均每分钟借出4.8万本图书。截止2016年年底，《“无微不至”的借阅伴侣》网站单日交易额峰值达到43.8亿元，创造270.8万直接 且充分就业机会。随着《“无微不至”的借阅伴侣》网站规模的扩大和用户数量的增加，《“无微不至”的借阅伴侣》网站，目前已经成为世界范围的电子商务交易平台之一。<br>
                                    <br>
                                    &nbsp;&nbsp;&nbsp;《“无微不至”的借阅伴侣》网站致力于推动“货真价实、物美价廉、按需定制”网货的普及，帮助更多的消费者享用海量且丰富的网货，获得更高的生活品质；通过提供网络借阅平台等基础性服务，帮助更多的企业开拓市场、建立品牌，实现产业升级；帮助更多胸怀梦想的人通过网络 实现创业就业。新商业文明下的《“无微不至”的借阅伴侣》网站，正走在创造1000万就业岗位这下一个目标的路上。<br>
                                    <br>
                                    &nbsp;&nbsp;&nbsp;《“无微不至”的借阅伴侣》网站不仅是中国深受欢迎的网络借阅平台，也是中国的读书爱好者交流社区和全球创意书籍的集中地。《“无微不至”的借阅伴侣》网站在很大程度上改变了传统的生产方式，也改变了人们的生活消费方式。不做冤大头、崇尚时尚和个性、开放擅于交流的心态以及理性的思维，成为《“无微不至”的借阅伴侣》网站上崛起的“借阅一代”的重要特征。《“无微不至”的借阅伴侣》网站多样化的消费体验，让借阅一代们乐在其中：团设计、玩定制、赶时髦、爱传统。<br>
                                    <br>
                                    &nbsp;&nbsp;&nbsp;;9岁的借阅，从“牙牙学语”时的稚嫩懵懂到“青春少年”的活力潮流，用一种特殊的气质影响并改变着《“无微不至”的借阅伴侣》网站上的消费者、商家的流行态度和风尚趋势。潮流的平台揭示着潮流的趋势——《“无微不至”的借阅伴侣》网站引领的借阅潮流时代已然来临。</div>
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
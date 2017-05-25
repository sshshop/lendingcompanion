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
                <li class="active" style="margin-top: 20px;"> <a href="LagalStatement.action">法律声明</a></li>
                <li style="margin-top: 20px;"><a href="Recruitingtalents.action"  >诚招英才</a></li>
                <li style="margin-top: 20px;"><a href="joinUs.action" >加盟我们</a></li>
                <li style="margin-top: 20px;"><a href="usuallyQuestion.action">常见问题</a></li>
                <li style="margin-top: 20px;"><a href="contactUs.action" >联系我们</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="tab-content" >

                <div class="tab-pane fade in active" style="padding-top: 30px;letter-spacing: 2px;align-content: center; "id="2" >
                    <div class="context_form" style=" height:auto;" >
                        <div>
                            <ul  class="nav nav-tabs">

                                <li class="active">
                                    <a >
                                        法律声明
                                    </a>
                                </li>


                            </ul>
                        </div>
                        <div class="tab-content">
                            <%--用户资料界面--%>
                            <div class="tab-pane fade in active"  style="font-size: 15px;margin-top: 20px; ">
                                <div class="context_form" style="border: 0;">
                                    <h3>权利归属</h3>
                                    <br> &nbsp;&nbsp;&nbsp;除非《“无微不至”的借阅伴侣》网站另行声明，《“无微不至”的借阅伴侣》网站平台内的所有产品、技术、软件、程序、数据及其他信息（包括但不限于文字、图像、图片、照片、音频、视频、图表、色彩、版面设计、电子文档）的所有权利（包括但不限于版权、商标权、专利权、商业秘密及其他所有相关权利）均归《“无微不至”的借阅伴侣》网站或其关联公司所有。未经《“无微不至”的借阅伴侣》网站许可，任何人不得擅自使用（包括但不限于通过任何机器人、蜘蛛等程序或设备监视、复制、传播、展示、镜像、上载、下载《“无微不至”的借阅伴侣》网站平台内的任何内容）。<br>
                                    <br> &nbsp;&nbsp;&nbsp;《“无微不至”的借阅伴侣》网站平台的Logo、“无微不至”等文字、图形及其组合，以及《“无微不至”的借阅伴侣》网站平台的其他标识、徵记、产品和服务名称均为《“无微不至”的借阅伴侣》网站及其关联公司在中国和其它国家的商标，未经《“无微不至”的借阅伴侣》网站书面授权，任何人不得以任何方式展示、使用或作其他处理，也不得向他人表明您有权展示、使用或作其他处理。
                                     
                                    <h3>责任限制</h3><br>

                                    <br> &nbsp;&nbsp;&nbsp;鉴于《“无微不至”的借阅伴侣》网站平台提供的服务属于电子公告牌（BBS）性质，《“无微不至”的借阅伴侣》网站平台上的店铺、商品信息（包括但不限于店铺名称、公司名称、 联系人及联络信息、产品的描述和说明、相关图片、视频等）均由会员自行提供并上传，由会员对其提供并上传的所有信息承担相应法律责任。
                                     <br> &nbsp;&nbsp;&nbsp;《“无微不至”的借阅伴侣》网站平台转载作品（包括论坛内容）出于传递更多信息之目的，并不意味《“无微不至”的借阅伴侣》网站赞同其观点或已经证实其内容的真实性。<br>
                                     
                                    <h3>知识产权保护</h3>
                                     <br> &nbsp;&nbsp;&nbsp;《“无微不至”的借阅伴侣》网站尊重知识产权，反对侵权盗版行为。知识产权权利人认为《“无微不至”的借阅伴侣》网站平台内容（包括但不限于《“无微不至”的借阅伴侣》网站平台会员发布的商品信息）可能涉嫌侵犯其合法权益。</div>
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
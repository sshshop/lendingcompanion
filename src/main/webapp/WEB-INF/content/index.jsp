<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>“无微不至”的借阅伴侣</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg" style="width: 100%;height: 100%;"></div>
<!--头部页面-->
<%@include file="header.jsp"%>

<!--中间部分-->
<div class="container index">
    <div class="row">
        <div class="col-md-3 index_category">
            <div class="col-md-8 category_nav">
                <ol class="">
                    <s:iterator var="c" value="#session.category">
                        <li class="category_nav_item"><a href="#"><s:property value="#c.cname" /></a></li>
                    </s:iterator>
                </ol>
            </div>
        </div>
        <div class="col-md-9 index_information">
            <div class="row">
                <div class="col-md-9">
                    <div id="myCarousel" class="carousel slide">
                        <!-- 轮播（Carousel）指标 -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>
                        <!-- 轮播（Carousel）项目 -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <a href="#"><img src="image/40.jpg" alt="First slide"></a>
                            </div>
                            <div class="item">
                                <img src="image/39.jpg" alt="Second slide">
                            </div>
                            <div class="item">
                                <img src="image/42.jpg" alt="Third slide">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 borrowBook">
                    <div class="borrowBook_title"><strong>热门书籍排行榜</strong></div>
                    <s:iterator var="h" value="hbook">
                        <div class="row borrowBook_row">
                            <div class="col-md-10 bookname">
                                <a href="findBookBybid.action?bid=<s:property value="#h.bid"/>" style="display: inherit;"><span class="borrorBook_row_item"><s:property value="#h.bname" /></span></a>
                            </div>
                            <div class="col-md-2 bookgrade">
                                <span><s:property value="#h.hborrowed"/> </span>
                            </div>
                        </div>

                    </s:iterator>
                   <%-- <div class="row borrowBook_row">
                        <div class="col-md-4 bookname">
                            <span>三体</span>
                        </div>
                        <div class="col-md-4"></div>
                        <div class="col-md-4 bookgrade">
                            <span>123123</span>
                        </div>
                    </div>
                    <div class="row borrowBook_row">
                        <div class="col-md-4 bookname">
                            <span>三体</span>
                        </div>
                        <div class="col-md-4"></div>
                        <div class="col-md-4 bookgrade">
                            <span>123123</span>
                        </div>
                    </div>
                    <div class="row borrowBook_row">
                        <div class="col-md-4 bookname">
                            <span>三体</span>
                        </div>
                        <div class="col-md-4"></div>
                        <div class="col-md-4 bookgrade">
                            <span>123123</span>
                        </div>
                    </div>
                    <div class="row borrowBook_row">
                        <div class="col-md-4 bookname">
                            <span>三体</span>
                        </div>
                        <div class="col-md-4"></div>
                        <div class="col-md-4 bookgrade">
                            <span>123123</span>
                        </div>
                    </div>--%>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 index_booklist">
                    <span class="index_booklist_text">新书上架</span>
                </div>
            </div>
            <div class="row book_list">
                <div>
                    <s:iterator var="n" value="nbook">
                        <div class="col-md-3 book_list_item">
                            <a href="findBookBybid.action?bid=<s:property value="#n.bid"/> ">
                                <img src="<s:property value="#n.bcover" />" class="book_img">
                            </a>
                            <br>
                            <span class="bname"><a href="findBookBybid.action?bid=<s:property value="#n.bid"/> "><s:property value="#n.bname" /></a></span>
                            <br>
                            余量：<span class="hborrowed"><s:property value="#n.nborrowed" /></span>
                        </div>
                    </s:iterator>

                </div>
            </div>
        </div>
    </div>
</div>
<br>
<!--底部页面-->
<%@include file="footer.jsp"%>
</body>
</html>
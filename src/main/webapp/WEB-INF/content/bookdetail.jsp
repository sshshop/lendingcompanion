<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/bookdetail.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <title>书籍详情页</title>
</head>
<body>
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg"
                                                                                          style="width: 100%;height: 100%;">
</div>
<!--头部-->
<%@include file="header.jsp" %>
<!--中间-->
<div class="container index">
    <div class="row">
        <div class="col-md-3 index_about_book">
            <div class="col-md-9 about-book ">
                <div class="row" style="margin-bottom: 5px"><span STYLE="font-size: 20px">相关书籍</span></div>
                <div class="row">
                    <div class="about-book-imagediv"><img class="about-book-image" src="image/1/d02.png"
                                                          alt=""></div>
                    <div class=" about-book-detaildiv">
                        <span>《在那遥远的地方》</span>
                        <br>
                        <span>作者：谢晓晓</span>
                    </div>
                </div>
                <div class="row">
                    <div class="about-book-imagediv"><img class="about-book-image" src="image/1/d02.png"
                                                          alt=""></div>
                    <div class=" about-book-detaildiv">
                        <span>《在那遥远的地方》</span>
                        <br>
                        <span>作者：谢晓晓</span>
                    </div>
                </div>
                <div class="row">
                    <div class="about-book-imagediv"><img class="about-book-image" src="image/1/d02.png"
                                                          alt=""></div>
                    <div class=" about-book-detaildiv">
                        <span>《在那遥远的地方》</span>
                        <br>
                        <span>作者：谢晓晓</span>
                    </div>
                </div>
                <div class="row">
                    <div class="about-book-imagediv"><img class="about-book-image" src="image/1/d02.png"
                                                          alt=""></div>
                    <div class=" about-book-detaildiv">
                        <span>《在那遥远的地方》</span>
                        <br>
                        <span>作者：谢晓晓</span>
                    </div>
                </div>
                <div class="row">
                    <div class="about-book-imagediv"><img class="about-book-image" src="image/1/d02.png"
                                                          alt=""></div>
                    <div class=" about-book-detaildiv">
                        <span>《在那遥远的地方》</span>
                        <br>
                        <span>作者：谢晓晓</span>
                    </div>
                </div>
                <div class="row">
                    <div class="about-book-imagediv"><img class="about-book-image" src="image/1/d02.png"
                                                          alt=""></div>
                    <div class=" about-book-detaildiv">
                        <span>《在那遥远的地方》</span>
                        <br>
                        <span>作者：谢晓晓</span>
                    </div>
                </div>


            </div>
        </div>
        <div class="col-md-9 index-information">
            <!--书籍标题-->
            <div class="row" style="background-color:#91c2ad;height:19%;">
                <div class="col-md-12">
                    <h1 class="text-center" style="font-size: 25px">《<s:property value="model.bname"/>》
                        <small>作者：<s:property value="model.bauthor"/></small>
                    </h1>
                </div>
            </div>
            <!--书籍图片-->
            <div class="row book-detail" style="background-color: #FFFFFF;height:30% ">
                <div class="col-md-5 book-detail-bimgage"><img class="book-detail-bimgage-img img-responsive"
                                                               src="<s:property value="model.bcover"/>"></div>
                <!--书籍基本信息-->
                <div class="col-md-7 book-detail-bimgage book-detail-sign">
                    <div class="row test_color"><p class="text-left book-detail-sign-font">版本号:<s:property
                            value="model.bnum"/></p></div>
                    <div class="row test_color"><p class="text-left book-detail-sign-font">出版社:<s:property
                            value="model.badr"/></p></div>
                    <div class="row test_color"><p class="text-left book-detail-sign-font">所属分类:<s:property
                            value="model.category.cname"/></p></div>
                    <div class="row test_color"><p class="text-left book-detail-sign-font">历史借阅量:<s:property
                            value="model.hborrowed"/></p></div>
                    <div class="row test_color"><p class="text-left book-detail-sign-font">总藏书量:<s:property
                            value="model.bcobn"/></p></div>
                    <div class="row test_color"><p class="text-left book-detail-sign-font">未借阅量:<s:property
                            value="model.nborrowed"/></p></div>
                    <!--模态框测试-->

                    <button type="button" class="borrow" data-toggle="modal" data-target="#borrowModal"
                            style="padding: 0px;"><img src="image/borrow.gif"></button>
                </div>
            </div>
            <!--导读、简介、书评-->
            <div class="row book-detail-introductions" style="height:50%">
                <div class="row" id="book-detail-introduction">
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active">
                            <a href="#bcontent" data-toggle="tab">
                                内容简介
                            </a>
                        </li>
                        <li><a href="#bidt" data-toggle="tab">导读</a></li>
                        <li><a href="#bsequence" data-toggle="tab">绪论</a></li>
                        <li><a href="#comment" data-toggle="tab">书评</a></li>
                    </ul>
                </div>
            </div>
            <div class="row book-detail-introduction-content">
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade in active " id="bcontent">
                        <br>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="model.bcontent"/>
                        </p>
                    </div>
                    <div class="tab-pane fade" id="bidt">
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="model.bidt"/></p>
                    </div>
                    <div class="tab-pane fade" id="comment" style="position: relative">
                        <!--评价内容-->
                        <div class="col-md-12">
                            <!--评价详细内容start-->
                            <s:iterator var="p" value="pageBean">
                                <div class="row book-content">
                                    <div class="row"><s:property value="#p.inf"/></div>
                                    <div class="row" style="float:right;">评价时间：<s:property value="#p.bctime"/> &nbsp;&nbsp;&nbsp;&nbsp;用户：<s:property
                                            value="#p.username"/></div>
                                </div>
                                <br>
                            </s:iterator>
                            <!--评价内容end-->
                        </div>
                        <div class="row" style="height: 10%; float: right; margin-right: 30px;">
                            <ul class="pagination pagination-sm">
                                <li><a href="findBookBybid.action?bid=<s:property value="model.bid"/>&page=<s:property value="pageBean.page-1"/> ">&laquo;</a></li>
                                <li><a href="#comment">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">6</a></li>
                                <li><a href="findBookBybid.action?bid=<s:property value="model.bid"/>&page=<s:property value="pageBean.page+1"/> ">&raquo;</a></li>

                            </ul>

                        </div>

                    </div>
                    <div class="tab-pane fade" id="bsequence">
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="model.bsequence"/></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--模态框主体start-->
<div class="modal fade" id="borrowModal" tabindex="-1" role="dialog" aria-labelledby="borrowLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="borrowLabel">您还没有登录，请先登录</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <form class="loginform form-horizontal" id="loginform" method="post">
                            <div class="form-group">
                                <input class="form-control username" id="username" placeholder="请输入用户名"/>
                            </div>
                            <div class="form-group">
                                <input class="form-control password" id="password" placeholder="请输入密码"/>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">登录</button>
            </div>
        </div>
    </div>
</div>
<!--模态框主体end-->

<!--尾部-->
<%@include file="footer.jsp" %>

</body>
</html>
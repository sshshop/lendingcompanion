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
    <link type="text/css" rel="stylesheet" href="laydate/skins/default/laydate.css" id="LayDateSkin">
    <link type="text/css" rel="stylesheet" href="laydate/need/laydate.css">
    <script src="js/pageJS.js"></script>
    <script src="js/jquery-2.1.1/jquery.js"></script>
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="laydate/laydate.js"></script>
    <title>“无微不至”的借阅伴侣</title>
</head>
<body onload="goPage(1,7)">
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg"
                                                                                          style="width: 100%;height: 100%;">
</div>
<!--头部-->
<
<%@include file="header.jsp" %>

<!--中间-->
<div class="container index">
    <div class="row">
        <div class="col-md-3 index_about_book">
            <div class="col-md-9 about-book ">
                <div class="row" style="margin-bottom: 5px"><span STYLE="font-size: 20px">相关书籍</span></div>
                <s:iterator var="c" value="category">
                    <div class="row">
                        <div class="about-book-imagediv"><a
                                href="findBookBybid.action?bid=<s:property value="#c.bid"/>"><img
                                class="about-book-image" src="<s:property value="#c.bcover"/> " alt=""></a></div>
                        <div class=" about-book-detaildiv">
                            <span><a
                                    href="findBookBybid.action?bid=<s:property value="#c.bid"/>">《<s:property
                                    value="#c.bname"/> 》</a></span>
                            <br>
                                <%--加上搜索链接--%>
                            <a href="findAuthor.action?bauthor=<s:property value="#c.bauthor"/>">
                                <span>作者：<s:property value="#c.bauthor"/> </span>
                            </a>

                        </div>
                    </div>
                </s:iterator>
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
                        <div class="col-md-12" id="count">
                            <!--评价详细内容start-->
                            <s:iterator var="p" value="pageBean">
                                <div class="row book-content">
                                    <div class="row"><s:property value="#p.inf"/></div>
                                    <div class="row" style="float:right;">评价时间：<s:property value="#p.bctime"/> &nbsp;&nbsp;&nbsp;&nbsp;用户：<s:property
                                            value="#p.username"/></div>
                                </div>
                            </s:iterator>
                            <!--评价内容end-->
                        </div>
                        <div class="row" style="height: 50px; float: right; margin-right: 30px;">
                            <ul class="pagination pagination-sm" id="jumpWhere">

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
                <h4 class="modal-title" id="borrowLabel">
                    <s:if test="#session.existedUser == null">
                        您还没有登录，请先登录
                    </s:if><s:else>
                    <s:if test="model.nborrowed > 0">
                        请选择您的取书时间和还书时间
                    </s:if><s:else>
                    啊哦~已经没有余量了
                </s:else>
                </s:else>
                </h4>
            </div>
            <div class="modal-body logindiv">
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-8 logindiv">
                        <s:if test="#session.existedUser == null">
                            <form class="loginform form-horizontal" id="loginform" method="post"
                                  action="loginJumpThis.action?bid=<s:property value="model.bid"/>">
                                <div class="form-group">
                                    <input class="form-control username" name="username" id="username"
                                           placeholder="请输入用户名"/>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control password" name="upassword" id="upassword"
                                           placeholder="请输入密码"/>
                                </div>
                                <button type="submit" class="btn btn-primary">登录</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </form>
                        </s:if><s:else>
                        <s:if test="model.nborrowed > 0">
                            <form class="" method="post" action="addBorrowBook.action?bid=<s:property value="model.bid"/>">
                                <div class="form-group row">
                                    <label class="control-label col-md-4">取书时间</label>
                                    <input style="height: 50px;" type="text" name="ttime" class="form-control col-md-4 laydate-icon"
                                           id="borrowTime"/>
                                </div>
                                <div class="form-group row">
                                    <label class="control-label col-md-4">还书时间</label>
                                    <input style="height: 50px;" type="text" name="rtime" class="form-control col-md-4 laydate-icon"
                                           id="takeTime"/>
                                </div>
                                <button type="submit" class="btn btn-primary">借阅</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </form>
                        </s:if><s:else>
                        <p style="font-size: 18px;color: #000;">亲！这本书已经没有余量了，点击下方的收藏按钮我们会在有书的第一时间通知您的哟</p>
                        <form class="loginform form-horizontal" id="loginform" method="post"
                              action="addSubscription.action?bid=<s:property value="model.bid"/>">
                            <button class="btn btn-primary">收藏</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </form>
                    </s:else>
                    </s:else>
                    </div>
                    <div class="col-md-2"></div>
                </div>
            </div>
            <div class="modal-footer logindiv">
                <%--
                                <s:if test="#session.loginedUser == null">
                                </s:if><s:else>
                                <s:if test="model.nborrowed > 0">
                                </s:if><s:else>
                                <button class="btn btn-primary">收藏</button>
                            </s:else>
                            </s:else>--%>
            </div>
        </div>
    </div>
</div>
<!--模态框主体end-->

<!--尾部-->
<%@include file="footer.jsp" %>

</body>
<script>
    var star = {
        elem: '#borrowTime',
        format: 'YYYY-MM-DD hh:mm:ss',
        min: laydate.now(),
        max: laydate.now(3),
        istime: true,
        istoday: false,
        choose: function (datas) {
            end.min = datas;//开始日选好以后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };

    var end = {
        elem: '#takeTime',
        format: 'YYYY-MM-DD hh:mm:ss',
        min: laydate.now(),
        max: '2099-12-30',
        istime: true,
        istoday: false,
        choose: function (datas) {
            start.max = datas;
        }
    };
    laydate(star);
    laydate(end)

</script>
</html>
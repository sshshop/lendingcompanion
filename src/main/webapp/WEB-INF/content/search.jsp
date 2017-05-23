<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>“无微不至”的借阅伴侣</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/productlist.css">
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
        <div class="col-md-2 index_category">
            <div class="col-md-10 category_nav">
                <ol class="">
                    <s:if test="#session.existedUser != null">
                        <span style="float: left;">相关历史搜索：</span></br>
                        <s:iterator var="book" value="recentSearchBook">
                                <span style="width: 190px;margin:0 auto;margin-left: -10px;">
                                    <a href="findBookBybid.action?bid=<s:property value="#book.bid"/>">
                                        <img style="width:130px;height: 140px " src="<s:property value="#book.bcover" />">
                                    </a>
                                </span>
                                <a href="findBookBybid.action?bid=<s:property value="#book.bid"/>">
                                    <span><s:property value="#book.bname"/></span>
                                </a> </br>
                                <a href="findAuthor.action?bauthor=<s:property value="#book.bauthor"/>">
                                <span><small>作者：<s:property value="#book.bauthor"/></small></span></a></br>
                        </s:iterator>
                    </s:if>

                    <s:else>
                        <span style="float: left;margin-left: -10px">您可能感兴趣：</span></br>
                        <s:iterator var="book" value="recentSearchBook">
                            <span style="width: 190px;margin:0 auto;margin-left: -10px;">
                                <a href="findBookBybid.action?bid=<s:property value="#book.bid"/>">
                                    <img style="width:130px;height: 140px " src="<s:property value="#book.bcover" />">
                                </a>
                            </span>
                            <a href="findBookBybid.action?bid=<s:property value="#book.bid"/>">
                                <span><s:property value="#book.bname"/></span>
                            </a> </br>
                            </br>
                            <a href="findAuthor.action?bauthor=<s:property value="#book.bauthor"/>">
                            <span><small>作者：<s:property value="#book.bauthor"/></small></span></a></br>
                        </s:iterator>
                    </s:else>
                </ol>
            </div>
        </div>
        <div class="col-md-10 index_information">
            <!--显示搜索结果start-->
            <div style="float: right;margin-right: 5px">
                <s:iterator var="pageBean" value="pageBean">
                    <tr>
                        <td>共查询<s:property value="#pageBean.totalCount"/>条信息<br/></td>
                    </tr>
                </s:iterator>
            </div>
            <s:actionmessage/>
            <s:iterator var="BookList" value="BookList">
                <div class="productlist">
                    <div class="row productlist_2" style="overflow: hidden">
                        <div class="col-md-3 productlistimg">
                            <a href="findBookBybid.action?bid=<s:property value="#BookList.bid"/>"><img src="<s:property value="#BookList.bcover"/>"></a>
                        </div>
                        <div class="col-md-8 productlistcontent">
                            <div class="row productlistname">
                                <a href="findBookBybid.action?bid=<s:property value="#BookList.bid"/>">
                                    <span class="bname">书名：<s:property value="#BookList.bname"  escapeHtml="escapeHtml"/></span>
                                </a>
                            </div>
                            <div class="row productlistauthor">
                                <span class="bauthor"><a href="findAuthor.action?bauthor=<s:property value="#BookList.bauthor"/>">作者:<s:property value="#BookList.bauthor" escapeHtml="escapeHtml"/>
                                </a>
                                </span>
                            </div>
                            <div class="row productlistauthor">
                                <span class="bauthor">出版社：<s:property value="#BookList.badr" escapeHtml="escapeHtml"/></span>
                            </div>
                            <div class="row productlisttext">
                                <span class="bnumber">图书编号：<s:property value="#BookList.bnum" escapeHtml="escapeHtml"/></span>
                            </div>
                            <div class="row">
                                <div class="borrowButton">
                                    <button type="button" class="borrow" data-toggle="modal" data-target="#borrowModal"><img src="image/borrow.gif"></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </s:iterator>
            <!--显示搜索结果end-->

            <!--分页标签start 不要删-->
        <s:iterator begin="var item=1" var="pageBean" value="pageBean" status="s">
            <s:if test="pageBean.totalPage!=0">
                <div class="row" style="text-align: center">
                    <ul class="pagination">
                        <li></li>
                        <li><a <s:if test="pageBean.page != 1"> href="searchBookInfo.action?page=1&inputInfo= <%= request.getAttribute("inputInfo") %>"</s:if>>首页</a></li>
                        <li><a <s:if test="pageBean.page > 1"> href="searchBookInfo.action?page=<s:property value="pageBean.page-1"/>&inputInfo= <%= request.getAttribute("inputInfo") %>" </s:if>>上一页</a></li>
                        <li><a <s:if test="pageBean.page < pageBean.totalPage"> href="searchBookInfo.action?page=<s:property value="pageBean.page+1"/>&inputInfo= <%= request.getAttribute("inputInfo") %>"</s:if>>下一页</a></li>
                        <li><a <s:if test="pageBean.page != pageBean.totalPage&&pageBean.totalPage>0"> href="searchBookInfo.action?page=<s:property value="pageBean.totalPage"/>&inputInfo= <%= request.getAttribute("inputInfo") %>"</s:if>>尾页</a></li>
                        <li><select style="border: 0px;height: 33px">
                            <s:if test="1 < pageBean.page">
                                <option><a href="searchBookInfo.action?page=<s:property value="pageBean.page-1"/>&inputInfo= <%= request.getAttribute("inputInfo") %>">第<s:property value="pageBean.page-1"/>/<s:property value="pageBean.totalPage"/>页</a></option>
                            </s:if>
                            <a href=""><option selected>第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页</option></a>
                            <s:if test="pageBean.page < pageBean.totalPage">
                                <option><a href="searchBookInfo.action?page=<s:property value="pageBean.page+1"/>&inputInfo= <%= request.getAttribute("inputInfo") %>">第<s:property value="pageBean.page+1"/>/<s:property value="pageBean.totalPage"/>页</a></option>
                            </s:if>
                        </select></li>
                    </ul>
                </div>
            </s:if>
        </s:iterator>
            <!--分页标签END-->
        </div>
    </div>
</div>
<br>
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
<!--底部页面-->
<%@include file="footer.jsp"%>
</body>
</html>

</body>
</html>

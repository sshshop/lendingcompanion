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
                                <span class="bname">书名：<s:property value="#BookList.bname"  escapeHtml="escapeHtml"/></span>
                            </div>
                            <div class="row productlistauthor">
                                <span class="bauthor">作者：<s:property value="#BookList.bauthor" escapeHtml="escapeHtml"/></span>
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
        <s:iterator begin="var item=1" var="pageBean" value="pageBean">
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
<!--模态框主体start-->
<div class="modal fade" id="borrowModal" tabindex="-1" role="dialog" aria-labelledby="borrowLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form class="loginform form-horizontal" id="loginform" method="post" action="userLogin.action">
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
                                    <div class="form-group">
                                        <input class="form-control username" name="username" id="username" placeholder="请输入用户名" />
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control password" id="password" name="upassword" placeholder="请输入密码" />
                                    </div>
                            </div>
                        <div class="col-md-4"></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">登陆</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--模态框主体end-->
<!--底部页面-->
<%@include file="footer.jsp"%>
</body>
</html>

</body>
</html>

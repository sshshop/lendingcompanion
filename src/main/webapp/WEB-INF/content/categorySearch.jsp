<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>分类搜索</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/productlist.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="js/jquery-2.1.1/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body onload="goPage(1,12)">
<div style="position:fixed;left: 0px;top: 0px;width:100%;height: 100%; z-index: -1;"><img src="image/background.jpg"
                                                                                          style="width: 100%;height: 100%;">
</div>
<!--头部页面-->
<%@include file="header.jsp" %>

<!--中间部分-->
<div class="container index">
    <div class="row">
        <div class="col-md-3 index_category">
            <div class="col-md-8 category_nav">
                <ol class="">
                    <s:iterator var="c" value="#session.category">
                        <li class="category_nav_item"><a
                                href="findBookByCid.action?cid=<s:property value="#c.cid"/>"><s:property
                                value="#c.cname"/></a></li>
                    </s:iterator>
                </ol>
            </div>
        </div>
        <div class="col-md-9 index_information">
            <!--显示搜索结果start-->
            <div class="row">
                <div class="col-md-12 index_booklist">
                    <span class="index_booklist_text"><s:property value="#session.categoryName.cname"/> </span>
                </div>
            </div>
            <div class="row book_list" id="count">

                <s:iterator var="c" value="cbook">
                    <div class="col-md-3 book_list_item">
                        <a href="#">
                            <a href="findBookBybid.action?bid=<s:property value="#c.bid"/>&cid=<s:property value="c.cid" />"><img
                                    src="<s:property value="#c.bcover"/> " class="book_img">
                            </a>
                            <br>
                            <span class="bname"><a
                                    href="findBookBybid.action?bid=<s:property value="#c.bid"/>&cid=<s:property value="c.cid" />">《<s:property
                                    value="#c.bname"/>》</a></span>
                            <br><%--作者搜索--%>
                            作者：<s:property value="#c.bauthor"/><span class="hborrowed"></span>
                    </div>
                </s:iterator>

            </div>
            <!--热门推荐-->
            <div class="row" style="height: 50px; float: right; margin-right: 30px;">
                <ul class="pagination pagination-sm" id="jumpWhere">

                </ul>

            </div>
        </div>
    </div>
</div>
<br>

<!--底部页面-->
<%@include file="footer.jsp" %>
</body>
<script>
    var pageSize = 0;//每页显示行数
    var currentPage_ = 1;//当前页全局变量，用于跳转时判断是否在相同页，在就不跳，否则跳转。
    function goPage(pno, psize) {
        var divNum = document.getElementById("count");
        var num = divNum.getElementsByClassName("book_list_item").length;
        var divCount = divNum.getElementsByClassName("book_list_item");
        pageSize = psize;//每页显示行数
        //总共分几页
        if (num / pageSize > parseInt(num / pageSize)) {
            totalPage = parseInt(num / pageSize) + 1;
        } else {
            totalPage = parseInt(num / pageSize);
        }
        var currentPage = pno;//当前页数
        currentPage_ = currentPage;
        var startRow = (currentPage - 1) * pageSize + 1;
        var endRow = currentPage * pageSize;
        endRow = (endRow > num) ? num : endRow;
        //遍历显示数据实现分页
        for (var i = 1; i < (num + 1); i++) {
            var irow = divCount[i - 1];
            if (i >= startRow && i <= endRow) {
                irow.style.display = "";
            } else {
                irow.style.display = "none";
            }
        }
        var tempLi = "";
        for (var i = 1; i <= totalPage; i++) {
            tempLi += '<li value=' + i + '><a href="#comment" onclick="jumpPage(' + i + ')"> ' + i + '</a></li>'
        }
        $("#jumpWhere").html(tempLi);
        $("#jumpWhere").val(currentPage);
    }


    function jumpPage(i) {
        var num = parseInt(i);
        console.log(pageSize);
        if (num != currentPage_) {
            goPage(num, pageSize);
        }
    }
</script>
</html>
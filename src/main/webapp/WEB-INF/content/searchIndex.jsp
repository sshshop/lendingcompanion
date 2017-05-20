<%--
  Created by IntelliJ IDEA.
  User: jidy
  Date: 2017/5/16
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>“无微不至”的借阅伴侣</title>
    <script>
        var inputInfo = <%= request.getAttribute("inputInfo") %>;
    </script>
</head>
<body>
        <form method="post" action="searchBookInfo.action">
            <input id="inputInfo" name="inputInfo"  placeholder="请输入您要搜索的作品" value="<%=request.getParameter("inputInfo")%>" >
            <input type="submit" name="submit" value="搜索">
        </form>

        <s:actionmessage/>

    <s:iterator var="pageBean" value="pageBean">
        <tr>
            <td>共查询<s:property value="#pageBean.totalCount"/>条信息<br/></td>
        </tr>
    </s:iterator>

    <s:iterator var="BookList" value="BookList">
        <tr>
            <td>图片：<img width="40" height="45" src="<s:property value="#BookList.image"/>"><br/></td>
        </tr>
        <tr>
            <td>书名：<a href="#"><s:property value="#BookList.bname"/></a><br/></td>
        </tr>
        <tr>
            <td>作者：<s:property value="#BookList.bauthor"/><br/></td>
        </tr>
        <tr>
            <td>编号：<s:property value="#BookList.bnum"/><br/></td>
        </tr>
        <tr>
            <td>出版社：<s:property value="#BookList.badr"/><br/></td>
        </tr>
        <tr>
            <td>藏书量：<s:property value="#BookList.bcobn"/><br/></td>
        </tr>
        <tr>
            <td>余 量：<s:property value="#BookList.nborrowed"/><br/></td>
        </tr>
        <tr>
            <td> <a href="#">订阅</a></td>&nbsp;&nbsp;<td><a href="#">详情</a><br/></td>
        </tr>
    </s:iterator>

        <s:iterator var="pageBean" value="pageBean">
            第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页
            <s:if test="pageBean.page != 1">
                <a href="searchBookInfo.action?page=1&inputInfo= <%= request.getAttribute("inputInfo") %>">首页</a>|
                <a href="searchBookInfo.action?page=<s:property value="pageBean.page-1"/>&inputInfo= <%= request.getAttribute("inputInfo") %>">上一页</a>|
            </s:if>
            <s:if test="pageBean.page != pageBean.totalPage">
                <a href="searchBookInfo.action?page=<s:property value="pageBean.page+1"/>&inputInfo= <%= request.getAttribute("inputInfo") %>">下一页</a>|
                <a href="searchBookInfo.action?page=<s:property value="pageBean.totalPage"/>&inputInfo= <%= request.getAttribute("inputInfo") %>">尾页</a>|
            </s:if>
        </s:iterator>

</body>
</html>

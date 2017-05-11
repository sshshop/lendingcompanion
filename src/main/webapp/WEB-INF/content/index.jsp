<%--
  Created by IntelliJ IDEA.
  User: Rabit
  Date: 2017/5/6
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>hello world</title>
</head>
<body>
<h1>WEB-INF/content下的index.jsp</h1>
    <tbody>
        <div style="width:200px;height:150px;float: left;">
            <s:iterator var="BookInfo" value="Booklist" >
                <tr>
                    <td width="60"><img src="${ pageContext.request.contextPath }/<s:property value="#BookInfo.bcover"/>" /><br/></td>
                </tr>
                <tr>
                    <td>书名：<s:property value="#BookInfo.bname" /><br/></td>
                </tr>
                <tr>
                    <td>作者：<s:property value="#BookInfo.bauthor" /><br/></td>
                </tr>
                <tr>
                    <td>出版社：<s:property value="#BookInfo.badr" /><br/></td>
                </tr>
                <tr>
                    <td>余量：<s:property value="#BookInfo.nborrowed" /><br/></td>
                </tr>
            </s:iterator>
        </div>
    </tbody>
</body>
</html>

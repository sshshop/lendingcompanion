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
        <s:iterator var="BookInfo" value="Booklist" >
            <tr>
                <td width="60"><img src="${ pageContext.request.contextPath }/<s:property value="#BookInfo.bcover"/>" /></td>
            </tr>
            <tr>
                <td><s:property value="#BookInfo.bname" /></td>
            </tr>
            <tr>
                <td><s:property value="#BookInfo.bauthor" /></td>
            </tr>
            <tr>
                <td><s:property value="#BookInfo.nborrowed" /></td>
            </tr>
        </s:iterator>
    </tbody>
</body>
</html>

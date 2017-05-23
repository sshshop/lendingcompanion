<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Scream
  Date: 2017/5/24
  Time: 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:property value="#session.existedUser.uid"/>
<form class="loginform form-horizontal" id="loginform" method="post" action="addBookcomment.action?bid=<s:property value="BBBID.bid"/>&bbid=<s:property value="BBBID.bbid"/>">
        <textarea rows="5" cols="60" name="inf" id="bookcomment"></textarea>
    <button type="submit" class="btn btn-primary">提交</button>
</form>
</body>
</html>

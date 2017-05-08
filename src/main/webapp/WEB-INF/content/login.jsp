<%--
  Created by IntelliJ IDEA.
  User: 盖世太保
  Date: 2017/5/7
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<form method="post"  action="${pageContext.request.contextPath}/userLogin.action">
    <input type="text" id="username" name="username"/><br/>
    <input type="password" id="upassword" name="upassword"><br/>
    <input type="submit" value="登录">
</form>
<body>

</body>
</html>

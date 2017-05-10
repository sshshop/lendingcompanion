<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>搜索</title>
    <link href="./css/base.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/searchBookInfo.action">
        <input id="bname" name="bname"  placeholder="请输入您要搜索的作品" >
        <input type="submit" name="submit" value="搜索">
    </form>
</body>
</html>


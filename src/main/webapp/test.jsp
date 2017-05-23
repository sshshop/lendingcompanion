<%--
  Created by IntelliJ IDEA.
  User: Rabit
  Date: 2017/5/22
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="hh()">

<select id="select1">

</select>
<script>
    function hh() {
        var tempOp="";
        var op ="1,2,3,4,5";
        var oit=op.split(",");
        alert(oit.length);
        for (var  x=0; x<oit.length;x++){
            tempOp+='<option value='+i+'>'+i+'</option>';
            alert(oit[i]);
        }
        $("select1").html(tempOp)
    }
</script>
</body>
</html>

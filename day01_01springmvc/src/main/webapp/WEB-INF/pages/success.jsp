<%--
  Created by IntelliJ IDEA.
  User: 87392
  Date: 2019/10/16
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>入门成功</title>
</head>
<body>
    <h3>成功！</h3>
    username = ${username}
    password = ${password}
    age = ${age}
    sessionScope = ${sessionScope}
    <% System.out.println("页面跳转了"); %>
</body>
</html>

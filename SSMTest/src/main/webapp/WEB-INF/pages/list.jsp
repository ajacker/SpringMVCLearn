<%--
  Created by IntelliJ IDEA.
  User: 87392
  Date: 2019/10/18
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<h3>查询结果：</h3>
<table border="1">
    <th>id</th>
    <th>姓名</th>
    <th>金额</th>
    <c:forEach items="${accounts}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>${account.name}</td>
            <td>${account.money}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

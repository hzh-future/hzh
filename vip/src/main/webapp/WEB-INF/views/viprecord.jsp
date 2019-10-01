<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<p>${message}</p><br><br>
<form action="viprecord.do" method="post">
    请输入查询电话：<input type="text" name="code">
    <input type="submit" value="查询"><br><br><br>
    <hr>
</form>
<div>
    <table border="1">
        <tr>
            <th>编号</th>
            <th>电话号码</th>
            <th>姓名</th>
            <th>消费时间</th>
            <th>消费项目</th>
            <th>消费金额</th>
        </tr>
        <c:forEach items="${list}" var="vip">
            <tr>
                <td>${vip.id}</td>
                <td>${vip.code}</td>
                <td>${vip.name}</td>
                <td>${vip.x_date}</td>
                <td>${vip.x_project}</td>
                <td>${vip.x_je}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<% request.removeAttribute("list");%>
</body>
</html>

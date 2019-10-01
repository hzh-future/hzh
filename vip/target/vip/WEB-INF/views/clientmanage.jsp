<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body><br>
    <p>${message}</p> <br>
    <form action="clientmanage.do" method="post">
        请输入电话号码：<input type="text" name="code">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="查询">
    </form>
    <br><br>
    <hr><br>
    <table border="1">
        <tr>
            <th>编号</th>
            <th>电话号码</th>
            <th>姓名</th>
            <th>总积分</th>
            <th>当前等级</th>
            <th>距离下一次还差多少积分</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.code}</td>
                <td>${client.name}</td>
                <td>${client.money}</td>
                <td>${client.dengji}</td>
                <td>${client.xia}</td>
                <td>
                    <a href="clientdelete.do?id=${client.id}&code=${client.code}">删除</a>&nbsp;&nbsp;&nbsp;
                    <a href="clientupdate.do?id=${client.id}&code=${client.code}&name=${client.name}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

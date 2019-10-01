<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<br><br>
    <form action="clientupdate.do" method="post">
            编号：<input type="text" name="id" value="${id}"  readonly=”readonly” ><br>
            电话号码：<input type="text" name="code" value="${code}"><br>
            姓名：<input type="text" name="name" value="${name}"><br>
            <%--总积分：<input type="text" name="money" value="${client.money}" disabled="disabled" ><br>
            当前等级：<input type="text" name="dengji" value="${client.dengji}" disabled="disabled" ><br>
            距离下一等级还差：<input type="text" name="xia" value="${client.xia}" disabled="disabled" ><br>--%>
            <input type="submit" value="提交">
    </form>
</body>
</html>

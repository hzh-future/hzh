
<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<p>${message}</p>
<form method="post" action="client.do">
    <p>
        <label>电话号码：<input type="text" name="code"></label>
    </p>
    <p>
        <label>姓名：<input type="text" name="name"></label>
    </p>
    <p>
        <label>消费金额：<input type="text" name="money"></label>
    </p>
    <p>
        <input type="submit" value="提交">
        <a href="welcome.do">返回</a>
    </p>


</form>

</body>
</html>

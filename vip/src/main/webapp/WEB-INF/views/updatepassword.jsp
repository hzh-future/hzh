
<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<strong>${message}</strong>
<form action="updatepassword.do" method="post">
    <p>
        <label>旧密码：<input type="password" name="oldPassword"></label>
    </p>
    <p>
        <label>新密码：<input type="password" name="newPassword"></label>
    </p>
    <p>
        <label>新密码确认：<input type="password" name="newPasswordConfirm"></label>
    </p>
    <p>
        <input type="submit" value="提交">
        <a href="welcome.do">返回</a>
    </p>

</form>

</body>
</html>

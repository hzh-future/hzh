<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>hzh</title>
    <script>
        if(window.top !== window){
            window.top.location.href = window.location.href;
        }
    </script>
</head>
<body>
    <strong>${message}</strong>
    <form method="post" action="login.do">
        <p>
            <label>Account :<input type="text" name="account"></label>
        </p>
        <p>
            <label>Password :<input type="password" name="password"></label>
        </p>
        <p>
            <button type="submit">Login</button>
        </p>
    </form>
<% session.removeAttribute("message");%>
</body>
</html>

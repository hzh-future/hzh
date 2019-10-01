<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<%--<p>${message}</p>--%>
<form method="post" action="vipinsert.do">
    <p>
        <label>电话号码：<input type="text" id="code" name="code" value="${client.code}"></label>
        <input type="submit" value="查询">
    </p>
    <p>
        <label>姓名：<input type="text" name="name" disabled="disabled" value="${client.name}"></label>
    </p>
    <p>
        <label>消费时间：<input type="text" name="name" disabled="disabled" value="${dateStr}"></label>
    </p>
    <p>消费项目：
    <input type="checkbox" name="x_project" value="榨油"><label>榨油</label>
    <input type="checkbox" name="x_project" value="打米"><label>打米</label>
    <input type="checkbox" name="x_project" value="卖油"><label>卖油</label>
    <input type="checkbox" name="x_project" value="打包谷"><label>打包谷</label>
    <%--<input type="checkbox" name="item" value=""><label>选项5</label>--%>

    </p>
    <p>
        <label>消费金额：<input type="text" name="x_je"></label>
    </p>
    <p>
        <input type="submit" value="提交">
        <a href="welcome.do">返回</a>
    </p>

</form>
<script src="../static/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    /*$(document).ready(function(){
        alert("怎么啦");
        $("#code").blur(function(){
            alert("获取电话");
            /!* $.get("vipinsert.do?code="+code,function(status) {
                 alert("获取的电话："+code);
                 alert("状态"+status);
             });*!/
        });
    });*/
</script>
</body>
</html>

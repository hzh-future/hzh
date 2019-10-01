<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <style>
        *{
            margin:0;
            padding:0;
        }
    </style>
   <script src="../static/jquery/jquery-3.3.1.min.js"></script>
</head>
<body>
    <br>
    <p>${message}</p><br><br>
<div id="main">

    <div id="header">
        <form method="post" action="selectclient.do">
            输入查询电话号码：<input type="text" name="code">
            &nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="查询">
        </form>
    </div>
    <br><br><br>
    <hr>
    <br><br><br>
    <div id="body">
        <table border="1px">
            <tr>
                <th>电话</th>
                <th>姓名</th>
                <th>当前余额</th>
                <th>当前等级</th>
                <th>距离下一个等级还差</th>
            </tr>
            <tr>
                <td>${client.code}</td>
                <td>${client.name}</td>
                <td>${client.money}</td>
                <td>${client.dengji}</td>
                <td>${client.xia}</td>
            </tr>
        </table>
    </div>
    </div>
</body>
</html>

<%@ page pageEncoding="utf-8" %>
<html>
<head>

    <meta charset = "utf-8">
    <title>主页</title>
    <link rel="stylesheet" href="../static/css/css.css" charset="utf-8">
   <%-- <style>
        menu,h1,ul{
            margin: 0;
        }
        html,body{
            margin: 0;
            height: 100%;
            font-size: 14px;
        }
        body>header{
            line-height: 80px;
            text-align: center;
            background: #999;
        }
        body>header>h1{
            display: inline;

        }
        .body{
            position: absolute;
            top: 80px;
            bottom: 0;
            width: 100%;
        }
        .body>menu{
            position: absolute;
            left: 0;
            width: 200px;
            height: 100%;
            background: lightgrey;
            box-sizing: border-box;
        }
        .body>main{
            margin-left: 200px;
            height: 100%;
        }
        main>iframe{
            float: right;
            height: 100%;
            width: 100%;
            border: 2px;
            display: block;
        }
        ul{
            list-style-type: none;
        }
    </style>--%>
</head>
<body>
    <header>
        <h1>VIP消费查询系统</h1>
        <span>
            <b>${sessionScope.currentUser.name}</b>
            <a href="logout.do">退出登录</a>
        </span>
    </header>
    <section class="body">
        <menu>
            <ul>
                <li><a href="selectclient.do" target="mainFrame">VIP客户查询</a></li>
                <li><a href="client.do" target="mainFrame">录入VIP客户</a></li>
                <li><a href="clientmanage.do" target="mainFrame">VIP客户管理</a></li>
                <li><a href="viprecord.do" target="mainFrame">查看VIP消费记录</a></li>
                <li><a href="vipinsert.do" target="mainFrame">录入VIP消费记录</a></li>
               <%-- <li><a>VIP消费记录管理</a></li>--%>
                <li><a href="updatepassword.do" target="mainFrame">修改密码</a></li>
            </ul>
        </menu>
        <main>
            <iframe src="welcome.do" name="mainFrame"></iframe>
        </main>
    </section>
</body>
</html>

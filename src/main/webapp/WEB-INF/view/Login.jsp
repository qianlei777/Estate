<%--
  Created by IntelliJ IDEA.
  User: 卢本伟的挂
  Date: 2020/11/25
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            margin-left: 40%;
        }
    </style>
</head>
<body>
<div>
    <h1>房地产信息查询</h1>
    <form action="/login.do" method="post">
        <p>请输入身份证：<input type="text" name="cardid"></p>
        <p>密码：<input type="password" name="password"></p>
        <input type="submit" value="登录"><a herf="">注册</a>
    </form>
</div>
</body>
</html>

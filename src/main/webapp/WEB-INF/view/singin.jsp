<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/11/25
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
</head>
<body>
<form action="/add.do" method="post">
    <h1>账号注册</h1>
    <p>身份证号：<input type="text" name="cardid"></p>
    <p>用户名：<input type="text" name="name"></p>
    <p>密码：<input type="text" name="password"></p>
    <p>确认密码：<input type="text" name="newpass"></p>
    <p><button type="submit">注册</button><button type="button" href="javascript:histroy.back">返回</button></p>
</form>
<script>

    $("[name='cardid']").blur(function () {
        var cardid=$("[name='cardid']").val();
        $.get("/yan.do","cardid="+cardid,function (flag) {
            if (flag){
                alert("账号已存在，请重新输入！");
                window.location.reload();
            }
        })
    });
</script>
<script>
    function exit() {
        var flag=confirm("是否确定退出？");
        if (flag){
            location.href="/tui.do";
        }
    }
</script>
</body>
</html>

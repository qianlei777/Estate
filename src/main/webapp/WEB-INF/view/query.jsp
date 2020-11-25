<%--
  Created by IntelliJ IDEA.
  User: 84911
  Date: 2020/11/25
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>房产信息查询</title>
</head>
<body>
<h1>房产星系查询系统</h1>
<p>
    用户名：<strong>${sessionScope.user.name}</strong>
    <a href="#">退出</a>
</p>

<a href="/query.do">房产信息查询</a>


<div>
    <h1>房产信息查询</h1>
    <form action="/paging.do" method="post">
        <p>查询类型：
            <select name="query">
                <c:if test="${query eq '用户名'}">
                    <option value="用户名" selected>用户名</option>
                    <option value="身份证">身份证</option>
                </c:if>
                <c:if test="${query eq '身份证'}">
                    <option value="身份证" selected>身份证</option>
                    <option value="用户名">用户名</option>
                </c:if>
                <c:if test="${query eq null}">
                    <option value="身份证" selected>身份证</option>
                    <option value="用户名">用户名</option>
                </c:if>

            </select>
            <input type="text" name="val" value="${val}">
            <input type="submit">
        </p>
    </form>
    <table border="1px">
        <tr>
            <td>序号</td>
            <td>项目名称</td>
            <td>产权人</td>
            <td>身份证号</td>
            <td>房屋类型</td>
            <td>使用面积</td>
            <td>建造时间</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="estate">
            <tr>
                <td>${estate.id}</td>
                <td>${estate.projectname}</td>
                <td>${estate.user.name}</td>
                <td>${estate.uid}</td>
                <td>${estate.housetype}</td>
                <td>${estate.area}</td>
                <td>${estate.buildtime}</td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="/paging.do?pageNum=${pageInfo.firstPage}&query=${query}&val=${val}">首頁</a>|
        <c:if test="${pageInfo.hasPreviousPage}">
            <a href="/paging.do?pageNum=${pageInfo.prePage}&query=${query}&val=${val}">上一頁</a>|
        </c:if>
        <c:if test="${pageInfo.hasNextPage}">
            <a href="/paging.do?pageNum=${pageInfo.nextPage}&query=${query}&val=${val}">下一頁</a>|
        </c:if>
        <a href="/paging.do?pageNum=${pageInfo.lastPage}&query=${query}&val=${val}">末頁</a>
        第${pageInfo.pageNum}/共${pageInfo.pages}页(${pageInfo.total}条)
    </p>
</div>
</body>
</html>

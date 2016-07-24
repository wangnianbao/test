<%--
  Created by IntelliJ IDEA.
  User: wangnianbao
  Date: 2016/7/23
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
  <title>用户登陆</title>
</head>

<body>
<form action="${pageContext.request.contextPath }/login" method="post">
  用户名：<input type="text" name="username"><br/>
  密码：<input type="password" name="password"><br/>
  <input type="submit" value="登陆">
</form>
</body>
</html>
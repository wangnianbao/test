<%--
  Created by IntelliJ IDEA.
  User: wangnianbao
  Date: 2016/7/26
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>欢迎来到登入界面</h1>
<form action="${pageContext.request.contextPath}/login1" method="post">
      用户名：<input type="text" name="username2"><br/>
密码：<input type="password" name="password2"><br/>
    手机号：<input type="text" name="phone"><br/>
<input type="submit" value="登陆">
</form>
</body>
</html>

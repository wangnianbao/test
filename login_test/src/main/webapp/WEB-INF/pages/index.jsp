<%--
  Created by IntelliJ IDEA.
  User: wangnianbao
  Date: 2016/7/23
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
  <title>首页</title>
  <script type="text/javascript">
    function doLogout(){
      //访问LogoutServlet注销当前登录的用户
      window.location.href="${pageContext.request.contextPath}/servlet/LogoutServlet";
    }
  </script>
</head>

<body>
  <h1>孤傲苍狼的网站</h1>
  <hr/>
    <c:if test="${user==null}">
      <a href="${pageContext.request.contextPath}/servlet/RegisterUIServlet" target="_blank">注册</a>
      <a href="${pageContext.request.contextPath}/servlet/LoginUIServlet">登陆</a>
    </c:if>
  <c:if test="${msg!=null}">
    <c:if test="${msg.status == 1}">
          欢迎您：${username}
      <input type="button" value="退出登陆" onclick="doLogout()">

    </c:if>
    <br>
    <c:if test="${msg.status != 1}">
     <span  style="font-color:red">${msg.msg}</span>
    </c:if>
  </c:if>
  <hr/>
  </body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangnianbao
  Date: 2016/7/26
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1>王年宝的网站</h1>
<hr/>
<c:if test="${user==null}">

  <a href="${pageContext.request.contextPath}/register" target="_blank">注册</a>
  <a href="${pageContext.request.contextPath}/login1">登陆</a>
</c:if>
<c:if test="${msg!=null}">
  <c:if test="${msg.status == 1}">
    欢迎您：${username2}
    <input type="button" value="退出登陆" onclick="doLogout()">
  </c:if>
  <br>
  <c:if test="${msg.status != 1}">
    <span  style="font-color:#ff0000">${msg.msg}</span>
  </c:if>
</c:if>
<hr/>
  <form action="${pageContext.request.contextPath}/register" method="post">
      <input type ="text" name="userName">
      <input type ="hidden" name="method" value="query">
      <input type="submit" value="查询" >
  </form>
<table border="1">
  <tr>
    <td>用户名</td>
    <td>学历</td>
    <td>性别</td>
  </tr>
  <c:forEach items="${userinfos}" var="userinfo">
    <tr>
      <td><c:out value="${userinfo.name}"/><p></td>
      <td><c:out value="${userinfo.xueli}"/></td>
      <td><c:out value="${userinfo.sex}"/></td>
    </tr>
  </c:forEach>

</table>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: wangnianbao
  Date: 2016/8/30
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
  <script type="text/javascript">
    function doLogout(){
      //访问LogoutServlet注销当前登录的用户
      window.location.href="${pageContext.request.contextPath}/servlet/LogoutServlet";
    }
  </script>

</head>
<body>
<h1>欢迎来到学生管理系统注册中心</h1>
<form acton="${pageContext.request.contextPath}/register"method="post" >
  <table align="center">
    <tbody>
    <tr>
      <td colspan="2" align="center">请注册</td>
    </tr>
    <tr>
      <td>用户名：</td>
      <td><input type="text" name="userName" /></td>
    </tr>
    <tr>
      <td>密码：</td>
      <td><input type="password" name="userPassWord" /></td>
    </tr>
    <tr>
      <td>性别：</td>
      <td><select name="sex" size="1"> <option value="man"> man</option> </select> <select name="sex" size="1"> <option value="woman"> women</option> </select></td>
    </tr>
    <tr>
      <td>学历：</td>
      <td><input type="text" name="xueli" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" value="注册" /></td>
    </tr>
    </tbody>
  </table>
</form>
</body>
</html>

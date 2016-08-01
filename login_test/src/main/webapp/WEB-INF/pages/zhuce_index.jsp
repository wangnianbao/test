<%--
  Created by IntelliJ IDEA.
  User: wangnianbao
  Date: 2016/7/28
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>欢迎来到注册界面</h1>
<form action="${pageContext.request.contextPath}/register" method="post">
  <table>
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

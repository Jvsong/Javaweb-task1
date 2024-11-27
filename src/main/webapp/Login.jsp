<%--
  Created by IntelliJ IDEA.
  User: 宋佳伟
  Date: 2024/11/21
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>用户登录</title>
  <!-- 引入外部 CSS 文件 -->
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="login-container">
  <h2>用户登录</h2>
  <form action="LoginServlet" method="post">
    <!-- 用户名输入框 -->
    <input type="text" name="username" placeholder="请输入用户名" minlength="8" required>
    <!-- 密码输入框 -->
    <input type="password" name="password" placeholder="请输入密码" minlength="
8" required>
    <!-- 登录按钮 -->
    <button type="submit">登录</button>
  </form>
  <p class="register-link">还没有账号？ <a href="Register.jsp">立即注册</a></p>
</div>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>用户注册</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="register-container">
  <h2>用户注册</h2>

  <!-- 显示错误信息 -->
  <c:if test="${not empty errorMessage}">
    <p style="color:red;">${errorMessage}</p>
  </c:if>

  <!-- 显示成功信息 -->
  <c:if test="${not empty sessionScope.successMessage}">
    <p style="color:green;">${sessionScope.successMessage}</p>
    <!-- 清理成功消息，防止重复显示 -->
    <c:set var="successMessage" value="" scope="session"/>
  </c:if>

  <form action="registerServlet" method="post">
    <!-- 用户名输入框 -->
    <input type="text" name="username" placeholder="请输入用户名" minlength="8" required>
    <!-- 密码输入框 -->
    <input type="password" name="password" placeholder="请输入密码" minlength="8" required>
    <!-- 确认密码输入框 -->
    <input type="password" name="confirmPassword" placeholder="请确认密码" required>
    <!-- 注册按钮 -->
    <button type="submit">注册</button>
  </form>
  <p class="login-link">已有账号？ <a href="Login.jsp">立即登录</a></p>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 宋佳伟
  Date: 2024/11/21
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>登录成功</title>
  <!-- 引入外部 CSS 文件 -->
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="success-container">
  <form action="/roginServlet" method="post"/>
  <h2>登录成功</h2>
  <p>欢迎回来，<strong>${sessionScope.username}</strong>！</p>
  <p>现在可以访问您的账户或返回主页。</p>
  <div class="button-group">
    <a href="#" class="button">进入账户</a>
    <a href="#" class="button button-secondary">返回主页</a>
  </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2020/10/27
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>

    <form action="/deptSys/UserController?type=login" method="post">
        用户名:<input type="text" name="username" /><br />
        密码:<input type="password" name="password" /><br />
        <input type="submit" value="登录" /><br />
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 23163
  Date: 2024/7/4
  Time: 下午2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--获取作用域数据--%>
    <%--不指定作用域 默认从小的作用域开始查找--%>
    从request作用域：${req}<br>
    从session作用域：${sess}<br>
    从application作用域：${app}<br>
</body>
</html>

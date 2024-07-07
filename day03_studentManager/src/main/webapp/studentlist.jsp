<%--
  Created by IntelliJ IDEA.
  User: 23163
  Date: 2024/7/3
  Time: 下午4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" align="center" style="border-collapse: collapse">
        <tr>
            <th colspan="5">
                <%--<input type="button" value="添加">--%>
                <a href="${pageContext.request.contextPath}/toAdd">添加</a>
            </th>
        </tr>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>班级</th>
        </tr>
        <c:forEach items="${slist}" var="stu">
            <tr align="center">
                <td>${stu.sid}</td>
                <td>${stu.sname}</td>
                <td>${stu.age}</td>
                <td>${stu.gender}</td>
                <td>${stu.grade.gname}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>

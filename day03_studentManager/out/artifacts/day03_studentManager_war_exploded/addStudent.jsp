<%--
  Created by IntelliJ IDEA.
  User: 23163
  Date: 2024/7/4
  Time: 下午2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>
        var flag = false;

        function checkName(name){
            //alert(name);
            <%-- $.get("${pageContext.request.contextPath}/checkName?sname="+name,function () {},"text"); --%>
            $.get("${pageContext.request.contextPath}/checkName?",{sname:name},function (res) {
                //alert(res);
                if(res == "true"){
                    $("#snamemsg").html("√").css("color","green");
                    flag = true;
                }
                else if (res == "false"){
                    $("#snamemsg").html("姓名已占用!");
                    flag = false;
                }

            },"text");

            return flag;
        }

        function checkFormData(){
            var sname = $("[name=sname]").val();
            if(checkName(sname)){
                return true;
            } else {
                return false;
            }
        }
    </script>
</head>
<body>
<table border="1" align="center" width="500px">
    <form action="${pageContext.request.contextPath}/addStudent" method="post" onsubmit="return checkFormData()">
        <caption><h2>添加学生信息</h2></caption>
        <tr>
            <td>姓名:</td>
            <td>
                <input type="text" name="sname" required onblur="checkName(this.value)">
                <span id="snamemsg"></span>
            </td>

        </tr>
        <tr>
            <td>年龄:</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                <input type="radio" name="gender" value="男">男
                <input type="radio" name="gender" value="女">女
            </td>
        </tr>
        <tr>
            <td>班级:</td>
            <td>
                <select name="gid">
                    <c:forEach items="${gradeList}" var="g">
                        <option value="${g.gid}">${g.gname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="添加">&nbsp；&nbsp;&nbsp<input type="reset" value="重置"></td>
        </tr>
    </form>
</table>
</body>
</html>

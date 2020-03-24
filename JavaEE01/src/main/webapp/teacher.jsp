<%@ page import="com.javaee.code.model.StudentHomework" %>
<%@ page import="com.javaee.code.jdbc.StudentHomeworkJDBC" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 清笛吹月
  Date: 2020/3/11
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师页面</title>
</head>
<body>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>ID</td>
        <td>学生学号</td>
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>
    </tr>
    <%
        List<StudentHomework> list = StudentHomeworkJDBC.selectAll();
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
            for (StudentHomework sh : list){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getId()%></td>
        <td><%=sh.getStudentId()%></td>
        <td><%=sh.getHomeworkId()%></td>
        <td><%=sh.getHomeworkTitle()%></td>
        <td><%=sh.getHomeworkContent()%></td>
        <td><%=sh.getCreateTime()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
<div align="center" style="margin-top: 30px">
    <button onclick="window.location.href='newStudent.jsp'">添加学生</button>
    <button onclick="window.location.href='newHomework.jsp'">添加作业</button>
</div>
</body>
</html>

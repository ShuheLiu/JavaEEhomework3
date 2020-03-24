<%@ page import="com.javaee.code.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.javaee.code.jdbc.StudentHomeworkJDBC" %><%--
  Created by IntelliJ IDEA.
  User: 清笛吹月
  Date: 2020/3/12
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<button onclick="window.location.href='teacher.jsp'">返回</button>
<br/>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>学生ID</td>
        <td>学生姓名</td>
        <td>入学年份</td>
    </tr>
    <%
        List<Student> list = StudentHomeworkJDBC.getAllStudent();
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
            for (Student student : list){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=student.getStudent_id()%></td>
        <td><%=student.getStudent_name()%></td>
        <td><%=student.getGrade()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
<h2>添加学生</h2>
<form action="addStudent" method="post">
    <p>学号：</p>
    <input name="student_id">
    <p>姓名</p>
    <input name="student_name">
    <p>年级</p>
    <input name="student_grade">

    <br/>
    <div style="margin-top: 20px">
        <button type="submit">添加</button>
    </div>
</form>

</body>
</html>

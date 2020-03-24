<%@ page import="com.javaee.code.model.Homework" %>
<%@ page import="com.javaee.code.jdbc.StudentHomeworkJDBC" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 清笛吹月
  Date: 2020/3/12
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加作业</title>
</head>
<body>
<button onclick="window.location.href='teacher.jsp'">返回</button>
<br/>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>作业ID</td>
        <td>作业详情</td>
        <td>开始时间</td>
        <td>结束时间</td>
        <%--<td></td>--%>
    </tr>
    <%
        List<Homework> list = StudentHomeworkJDBC.getAllHomework();
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
            for (Homework sh : list){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getHomeworkId()%></td>
        <td><%=sh.getHomeworkDetail()%></td>
        <td><%=sh.getStartTime()%></td>
        <td><%=sh.getEndTime()%></td>
        <%--<td><button onclick="<%
        StudentHomeworkJDBC.deleteHomework(sh.getHomeworkId());
            %>">删除</button></td>--%>
    </tr>
    <%
            }
        }
    %>
</table>
<h2>添加作业</h2>
<%--通过add接口调用servlet,将button的type设置为submit,达到点击提交效果--%>
<form action="add" method="post">
    <p>作业详情：</p>
    <textarea style="width: 500px;height: 80px" name="homework_detail"></textarea>
    <p>开始时间</p>
    <input name="start_time">
    <p>截止时间</p>
    <input name="end_time">

    <br/>
    <div style="margin-top: 20px">
        <button type="submit">添加</button>
    </div>
</form>

</body>
</html>

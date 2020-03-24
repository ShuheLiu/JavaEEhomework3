<%@ page import="com.javaee.code.model.Homework" %>
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
    <title>学生页面</title>
</head>
<body>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <%--表头--%>
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>作业ID</td>
        <td>作业详情</td>
        <td>开始时间</td>
        <td>结束时间</td>
        <td style="width: 100px"></td>
    </tr>

    <%--表格数据，<%%>包裹Java源代码,获取数据并填充表格--%>
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
        <%--按钮点击跳转到submitHomework.jsp页面,通过"?homeworkID="传参,
            目标页面通过request.getParameter("homeworkID")获得该参数--%>
        <td><button onclick="window.location.href='submitHomework.jsp?homeworkID=<%=sh.getHomeworkId()%>'">提交</button></td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>

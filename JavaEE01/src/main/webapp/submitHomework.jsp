<%--
  Created by IntelliJ IDEA.
  User: 清笛吹月
  Date: 2020/3/13
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
</head>
<body>
<h2>提交作业</h2>
<form action="submitHomework" method="post">
    <p>作业ID</p>
    <input name="homework_id" value="<%=request.getParameter("homeworkID")%>" readonly>
    <p>学号</p>
    <input name="student_id">
    <p>作业题目</p>
    <input name="homework_title">
    <p>作业内容：</p>
    <textarea style="width: 500px;height: 80px" name="homework_content"></textarea>

    <br/>
    <div style="margin-top: 20px">
        <button type="submit">提交</button>
    </div>
</form>

</body>
</html>

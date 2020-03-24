package com.javaee.code.servlet;

import com.javaee.code.jdbc.StudentHomeworkJDBC;
import com.javaee.code.model.Student;
import com.javaee.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/submitHomework")
public class SubmitHomework extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("UTF8");
        StudentHomework shm=new StudentHomework();

        shm.setId(null);
        shm.setStudentId(Long.parseLong(request.getParameter("student_id")));
        shm.setHomeworkId(Long.parseLong(request.getParameter("homework_id")));
        shm.setHomeworkTitle(request.getParameter("homework_title"));
        shm.setHomeworkContent(request.getParameter("homework_content"));
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        shm.setCreateTime(df.format(day));
        shm.setUpdateTime(df.format(day));
        StudentHomeworkJDBC.addStudentHomework(shm);
        request.getRequestDispatcher("student.jsp").forward(request,response);
    }
}

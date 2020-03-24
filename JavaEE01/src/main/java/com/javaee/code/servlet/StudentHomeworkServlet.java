package com.javaee.code.servlet;

import com.javaee.code.jdbc.StudentHomeworkJDBC;
import com.javaee.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class StudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<StudentHomework> list= StudentHomeworkJDBC.selectAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("teacher.jsp").forward(request,response);
    }
}

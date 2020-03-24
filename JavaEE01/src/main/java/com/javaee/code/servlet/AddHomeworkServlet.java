package com.javaee.code.servlet;

import com.javaee.code.jdbc.StudentHomeworkJDBC;
import com.javaee.code.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")//设置接口
public class AddHomeworkServlet extends HttpServlet {
    @Override
    //执行post方法
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("UTF8");//更改中文字符编码方式
        Homework hw=new Homework();
        hw.setHomeworkId(null);
        //采用request.getParameter()方法获取jsp页面上的输入值,参数对应jsp页面相应输入框的name
        hw.setHomeworkDetail(request.getParameter("homework_detail"));
        hw.setStartTime(request.getParameter("start_time"));
        hw.setEndTime(request.getParameter("end_time"));
        //调用JDBC中的函数
        String answer=StudentHomeworkJDBC.addHomework(hw);
        //刷新页面
        request.getRequestDispatcher("newHomework.jsp").forward(request,response);
    }
}

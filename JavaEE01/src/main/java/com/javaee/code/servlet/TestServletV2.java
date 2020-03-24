package com.javaee.code.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServletV2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String myHeader=request;
        String myHeader=request.getHeader("myHeader");
        response.getWriter().println("Hello servlet GET V2"+myHeader);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String param=request.getParameter("id");
        response.getWriter().println("Hello POST V2"+param);
    }
}

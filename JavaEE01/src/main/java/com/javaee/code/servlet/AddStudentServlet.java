package main.java.com.javaee.code.servlet;

import com.javaee.code.jdbc.StudentHomeworkJDBC;
import com.javaee.code.model.Homework;
import com.javaee.code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("UTF8");
        Student student=new Student();
        student.setStudent_id(Long.parseLong(request.getParameter("student_id")));
        student.setStudent_name(request.getParameter("student_name"));
        student.setGrade(request.getParameter("student_grade"));
        StudentHomeworkJDBC.addStudent(student);
        request.getRequestDispatcher("newStudent.jsp").forward(request,response);
    }
}

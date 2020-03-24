package com.javaee.code.jdbc;

import com.javaee.code.model.Homework;
import com.javaee.code.model.Student;
import com.javaee.code.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentHomeworkJDBC {
    public static List<StudentHomework> selectAll(){
        String url="jdbc:mysql://127.0.0.1:3306/JavaEEcourse";//设置数据库连接，127.0.0.1：3306是本地数据库的端口，JavaEEcourse是本地已建好的一个数据库
        String driverName="com.mysql.jdbc.Driver";
        String sqlString="select * from studentHomework";

        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        List<StudentHomework> list=new ArrayList<>();

        try(Connection connection= Objects.requireNonNull(DatabasePool.getHikariDataSource()).getConnection()){
            try(Statement statement=connection.createStatement()){
                try(ResultSet resultSet=statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        StudentHomework sh=new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getString("create_time"));
                        list.add(sh);
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static String addStudentHomework(StudentHomework shm){
        String url="jdbc:mysql://127.0.0.1:3306/JavaEEcourse";//设置数据库连接，127.0.0.1：3306是本地数据库的端口，JavaEEcourse是本地已建好的一个数据库
        String driverName="com.mysql.jdbc.Driver";
        String sqlString="INSERT INTO studentHomework VALUES "+shm.toString();
        String str="";

        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection= DriverManager.getConnection(url,"root","123456")){
            try(Statement statement=connection.createStatement()){
                if(statement.executeUpdate(sqlString)>0){
                    str="Successfully submit a homework!";
                }else{
                    str="Submit homework fail!";
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String addHomework(Homework hw){
        String url="jdbc:mysql://127.0.0.1:3306/JavaEEcourse";//设置数据库连接，127.0.0.1：3306是本地数据库的端口，JavaEEcourse是本地已建好的一个数据库
        String driverName="com.mysql.jdbc.Driver";
        //设置插入语句,Homework类中的toString方法将数据转化为插入语句
        String sqlString="INSERT INTO homework VALUES "+hw.toString();
        String str="";

        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        //使用try/catch包裹,处理异常
        try(Connection connection= DriverManager.getConnection(url,"root","123456")){
            try(Statement statement=connection.createStatement()){
                //使用executeUpdate()插入数据
                if(statement.executeUpdate(sqlString)>0){
                    str="Successfully add a homework!";
                }else{
                    str="Add homework fail!";
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static List<Homework> getAllHomework(){
        String url="jdbc:mysql://127.0.0.1:3306/JavaEEcourse";//设置数据库连接，127.0.0.1：3306是本地数据库的端口，JavaEEcourse是本地已建好的一个数据库
        String driverName="com.mysql.jdbc.Driver";
        String sqlString="select * from homework";

        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        List<Homework> list=new ArrayList<>();

        try(Connection connection= DriverManager.getConnection(url,"root","123456")){
            try(Statement statement=connection.createStatement()){
                try(ResultSet resultSet=statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        Homework hw=new Homework();
                        hw.setHomeworkId(resultSet.getLong("homework_id"));
                        hw.setHomeworkDetail(resultSet.getString("homework_detail"));
                        hw.setStartTime(resultSet.getString("start_time"));
                        hw.setEndTime(resultSet.getString("end_time"));
                        list.add(hw);
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void deleteHomework(Long id){
        String url="jdbc:mysql://127.0.0.1:3306/JavaEEcourse";//设置数据库连接，127.0.0.1：3306是本地数据库的端口，JavaEEcourse是本地已建好的一个数据库
        String driverName="com.mysql.jdbc.Driver";
        String sqlString="delete from homework where homework_id="+id;

        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection connection= DriverManager.getConnection(url,"root","123456")){
            try(Statement statement=connection.createStatement()){
                int x=statement.executeUpdate(sqlString);
                if(x>0){
                    System.out.println("Success!"+x);
                }else{
                    System.out.println("Fail!");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getAllStudent(){
        String url="jdbc:mysql://127.0.0.1:3306/JavaEEcourse";//设置数据库连接，127.0.0.1：3306是本地数据库的端口，JavaEEcourse是本地已建好的一个数据库
        String driverName="com.mysql.jdbc.Driver";
        String sqlString="select * from student";

        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        List<Student> list=new ArrayList<>();

        try(Connection connection= DriverManager.getConnection(url,"root","123456")){
            try(Statement statement=connection.createStatement()){
                try(ResultSet resultSet=statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        Student student=new Student();
                        student.setStudent_id(resultSet.getLong("student_id"));
                        student.setStudent_name(resultSet.getString("student_name"));
                        student.setGrade(resultSet.getString("student_grade"));
                        list.add(student);
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static String addStudent(Student student){
        String url="jdbc:mysql://127.0.0.1:3306/JavaEEcourse";//设置数据库连接，127.0.0.1：3306是本地数据库的端口，JavaEEcourse是本地已建好的一个数据库
        String driverName="com.mysql.jdbc.Driver";
        String sqlString="INSERT INTO student VALUES "+student.toString();
        String str="";

        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection= DriverManager.getConnection(url,"root","123456")){
            try(Statement statement=connection.createStatement()){
                if(statement.executeUpdate(sqlString)>0){
                    str="Successfully add a student!";
                }else{
                    str="Add student fail!";
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
}

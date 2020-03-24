package com.javaee.code.jdbc;

import java.sql.*;

public class TestJDBCV2 {
    public static String getMysql2(){
        String url="jdbc:mysql://127.0.0.1:3306/JavaEEcourse";//设置数据库连接，127.0.0.1：3306是本地数据库的端口，JavaEEcourse是本地已建好的一个数据库
        String driverName="com.mysql.jdbc.Driver";
        String sqlString="select * from test1";

        try {
            //加载驱动
            Class.forName(driverName);

            //创建链接
            Connection connection= DriverManager.getConnection(url,"root","123456");//连接数据库，root和123456对应数据库的账号和密码
            Statement statement=connection.createStatement();

            //通过statement增删改查
            ResultSet resultSet=statement.executeQuery(sqlString);

            //获取执行结果
            while(resultSet.next()){
                System.out.println(resultSet.getLong(1));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args){
        getMysql2();
    }
}

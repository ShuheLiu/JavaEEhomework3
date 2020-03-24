package com.javaee.code.jdbc;

import java.sql.*;

public class TestJDBCV3 {
    public static String getMysql(){
        String url="jdbc:mysql://127.0.0.1:3306/JavaEEcourse";//设置数据库连接，127.0.0.1：3306是本地数据库的端口，JavaEEcourse是本地已建好的一个数据库
        String driverName="com.mysql.jdbc.Driver";
        String sqlString="select * from test1";

        try(Connection connection=DriverManager.getConnection(url,"root","123456")){
            try(Statement statement=connection.createStatement()){
                try(ResultSet resultSet=statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        System.out.println(resultSet.getLong(1));
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args){
        getMysql();
    }
}

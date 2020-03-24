package com.javaee.code.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabasePool {

    public  static HikariDataSource hikariDataSource;

    public static HikariDataSource getHikariDataSource(){

        if(hikariDataSource != null){
            return hikariDataSource;
        }

        synchronized (DatabasePool.class){
            if(hikariDataSource != null){
                String jdbcUrl="jdbc:mysql://127.0.0.1:3306/JavaEEcourse?useUnicode=true&useSSL=false&serverTimezone=UTC";
                String driverName="com.mysql.jdbc.Driver";

                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setUsername("root");
                hikariConfig.setPassword("123456");
                hikariConfig.setDriverClassName(driverName);
                hikariConfig.setJdbcUrl(jdbcUrl);

                hikariDataSource = new HikariDataSource(hikariConfig);
                return hikariDataSource;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        while (true){
            getHikariDataSource();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

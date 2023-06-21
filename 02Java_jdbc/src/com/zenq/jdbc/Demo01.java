package com.zenq.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*

* */
public class Demo01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String name = "root";
        String password = "root";
        //驱动名字 5.x com.mysql.jdbc.Driver
        // 8.x com.mysql.cj.jdbc.Driver
        String driverName = "com.mysql.jdbc.Driver";
        //经典7步链接数据库
        //1. 加载驱动
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. 通过驱动创建链接
        try {
            Connection connection = DriverManager.getConnection(
                    url,
                    name,
                    password
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

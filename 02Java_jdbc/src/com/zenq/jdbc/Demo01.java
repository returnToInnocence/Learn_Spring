package com.zenq.jdbc;


import java.sql.*;

/*

* */
public class Demo01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ssm_db?useSSL=false";
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
        Connection connection = null;
        try {
             connection = DriverManager.getConnection(
                    url,
                    name,
                    password
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //3. 通过数据库链接干事情，拿到sql执行代理对象
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //4. 编写sql语句，增删改查对象
        String sql = "select * from tbl_item";
        //5. 通过代理对象执行sql
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //6. 解析结果查看数据

        //7. 关闭所有资源
        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

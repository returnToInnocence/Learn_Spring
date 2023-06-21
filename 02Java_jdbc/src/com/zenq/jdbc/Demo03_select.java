package com.zenq.jdbc;

import java.sql.*;

public class Demo03_select {
    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {
        //数据库协议 地址 端口 数据库名字
        String url = "jdbc:mysql://localhost:3306/ssm_db?useSSL=false";
        //用户名
        String name = "root";
        //密码
        String password = "root";
        //驱动的名字： 5.x com.mysql.jdbc.Driver 8.x com.mysql.cj.jdbc.Driver
        String driverName = "com.mysql.jdbc.Driver";
        //经典7步链接数据库
        //1.加载驱动 throws抛出异常
        Class.forName(driverName);
        //2.通过驱动创建链接
        Connection conn = DriverManager.getConnection(url, name, password);
        //3.通过数据库链接做事情，拿到sql执行代理对象
        Statement statement = conn.createStatement();
        //4.编写sql语句 增删查改的sql语句
        String sql = "select * from `tbl_item` ";
        //5.通过代理对象执行sql
        ResultSet rs = statement.executeQuery(sql);
        //6.解析结果 查看数据
        while (rs.next()) { //只要还有下一条数据就循环，直到拿到结果集中的所有数据
            int itemId = rs.getInt("itemId");
            String itemName = rs.getString("itemName");
            int itemValue = rs.getInt("itemValue");
            System.out.println(itemId + " , " + itemName + " , " + itemValue);
        }
        //7.关闭资源
        rs.close();
        statement.close();
        conn.close();
    }

}

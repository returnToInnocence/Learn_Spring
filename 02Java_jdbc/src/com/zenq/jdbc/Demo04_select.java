package com.zenq.jdbc;

import com.zenq.jdbc.po.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Demo04_select {
    //jvm虚拟机调用main
    public static void main(String[] args)throws SQLException,
            ClassNotFoundException {
        List<User> userList = Demo04_select.selectTest();
        System.out.println(userList); // []
    }
    /**
     * 查询数据库是所有的模块操作中的一环，当前的查询操作需要返回查询到的数据
     * 返回值是什么：容器【集合操作】 List【接口】--> ArrayList【实现类】
     * List<泛型> List<int> 一个只能装int数据的列表 List<String>列表中只能装字符串
     * User[ id name pass] List<User>
     */
    public static List<User> selectTest() throws SQLException, ClassNotFoundException {
        //准备一个返回值的列表容器
        List<User> userList = new ArrayList<User>();
        //数据库协议 地址 端口 数据库名字
        String url = "jdbc:mysql://localhost:3306/ssm_db?useSSL=false";
        //用户名
        String name = "root";
        //密码
        String password = "root";
        //驱动的名字： 5.x com.mysql.jdbc.Driver 8.x com.mysql.cj.jdbc.Driver
        String driverName ="com.mysql.jdbc.Driver";
        //经典7步链接数据库
        //1.加载驱动 throws抛出异常
        Class.forName(driverName);
        //2.通过驱动创建链接
        Connection conn = DriverManager.getConnection(url,name,password);
        //3.通过数据库链接做事情，拿到sql执行代理对象
        Statement statement = conn.createStatement();
        //4.编写sql语句 增删查改的sql语句
        String sql = "select * from `tbl_item` ";
        //5.通过代理对象执行sql
        ResultSet rs = statement.executeQuery(sql);
        //6.解析结果 查看数据
        while(rs.next()){ //只要还有下一条数据就循环，直到拿到结果集中的所有数据
            int itemId = rs.getInt("itemId");
            String itemName = rs.getString("itemName");
            int itemValue = rs.getInt("itemValue");
            User user = new User(itemId, itemName, itemValue);
            userList.add(user);
        }
        //7.关闭资源
        rs.close();
        statement.close();
        conn.close();
        return userList;
    }
}
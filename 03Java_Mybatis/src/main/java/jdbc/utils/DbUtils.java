package jdbc.utils;

import java.sql.*;

public class DbUtils {
    //数据库协议 地址 端口 数据库名字
    static String url = "jdbc:mysql://localhost:3306/ssm_db?useSSL=false";
    //用户名
    static String name = "root";
    //密码
    static String password = "root";
    //驱动的名字： 5.x com.mysql.jdbc.Driver 8.x com.mysql.cj.jdbc.Driver
    static String driverName = "com.mysql.jdbc.Driver";

    /**
     * 定义一个方法 返回数据库链接对象
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //1.加载驱动 throws抛出异常
            Class.forName(driverName);
            //2.通过驱动创建链接
            conn = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭资源的方法封装
     * 关闭资源的三个对象，需要先判断是否为空，再执行关闭
     * ResultSet 结果集对象只有查询操作的时候才会出现
     */
    public static void closeResource(ResultSet rs, Statement statement, Connection conn) {
        //关闭资源的操作
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package jdbc.test;



import jdbc.po.User;
import jdbc.utils.DbUtils;

import java.sql.*;

public class TestDb {
    public static void main(String[] args) throws SQLException {
        User user = findByNamePass("草莓",1);
        System.out.println(user);
    }
    /**
     * 模拟登录的操作
     * 获取用户名和密码，执行sql查询即可
     * 参数：用户名 密码
     * 返回值： 返回查询的对象
     * 方法名： findByNamePass
     */
    public static User findByNamePass(String name, int value) throws SQLException {
        User user = null;
        //获取链接
        Connection conn = DbUtils.getConnection();
        //操作数据库
        //普通的代理对象
        Statement stmt = conn.createStatement();
        //编写sql语句 sql语句的拼接
        String sql = "select * from `tbl_item` where `itemName` = '" + name +"' and `itemValue` = "+value;
        //执行sql语句
        ResultSet rs = stmt.executeQuery(sql);
        //获取结果集中的数据
        if(rs.next()){ //如果有数据 则获取结果集中的数据
            int itemId = rs.getInt("itemId");
            String itemName = rs.getString("itemName");
            int itemValue = rs.getInt("itemValue");
            user = new User(itemId, itemName, itemValue);
        }
        //调用公共方法关闭资源
        DbUtils.closeResource(rs,stmt,conn);
        return user;
    }

    /**
     * 预编译的statement，解决sql注入攻击
     * @param name 水果名
    预编译的Statement
    sql注入攻击演示
    单元测试
    7Mybatis持久层框架
     * @param value 水果价值
     */
    public static User findByNamePass1(String name, int value) throws SQLException{
        User user = null;
        //获取链接
        Connection conn = DbUtils.getConnection();
        //操作数据库
        //普通的代理对象
        Statement stmt = conn.createStatement();
        //使用描述参数的方式
        String sql = "select * from `tbl_item` where `itemName` = ？ and `itemValue` = ？";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //解决问号参数
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,value);
        //执行sql语句
        ResultSet rs = preparedStatement.executeQuery();
        //获取结果集中的数据
        if(rs.next()){ //如果有数据 则获取结果集中的数据
            int itemId = rs.getInt("itemId");
            String itemName = rs.getString("itemName");
            int itemValue = rs.getInt("itemValue");
            user = new User(itemId, itemName, itemValue);
        }
        //调用公共方法关闭资源
        DbUtils.closeResource(rs,stmt,conn);
        return user;
    }
}


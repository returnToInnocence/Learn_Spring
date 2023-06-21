package jdbc;


import jdbc.utils.DbUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
junit单元测试
* */
public class Demo01 {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    @Before
    public void before(){
        System.out.println("获取数据库连接");
        connection = DbUtils.getConnection();
    }

    @Test
    public void testDelete() throws SQLException {
        statement = connection.createStatement();
//        String sql = "delete from"
        System.out.println("测试");
    }

    @After
    public void after(){
        System.out.println("之后");
    }

}

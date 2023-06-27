package mybatis2;

import mybatis2.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis2 {
    //提取这个会话变量的作用域
    SqlSession session = null;
    //执行Test之前执行，为会话赋值
    @Before
    public void before() throws IOException {
        //----------------------------------------------------------------
        String resource = "mybatis2/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //会话工厂获取会话
        session = sqlSessionFactory.openSession();
        System.out.println("执行测试之前获取会话：" + session);
        //----------------------------------------------------------------
    }
    //执行业务测试代码
    @Test
    public void testUpdateUser() throws IOException {
        System.out.println("开始测试更新操作····");
        //具体的操作数据库的代码
        //获取mapper代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.changePass("hello", "1");
    }
    //执行业务测试代码
    @Test
    public void testDeleteUser() throws IOException {
        System.out.println("开始测试删除操作····");
        //具体的操作数据库的代码
        //获取mapper代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.delUserById(1);
    }
    //执行Test之后，提交事务完成资源关闭
    @After
    public void after() throws IOException {
        //---------------------------------------------------------------
        System.out.println("测试结束，关闭资源····");
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        //----------------------------------------------------------------
    }
}

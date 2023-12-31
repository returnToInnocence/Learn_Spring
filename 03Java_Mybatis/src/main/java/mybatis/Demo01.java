package mybatis;

import mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //拿到配置文件路径
        String resource = "mybatis/mybatis-config.xml";
        //用对应接口拿到配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        //会话工厂对象：
//        System.out.println("会话工厂对象："+sqlSessionFactory);
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("org.mybatis.example.UserMapper.selectUser", 2);
        System.out.println(user.toString());
        List<User> userList = session.selectList("org.mybatis.example.UserMapper.selectUserList");
        System.out.println(userList.toString());
    }
}
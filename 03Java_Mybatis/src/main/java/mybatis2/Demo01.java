package mybatis2;

import mybatis.po.User;
import mybatis2.mapper.UserMapper;
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
        String resource = "mybatis2/mybatis-config.xml";
        //用对应接口拿到配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUser(2);
        System.out.println(user);
        List<User> userList = mapper.selectUserList();
        System.out.println(userList);
    }
}

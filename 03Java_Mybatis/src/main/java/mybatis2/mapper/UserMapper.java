package mybatis2.mapper;

import mybatis.po.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    /**
     * 返回对应id的user对象
     * @param id
     * @return
     */
    public User selectUser(int id);
    /**
     * 返回所有的user列表
     * @return
     */
    public List<User> selectUserList();
    /**
     * 新增一条数据
     * @param id id
     * @param userName 用户名
     * @param password 密码
     * @return 返回影响的条数
     */
    public int insertUser(@Param("id") int id,
                          @Param("userName") String userName,
                          @Param("password") String password);
    /**
     * 新增用户
     * @param user
     * @return 返回影响的条数
     */
    public int addUser(User user);
    /**
     * 通过用户名修改密码
     * 参数：【用户名，密码】 User 、 两个String
     * 返回值： void int
     * 方法名： changePass
     * sql语句编写： update user set password = "?" where username = "?"
     */
    @Update("update user set password = #{password} where username = #{username} " )
    public void changePass(@Param("username") String username,@Param("password") String password);
    /**
     * 通过id删除user表
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    public void delUserById(int id);

 }

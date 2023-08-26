package dao;
//接口，实体类User之后放UserDao接口
import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<User> getUserLike(String value);

    //查询全部用户
    /*@Select("select * from user"); 这就是注解，不需要在实现类UserMapper.xml去编程，注意要在核心配置文件里绑定接口 */
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //使用map查询用户（数据库中的表，字段或者参数过多，我们应当考虑使用Map）
    User getUserById2(Map<String,Object>map);

    //insert增加一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户信息
    int deleteUser(int id);

    //分页 起止和终点至少要2个参数，用万能的map来实现
    List<User> getUserByLimit(Map<String,Integer>map);

    //最后写2个接口的应用吧，查select和插insert
    //所有参数最好加上@Param("")注解
    @Select("select * from user where id=#{id} and name=#{name}")
    User getUserByID(@Param("id") int id,@Param("name") String name);

    @Insert("insert into user (id,name,password) values (#{id},#{name},#{password})")
    int addUsernew(User user);

    @Update("update user set name=#{name},password=#{password} where id=#{id}")
    int updateUsernew(User user);

    @Delete("delete from user where id = #{aid}") //这里面的aid名字要与Param("aid")一致
    int deleteUsernew(@Param("aid") int id);
}

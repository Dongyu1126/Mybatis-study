package hhh.com.kuang.dao.Utils;

//工具类
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory ==> sqlSession
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    static{

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
// SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。

    public static SqlSession getSqlSession(){

        return sqlSessionFactory.openSession(true);//b:true则以后所有东西都不需要手动提交，即增删改不需要提交
    }

}

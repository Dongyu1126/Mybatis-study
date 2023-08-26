package com.kuang.dao;

import com.kuang.dao.utils.MybatisUtils;
import com.kuang.pojo.User;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    @Test
    //模糊查询
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();//从工具类里找到其中，数据库执行命令的getSqlSession方法
        UserDao mapper = sqlSession.getMapper(UserDao.class);//之后获得定义的接口
        List<User> like = mapper.getUserLike("%李%");//mapper接口里，获得定义的getUserLike方法，模糊查询必须前后加上%，即%%传递通配符
        for (User user : like) {
            System.out.println(like);//输出like或user都可以
        }

        sqlSession.close();
    }


    @Test
    public void test(){

        //获得SQLSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{

            //方式一：执行Sql
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();

            //方式二：太具体，不推荐使用
            //List<User> userList = sqlSession.selectList("dao.UserDao.getUserList");

            /*userList.for+Enter来实现*/
            for (User user : userList) {
                System.out.println(userList);
            }

        }
        finally {
            //关闭SqlSession
            sqlSession.close();
        }
        }
        @Test
        public void getUserById(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();

            try {
                UserDao mapper = sqlSession.getMapper(UserDao.class);
                User user = mapper.getUserById(2);
                System.out.println(user);
            }
            finally{
                sqlSession.close();
            }

        }

        @Test
        //数据库中的表，字段或者参数过多，我们应当考虑使用Map
        public void getUserById2(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            HashMap<String,Object> map = new HashMap<>();

            map.put("jiangdongyuid",2);//map里面的名称随便定义，使用几个随便

            mapper.getUserById2(map);
            sqlSession.close();
        }

        //增删改（insert delete update）需要提交事务commit
        @Test
        public void addUser(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            try {

                UserDao mapper = sqlSession.getMapper(UserDao.class);
                int qdbs = mapper.addUser(new User(12, "青岛", "2022316"));
                if(qdbs>0){
                    System.out.println("插入成功！");
                }
            }
            finally {
                //提交事务
                sqlSession.commit();
                sqlSession.close();
            }

        }

        @Test
    public void updateUser(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserDao mapper = sqlSession.getMapper(UserDao.class);//获取接口
            int result = mapper.updateUser(new User(2, "青岛", "2022"));//得到接口可以new里面的方法了
            if(result>0){
                System.out.println("修改成功！");
            }

            sqlSession.commit();
            sqlSession.close();

        }

        @Test
    public void deleteUser(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            int res = mapper.deleteUser(7);
            if(res>0){
                System.out.println("删除成功！");
            }


            sqlSession.close();
        }

        @Test
    public void getUserByLimit(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            Object mapper = sqlSession.getMapper(UserDao.class);
            HashMap<String, Integer> map = new HashMap<>();
            map.put("startIndex",3);//起点
            map.put("pageSize",3);//从起点开始的尺寸

            List<User> userList = ((UserDao) mapper).getUserByLimit(map);
            for (User user : userList) {
                System.out.println(user);
            }
            sqlSession.close();
        }

        @Test //注解增删改查
    public void getUserByID(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            Object mapper = sqlSession.getMapper(UserDao.class);
            User userByID = ((UserDao) mapper).getUserByID(7, "姜栋宇");
            System.out.println(userByID);

            sqlSession.close();
        }

        @Test
    public void addUsernew(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            int i =  mapper.addUsernew(new User(7, "姜栋宇", "777777"));
            if(i>0){
                System.out.println("插入成功");
            }

            sqlSession.close();
        }

    @Test  //接口搞得增删改，接口默认autocommit=true不需要事务提交
    public void updateUsernew(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int i = mapper.updateUsernew(new User(10, "jdy", "777777"));
        if(i>0){
            System.out.println("修改成功");
        }

        sqlSession.close();
    }

    @Test
    public void deleteUsernew(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.deleteUsernew(7);

        sqlSession.close();
    }
}

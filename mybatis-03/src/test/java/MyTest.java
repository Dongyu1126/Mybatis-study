import hhh.com.kuang.dao.Utils.MybatisUtils;
import hhh.com.kuang.pojo.Teacher;
import hhh.dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Object mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacher = ((TeacherMapper) mapper).getTeacher();
        for (Teacher teacher1 : teacher) {
            System.out.println(teacher1  );
        }

        sqlSession.close();

    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher2 = mapper.getTeacher2(1);
        System.out.println(teacher2);

        sqlSession.close();

    }
}

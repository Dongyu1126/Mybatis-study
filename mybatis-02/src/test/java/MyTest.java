import hhh.com.kuang.pojo.Student;
import hhh.dao.StudentMapper;
import org.apache.ibatis.session.SqlSession;

import hhh.com.kuang.dao.Utils.MybatisUtils;
import hhh.com.kuang.pojo.Teacher;
import hhh.dao.TeacherMapper;
import org.junit.Test;

import java.util.List;

public class MyTest {


    public static void main(String[] args) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();
    }


   /* 多对一，多个学生对应一个老师*/

    @Test
    public void StudentTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void StudentTeacher2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student2List = mapper.getStudent2();
        for (Student student2 : student2List) {
            System.out.println(student2);
        }
    }
}

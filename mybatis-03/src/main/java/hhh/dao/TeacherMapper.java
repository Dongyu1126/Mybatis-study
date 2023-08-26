package hhh.dao;
//接口
import hhh.com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    //获取老师
    List<Teacher> getTeacher();

    Teacher getTeacher2(@Param("tid") int id);

    Teacher getTeacher3(@Param("tid") int id);
}

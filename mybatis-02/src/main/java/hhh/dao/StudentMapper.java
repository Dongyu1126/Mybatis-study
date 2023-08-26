package hhh.dao;

import hhh.com.kuang.pojo.Student;
import hhh.com.kuang.pojo.Teacher;

import java.util.List;

//接口
public interface StudentMapper {

    //任务：查询所有的学生信息，以及对应的老师的信息！
    public List<Student> getStudent();

    public List<Student> getStudent2();
}

package hhh.com.kuang.pojo;


//实体类

import lombok.Data;

import java.util.List;
@Data
public class Teacher {

    private int id;
    private String name;
    //一个老师关联多个学生（一对多）
    private List<Student> student;

}

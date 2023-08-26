package hhh.com.kuang.pojo;

import lombok.Data;
//实体类
@Data
public class Student {
    private int id;
    private String name;

    //多个学生去关联一个老师（多对一）
    private Teacher teacher;
}

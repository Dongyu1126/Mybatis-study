package com.kuang.pojo;

import lombok.Data;

import java.util.Date;//java里面用util Date,sql Date创建不了时间的

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;//这个名字跟数据库名不一样，可以用mapUnderscoreToCamelCase这个只适用于驼峰命名
    private int views;
}

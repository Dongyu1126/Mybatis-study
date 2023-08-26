package com.kuang.pojo;

import lombok.Data;

//实体类
//@Alias("author") 也可以这个注解随意diy名字
/*@Data  lombok的使用*/
public class User {

    private int id;
    private String name;
    private String password;

    /*快捷键：alt+fn+ins  选择constructor选择最上面那个就是无参，重复在选择下面那3个变量构造有参*/

    public User() {
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /*快捷键：alt+fn+ins  选择Getters and Setters选择三个变量*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }


    //加个注解
    /*快捷键：alt+fn+ins  选择toString选择三个变量*/
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

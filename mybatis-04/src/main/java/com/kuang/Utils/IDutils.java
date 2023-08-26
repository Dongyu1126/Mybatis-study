package com.kuang.Utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")//抑制警告：此注解专门解决一些可能出错词汇下面的斜杠，可以理解为掩耳盗铃，哈哈哈！
public class IDutils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
        System.out.println(IDutils.getId());
        System.out.println(IDutils.getId());
    }
}

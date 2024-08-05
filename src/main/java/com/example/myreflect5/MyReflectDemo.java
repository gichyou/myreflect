package com.example.myreflect5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class MyReflectDemo {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Student s = new Student("小A", 23, '女', 167.5, "睡觉");
        Teacher t = new Teacher("波妞", 10000);

        saveObject(s);
    }

    public static void saveObject(Object s) throws IllegalAccessException, IOException {
        //1.获取字节码文件对象
        Class clazz = s.getClass();

        //创建IO流
        BufferedWriter bw = new BufferedWriter(new FileWriter("..\\myreflect\\a.txt"));

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            //获取成员变量的名字
            String name = field.getName();
            //获取成员变量的值
            Object value = field.get(s);
            bw.write(name + "=" + value);
            bw.newLine();
        }
        bw.close();
    }
}

package com.example.myreflect3;

import java.lang.reflect.Field;

public class MyReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //1.获取对象的字节码文件对象
        Class clazz = Class.forName("com.example.myreflect3.Student");

        //2.获取成员变量
//        Field[] fields = clazz.getFields();//返回所有公共成员变量对象的数组
//        for (Field field : fields) {
//            System.out.println(field);
//        }

//        Field[] fields = clazz.getDeclaredFields();//返回所有成员变量对象的数组
//        for (Field field : fields) {
//            System.out.println(field);
//        }

//        Field gender = clazz.getField("gender");//返回单个的成员变量
//        System.out.println(gender);


        Field name = clazz.getDeclaredField("name");//返回单个成员变量（包括private）
//        System.out.println(name);

        int modifiers = name.getModifiers();//获取权限修饰符
        System.out.println(modifiers);

        String n = name.getName();//获取成员变量的名字
        System.out.println(n);

        Class<?> type = name.getType();//获取成员变量的数据类型
        System.out.println(type);

        Student s = new Student("zhangsan", 23, "男");
        name.setAccessible(true);
        String value = (String)name.get(s);
        System.out.println(value);

        //修改对象里面记录的值
        name.set(s,"lisi");
        System.out.println(s);
    }
}

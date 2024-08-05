package com.example.myreflect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class MyReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //1.获取class字节码文件对象
        Class clazz = Class.forName("com.example.myreflect2.Student");

        //2.获取构造方法
/*        Constructor[] cons = clazz.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }*/

        Constructor[] cons2 = clazz.getDeclaredConstructors();
        for (Constructor con : cons2) {
            System.out.println(con);
        }

//        Constructor con1 = clazz.getDeclaredConstructor();
//        System.out.println(con1);
//
//        Constructor con2 = clazz.getDeclaredConstructor(String.class);
//        System.out.println(con2);
//
        Constructor con3 = clazz.getDeclaredConstructor(String.class, int.class);
        System.out.println(con3);

/*        int modifiers = con3.getModifiers();
        System.out.println(modifiers);

        Parameter[] parameters = con3.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }*/

        con3.setAccessible(true);//暴力反射：表示临时取消权限校验
        Student student = (Student) con3.newInstance("zhangsan", 23);
        System.out.println(student);
    }
}

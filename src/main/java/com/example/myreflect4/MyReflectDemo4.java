package com.example.myreflect4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName("com.example.myreflect4.Student");

        //2.获取里面所有的方法对象（包含父类中所有的公共方法）
//        Method[] methods = clazz.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

        //3.获取里面所有的方法对象（不包含父类，但是可以获取本类中私有的方法）
//        Method[] methods1 = clazz.getDeclaredMethods();
//        for (Method method : methods1) {
//            System.out.println(method);
//        }


        //4.获取指定的单一方法
        Method method2 = clazz.getDeclaredMethod("eat", String.class);
//        System.out.println(method2);

        //获取方法的修饰符
        int modifiers = method2.getModifiers();
        System.out.println(modifiers);

        //获取方法的名字
        String name = method2.getName();
        System.out.println(name);

        //获取方法的形参
        Parameter[] parameters = method2.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

        //获取方法地抛出的异常
        Class[] exceptionTypes = method2.getExceptionTypes();
        for (Class exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }

        //方法运行
        Student s = new Student();
        method2.setAccessible(true);
        Object result = method2.invoke(s, "steak");
        System.out.println(result);
    }

}

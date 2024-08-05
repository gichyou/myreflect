package com.example.myreflect1;

public class MyReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName
        //全类名： 包名+类名
        //最为常用
        Class clazz1 = Class.forName("com.example.myreflect1.Student");

        //打印
        System.out.println(clazz1);


        //2.第二种方式
        //一般更多的是当作参数进行传递
        Class clazz2 = Student.class;
        System.out.println(clazz1 == clazz2);

        //3.第三种方式
        //当已经有了这个类的对象时，才可以使用
        Student s = new Student();
        Class clazz3 = s.getClass();
        System.out.println(clazz2 == clazz3);
    }
}

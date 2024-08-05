package com.example.myreflect6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyReflectDemo6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1.读取配置文件中的信息
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\gichy\\Documents\\myreflect\\src\\main\\java\\com\\example\\myreflect6\\prop.properties");
        prop.load(fis);
        fis.close();
        System.out.println(prop);

        //2.获取全类名和方法名
        String classname = (String)prop.get("classname");
        String methodName = (String) prop.get("method");

        System.out.println(classname);
        System.out.println(methodName);

        //3.利用反射创建对象并运行方法
        Class clazz = Class.forName(classname);

        Constructor con = clazz.getDeclaredConstructor(String.class, Double.class);
        con.setAccessible(true);
        Teacher teacher = (Teacher) con.newInstance("zhangsan",100.00);
        System.out.println(teacher);

        //获取成员方法并运行
        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(teacher);
    }
}

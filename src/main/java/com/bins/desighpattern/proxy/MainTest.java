package com.bins.desighpattern.proxy;

import com.bins.desighpattern.proxy.dynamicproxy.cglib.MyCGLIBProxy;
import com.bins.desighpattern.proxy.dynamicproxy.cglib.MyMethodInterceptor;
import com.bins.desighpattern.proxy.dynamicproxy.jdk.MyJDKProxy;
import com.bins.desighpattern.proxy.dynamicproxy.jdk.MyInvocationHandler;
import com.bins.desighpattern.proxy.staticproxy.PrintStaticProxy;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author leo-bin
 * @date 2020/3/2 12:23
 * @apiNote 几种代理模式测试
 */
public class MainTest {

    public static void main(String[] args) {
        String name = "甜甜";

        System.out.println("///////////////静态代理测试开始////////////");
        //测试静态代理
        testStatic(name);

        System.out.println("///////////////JDK代理测试开始////////////");
        //测试jdk动态代理
        testJDKDynamic(name);

        System.out.println("///////////////CGLIB代理测试开始////////////");
        //测试cglib动态代理
        testCGLIBDynamic(name);
    }


    private static void testStatic(String name) {
        //1.生成代理对象
        PrintInterFace proxy = new PrintStaticProxy(new PrintName());

        //2.代理对象执行方法
        proxy.print(name);
    }


    @SuppressWarnings("unchecked")
    private static void testJDKDynamic(String name) {
        //1.根据被代理对象和调用执行器来创建一个代理对象
        PrintInterFace proxy = (PrintInterFace) MyJDKProxy.createProxy(PrintInterFace.class.getClassLoader(),
                new Class<?>[]{PrintInterFace.class}, new MyInvocationHandler(new PrintName()));

        //生成代理对象的字节码文件
        PrintName printName = new PrintName();
        Class<? extends PrintName> clazz = printName.getClass();
        try {
            byte[] bytes = ProxyGenerator.generateProxyClass("proxy", clazz.getInterfaces());
            File file = new File("C:\\Users\\Bing\\Desktop\\proxy.class");
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //2.代理对象执行方法
        proxy.print(name);
    }


    private static void testCGLIBDynamic(String name) {
        //1.根据代理类以及被代理类动态创建代理对象
        PrintName printName = (PrintName) MyCGLIBProxy.createProxy(PrintName.class, new MyMethodInterceptor());

        //2.被代理对象执行方法（实质上是代理对象执行的）
        printName.print(name);
    }
}

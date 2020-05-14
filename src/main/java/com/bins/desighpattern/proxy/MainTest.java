package com.bins.desighpattern.proxy;

import com.bins.desighpattern.proxy.dynamicproxy.cglib.CGLIBProxy;
import com.bins.desighpattern.proxy.dynamicproxy.jdk.JDKProxy;
import com.bins.desighpattern.proxy.staticproxy.PrintStaticProxy;

/**
 * @author leo-bin
 * @date 2020/3/2 12:23
 * @apiNote
 */
public class MainTest {

    public static void main(String[] args) {
        String name = "甜甜";

        /*System.out.println("///////////////静态代理测试开始////////////");
        //测试静态代理
        testStatic(name);*/

        System.out.println("///////////////JDK代理测试开始////////////");
        //测试jdk动态代理
        testJDKDynamic(name);

        /*System.out.println("///////////////CGLIB代理测试开始////////////");
        //测试cglib动态代理
        testCGLIBDynamic(name);*/
    }


    private static void testStatic(String name) {
        //原来的类
        PrintInterFace printName = new PrintName();

        //代理之后的类
        PrintInterFace proxy = new PrintStaticProxy(printName);

        System.out.println("静态代理测试结果:");
        proxy.print(name);
    }


    private static void testJDKDynamic(String name) {
        //1.创建一个与代理对象相关联的InvocationHandler,调用执行器
        PrintInterFace printName = new PrintName();

        /*InvocationHandler printHandler = new JDKProxy<>(printName);


        PrintInterFace proxy = (PrintInterFace) Proxy.newProxyInstance(PrintInterFace.class.getClassLoader()
                , new Class<?>[]{PrintInterFace.class}, printHandler);*/

        //2.根据被代理对象和调用执行器来创建一个代理对象
        JDKProxy<PrintInterFace> jdkProxy = new JDKProxy<>(printName);
        PrintInterFace proxy = (PrintInterFace) jdkProxy.createProxy(PrintInterFace.class.getClassLoader(),
                new Class<?>[]{PrintInterFace.class});


        //3.代理对象执行方法
        System.out.println("JDK代理测试结果:");
        proxy.print(name);
    }


    private static void testCGLIBDynamic(String name) {
        //1.根据代理类以及被代理类动态创建代理对象
        CGLIBProxy cglibProxy = new CGLIBProxy();
        PrintName printName = (PrintName) cglibProxy.CreatProxyObj(PrintName.class);

        System.out.println("CGLIB代理测试结果:");
        //2.被代理对象执行方法（实质上是代理对象执行的）
        printName.print(name);
    }
}

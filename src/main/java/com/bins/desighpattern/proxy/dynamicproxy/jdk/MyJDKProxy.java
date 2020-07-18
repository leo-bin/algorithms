package com.bins.desighpattern.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author leo-bin
 * @date 2020/3/2 12:17
 * @apiNote JDK动态代理实现
 */
public class MyJDKProxy {

    /**
     * 构造自己的代理类
     *
     * @param loader     被代理类的类加载器
     * @param interfaces 被代理类本身的Class对象
     * @return 包装好的代理对象
     */
    public static Object createProxy(ClassLoader loader,
                                     Class<?>[] interfaces, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(loader, interfaces, invocationHandler);
    }
}

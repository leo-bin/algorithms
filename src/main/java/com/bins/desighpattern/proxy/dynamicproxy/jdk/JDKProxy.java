package com.bins.desighpattern.proxy.dynamicproxy.jdk;

import com.bins.util.MethodMonitorUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author leo-bin
 * @date 2020/3/2 12:17
 * @apiNote JDK动态代理实现
 */
public class JDKProxy<T> implements InvocationHandler {

    /**
     * 被代理对象
     */
    private T targetObject;

    /**
     * 初始化被代理对象
     */
    public JDKProxy(T targetObject) {
        this.targetObject = targetObject;
    }

    /**
     * 构造自己的代理类
     *
     * @param loader     被代理类的类加载器
     * @param interfaces 被代理类本身的Class对象
     * @return 包装好的代理对象
     */
    public Object createProxy(ClassLoader loader,
                              Class<?>[] interfaces) {
        return Proxy.newProxyInstance(loader, interfaces, this);
    }

    /**
     * 重写方法
     *
     * @param proxy  动态代理对象
     * @param method 正在被用户直接调用的接口中的方法
     * @param args   对应方法中的参数
     * @return 返回被代理对象中被调用方法的结果
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");

        //开始计时
        MethodMonitorUtil.start();

        //代理对象来执行被代理对象中的方法
        Object result = method.invoke(targetObject, args);
        //执行增强方法
        otherAction((String) args[0]);

        //结束计时
        MethodMonitorUtil.finish(method.getName());
        //返回被代理对象中被调用方法的结果
        return result;
    }


    /**
     * 添加的其他增强方法
     */
    public void otherAction(String name) {
        System.out.println("亲亲" + name);
    }
}

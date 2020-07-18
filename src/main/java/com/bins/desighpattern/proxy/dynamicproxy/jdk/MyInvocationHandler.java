package com.bins.desighpattern.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author leo-bin
 * @date 2020/7/18 15:43
 * @apiNote jdk代理测试，自定义加强方法
 */
public class MyInvocationHandler<T> implements InvocationHandler {

    /**
     * 被代理对象
     */
    private T targetObject;

    /**
     * 初始化被代理对象
     */
    public MyInvocationHandler(T targetObject) {
        this.targetObject = targetObject;
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
        //代理对象来执行被代理对象中的方法
        Object result = method.invoke(targetObject, args);

        //执行增强方法
        otherAction((String) args[0]);

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

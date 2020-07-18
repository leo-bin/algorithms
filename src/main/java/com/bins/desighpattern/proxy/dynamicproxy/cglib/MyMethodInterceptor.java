package com.bins.desighpattern.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author leo-bin
 * @date 2020/7/18 15:57
 * @apiNote CGLIB动态代理测试，自定义加强方法
 */
public class MyMethodInterceptor implements MethodInterceptor {

    /**
     * 方法拦截器
     *
     * @param o           代理类
     * @param method      被代理类调用的方法
     * @param objects     方法参数集合
     * @param methodProxy 代理方法
     * @return 被代理类执行的方法的返回结果
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //调用父类中的方法
        Object result = methodProxy.invokeSuper(o, objects);

        //执行增强方法
        otherAction(objects);

        return result;
    }


    /**
     * 添加的其他增强方法
     */
    public void otherAction(Object[] objects) {
        for (Object o : objects) {
            System.out.println("亲亲" + o.toString());
        }
    }
}

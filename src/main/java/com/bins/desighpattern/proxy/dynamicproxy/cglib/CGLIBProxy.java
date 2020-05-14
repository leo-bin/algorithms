package com.bins.desighpattern.proxy.dynamicproxy.cglib;

import com.bins.util.MethodMonitorUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author leo-bin
 * @date 2020/3/2 12:17
 * @apiNote CGLIB动态代理实现
 */
public class CGLIBProxy implements MethodInterceptor {

    /**
     * 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中
     *
     * @param clazz 被代理类的Class对象
     * @return 代理对象
     */
    public Object CreatProxyObj(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }


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
        //开始计时
        MethodMonitorUtil.start();

        //调用父类中的方法
        Object result = methodProxy.invokeSuper(o, objects);
        //执行增强方法
        otherAction(objects);

        //结束计时
        MethodMonitorUtil.finish(method.getName());
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

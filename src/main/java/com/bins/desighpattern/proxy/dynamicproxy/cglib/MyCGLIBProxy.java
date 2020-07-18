package com.bins.desighpattern.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * @author leo-bin
 * @date 2020/3/2 12:17
 * @apiNote CGLIB动态代理实现
 */
public class MyCGLIBProxy {

    /**
     * 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中
     *
     * @param clazz 被代理类的Class对象
     * @return 代理对象
     */
    public static Object createProxy(Class<?> clazz, MethodInterceptor interceptor) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        //通过自定义方法拦截器实现加强方法
        enhancer.setCallback(interceptor);

        return enhancer.create();
    }
}

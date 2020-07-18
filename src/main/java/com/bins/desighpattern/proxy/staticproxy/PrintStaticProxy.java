package com.bins.desighpattern.proxy.staticproxy;

import com.bins.desighpattern.proxy.PrintInterFace;
import com.bins.desighpattern.proxy.PrintName;
import com.bins.util.MethodMonitorUtil;

/**
 * @author leo-bin
 * @date 2020/3/2 12:15
 * @apiNote 静态代理类，既实现了原来的接口类，有可以增加新的功能
 */
public class PrintStaticProxy implements PrintInterFace {

    /**
     * 被代理对象，打印名字对象
     */
    private PrintName printName;

    /**
     * 构造方法
     *
     * @param printName 被代理对象实例
     */
    public PrintStaticProxy(PrintInterFace printName) {
        //只代理这个打印名字对象
        if (printName.getClass() == PrintName.class) {
            this.printName = (PrintName) printName;
        }
    }


    @Override
    public void print(String name) {
        //1.执行代理方法
        printName.print(name);

        //2.在正式调用print方法之后调用增强方法
        otherAction(name);

    }

    /**
     * 添加的其他增强方法
     */
    public void otherAction(String name) {
        System.out.println("亲亲" + name);
    }
}

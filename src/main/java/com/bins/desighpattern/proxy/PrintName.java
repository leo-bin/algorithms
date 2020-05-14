package com.bins.desighpattern.proxy;


/**
 * @author leo-bin
 * @date 2020/3/2 12:20
 * @apiNote 被代理类
 */
public class PrintName implements PrintInterFace {


    @Override
    public void print(String name) {
        System.out.println("name=" + name);
    }
}

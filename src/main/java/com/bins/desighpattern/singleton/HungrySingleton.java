package com.bins.desighpattern.singleton;

/**
 * @author leo-bin
 * @date 2020/1/2 10:33
 * @apiNote 单例设计模式之 饿汉式加载模式
 * 特点：
 * 1.任何时候只要你想使用本实例，只要get就行
 * 2.但是如果本实例很少甚至没有被用到过的话，那就会很占内存
 * 为什么会占内存？
 * 一旦本类被加载了之后，就会给静态变量赋值，也就是new一个本实例的对象，但是没人使用它
 */
public class HungrySingleton {

    /**
     * 1.将构造函数私有化，外部不可以通过new来获得本类的实例
     */
    private HungrySingleton() {
    }

    /**
     * 2.直接生成一个已经初始化好的本类的实例
     */
    private static final HungrySingleton singleTon = new HungrySingleton();

    /**
     * 3.对外提供一个获得本实例的唯一方法
     */
    public static HungrySingleton getSingleTon() {
        return singleTon;
    }

    public void print() {
        System.out.println("单例模式之饿汉式加载模式::HungrySingleton");
    }
}

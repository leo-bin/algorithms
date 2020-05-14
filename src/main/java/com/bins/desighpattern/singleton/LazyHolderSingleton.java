package com.bins.desighpattern.singleton;

/**
 * @author leo-bin
 * @date 2020/1/2 16:19
 * @apiNote 单例设计模式之 静态内部类实现懒汉式加载模式
 * 特点：
 * 1.被调用时才进行初始化
 * 当任何一个线程第一次调用getInstance()时，都会使LazyHolderSingleton被加载和被初始化，此时静态初始化器将执行Singleton的初始化操作
 * 2.初始化静态数据时，Java提供了的线程安全性保证(所以不需要任何的同步)
 */
public class LazyHolderSingleton {

    /**
     * 1.将构造函数私有化，外部不可以通过new来获得本类的实例
     */
    private LazyHolderSingleton() {
    }

    /**
     * 2.定义一个静态内部类，里面实现，初始化一个静态的本类实例（指的是外部类）
     */
    private static class LazyHolder {
        private static final LazyHolderSingleton INSTANCE = new LazyHolderSingleton();
    }

    /**
     * 3.提供一个获取本实例的唯一方法
     */
    public static LazyHolderSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void print() {
        System.out.println("单例模式之静态内部类懒汉式加载模式::LazyHolderSingleton");
    }
}

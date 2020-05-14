package com.bins.desighpattern.singleton;

/**
 * @author leo-bin
 * @date 2020/2/14 15:13
 * @apiNote 单例设计模式测试
 */
public class Test {


    public static void main(String[] args) {
        test1();
        /*test2();*/
    }


    /**
     * 普通测试
     */
    public static void test1() {
        //单例模式之饿汉式加载模式
        HungrySingleton hungrySingleton = HungrySingleton.getSingleTon();
        hungrySingleton.print();
        //单例模式之懒汉式加载模式
        LazySingleton lazySingleton = LazySingleton.getSingleton();
        /*lazySingleton.print();*/
        //单例模式之静态内部类懒汉式加载模式
        LazyHolderSingleton lazyHolderSingleton = LazyHolderSingleton.getInstance();
        lazyHolderSingleton.print();
        //枚举类实现单例模式
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        enumSingleton.print();
    }


    /**
     * 多线程安全测试
     */
    public static void test2() {
        //同时开启5个线程同时去获取同一个对象的实例
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LazySingleton lazySingleton = LazySingleton.getSingleton();
                    //将实例的hash地址传递过去，验证是否同时存在两个实例
                    lazySingleton.print(lazySingleton.hashCode());
                }
            }).start();
        }
    }
}

package com.bins.desighpattern.singleton;


/**
 * @author leo-bin
 * @date 2020/1/2 10:26
 * @apiNote 单例设计模式之 懒汉式加载模式
 * 特点：
 * 1.只要在你需要用到本类的实例的时候才会给你一个本类的实例
 * 2.通过DCL（Double Check Lock，双重检测锁）措施和volatile锁解决多线程下产生的问题
 */
public class LazySingleton {

    /**
     * 1.将构造函数私有化，外部不可以通过new来获得本类的实例
     */
    private LazySingleton() {
    }

    /**
     * 2.定义一个加了volatile锁的本类对象的引用，但是不赋值，加上volatile目的就是设置内存屏障，防止指令重排
     * 指令重排是因为CPU考虑到具体的性能，默认进行的一个指令排序
     * 一般来说new一个对象需要4条指令：
     * a.给对象分配内存
     * b.初始化对象
     * c.调用对象的构造方法
     * d.返回对象的堆地址
     * <p>
     * 1.在一般的情况下，CPU会认为先执行d再执行c，效率会高一点
     * 2.那是因为CPU认为反正对象最后也是要调用自己的构造方法的，不如先将地址返回，提高速度
     * <p>
     * 1.但是像下面这种情况，如果有一个线程B正在执行new的方法，CPU给他的指令重排序了
     * 2.也就是说B线程还没有完完全全的把对象给实例出来，但是B突然阻塞，而且已经将对象的堆地址返回了。
     * 3.然后这个时候有一个线程A执行if(singleton==null)判断对象的地址不为空，返回这个对象的地址
     * 4.最后还调用了它，直接空指针异常
     */
    private static volatile LazySingleton singleton;


    /**
     * 3.提供一个获取本实例的唯一方法（静态方法）+synchronized
     */
    public static LazySingleton getSingleton() {
        if (singleton == null) {
            //把synchronized锁加在了代码块里，而不是方法上，目的就是为了将锁的范围缩小，提高性能
            synchronized (LazySingleton.class) {
                //因为synchronized是可重入锁，所以这里在判断一次是否为空，防止同一个线程再次调用这个方法
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }


    /**
     * 普通懒汉式加载模式（不加锁实现）
     *
     * @return
     */
/*    public static LazySingleton getSingleton() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }*/


    public void print(int hashCode) {
        System.out.println("实例的地址为：" + hashCode + "单例模式之懒汉式加载模式::LazySingleton：：线程：" + Thread.currentThread().getName());
    }
}

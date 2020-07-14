package com.bins.desighpattern.singleton;

/**
 * @author leo-bin
 * @date 2020/5/12 10:11
 * @apiNote 使用枚举实现单例模式
 */
public class EnumSingleton {

    /**
     * 1.构造器私有化
     */
    private EnumSingleton() {

    }

    /**
     * 2.定义一个内部枚举类用来生成本实列，也就是外部类的实例
     */
    private enum Singleton {
        /**
         * 实例
         */
        INSTANCE;

        /**
         * 持有外部类的实例
         */
        private final EnumSingleton enumSingleton;

        Singleton() {
            enumSingleton = new EnumSingleton();
        }

        /**
         * 返回实例
         */
        private EnumSingleton getInstance() {
            return enumSingleton;
        }
    }


    /**
     * 3.提供一个公有的静态方法用来获取本实例
     */
    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }


    public  void print() {
        System.out.println("通过枚举拿到单例：EnumSingleton");
    }
}

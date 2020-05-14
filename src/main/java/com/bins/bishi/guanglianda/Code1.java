package com.bins.bishi.guanglianda;

/**
 * @author leo-bin
 * @date 2020/4/21 18:29
 * @apiNote 广联达2018校招开发工程师笔试题
 * 第一题
 */
public class Code1 {

    /**
     * 1.构造方法私有化
     */
    private Code1() {

    }

    /**
     * 2.成员变量使用volatile修饰，防止指令重排序
     */
    public static volatile Code1 singleTon;


    /**
     * 3.写一个获取本实例的静态方法
     */
    public static Code1 getInstance() {
        if (singleTon == null) {
            synchronized (Code1.class) {
                //可重入式锁
                if (singleTon == null) {
                    singleTon = new Code1();
                }
            }
        }
        return singleTon;
    }
}

package com.bins.util;

/**
 * @author leo-bin
 * @date 2020/3/6 1:25
 * @apiNote 封装对方法的调用时间的检测工具类
 */
public class MethodMonitorUtil {

    /**
     * 使用ThreadLocal用于存储当前线程中的变量
     */
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 记录方法开始时间
     */
    public static void start() {
        threadLocal.set(System.currentTimeMillis());
    }

    /**
     * 记录方法结束时间，并计算耗时时间
     *
     * @param methodName 方法名
     */
    public static void finish(String methodName) {
        //方法结束时间
        Long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - threadLocal.get()) + "ms");
    }
}

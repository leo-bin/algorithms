package com.bins.javabasic.thread.threadlocal;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author leo-bin
 * @date 2020/2/25 23:55
 * @apiNote 自定义实现一个ThreadLocal
 */
public class MyThreadLocal<T> {

    /**
     *
     */
    private Map<Thread, T> threadMap = new WeakHashMap<>();


    /**
     * set方法
     *
     * @param value
     */
    public synchronized void set(T value) {
        threadMap.put(Thread.currentThread(), value);
    }

    /**
     * get方法
     *
     * @return
     */
    public synchronized T get() {
        return threadMap.get(Thread.currentThread());
    }

    /**
     * remove方法
     */
    public synchronized void remove() {
        threadMap.remove(Thread.currentThread());
    }
}

package com.bins.javabasic.lock.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author leo-bin
 * @date 2020/2/12 20:02
 * @apiNote 自旋锁（不可重入式的）
 */
public class SpinLock1 {

    /**
     * 原子引用对象，可以操作一些原子级别的方法
     */
    private AtomicReference<Thread> sign = new AtomicReference<>();


    /**
     * 锁住
     *
     * @apiNote compareAndSet源码：
     * public final boolean compareAndSet(V expect, V update) {
     * //使用unsafe这个类直接操作操作系统底层方法
     * return unsafe.compareAndSwapObject(this, valueOffset, expect, update);
     * }
     */
    public void lock() {
        //获取当前线程的实例
        Thread current = Thread.currentThread();
        //compareAndSet利用JNI（Java Native Interface）来完成CPU指令的操作
        //我们假设现在有三个线程A,B,C
        //A首先去拿C线程的锁，调用这里的方法lock()
        //这里的expect的值是null，也就是说，当A线程第一次去拿这个锁的时候，内存中的锁也是null，两个值相等
        //所以正好把当前的线程写入内存，相等于当前线程获得锁
        //当B也想要获得这把锁的时候，再次调用此方法，发现内存中的值不为null，返回false，这里进入死循环，反复判断是否满足条件
        //只有当A调用unlock()方法把锁给释放了，将内存中的值重新置为null，这里才会跳出循环
        while (!sign.compareAndSet(null, current)) {
            //do nothing
            System.out.println("线程" + current.getName() + "正在等待锁的释放。。。");
        }
    }

    /**
     * 解锁
     */
    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
        System.out.println("线程" + current.getName() + "的锁已经释放。。。");
    }

}

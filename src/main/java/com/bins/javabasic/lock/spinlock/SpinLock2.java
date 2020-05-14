package com.bins.javabasic.lock.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author leo-bin
 * @date 2020/2/12 20:56
 * @apiNote 自旋锁（可重入式锁）
 */
public class SpinLock2 {

    /**
     * 原子引用对象，可以操作一些原子级别的方法
     */
    private AtomicReference<Thread> sigh = new AtomicReference<>();

    /**
     * 线程计数器，用来记录线程获得了几把锁
     */
    private int count;

    /**
     * 加锁
     */
    public void lock() {
        Thread current = Thread.currentThread();
        //如果当前的线程是之前拿到了锁的线程，count+1，表示获得的锁数量+1，并且直接返回，也就是代表又获得了一次锁
        if (current == sigh.get()) {
            count++;
            return;
        }
        while (!sigh.compareAndSet(null, current)) {
            //do nothing
        }
    }

    /**
     * 解锁
     */
    public void unlock() {
        Thread current = Thread.currentThread();
        //如果是当前线程的话
        if (current == sigh.get()) {
            //只要count>0，那就执行--操作，也就是说当前线程获得了多次锁，需要一个一个的释放才行，这里通过count值减一来模拟这一动作
            if (count > 0) {
                count--;
            } else {
                //释放锁
                sigh.compareAndSet(current, null);
            }
        }
    }
}

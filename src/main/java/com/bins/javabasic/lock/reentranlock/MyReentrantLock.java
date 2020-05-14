package com.bins.javabasic.lock.reentranlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leo-bin
 * @date 2020/2/13 17:43
 * @apiNote ReentranLock 可重入式锁 demo
 */
public class MyReentrantLock {


    /**
     * 获取一把锁，默认是不公平锁
     */
    private ReentrantLock reentrantLock = null;


    private MyReentrantLock(boolean isFair) {
        this.reentrantLock = new ReentrantLock(isFair);
    }


    /**
     * 1.lock方法：
     * 如果再执行lock()方法的时候，如果一直没有获取到锁（说明资源被其他线程给占用了）那么就会一直等待，直到获取锁
     * 2.
     */
    private void get() {
        //先锁住当前的线程
        /*reentrantLock.lock();*/
        try {
            if (reentrantLock.tryLock(1L, TimeUnit.MILLISECONDS)) {
                System.out.println("成功拿到锁，当前线程的id=" + Thread.currentThread().getId() + ",is running");
                //调用当前线程的另外一个方法
                set();
                Thread.sleep(10L);
            } else {
                System.out.println("获取锁失败，当前线程的id=" + Thread.currentThread().getId());
                return;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //释放锁
        reentrantLock.unlock();
    }


    /**
     *
     */
    private void set() {
        //先锁住当前的线程
        reentrantLock.lock();
        System.out.println("当前线程的id=" + Thread.currentThread().getId() + ",is running");
        //释放锁
        reentrantLock.unlock();
    }


    /**
     * 测试入口
     *
     * @param args
     * @apiNote 通过制造死锁的产生来测试ReentrantLock的特性
     */
    public static void main(String[] args) throws InterruptedException {
        //初始化一个非公平锁（默认就是不公平锁，这里false其实没有必要写）
        MyReentrantLock myReentrantLock = new MyReentrantLock(false);
        //开启两个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReentrantLock.get();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myReentrantLock.get();
            }
        }).start();
    }

}

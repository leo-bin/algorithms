package com.bins.javabasic.thread.threadlocal;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leo-bin
 * @date 2020/2/26 0:00
 * @apiNote
 */
public class ThreadLocalTest {

    /**
     * 使用volatile修饰保证内存可见性
     */
    private static volatile AtomicInteger count = new AtomicInteger();


    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        //开一个线程A
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(1);
                int tmp = 0;
                for (int i = 0; i < 10000; i++) {
                    tmp = threadLocal.get() + 1;
                    threadLocal.set(tmp);
                }
                //自旋直到set成功
                int expect = count.get();
                tmp = count.get() + tmp;
                while (!count.compareAndSet(expect, tmp)) {
                    //do nothing
                }
                System.out.println("线程" + Thread.currentThread().getName() + "一共计数：" + threadLocal.get());
            }
        }).start();

        //开一个线程B
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(1);
                int tmp = 0;
                for (int i = 0; i < 10000; i++) {
                    tmp = threadLocal.get() + 1;
                    threadLocal.set(tmp);
                }
                int expect = count.get();
                tmp = count.get() + tmp;
                while (!count.compareAndSet(expect, tmp)) {
                    //do nothing
                }
                System.out.println("线程" + Thread.currentThread().getName() + "一共计数：" + threadLocal.get());
            }
        }).start();

        //Main线程等待其他线程执行完毕
        try {
            Thread.sleep(800L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个线程总共计数：" + count.get());
    }

}

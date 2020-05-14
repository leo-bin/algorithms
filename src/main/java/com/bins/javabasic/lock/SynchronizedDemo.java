package com.bins.javabasic.lock;

/**
 * @author leo-bin
 * @date 2020/2/13 18:26
 * @apiNote Synchronized  Demo
 */
public class SynchronizedDemo {


    /**
     * 同步代码块
     */
    public void method1(String threadName) {
        try {
            synchronized (this) {
                System.out.println(threadName + "中的" + "method1 is running");
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步方法
     */
    public synchronized void method2(String threadName) {
        try {
            System.out.println(threadName + "中的" + "method2 is running");
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步静态方法
     */
    public static synchronized void method3(String threadName) {
        try {
            System.out.println(threadName + "中的" + "method3 is running");
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步类
     */
    public void method4(String threadName) {
        synchronized (SynchronizedDemo.class) {
            try {
                System.out.println(threadName + "中的" + "method4 is running");
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 测试入口
     *
     * @param args
     */
    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

        //开启第一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "正在运行");
                /*synchronizedDemo.method1(Thread.currentThread().getName());*/
                /*synchronizedDemo.method2(Thread.currentThread().getName());*/
                synchronizedDemo.method4(Thread.currentThread().getName());
            }
        }).start();

        //开启第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "正在运行");
                /*synchronizedDemo.method1(Thread.currentThread().getName());*/
                /*synchronizedDemo.method2(Thread.currentThread().getName());*/
                synchronizedDemo.method4(Thread.currentThread().getName());
            }
        }).start();
    }
}

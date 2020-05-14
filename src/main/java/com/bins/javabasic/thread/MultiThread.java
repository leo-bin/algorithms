package com.bins.javabasic.thread;

import java.util.concurrent.*;

/**
 * @author leo-bin
 * @date 2020/2/19 14:56
 * @apiNote 多线程测试
 */
public class MultiThread {

    /**
     * 初始化一个线程池
     */
    public static ThreadFactory myThreadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            System.out.println("使用ThreadFactory创建了一个线程" + thread.getName());
            return thread;
        }
    };

    /**
     * 线程池执行器
     */
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
            10,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(15),
            myThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());

    /**
     * 使用Executors中的静态方法直接创建一个线程池
     *
     * @apiNote 这种方式不好
     * 1.第一是不能让人了解线程池的创建规则
     * 2.二是线程池的具体配置需要结合自己的实际情况来设置的，不能使用默认配置，容易导致OOM的情况
     */
    public static void start1(int num) {
        //使用线程执行器创建一个大小固定为10个的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        System.out.println("这是使用Executors.newFixedThreadPool创建的线程：");
        for (int i = 0; i < num; i++) {
            MyThread myThread = new MyThread();
            //提交当前的线程
            executorService.submit(myThread);
        }
        executorService.shutdown();
    }

    /**
     * 手动创建线程池，自定义配置自己的线程池
     */
    public static void start2(int num) {
        System.out.println("这是使用自定义手动线程池创建的线程：");
        for (int i = 0; i < 100; i++) {
            MyThread myThread = new MyThread();
            executor.execute(myThread);
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        final int THREAD_NUM = 3;
        /*start1(THREAD_NUM);*/
        start2(THREAD_NUM);
    }
}

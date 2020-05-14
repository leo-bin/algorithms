package com.bins.javabasic.collection.queue.blockingqueue;

import java.util.HashSet;
import java.util.concurrent.*;

/**
 * @author leo-bin
 * @date 2020/2/5 16:10
 * @apiNote 测试入口
 */
public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue(10);
        HashSet<String> hashSet = new HashSet<>(16);
        //初始化一个容量为10的ArrayBlockingQueue队列
        BlockingQueue queue = new ArrayBlockingQueue(10);
        //LinkedBlockingQueue
        BlockingQueue queue1 = new LinkedBlockingQueue(10);
        //初始化一个固定大小为5个线程的线程池
        ExecutorService poolExecutor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            Consumer consumer = new Consumer(queue);
            //当这里提交的时候，线程池会自动创建一个线程
            poolExecutor.submit(consumer);
        }
        for (int i = 0; i < 5; i++) {
            Producer producer = new Producer(queue);
            poolExecutor.submit(producer);
        }
    }
}

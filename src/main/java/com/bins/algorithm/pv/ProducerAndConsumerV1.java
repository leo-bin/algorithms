package com.bins.algorithm.pv;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leo-bin
 * @date 2020/4/24 17:22
 * @apiNote 模拟生产者消费者1, 仿造ArrayBlockingQueue，使用数组加ReentrantLock+二条件算法实现
 */
public class ProducerAndConsumerV1<T> {
    /**
     * pv容器
     */
    private final Object[] items;
    /**
     * 元素个数统计
     */
    private int count;
    /**
     * 下一个要取的元素的位置
     */
    private int takeIndex;
    /**
     * 下一个要放进数组的位置
     */
    private int putIndex;
    /**
     * 唯一一把锁负责所有线程的安全
     */
    private final ReentrantLock lock;
    /**
     * 等待取元素的条件
     */
    private final Condition notEmpty;
    /**
     * 等待放元素的条件
     */
    private final Condition notFull;


    public ProducerAndConsumerV1(int capacity) {
        //特判
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        //初始化
        this.items = new Object[capacity];
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }


    /**
     * take操作，阻塞操作，如果拿不到就阻塞
     */
    public T take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            //如果没有那就原地等待呗
            while (count == 0) {
                notEmpty.await();
            }
            //有了再去拿呗
            return dequeue();
        } finally {
            lock.unlock();
        }
    }


    /**
     * put操作，如果放不下了，那就阻塞，知道有空间为止
     */
    public void put(T e) throws InterruptedException {
        //特判
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            enqueue(e);
        } finally {
            lock.unlock();
        }
    }


    /**
     * 取目前的take索引所在位置的元素出队列
     */
    private T dequeue() {
        final Object[] items = this.items;
        //通过takeIndex去取元素
        @SuppressWarnings("unchecked")
        T x = (T) items[takeIndex];
        //取完之后销毁
        items[takeIndex++] = null;
        //在takeIndex即将要用完了的时候归零
        if (takeIndex == items.length) {
            takeIndex = 0;
        }
        count--;
        //去唤醒正在等待put的生产者线程
        notFull.signal();
        return x;
    }


    /**
     * 在目前的put索引的位置上放一个元素，进队列
     */
    private void enqueue(T e) {
        final Object[] items = this.items;
        items[putIndex++] = e;
        //在putIndex即将用完的时候归零
        if (putIndex == items.length) {
            putIndex = 0;
        }
        count++;
        notEmpty.signal();
    }


    private static void checkNotNull(Object v) {
        if (v == null) {
            throw new NullPointerException();
        }
    }


    public static void main(String[] args) {
        ProducerAndConsumerV1<Integer> pv1 = new ProducerAndConsumerV1<>(10);
        //开启一个生产者线程不断的往队列里面加数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        pv1.put(i);
                        System.out.println(Thread.currentThread().getName() + "正在往队列中写入数据：" + i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //开启一个消费者线程不断的去取数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 15; i++) {
                        System.out.println(Thread.currentThread().getName() + "从队列拿到一个数据：" + pv1.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

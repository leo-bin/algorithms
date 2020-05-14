package com.bins.algorithm.pv;

import java.util.LinkedList;

/**
 * @author leo-bin
 * @date 2020/4/24 17:22
 * @apiNote 生产者消费者，synchronized+LinkedList实现
 */
public class ProducerAndConsumerV1<T> {

    /**
     * 未满锁
     */
    private final Object notFullLock = new Object();
    /**
     * 非空锁
     */
    private final Object notNullLock = new Object();
    /**
     * 容量
     */
    private int capacity;
    /**
     * 数据容器
     */
    private LinkedList<T> container;


    public ProducerAndConsumerV1(int capacity) {
        this.capacity = capacity;
        this.container = new LinkedList<>();
    }

    /**
     * 消费数据
     */
    public T get() {
        //1.如果是空的话，当前消费者线程阻塞
        while (container.size() == 0) {
            synchronized (notNullLock) {
                try {
                    notNullLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //2.不为空，取数据
        T data = container.poll();
        --capacity;
        //3.唤醒正在阻塞的生产者线程
        synchronized (notFullLock) {
            notFullLock.notify();
        }
        return data;
    }

    /**
     * 生产数据
     */
    public boolean set(T value) {
        //1.满了，当前的生产者线程阻塞
        while (container.size() == capacity) {
            synchronized (notFullLock) {
                try {
                    notFullLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //2.没满，放数据
        boolean result = container.add(value);
        ++capacity;
        //3.唤醒正在阻塞的消费者线程
        synchronized (notNullLock) {
            notNullLock.notify();
        }
        return result;
    }


    public static void main(String[] args) {
        //设置初始容量为10
        int cap = 10;
        ProducerAndConsumerV1<String> pv = new ProducerAndConsumerV1<>(cap);
        //开一个生产者线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试获取");
            System.out.println(Thread.currentThread().getName() + "获取了一个元素：" + pv.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "设置了一个元素，状态：" + pv.set("test1"));
        }).start();

        //开一个消费者线程
        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "设置了一个元素，状态：" + pv.set("test2"));
            System.out.println(Thread.currentThread().getName() + "尝试获取");
            System.out.println(Thread.currentThread().getName() + "获取了一个元素：" + pv.get());
        }).start();
    }
}

package com.bins.algorithm.pv;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leo-bin
 * @date 2020/4/24 17:35
 * @apiNote 生产者消费者2，仿造LinkedBlockingQueue，使用单链表+ReentrantLock+二条件算法实现
 */
public class ProducerAndConsumerV2<T> {
    /**
     * 内部类节点
     *
     * @param <T>
     */
    static class Node<T> {
        T item;
        Node<T> next;

        Node(T item) {
            this.item = item;
        }
    }

    /**
     * 队列容量，默认是int的最大值
     */
    private final int capacity;
    /**
     * 元素个数统计
     */
    private final AtomicInteger count = new AtomicInteger();
    /**
     * 队列的头结点
     */
    private transient Node<T> head;
    /**
     * 队列的尾节点
     */
    private transient Node<T> last;

    /**
     * take锁和take的条件
     */
    private final ReentrantLock takeLock = new ReentrantLock();
    private final Condition notEmpty = takeLock.newCondition();
    /**
     * put锁和put的条件
     */
    private final ReentrantLock putLock = new ReentrantLock();
    private final Condition notFull = putLock.newCondition();


    public ProducerAndConsumerV2() {
        this.capacity = Integer.MAX_VALUE;
        last = head = new Node<>(null);
    }

    /**
     * take操作，阻塞操作，如果拿不到就阻塞
     */
    public T take() throws InterruptedException {
        T e;
        int c;
        final AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            e = dequeue();
            c = count.getAndDecrement();
            //自己释放消费者线程
            if (c > 1) {
                notEmpty.signal();
            }
        } finally {
            takeLock.unlock();
        }
        //如果达到了最大容量就去释放生产者线程
        if (c == capacity) {
            signalNotFull();
        }
        return e;
    }


    /**
     * put操作，如果放不下了，那就阻塞，知道有空间为止
     */
    public void put(T e) throws InterruptedException {
        //特判
        checkNotNull(e);
        int c;
        Node<T> node = new Node<>(e);
        final AtomicInteger count = this.count;
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            //达到最大容量了就阻塞
            while (count.get() == capacity) {
                notFull.await();
            }
            enqueue(node);
            c = count.getAndIncrement();
            //有空闲区了就去释放生产者线程
            if (c + 1 < capacity) {
                notFull.signal();
            }
        } finally {
            putLock.unlock();
        }
        //如果现在还是空的话就去释放生产者线程
        if (c == 0) {
            signalNotEmpty();
        }
    }


    /**
     * 将元素放进队尾，入队列
     */
    private void enqueue(Node<T> node) {
        last.next = node;
        last = node;
    }


    /**
     * 取目前的队头元素出队列
     */
    private T dequeue() {
        Node<T> h = head;
        Node<T> first = h.next;
        h.next = null;
        head = first;
        T x = first.item;
        first.item = null;
        return x;
    }

    /**
     * 释放生产者线程
     */
    private void signalNotFull() {
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

    /**
     * 释放消费者线程
     */
    private void signalNotEmpty() {
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }


    private static void checkNotNull(Object v) {
        if (v == null) {
            throw new NullPointerException();
        }
    }


    public static void main(String[] args) {
        ProducerAndConsumerV2<Integer> pv2 = new ProducerAndConsumerV2<>();
        //开启一个生产者线程不断的往队列里面加数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        pv2.put(i);
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
                        System.out.println(Thread.currentThread().getName() + "从队列拿到一个数据：" + pv2.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

package com.bins.question.print;

import java.util.concurrent.Semaphore;

/**
 * @author leo-bin
 * @date 2020/3/4 10:59
 * @apiNote 题目描述：
 * 1.给定正整数n
 * 2.设计两个线程
 * 3.A只打印奇数，B只打印偶数，要求顺序打印1~n
 * <p>
 * 思路：
 * 1.信号量解决
 * 2.还是设置奇数信号量和偶数信号量，根据情况设定两个信号量的初始资源数
 * 3.根据情况决定如何循环1~n
 */
public class PrintOddAndEvenUsingSemaphore {

    /**
     * 代表奇数信号量，可用资源数设为1
     */
    private Semaphore semaphoreOdd = new Semaphore(1);

    /**
     * 代表偶数信号量，可用资源数设为0
     */
    private Semaphore semaphoreEven = new Semaphore(0);


    /**
     * 打印奇数或者偶数
     */
    public void printOddOrEven(int number, String threadName) {
        //为奇数才打印
        if ((number & 1) == 1) {
            print(number, semaphoreOdd, semaphoreEven, threadName);
        } else {
            print(number, semaphoreEven, semaphoreOdd, threadName);
        }
    }


    /**
     * 打印数字
     */
    private void print(int number, Semaphore currentSemaphore, Semaphore nextSemaphore, String threadName) {
        try {
            //抢当前的资源数,拿到的资源数为1，成功抢到，0代表没抢到，当前线程阻塞
            currentSemaphore.acquire();
            System.out.println("当前线程是：" + threadName + "打印结果是：" + number);
            //当前线程执行完毕，释放下一个信号量的资源数
            nextSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试
     */
    public static void main(String[] args) {
        int n = 9;
        PrintOddAndEvenUsingSemaphore printOddAndEvenUsingSemaphore = new PrintOddAndEvenUsingSemaphore();
        //开启A线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= n; i++) {
                    if ((i & 1) == 1) {
                        printOddAndEvenUsingSemaphore.printOddOrEven(i, Thread.currentThread().getName());
                    }
                }
            }
        }).start();

        //开启线程B
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= n; i++) {
                    if ((i & 1) == 0) {
                        printOddAndEvenUsingSemaphore.printOddOrEven(i, Thread.currentThread().getName());
                    }
                }
            }
        }).start();
    }
}

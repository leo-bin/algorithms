package com.bins.question.print;

import java.util.concurrent.Semaphore;

/**
 * @author leo-bin
 * @date 2020/3/4 11:47
 * @apiNote 题目描述：
 * 1.现在有10个线程，同时启动这10个线程
 * 2.如何使用这10个线程按照顺序依次打印出12345678910。
 * <p>
 * 思路：
 * 1.还是使用信号量解题
 * 2.12345678910无非就是奇数或者偶数
 * 3.那就设置两个信号量，奇数信号量，偶数信号量，根据要求打印的顺序，来判断是先打印奇数还是偶数
 * 4.奇数先打印，那就将奇数信号量的资源数初始化为1，偶数为0
 * 5.偶数先打印，那就先将偶数信号量的资源数初始化为1，奇数位0
 */
public class PrintNumberUsingSemaphore {

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
    public void isOddOrEven(int number) {
        if ((number & 1) == 1) {
            print(number, semaphoreOdd, semaphoreEven);
        } else {
            print(number, semaphoreEven, semaphoreOdd);
        }
    }


    /**
     * 打印方法
     *
     * @param number           需要打印的number
     * @param currentSemaphore 当前的信号量
     * @param nextSemaphore    下一个要执行的信号量
     */
    private void print(int number, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        try {
            currentSemaphore.acquire();
            System.out.println(number);
            nextSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintNumberUsingSemaphore printNumberUsingSemaphore = new PrintNumberUsingSemaphore();
        for (int i = 1; i <= 10; i++) {
            final int number = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    printNumberUsingSemaphore.isOddOrEven(number);
                }
            }).start();
        }
    }
}

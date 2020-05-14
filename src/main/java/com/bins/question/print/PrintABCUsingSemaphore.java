package com.bins.question.print;

import java.util.concurrent.Semaphore;

/**
 * @author leo-bin
 * @date 2020/3/1 22:26
 * @apiNote 题目要求：
 * 三个线程分别打印A，B，C，要求这三个线程一起运行，打印n次，输出形如“ABCABCABC....”的字符串。
 * <p>
 * 思路：
 * 1.可以使用信号量（Semaphore）解决问题
 * 2.分别设置三个信号量A,B,C
 * 3.A信号量的初始资源数设置为1，其他都设置为0
 * 4.分别启动三个线程，每一线程只需要获取当前信号量，然后结束之后释放下一个信号量就行
 * 5.这样就能保证一个绝对的执行顺序
 */
public class PrintABCUsingSemaphore {

    /**
     * 期望打印次数
     */
    private int times;

    /**
     * 信号量A，初始的共享资源的数量为1
     */
    private Semaphore semaphoreA = new Semaphore(1);

    /**
     * 信号量B，初始的共享的资源数量为0
     */
    private Semaphore semaphoreB = new Semaphore(0);

    /**
     * 信号量C，初始的共享的资源数量为0
     */
    private Semaphore semaphoreC = new Semaphore(0);

    /**
     * 初始化每一个线程的打印次数
     *
     * @param times 次数
     */
    public PrintABCUsingSemaphore(int times) {
        this.times = times;
    }


    /**
     * 打印A
     */
    public void printA() {
        print("A", semaphoreA, semaphoreB);
    }

    /**
     * 打印B
     */
    public void printB() {
        print("B", semaphoreB, semaphoreC);
    }

    /**
     * 打印C
     */
    public void printC() {
        print("C", semaphoreC, semaphoreA);
    }

    /**
     * 打印方法
     */
    private void print(String name, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        try {
            for (int i = 0; i < times; i++) {
                //尝试去判断当前信号量中的资源数,只要资源数不等于0，当前线程继续执行，否则，当前线程阻塞
                currentSemaphore.acquire();
                System.out.println(name);
                //当前线程执行完毕，将顺序的下一个信号量的资源数+1
                nextSemaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试入口
     */
    public static void main(String[] args) {
        PrintABCUsingSemaphore printABCUsingSemaphore = new PrintABCUsingSemaphore(5);
        //启动线程1
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABCUsingSemaphore.printA();
            }
        }).start();

        //启动线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABCUsingSemaphore.printB();
            }
        }).start();

        //启动线程3
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABCUsingSemaphore.printC();
            }
        }).start();
    }
}

package com.bins.question.print;

import java.util.concurrent.Semaphore;

/**
 * @author leo-bin
 * @date 2020/3/1 22:26
 * @apiNote 题目要求：
 * 1.三个线程分别打印A，B，C
 * 2.要求这三个线程一起运行，打印n次
 * 3.输出形如“ABCABCABC....”的字符串。
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
     */
    public PrintABCUsingSemaphore(int times) {
        this.times = times;
    }


    /**
     * 根据传过来的值决定打印顺序
     */
    public void printABC(String content) {
        if ("A".equals(content)) {
            print(content, semaphoreA, semaphoreB);
        }
        if ("B".equals(content)) {
            print(content, semaphoreB, semaphoreC);
        }
        if ("C".equals(content)) {
            print(content, semaphoreC, semaphoreA);
        }
    }


    /**
     * 打印方法
     */
    private void print(String content, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        try {
            //开启循环打印
            for (int i = 0; i < times; i++) {
                //尝试获取信号量中的资源数,当资源数不为0，当前线程继续执行，否则，当前线程阻塞，一旦拿到资源，原始的资源数-1
                currentSemaphore.acquire();
                System.out.println(content);
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
        PrintABCUsingSemaphore printABCUsingSemaphore = new PrintABCUsingSemaphore(3);
        //启动线程1
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABCUsingSemaphore.printABC("A");
            }
        }).start();

        //启动线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABCUsingSemaphore.printABC("B");
            }
        }).start();

        //启动线程3
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABCUsingSemaphore.printABC("C");
            }
        }).start();
    }
}

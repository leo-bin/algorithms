package com.bins.javabasic.thread;

/**
 * @author leo-bin
 * @date 2020/2/19 14:56
 * @apiNote
 */
public class MyThread implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(1L);
            System.out.println(Thread.currentThread().getName() + "is Running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

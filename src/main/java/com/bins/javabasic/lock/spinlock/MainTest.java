package com.bins.javabasic.lock.spinlock;

/**
 * @author leo-bin
 * @date 2020/2/13 9:44
 * @apiNote 测试入口
 */
public class MainTest {

    /**
     * 测试入口
     *
     * @param args
     */
    public static void main(String[] args) {
        SpinLock1 spinLock1 = new SpinLock1();
        //线程A
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //先拿到锁
                spinLock1.lock();
                System.out.println(Thread.currentThread().getName() + "线程正在运行");
                System.out.println(Thread.currentThread().getName() + "已经拿到锁了");
                //休眠,等待其他线程抢占本线程的资源
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //释放锁
                spinLock1.unlock();
            }
        });
        //线程B
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                spinLock1.lock();
                System.out.println(Thread.currentThread().getName() + "线程正在运行");
                System.out.println(Thread.currentThread().getName() + "已经拿到锁了");
                //休眠,等待其他线程抢占本线程的资源
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spinLock1.unlock();

            }
        });
        //线程C
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                spinLock1.lock();
                System.out.println(Thread.currentThread().getName() + "线程正在运行");
                System.out.println(Thread.currentThread().getName() + "已经拿到锁了");
                //休眠,等待其他线程抢占本线程的资源
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spinLock1.unlock();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

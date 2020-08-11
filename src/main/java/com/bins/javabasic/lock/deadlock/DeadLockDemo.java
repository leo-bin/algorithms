package com.bins.javabasic.lock.deadlock;

/**
 * @author leo-bin
 * @date 2020/8/11 11:05
 * @apiNote 死锁案例：
 * 1.通过设置两个公共资源A和B并同时开启两个线程1和2
 * 2.先保证线程A首先拿到资源A，然后线程等待一下B，大概2s左右，然后才去尝试获取资源B
 * 3.等到线程2首先拿到了资源B的时候，线程1这个时候估计也醒了，线程2也去拿资源A
 * 4.这个时候两个线程就会陷入一个死锁的情况，都想要拿到对方的资源，但是对方的资源都无法被释放。
 * 5.如何解决呢？
 */
public class DeadLockDemo implements Runnable {

    private final String lockA;
    private final String lockB;

    public DeadLockDemo(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "已经持有：" + lockA + "正在尝试获取：" + lockB);
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "已经持有：" + lockA + "和" + lockB);
            }
        }
    }

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        //开启线程1，首先去锁A，然后尝试获取B
        new Thread(new DeadLockDemo(lockA, lockB)).start();

        //开启线程2，首先去锁B，然后尝试获取A
        new Thread(new DeadLockDemo(lockB, lockA)).start();
    }
}

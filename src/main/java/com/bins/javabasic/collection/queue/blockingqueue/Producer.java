package com.bins.javabasic.collection.queue.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leo-bin
 * @date 2020/2/5 16:12
 * @apiNote 生产者
 */
public class Producer implements Runnable{

    private BlockingQueue<DataBean> queue;

    /**
     * 原子数
     */
    private static AtomicInteger integer = new AtomicInteger(0);


    private Random random=new Random();

    public Producer(BlockingQueue<DataBean> queue) {
        this.queue = queue;
    }

    /**
     * 模拟生产者生产消息
     */
    private void produce(){
            //实际情况可能比较复杂，所以这里模拟数据耗时，随机等待一段时间
            try {
                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //等待队列超时时间
            final long timeout=2000L;
            //初始化消息
            DataBean dataBean=new DataBean(String.valueOf(integer.getAndIncrement()));
            try{
                //offer方法为，向队列中插入一个对象，如果在插入的过程中等待的时间超过timeout，则返回false，没有超时返回true
                if (!queue.offer(dataBean,timeout, TimeUnit.MILLISECONDS)){
                    System.out.println("等待队列时间超时了,超时时间为:"+timeout+"毫秒");
                }
                System.out.println("------成功生产了一条数据:"+dataBean.getMessage());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
    }

    /**
     * 启动本线程
     */
    @Override
    public void run() {
        while (true){
            produce();
        }
    }
}

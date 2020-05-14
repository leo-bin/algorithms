package com.bins.javabasic.collection.queue.blockingqueue;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author leo-bin
 * @date 2020/2/5 16:12
 * @apiNote 消费者
 */
public class Consumer implements Runnable{

    private BlockingQueue<DataBean> queue;

    public Consumer(BlockingQueue<DataBean> queue) {
        this.queue = queue;
    }

    private Random random=new Random();

    /**
     * 模拟消费者行为进行消费
     *
     * take源码：
     * public E take() throws InterruptedException {
     *  final ReentrantLock lock = this.lock;
     *  lock.lockInterruptibly();
     *   try {
     *   while (count == 0)
     *   //如果队列中没有元素，该线程一直处于阻塞状态
     *   notEmpty.await();
     *   return dequeue();
     *   } finally {
     *    lock.unlock();
     *    }
     *  }
     */
    private void consume(){
        //超时时间
        final long timeout=500L;
        try {
            //take方法，去队列中拿一条队首数据，如果此时队列中没有数据的话，当前线程会被阻塞，直到队列中有数据
            //查看take的源码发现，内部使用可重入式锁来实现：
            /*DataBean dataBean=queue.take();*/

            //这里使用poll方法，如果超过等待时间，返回null，没超过返回队列中的一条队首数据
            //这里设置为500毫秒，因为如果不设置的话，一旦队列中产生了第一条数据，，生产者还来不及处理业务就会立马被消费者拿到，产生逻辑错误
            DataBean dataBean=queue.poll(500L, TimeUnit.MILLISECONDS);
            if (dataBean!=null){
                System.out.println("------数据"+dataBean.getMessage()+"成功被消费");
            }
            }catch (InterruptedException e){
             e.printStackTrace();
            }
        //模拟数据消耗
        try{
            Thread.sleep(random.nextInt(1000));
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
            consume();
        }
    }
}

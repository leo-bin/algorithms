package com.bins.javabasic.collection.queue.delayqueue;

import cn.hutool.core.lang.TypeReference;
import com.alibaba.fastjson.JSON;
import com.bins.util.JedisUtil;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.UUID;

/**
 * @author leo-bin
 * @date 2020/5/22 18:19
 * @apiNote 使用redis来实现一个延迟队列
 */
public class RedisDelayingQueue<T> {

    /**
     * 任务体
     *
     * @param <T>
     */
    static class TaskItem<T> {
        public String id;
        public T msg;
    }

    /**
     * 序列化模板
     */
    private Type TaskType = new TypeReference<TaskItem<T>>() {
    }.getType();


    /**
     * 生产者jedis实例
     */
    private Jedis jedisForProducer;
    /**
     * 消费者jedis实例
     */
    private Jedis jedisForConsumer;
    private String queueName;

    public RedisDelayingQueue(Jedis jedisForProducer, Jedis jedisForConsumer, String queueName) {
        this.jedisForProducer = jedisForProducer;
        this.jedisForConsumer = jedisForConsumer;
        this.queueName = queueName;
    }


    /**
     * 将消息加入延时队列
     *
     * @param msg 消息
     */
    public void delay(T msg) {
        TaskItem<T> task = new TaskItem<>();
        task.id = UUID.randomUUID().toString();
        task.msg = msg;
        //将消息序列化
        String json = JSON.toJSONString(task);
        //加入延时队列，并设置5s的间隔时间
        jedisForProducer.zadd(queueName, System.currentTimeMillis() + 5000, json);
    }


    /**
     * 消费者
     */
    public void loop() {
        while (!Thread.interrupted()) {
            //
            Set<String> values = jedisForConsumer.zrangeByScore(queueName, 0, System.currentTimeMillis()
                    , 0, 1);
            if (values.isEmpty()) {
                try {
                    //如果没拿到消息那就先睡一会
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            //拿到了
            String s = values.iterator().next();
            //如果抢到了的话,开始反序列化
            if (jedisForConsumer.zrem(queueName, s) > 0) {
                TaskItem<T> task = JSON.parseObject(s, TaskType);
                //消费消息
                this.handleMsg(task.msg);
            }
        }
    }


    /**
     * 处理消息（这里简单写成打印）
     *
     * @param msg 消息
     */
    public void handleMsg(T msg) {
        System.out.println(msg + "被处理完毕");
    }


    public static void main(String[] args) {
        int n = 50;
        //考虑到jedis并不是线程安全的，所以在这种多线程的情况下我们使用创建两个jedis实例
        Jedis jedis1 = JedisUtil.getInstance();
        Jedis jedis2 = JedisUtil.getInstance();
        RedisDelayingQueue<String> delayingQueue = new RedisDelayingQueue<>(jedis1, jedis2, "my-delay-queue");

        //生产者线程
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    delayingQueue.delay("消息" + i);
                }
            }
        };

        //消费者线程
        Thread consumer = new Thread() {
            @Override
            public void run() {
                delayingQueue.loop();
            }
        };

        //全部启动
        producer.start();
        consumer.start();

        //控制执行流程
        try {
            producer.join();
            Thread.sleep(6000L);
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            jedis1.close();
            jedis2.close();
        }
    }
}

package com.bins.javabasic.collection.queue.blockingqueue;

/**
 * @author leo-bin
 * @date 2020/2/5 16:00
 * @apiNote 模拟队列中的数据的对象
 */
public class DataBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "message='" + message + '\'' +
                '}';
    }
}

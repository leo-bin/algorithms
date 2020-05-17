package com.bins.algorithm.idgenerator;

import java.util.UUID;

/**
 * @author leo-bin
 * @date 2020/5/17 17:57
 * @apiNote 使用UUID生成全局唯一id
 */
public class MyUUID {


    /**
     * 使用UUID随机生成全局唯一id
     *
     * @apiNote 思路：
     * 1.直接使用api生成
     */
    public static synchronized String getNextId() {
        return UUID.randomUUID().toString();
    }


    public static void main(String[] args) {
        int n = 1000;
        for (int i = 0; i < n; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(getNextId());
                }
            }).start();
        }
    }

}

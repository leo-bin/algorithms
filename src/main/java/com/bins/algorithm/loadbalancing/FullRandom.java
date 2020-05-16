package com.bins.algorithm.loadbalancing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author leo-bin
 * @date 2020/5/14 20:28
 * @apiNote 负载均衡算法之——完全随机法
 */
public class FullRandom {

    /**
     * 初始化
     */
    private static List<String> serverList = new ArrayList<>();
    private static Random random = new Random();


    /**
     * 初始化服务器ip地址
     */
    private static void init() {
        String ip = "192.168.1.";
        for (int i = 1; i <= 10; i++) {
            serverList.add(ip + i);
        }
    }


    /**
     * 完全随机算法
     *
     * @apiNote 思路：
     * 1.完全随机，顾名思义，从列表中随便选一个就行
     * 2.这里使用Random方法来生成随机数
     */
    private static String fullRandom() {
        int serverNumber = random.nextInt(serverList.size());
        return serverList.get(serverNumber);
    }


    public static void main(String[] args) {
        int n = 20;
        init();
        for (int i = 1; i <= n; i++) {
            System.out.println("第" + i + "次负载到服务器地址：" + fullRandom());
        }
    }
}

package com.bins.algorithm.loadbalancing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/5/14 22:38
 * @apiNote 负载均衡算法之哈希算法
 */
public class HashRandom {

    /**
     * 服务器列表
     */
    private static List<String> serverList = new ArrayList<>();

    private static void init() {
        String prefix = "192.168.1.";
        for (int i = 1; i <= 5; i++) {
            serverList.add(prefix + i);
        }
    }


    /**
     * 普通hash算法
     *
     * @apiNote 思路：
     * 1.hash随机算法，根据传过来的某个唯一id进行hash算法
     * 2.将得到的结果和服务器数量进行取模运算
     * 3.得到的结果一定是0-服务器数量
     * 4.但是这样也和随机算法没什么区别，无法定制请求的走向
     */
    private static String hashRandom(String sessionId) {
        int serverNumber = Math.abs(sessionId.hashCode()) % serverList.size();
        return serverList.get(serverNumber);
    }


    public static void main(String[] args) {
        int n = 50;
        init();
        String sessionIDPrefix = "sessionId";
        for (int i = 1; i <= n; i++) {
            System.out.println("第" + i + "次负载到服务器地址：" + hashRandom(sessionIDPrefix + i));
        }
    }
}

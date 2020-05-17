package com.bins.algorithm.loadbalancing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leo-bin
 * @date 2020/5/14 22:37
 * @apiNote 加权轮询算法
 */
public class WeightRound {


    /**
     * 权重map
     */
    private static HashMap<String, Integer> weightMap = new HashMap<>(16);
    /**
     * 轮询次数
     */
    private static int askCount = 0;
    /**
     * 权重之和
     */
    private static int allWeight = 0;

    /**
     * 初始化服务器列表并设置权重
     */
    private static void init() {
        weightMap.put("192.168.1.1", 2);
        weightMap.put("192.168.1.2", 5);
        weightMap.put("192.168.1.3", 9);
        allWeight = weightMap.values().stream().mapToInt(a -> a).sum();
    }


    /**
     * 加权轮询算法
     *
     * @apiNote 思路：
     * 1.这里采用askCount不断++，然后取余的方式来计算区间
     * 2.比如说，askCount从0开始不断+1
     * 3.我们只要求askCount%allWeight的值
     * 4.当askCount=0，1时，它是属于权重为2的服务器
     * 5.当askCount=2,3,4，5，6时，它是属于权重为5的服务器
     * 6.依此类推。。。。
     */
    private static String weightRound() {
        int serverNumber = (askCount++) % allWeight;
        String serverName = "";
        for (Map.Entry entry : weightMap.entrySet()) {
            if ((int) entry.getValue() > serverNumber) {
                serverName = (String) entry.getKey();
                break;
            }
            serverNumber -= (int) entry.getValue();
        }
        return serverName;
    }



    public static void main(String[] args) {
        int n = 20;
        init();
        for (int i = 1; i <= n; i++) {
            System.out.println("第" + i + "次负载到服务器地址：" + weightRound());
        }
    }
}

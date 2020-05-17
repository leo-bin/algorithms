package com.bins.algorithm.loadbalancing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/5/14 22:36
 * @apiNote 负载均衡算法之--轮询算法
 */
public class FullRound {

    private static List<String> serverList = new ArrayList<>();
    private static int askCount = 0;

    /**
     * 生成服务器列表
     */
    private static void init() {
        String prefix = "192.168.1.";
        for (int i = 1; i <= 5; i++) {
            serverList.add(prefix + i);
        }
    }

    /**
     * 轮询算法
     *
     * @apiNote 思路：
     * 1.轮询，顾名思义，就是轮流的请求，轮流来处理
     * 2.这里使用一个askCount作为轮流次数的统计，初始为0
     * 3.每请求一次，askCount+1，askCount同样也代表着服务器列表的编号
     * 4.每次使用askCount去取ip地址
     * 5.可以发现这个算法本质上和完全随机算法差不多，每一台服务器被访问到的概率都是一样的
     * 6.要想实现某个性能比较好的服务器能够被访问的概率增大还是需要加权！
     */
    private static String fullRound() {
        if (askCount == serverList.size()) {
            askCount = 0;
        }
        return serverList.get(askCount++);
    }


    public static void main(String[] args) {
        int n = 20;
        init();
        for (int i = 0; i < n; i++) {
            System.out.println(fullRound());
        }
    }
}

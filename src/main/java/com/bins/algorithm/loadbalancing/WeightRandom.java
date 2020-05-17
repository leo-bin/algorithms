package com.bins.algorithm.loadbalancing;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/5/14 22:35
 * @apiNote 加权随机算法
 */
public class WeightRandom {

    /**
     * 初始化服务器配置
     */
    private static List<String> serverList = new ArrayList<>();
    private static Random random = new Random();
    private static HashMap<String, Integer> v1Map = new HashMap<>(16);
    private static HashMap<String, Integer> v2Map = new HashMap<>(16);
    private static int allWeight;


    /**
     * 初始化服务器列表，并设置权值（解法一）
     *
     * @apiNote 思路：
     * 1.这里也就是根据所设置的权值来决定列表中相同服务器出现的次数
     * 2.这种算法虽然直观易懂，但是list中存的元素个数取决于权重的大小
     * 3.如果权重很大，那么list中占用的内存岂不是很大？有点浪费空间
     */
    private static void initV1() {
        //设置服务器的权重
        v1Map.put("192.168.1.1", 2);
        v1Map.put("192.168.1.2", 5);
        v1Map.put("192.168.1.3", 9);
        for (Map.Entry entry : v1Map.entrySet()) {
            for (int i = 0; i < (Integer) entry.getValue(); i++) {
                serverList.add((String) entry.getKey());
            }
        }
    }


    /**
     * 加权随机算法
     */
    private static String weightRandomV1() {
        int serverNumber = random.nextInt(serverList.size());
        return serverList.get(serverNumber);
    }


    private static void initV2() {
        //设置服务器的权重
        v2Map.put("192.168.1.1", 2);
        v2Map.put("192.168.1.2", 5);
        v2Map.put("192.168.1.3", 9);
        allWeight = v2Map.values().stream().mapToInt(a -> a).sum();
    }


    /**
     * 解法二，使用区间判断的方法
     *
     * @apiNote 思路：
     * 1.因为权值的意思本质上就是占比
     * 2.所以我们其实可以将各个权值看成不同的区间
     * 3.比如说权值为2它代表的区间就是1-2，占2份
     * 4.权值为5代表的就是3-7，占5份
     * 5.权值为9代表的就是8-16，占9份
     * 6.接下来我只要获取一个从1到16的随机数，判断它是哪个区间的就能够确定服务器的地址了
     */
    private static String weightRandomV2() {
        int serverNumber = random.nextInt(allWeight);
        String server = "";
        for (Map.Entry entry : v2Map.entrySet()) {
            if (serverNumber <= (int) entry.getValue()) {
                server = (String) entry.getKey();
                break;
            }
            serverNumber -= (int) entry.getValue();
        }
        return server;
    }


    public static void main(String[] args) {
        int n = 20;
        initV2();
        for (int i = 1; i <= n; i++) {
            System.out.println("第" + i + "次负载到服务器地址：" + weightRandomV2());
        }
    }
}

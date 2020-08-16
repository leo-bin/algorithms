package com.bins.bishi.autumn2020.laohu;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/8/16 16:23
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.给定长度为N的字符串，要求按照字符出现的频率从高到低打印出来
     * 2.要求时间复杂度O(N)
     * <p>
     * 举例：
     * 输入： traeeaaa
     * 输出：aaaaeetr 或者 aaaeert
     * <p>
     * 示例1
     * 输入
     * "taeeaaa"
     * <p>
     * 输出
     * "aaaaeet"
     *
     * @apiNote 思路：
     * 1.先使用优先级队列试一下
     * 2.
     */

    public static class Node {
        private char c;
        private int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }


    public static String code(String s) {
        char[] chs = s.toCharArray();
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        //用HashMap来去重并且记录出现次数：时间复杂度：O(n)
        HashMap<Character, Integer> map = new HashMap<>(16);
        for (char c : chs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //建大顶堆：时间复杂度：O(n)
        for (Map.Entry entry : map.entrySet()) {
            maxHeap.add(new Node((char) entry.getKey(), (int) entry.getValue()));
        }
        //输出结果:O(n*log(n))
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < map.size(); i++) {
            Node node = maxHeap.poll();
            int j = node.count;
            while (j-- > 0) {
                result.append(node.c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "taeeaaa";
        String result = code(s);
        System.out.println(result);
    }
}

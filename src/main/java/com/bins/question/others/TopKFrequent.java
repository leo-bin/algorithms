package com.bins.question.others;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/8/7 10:06
 * @apiNote 前K个高频元素
 * 来源：leetcode-347
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {


    public static class Node {
        /**
         * 元素本身
         */
        private int element;
        /**
         * 元素出现次数
         */
        private int count;

        public Node(int element, int count) {
            this.element = element;
            this.count = count;
        }
    }

    /**
     * 题目描述：
     * 1.给定一个非空的整数数组
     * 2.返回其中出现频率前 k 高的元素
     * <p>
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * <p>
     * 示例 2:
     * 输入: nums = [1], k = 1
     * 输出: [1]
     * <p>
     * 提示：
     * 1.你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 2.你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 3.题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 4.你可以按任意顺序返回答案
     *
     * @apiNote 思路：
     * 1.大顶堆+Hash
     * 2.首先构建一个大顶堆的时间复杂度是O(n)
     * 3.一次调整的时间复杂度是：O(log(n))
     * 4.使用hash表来统计元素出现次数的时间复杂度O(n)
     * 5.总体时间复杂度：O(n)
     * 6.空间复杂度：O(n)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        //大顶堆，根据元素出现次数排序
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        HashMap<Integer, Integer> map = new HashMap<>(16);

        //先统计元素出现频率
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //元素和出现频率封装成Node存入大顶堆
        for (Map.Entry entry : map.entrySet()) {
            maxHeap.add(new Node((int) entry.getKey(), (int) entry.getValue()));
        }

        //依次拿出前k个元素
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Node top = maxHeap.poll();
            if (top != null) {
                result[i] = top.element;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}

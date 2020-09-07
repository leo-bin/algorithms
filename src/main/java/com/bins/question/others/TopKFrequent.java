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
     * 1.小顶堆+Hash
     * 2.首先构建一个大顶堆的时间复杂度是O(n)
     * 3.一次调整的时间复杂度是：O(log(n))
     * 4.使用hash表来统计元素出现次数的时间复杂度O(n)
     * 5.总体时间复杂度：O(n*log(k))
     * 6.空间复杂度：O(n)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        //小顶堆，根据元素出现次数排序
        PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
        HashMap<Integer, Integer> map = new HashMap<>(16);

        //先统计元素出现频率
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //元素和出现频率封装成Node存入小顶堆
        for (Map.Entry entry : map.entrySet()) {
            Node node = new Node((int) entry.getKey(), (int) entry.getValue());
            if (minHeap.size() < k) {
                minHeap.add(node);
            } else if (node.count > minHeap.peek().count) {
                minHeap.poll();
                minHeap.add(node);
            }
        }

        //依次拿出前k个元素
        int index = 0;
        int[] result = new int[k];
        for (Node node : minHeap) {
            result[index++] = node.element;
        }
        return result;
    }

    /**
     * 解法二，基于快速排序的思想
     *
     * @apiNote 思路：
     * 1.因为快排每次都能找到一个枢轴将原数组进行切分
     * 2.假设刚好找到的枢轴就等于k，那说明后面的k个元素
     */
    public static int[] topKFrequentV2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        //统计频率
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //封装成node数组
        int i = 0;
        Node[] nodes = new Node[map.size()];
        for (Map.Entry entry : map.entrySet()) {
            nodes[i++] = new Node((int) entry.getKey(), (int) entry.getValue());
        }
        //进行快排分治
        quickSort(nodes, 0, nodes.length - 1, k - 1);
        //取前k个元素作为结果
        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            result[j] = nodes[j].element;
        }
        return result;
    }

    /**
     * 快排的变形
     */
    public static void quickSort(Node[] nodes, int left, int right, int index) {
        //递归结束条件
        if (left > right) {
            return;
        }
        int midIndex = partition(nodes, left, right);
        //第k个元素就是枢轴直接返回
        if (midIndex == index) {
            return;
        }
        //根据index的位置来确定接下来从哪一边找
        if (midIndex > index) {
            quickSort(nodes, left, midIndex - 1, index);
        } else {
            quickSort(nodes, midIndex + 1, right, index);
        }
    }


    /**
     * 分治求枢轴，这里的枢轴代表左边都要大于自己，右边都要小于自己
     */
    public static int partition(Node[] nodes, int left, int right) {
        int midIndex = left;
        Node midValue = nodes[midIndex];
        while (left != right) {
            while (left < right && nodes[right].count < midValue.count) {
                right--;
            }
            while (left < right && nodes[left].count >= midValue.count) {
                left++;
            }
            if (left < right) {
                //交换
                Node t = nodes[left];
                nodes[left] = nodes[right];
                nodes[right] = t;
            }
        }
        //枢轴元素就位
        nodes[midIndex] = nodes[left];
        nodes[left] = midValue;
        //返回枢轴
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        int[] result1 = topKFrequentV2(nums, k);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
    }
}

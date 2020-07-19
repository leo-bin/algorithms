package com.bins.question.others;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/4/20 18:15
 * @apiNote 滑动窗口的最大值
 * 来源：leetcode-239
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class MaxInWindows {

    /**
     * 题目描述：
     * 1.给定一个数组 nums
     * 2.有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧
     * 3.你只可以看到在滑动窗口内的 k 个数字
     * 4.滑动窗口每次只向右移动一位
     * 5.返回滑动窗口中的最大值
     * <p>
     * 进阶：
     * 你能在线性时间复杂度内解决此题吗？
     * <p>
     * 示例:
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7      3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     *
     * @apiNote 思路：
     * 1.使用一个优先级队列存放每一个滑动窗口（大顶堆）
     * 2.这个时候的队头一定是最大值
     * 3.我们按照顺序以第一组滑动窗口的数据集构造一个大顶堆
     * 4.然后按顺序一个一个的往队列中加元素
     * 5.每加一次，先将堆顶元素存list，然后剔除掉队列中过期的元素，然后再加一个元素进去
     * 6.时间复杂度：O(n*k)(k为滑动窗口的数量)(在leetcode测试中超时了。。。)
     * 7.空间复杂度：O(n)
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        //构造一个大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int count = 0;
        //构造第一组滑动窗口
        for (; count < k; count++) {
            maxHeap.add(nums[count]);
        }
        //根据调整大顶堆来得到每一个滑动窗口的最大值(也就是堆顶值)
        int index = 0;
        while (index < result.length && count < nums.length) {
            //取堆顶值
            result[index++] = maxHeap.peek();
            //删掉当前窗口的第一个值
            maxHeap.remove(nums[count - k]);
            //更新下一个窗口
            maxHeap.add(nums[count++]);
        }
        //求最后一个窗口的最大值
        result[index] = maxHeap.peek();
        return result;
    }

    /**
     * 单调队列
     *
     * @apiNote 思路：
     * 1.
     */
    public static int[] maxSlidingWindowV2(int[] nums, int k) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        // 滑动窗口，注意：保存的是索引值
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            //新进来的数比队列里已经存在的数还要大那就删掉存在的数
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.add(i);
            // 当元素从左边界滑出的时候，如果它恰恰好是滑动窗口的最大值
            if (i - k == queue.peekFirst()) {
                queue.pollFirst();
            }
            // 队首一定是滑动窗口的最大值的索引
            if (i >= k - 1) {
                res.add(nums[queue.peekFirst()]);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        int[] result = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }
}

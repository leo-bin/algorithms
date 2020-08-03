package com.bins.question.array;

import java.util.Arrays;
import java.util.Random;

/**
 * @author leo-bin
 * @date 2020/8/3 12:30
 * @apiNote 洗牌算法
 * 来源：leetcode-384
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array/solution/
 */
public class ShuffleCards {

    private int[] nums;
    private int[] original;
    private Random random = new Random();

    public ShuffleCards(int[] nums) {
        this.nums = nums;
        this.original = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        nums = Arrays.copyOf(original, original.length);
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int randomIndex = getRandom(i, nums.length);
            swap(i, randomIndex);
        }
        return nums;
    }

    /**
     * 获取min-max之间的一个随机值
     */
    public int getRandom(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    /**
     * 题目描述：
     * 1.打乱一个没有重复元素的数组
     * <p>
     * 示例:
     * 1.以数字集合 1, 2 和 3 初始化数组。
     * int[] nums = {1,2,3};
     * Solution solution = new Solution(nums);
     * <p>
     * 2.打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
     * solution.shuffle();
     * <p>
     * 3.重设数组到它的初始状态[1,2,3]。
     * solution.reset();
     * <p>
     * 4.随机返回数组[1,2,3]打乱后的结果。
     * solution.shuffle();
     *
     * @apiNote 思路：
     * 1.对于洗牌算法，其实怎么设计完全就取决于最后得到的结果的可能性
     * 2.我们必须要求产生的结果可能种数是：n!即可
     * 3.一种做法就是，我们要满足从第一个元素开始，它的可能放的位置就是：n-1
     * 4.第二个元素就是：n-2
     * 5.最后：最后一个元素可能放的位置就是：1
     * 6.总体就是：n*(n-1)*(n-2)*(n-3)...(1)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ShuffleCards shuffleCards = new ShuffleCards(nums);
        int[] ori = shuffleCards.reset();
        System.out.println("洗牌之前的数组是：" + Arrays.toString(ori));
        int[] result = shuffleCards.shuffle();
        System.out.println("一次洗牌之后的数组是：" + Arrays.toString(result));
    }
}

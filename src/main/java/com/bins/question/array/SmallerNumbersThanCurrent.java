package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/10/26 15:49
 * @apiNote 有多少小于当前数字的数字
 * 来源：leetcode-1365
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class SmallerNumbersThanCurrent {

    /**
     * 题目描述：
     * 1.给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目
     * 2.换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i]
     * 3.以数组形式返回答案
     * <p>
     * 示例 1：
     * 输入：nums = [8,1,2,2,3]
     * 输出：[4,0,1,1,3]
     * 解释：
     * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）
     * 对于 nums[1]=1 不存在比它小的数字。
     * 对于 nums[2]=2 存在一个比它小的数字：（1）
     * 对于 nums[3]=2 存在一个比它小的数字：（1）
     * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）
     * <p>
     * 示例 2：
     * 输入：nums = [6,5,4,8]
     * 输出：[2,1,0,3]
     * <p>
     * 示例 3：
     * 输入：nums = [7,7,7,7]
     * 输出：[0,0,0,0]
     * <p>
     * 提示：
     * 2 <= nums.length <= 500
     * 0 <= nums[i] <= 100
     *
     * @apiNote 思路：
     * 1.暴力可以很简单的解决，但是时间太爆炸了，而且比较容易实现，这里就不写了
     * 2.自己想到了一种快排的方式，通过存储元素位置和元素本身，并通过比较元素进行一次快排
     * 3.之后统计下在自己位置之前的元素有多少个就行，这个也不写了，快排可以通过Arrays.sort实现
     * 4.这里参考了官方题解中的一种以空间换时间的解法
     * 5.通过仔细观察题目可以发现本次测试用例的数据有限制，元素是在0-100之间
     * 6.所以我们索性用一个大小为 101的数组来当作hash表存储每一个元素出现次数
     * 7.之后通过从前往后遍历的方式，累加自己前面的元素个数以及自己的元素个数
     * 8.最后根据原数组的顺序统计下每一个元素的出现次数即可
     * 9.时间复杂度：O(n)
     * 10.空间复杂度：O(1)
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int n : nums) {
            count[n]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] != 0 ? count[nums[i] - 1] : 0;
        }
        return nums;
    }



    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] result = smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(result));
    }
}

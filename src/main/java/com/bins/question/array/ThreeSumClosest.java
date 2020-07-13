package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/6/24 9:52
 * @apiNote 最接近的三数之和
 * 来源：leetcode-16
 * 链接：https://leetcode-cn.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    /**
     * 题目描述：
     * 1.给定一个包括 n 个整数的数组 nums 和 一个目标值 target
     * 2.找出nums中的三个整数，使得它们的和与target最接近
     * 3.返回这三个数的和。假定每组输入只存在唯一答案
     * <p>
     * 示例：
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
     * <p>
     * 提示：
     * 3 <= nums.length <= 10^3
     * -10^3 <= nums[i] <= 10^3
     * -10^4 <= target <= 10^4
     *
     * @apiNote 思路：
     * 1.数学+双指针
     * 2.这个题目我们依旧可以利用三数之和的思想去写
     * 3.也就是求a+b+c=target，我们只需要求b+c=(target-a),假设x=(target-a)
     * 4.a我们可以利用一次遍历每次都确定一个a
     * 5.接下来使用双指针i和j分别指向a之后的区间的头和尾，当然前提是提前排序了
     * 6.之前的三数之和题中我们是求是否等于，现在我们要求min(|(b+c)-x|)，也就是(b+c)-x的绝对值的最小值！
     * 7.只有满足了相减之后的绝对值是最小值，那么此时的a+b+c一定是最接近target的答案！
     * 8.时间复杂度：O(n*log(n))
     * 9.空间复杂度：O(1)
     */
    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int abs = Integer.MAX_VALUE;
        int curAbs;
        int curSum;
        //提前排序
        Arrays.sort(nums);
        //开始双指针遍历
        for (int index = 0; index < nums.length; index++) {
            int x = target - nums[index];
            //重新更新i，j指针
            int i = index + 1, j = nums.length - 1;
            while (i < j && i < nums.length && j >= 0) {
                curAbs = Math.abs((nums[i] + nums[j]) - x);
                curSum = nums[index] + nums[i] + nums[j];
                if (curAbs == 0) {
                    return curSum;
                }
                //更新最小绝对值
                if (curAbs <= abs) {
                    abs = curAbs;
                    sum = curSum;
                }
                //决定是i往右移还是j往左移
                if (curSum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println(threeSumClosest(nums1, target1));


        int[] nums2 = {1, 1, -1, -1, 3};
        int target2 = -1;
        System.out.println(threeSumClosest(nums2, target2));
    }
}

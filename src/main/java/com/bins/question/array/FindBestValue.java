package com.bins.question.array;


/**
 * @author leo-bin
 * @date 2020/6/14 9:25
 * @apiNote 转变数组后最接近目标值的数组和
 * 来源：leetcode-1300
 * 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
 */
public class FindBestValue {

    /**
     * 题目描述：
     * 1.给你一个整数数组 arr 和一个目标值 target,请你返回一个整数 value
     * 2.使得将数组中所有大于value的值变成value后，数组的和最接近 target（最接近表示两者之差的绝对值最小）
     * 3.如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
     * 4.请注意，答案不一定是 arr 中的数字
     * <p>
     * 示例 1：
     * 输入：arr = [4,9,3], target = 10
     * 输出：3
     * 解释：当选择value为3时，数组会变成[3,3,3]，和为9，这是最接近target的方案
     * <p>
     * 示例 2：
     * 输入：arr = [2,3,5], target = 10
     * 输出：5
     * <p>
     * 示例 3：
     * 输入：arr=[60864,25176,27249,21296,20204],target=56803
     * 输出：11361
     * <p>
     * 提示：
     * 1 <= arr.length <= 10^4
     * 1 <= arr[i], target <= 10^5
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.吐槽下，这个mid题比某些hard题都要难。。。只能暴力过了。。。
     * 3.我们直接从平均值开始暴力枚举
     * 4.每一次都将和算出来和上一次的和进行比较，求最小值就行
     * 4.时间复杂度：O(n*target)
     * 5.空间复杂度：O(1)
     */
    public static int findBestValue(int[] arr, int target) {
        int value = 0;
        int min = Integer.MAX_VALUE;
        //从平均数开始枚举
        for (int cur = target / arr.length; cur < target; cur++) {
            int sum = 0;
            //每次都计算sum
            for (int n : arr) {
                sum += Math.min(cur, n);
            }
            //求差值的最小值
            if (Math.abs(sum - target) < min) {
                min = Math.abs(sum - target);
                value = cur;
            } else {
                break;
            }
        }
        return value;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int target = 10;
        System.out.println(findBestValue(arr, target));
    }
}

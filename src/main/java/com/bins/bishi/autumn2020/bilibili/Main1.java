package com.bins.bishi.autumn2020.bilibili;

/**
 * @author leo-bin
 * @date 2020/8/13 18:22
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.给出4个1-10的数字
     * 2.通过加减乘除，得到数字为24就算胜利
     * <p>
     * 示例1
     * 输入
     * [7,2,1,10]
     * <p>
     * 输出
     * true
     * 说明:7*2+1*10
     *
     * @apiNote 思路：
     * 1.直接暴力就是干
     * 2.时间复杂度：O(1)
     * 3.空间复杂度：O(1)
     */
    private static boolean result = false;

    /**
     * 暴力回溯
     */
    public static boolean code(int[] arr) {
        //特判
        if (arr == null || arr.length == 0) {
            return false;
        }
        backtrace(arr, arr[0], 1);
        return result;
    }

    /**
     * 回溯
     */
    public static void backtrace(int[] arr, int currentSum, int index) {
        //递归结束条件
        if (result) {
            return;
        }
        if (index >= arr.length) {
            if (currentSum == 24) {
                result = true;
            }
            return;
        }
        //接着用+ - * /去递归
        backtrace(arr, currentSum + arr[index], index + 1);
        backtrace(arr, currentSum - arr[index], index + 1);
        backtrace(arr, currentSum * arr[index], index + 1);
        //除法单独考虑
        if (arr[index] != 0) {
            backtrace(arr, currentSum / arr[index], index + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 1, 10};
        System.out.println(code(nums));
    }
}

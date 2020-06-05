package com.bins.question.print;


import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/9 18:11
 * @apiNote 把数组排成最小的数
 * 来源：leetcode-面试题45
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class PrintMinNumber {


    /**
     * 题目描述：
     * 1.输入一个正整数数组，把数组里所有数字拼接起来排成一个数
     * 2.打印能拼接出的所有数字中最小的一个
     * 3.例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.时间复杂度：O(n*n)
     * 3.空间复杂度：O(n)
     */
    public static String minNumber(int[] nums) {
        int len = nums.length;
        //鲁棒
        if (len == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                long a = Long.valueOf((nums[i] + "" + nums[j]));
                long b = Long.valueOf((nums[j] + "" + nums[i]));
                //说明需要交换i和j的位置
                if (a > b) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            result.append(nums[i]);
        }
        return result.toString();
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.上面的思路本质上其实就是一个排序的过程
     * 2.但是我们使用了这种O(n*n)的排序思路去做，太慢了，我们可以套用快排的模板去写
     * 3.对于数组:[3,32,321],假设x=3，y=32，要满足拼接之后的字符串的大小是递减的
     * 4.必须满足，x+y>y+x,x和y交换,否则不变
     * 5.时间复杂度：O(n*log(n))
     * 6.空间复杂度：O(n)
     */
    public static String minNumberV2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        StringBuilder result = new StringBuilder();
        quickSort(strs, 0, nums.length - 1);
        for (String s : strs) {
            result.append(s);
        }
        return result.toString();
    }


    /**
     * 快排的变种
     */
    public static void quickSort(String[] strs, int left, int right) {
        //递归结束条件
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        String midValue = strs[left];
        int midIndex = left;
        while (left != right) {
            while (left < right && (strs[right] + midValue).compareTo(midValue + strs[right]) >= 0) {
                right--;
            }
            while (left < right && (strs[left] + midValue).compareTo(midValue + strs[left]) <= 0) {
                left++;
            }
            //交换
            String tmp = strs[left];
            strs[left] = strs[right];
            strs[right] = tmp;
        }
        //移动中轴
        strs[midIndex] = strs[left];
        strs[left] = midValue;
        //对目前中轴的左右分别进行分治
        quickSort(strs, i, left - 1);
        quickSort(strs, left + 1, j);
    }


    /**
     * 解法三
     *
     * @apiNote 思路：
     * 1.既然直到可以套用排序模板的话，这里有一种更加简洁的写法
     * 2.那就是利用Arrays.sort这个jdk内置的排序api并重写比较器来实现
     * 3.时间复杂度：O(n*log(n))
     * 4.空间复杂度：O(n)
     */
    public static String minNumberV3(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> ((x + y).compareTo(y + x)));
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        int[] numbers1 = {27, 100, 5};
        System.out.println(minNumber(numbers));
        System.out.println(minNumber(numbers1));

        System.out.println(minNumberV2(numbers));
        System.out.println(minNumberV2(numbers1));


        System.out.println(minNumberV3(numbers));
        System.out.println(minNumberV3(numbers1));
    }
}

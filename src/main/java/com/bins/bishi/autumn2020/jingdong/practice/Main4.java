package com.bins.bishi.autumn2020.jingdong.practice;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/8/6 10:49
 * @apiNote
 */
public class Main4 {

    /**
     * 题目描述：
     * 1.东东在一本古籍上看到有一种神奇数
     * 2.如果能够将一个数的数字分成两组,其中一组数字的和等于另一组数字的和,我们就将这个数称为神奇数
     * 3.例如242就是一个神奇数
     * 4.我们能够将这个数的数字分成两组,分别是{2,2}以及{4},而且这两组数的和都是4
     * 5.东东现在需要统计给定区间中有多少个神奇数
     * 6.即给定区间[l, r],统计这个区间中有多少个神奇数,请你来帮助他
     * <p>
     * 输入描述:
     * 输入包括一行,一行中两个整数l和r(1 ≤ l, r ≤ 10^9, 0 ≤ r - l ≤ 10^6),以空格分割
     * <p>
     * 输出描述:
     * 输出一个整数,即区间内的神奇数个数
     * <p>
     * 示例1
     * 输入
     * 1 50
     * <p>
     * 输出
     * 4
     *
     * @apiNote 思路：
     * 1.有的时候发现没思路了，一定要从暴力的角度入手
     * 2.我就是有个习惯，不会直接尝试用暴力，因为我总是觉得暴力会超时
     * 3.但是有时候你会发现，暴力效率也可以很高，而且通过不断的优化暴力
     * 4.可能这就是一个最优解法了
     * 5.能写出一个精妙的暴力算法也是一种能力
     * 6.这里思路很简单，通过回溯一个一个数去排列组合去判断就行
     * 7.时间复杂度就不给了，起码也是n*n*n
     * 8.虽然超时了，但是没关系，好歹过了部分测试用例
     */
    public static boolean code1(int n) {
        int sum = 0;
        int target;
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            sum += n % 10;
            n = n / 10;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        target = sum / 2;
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] flag = new boolean[list.size()];
        return backtrace(target, list, track, flag);
    }

    /**
     * 回溯
     */
    public static boolean backtrace(int target, List<Integer> list, LinkedList<Integer> track, boolean[] flag) {
        //递归结束条件
        if (track.size() > list.size()) {
            return false;
        }
        if (check(track, target)) {
            return true;
        }
        //递归分组
        for (int i = 0; i < list.size(); i++) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            track.add(list.get(i));
            if (backtrace(target, list, track, flag)) {
                return true;
            }
            track.removeLast();
            flag[i] = false;
        }
        return false;
    }


    /**
     * 判断是否等于目标值
     */
    public static boolean check(List<Integer> list, int target) {
        return list.stream().reduce(Integer::sum).orElse(0) == target;
    }


    /**
     * 解法二，动态规划
     *
     * @apiNote 思路：
     * 1.既然之前的暴力核心就是判断数组中的每一个元素组成的组合是否等于数组总和的一半
     * 2.其实这里可以转换为一个01背包的问题。
     * 3.就是判断使用数组中的元素能装下的最大值是否等于数组总和的一半
     * 4.
     */
    public static boolean code2(int n) {
        int sum = 0;
        int target;
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            sum += n % 10;
            n = n / 10;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        target = sum / 2;

        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int e : list) {
            //注意这里是从尾到头开始更新
            for (int cur = target; cur >= e; cur--) {
                dp[cur] = Math.max(dp[cur], dp[cur - e] + e);
            }
        }
        return target == dp[target];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (code2(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}

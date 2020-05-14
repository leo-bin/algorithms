package com.bins.question.math;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author leo-bin
 * @date 2020/4/30 9:50
 * @apiNote 快乐数
 * 来源：LeetCode-202
 * 链接：https://leetcode-cn.com/problems/happy-number
 */
public class IsHappy {


    /**
     * 循环集合，任何数字都是会造成一个死循环
     */
    private static HashSet<Integer> cycleSet = new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));


    /**
     * 题目描述：
     * 1.编写一个算法来判断一个数n是不是快乐数
     * 2.快乐数定义为
     * 3.对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和
     * 4.然后重复这个过程直到这个数变为1，也可能是无限循环但始终变不到1
     * 5.如果可以变为 1，那么这个数就是快乐数
     * 6.如果n是快乐数就返回True；不是，则返回False
     * <p>
     * 示例：
     * 输入：19
     * 输出：true
     * 解释：
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     *
     * @apiNote 思路：
     * 1.暴力+记忆数组
     * 2.时间复杂度：O(log(n))
     * 3.空间复杂度：O(log(n))
     */
    public static boolean isHappy(int n) {
        //鲁棒
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            //1.标记已经出现过
            set.add(n);
            //2.计算各个位上的平方和
            n = sum(n);
            //3.判断是否是快乐数
            if (n == 1) {
                return true;
            }
        }
        return false;
    }


    /**
     * 求各个位上的平方和
     */
    public static int sum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }


    /**
     * 解法二，数学+贪心
     *
     * @apiNote 思路：
     * 1.根据找规律可以知道，基本上所有非快乐数都会形成一个环形集合
     * 2.类似于：{4, 16, 37, 58, 89, 145, 42, 20}
     * 3.任何数字的平方和的结果只要等于上面的某个数字，直接判断为false
     * 4.时间复杂度：O(log(n))
     * 5.空间复杂度：O(1)
     */
    public static boolean isHappyV2(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (!cycleSet.contains(n)) {
            cycleSet.add(n);
            n = sum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }


    /**
     * 解法三，快慢指针破成环的问题
     *
     * @apiNote 思路：
     * 1.是快乐数肯定不成环，不是肯定会有环
     * 2.利用快指针先走，慢指针后走
     * 3.迟早有一天快指针会追上慢指针，这个时候就说明有环了
     * 4.时间复杂度：O(log(n))
     * 5.空间复杂度：O(1)
     */
    public static boolean isHappyV3(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int fastPointer = n;
        int slowPointer = n;
        do {
            fastPointer = sum(fastPointer);
            fastPointer = sum(fastPointer);
            slowPointer = sum(slowPointer);
            if (fastPointer == 1 || slowPointer == 1) {
                return true;
            }
        } while (fastPointer != slowPointer);
        return false;
    }


    public static void main(String[] args) {
        int n = 19;
        int n1 = 79;
        System.out.println("//////////////////解法一///////////////////////");
        System.out.println(isHappy(n));
        System.out.println(isHappy(n1));
        System.out.println("//////////////////解法二///////////////////////");
        System.out.println(isHappyV2(n));
        System.out.println(isHappyV2(n1));
        System.out.println("//////////////////解法三///////////////////////");
        System.out.println(isHappyV3(n));
        System.out.println(isHappyV3(n1));
    }

}

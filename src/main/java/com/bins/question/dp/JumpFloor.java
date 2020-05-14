package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/2/19 10:59
 * @apiNote 跳台阶问题
 */
public class JumpFloor {


    /**
     * 题目描述：
     * 跳台阶
     * 1.一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 2.求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * @apiNote 思路：
     * 1.找规律不难发现，这个其实就是一个斐波那契数列
     * 2.但是这里使用迭代的方式求数列，相当于尾递归
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(1)
     */
    public static int jumpFloor1(int target) {
        //鲁棒
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int preN = 2;
        int prePreN = 1;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = preN + prePreN;
            prePreN = preN;
            preN = result;
        }
        return result;
    }


    /**
     * 题目描述:
     * 变态跳台阶
     * 1.一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 2.求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * @apiNote 解法二：
     * 1.找到规律，发现是一个这样的数列：1，2，4，8，16，等比数列，直接找到求和公式F(n)=2^(n-1)
     * 2.使用Math.pow()直接求得n次方
     */
    public static int jumpFloor2(int target) {
        //鲁棒
        if (target <= 0) {
            return 0;
        }
        int result = (int) Math.pow(2, target - 1);
        return result;
    }

    /**
     * 题目描述:
     * 变态跳台阶
     * 1.一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 2.求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * @param target
     * @return
     * @apiNote 解法二：
     * 1.找到规律，发现是一个这样的数列：1，2，4，8，16，等比数列，直接找到求和公式F(n)=2^(n-1)
     * 2.使用递归求解
     * 3.时间复杂度：O(1)
     * 4.空间复杂度：O(n)
     */
    public static int jumpFloor3(int target) {
        //鲁棒
        if (target <= 0) {
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }
        return 2 * jumpFloor3(target - 1);
    }

    /**
     * dp解决
     *
     * @apiNote 思路：
     * 1.使用dp思想，从历史数据中找结果
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static int jumpFloor4(int target) {
        //鲁棒
        if (target <= 0) {
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }
        //dp数组
        int[] dp = new int[target + 1];
        //初始化dp数组
        dp[1] = 1;
        dp[2] = 2;
        //构造dp数组
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        //从历史数据中直接找结果就行
        return dp[target];
    }


    public static void main(String[] args) {
        int target = 5;
        System.out.println("这是普通跳台阶：：：递归解决：第" + target + "阶台阶的跳法有：" + jumpFloor1(target));
        System.out.println("这是普通跳台阶：：：dp解决：：：第" + target + "阶台阶的跳法有：" + jumpFloor4(target));
        System.out.println("这是变态跳台阶：：：api方法解决：：：第" + target + "阶台阶的跳法有：" + jumpFloor2(target));
        System.out.println("这是变态跳台阶：：：递归解决：：：第" + target + "阶台阶的跳法有：" + jumpFloor3(target));
    }
}

package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/6/13 14:23
 * @apiNote 变态跳台阶
 * 来源：牛客剑指offer
 * 链接：https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&&tqId=11162&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 */
public class JumpFloorⅡ {


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


    public static void main(String[] args) {
        int target = 5;
        System.out.println("这是变态跳台阶：：：api方法解决：：：第" + target + "阶台阶的跳法有：" + jumpFloor2(target));
    }

}

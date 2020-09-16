package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/4/27 21:54
 * @apiNote 丑数
 */
public class UglyNumber {

    /**
     * 题目描述：
     * 1.把只包含质因子2、3和5的数称作丑数（Ugly Number）
     * 2.例如6、8都是丑数，但14不是，因为它包含质因子7
     * 3.习惯上我们把1当做是第一个丑数
     * 4.求按从小到大的顺序的第N个丑数
     * 5.一个数是另一个数的因子，其实就是说一个数能不能被另一个数整除
     * 6.比如，n=4，m=2，要判断m是否是n的因子只需要判断n%m==0
     *
     * @apiNote 思路：
     * 1.暴力穷举(超时)
     * 2.时间复杂度：O(n*log(n))
     * 3.空间复杂度：O(1)
     */
    public static int getUglyNumber(int index) {
        //鲁棒
        if (index <= 0) {
            return 0;
        }
        int number = 0;
        int uglyNumber = 0;
        while (uglyNumber < index) {
            number++;
            if (isUglyNumber(number)) {
                uglyNumber++;
            }
        }
        return uglyNumber;
    }


    /**
     * 判断一个数是否是丑数
     *
     * @apiNote 思路：
     * 1.分别和2，3，5取模进行判断
     * 2.最后的结果如果是1的话就是丑数，否则不是
     */
    public static boolean isUglyNumber(int number) {
        //number mod 2
        while (number % 2 == 0) {
            number /= 2;
        }
        //number mod 3
        while (number % 3 == 0) {
            number /= 3;
        }
        //number mod 5
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }


    /**
     * 解法二，dp动态规划
     *
     * @apiNote 思路：
     * 1.因为之前计算了很多非丑数，比较耗时
     * 2.这里我们将所有的丑数按照从小到大的顺序打表保存下
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static int getUglyNumberV2(int index) {
        //鲁棒
        if (index < 7) {
            return index;
        }
        //1.定义dp数组
        int[] dp = new int[index];
        //2.初始化dp
        dp[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        //3.根据状态方程打表
        for (int i = 1; i < index; i++) {
            dp[i] = Math.min(Math.min(dp[t2] * 2, dp[t3] * 3), dp[t5] * 5);
            if (dp[i] == dp[t2] * 2) {
                t2++;
            }
            if (dp[i] == dp[t3] * 3) {
                t3++;
            }
            if (dp[i] == dp[t5] * 5) {
                t5++;
            }
        }
        return dp[index - 1];
    }


    public static void main(String[] args) {

    }
}

package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/4/10 16:33
 * @apiNote 矩形覆盖
 */
public class RecCover {

    /**
     * 题目描述：
     * 1.我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形
     * 2.请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 3.比如n=3时，2*3的矩形块有3种覆盖方法：
     *
     * @apiNote 思路：
     * 1.分析题目的情况
     * 2.找规律得知，当target分别为0，1，2，3，4，5的时候，对应的结果是0，1，2，3，5，8
     * 3.所以得到一个公式为，f(n)=f(n-1)+f(n-2)
     * 4.我们使用dp来解
     * 5.dp[0]=0,dp[1]=1,dp[2]=2
     * 6.dp[i]=dp[i-1]+dp[i-2]
     * 7.时间复杂度：O(n)
     * 8.空间复杂度：O(n)
     */
    public static int recCover(int target) {
        //鲁棒
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }



    public static void main(String[] args) {
        int n = 10;
        for (int target = 0; target < n; target++) {
            System.out.println(recCover(target));
        }
    }
}





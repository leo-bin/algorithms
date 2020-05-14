package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/3/28 11:27
 * @apiNote 砍绳子问题
 */
public class CutRope {


    /**
     * 砍绳子问题（找规律解法）
     * 1.给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1）
     * 2.每段绳子的长度记为k[0],k[1],...,k[m]
     * 3.请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
     * 4.例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
     * <p>
     * 例如：
     * 输入：8
     * 输出：18
     *
     * @apiNote 思路：
     * 1.贪心，直接找规律
     * 2.时间复杂度：O(1)
     * 3.空间复杂度：O(1)
     */
    public static int cutRope(int target) {
        //鲁棒
        if (target == 1) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int sum = 1;
        int result = target / 3;
        int mod = target % 3;
        if (mod == 0) {
            sum *= Math.pow(3, result);
        } else if (mod == 1) {
            sum *= 2 * 2 * Math.pow(3, result - 1);
        } else if (mod > 1) {
            sum *= 2 * Math.pow(3, result);
        }
        return sum;
    }


    /**
     * 砍绳子问题（dp动态规划解法）
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.设dp[i]为当绳子的长度为i的时候，划分之后的各个段的乘积之和的最大值
     * 2.dp[0]=0,dp[1]=1,dp[2]=2,dp[3]
     * 3.状态方程为：dp[i]=Max(dp[i],dp[j]*dp[i-j])
     * 4.时间复杂度：O(n*n)
     * 5.空间复杂度：O(n)
     */
    public static int cutRope2(int target) {
        //鲁棒
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        //1.定义dp数组
        int[] dp = new int[target + 1];
        //2.初始化dp数组
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        //3.根据状态方程打表
        for (int i = 4; i <= target; i++) {
            int tmp = 0;
            for (int j = 1; j <= i / 2; j++) {
                tmp = Math.max(tmp, dp[j] * dp[i - j]);
            }
            dp[i] = tmp;
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int target = 8;
        int target1 = 7;
        int target2 = 6;
        System.out.println("解法一，当绳子的长度为：" + target + "的时候，乘积之和的最大值是：" + cutRope(target));
        System.out.println("解法一，当绳子的长度为：" + target1 + "的时候，乘积之和的最大值是：" + cutRope(target1));
        System.out.println("解法一，当绳子的长度为：" + target2 + "的时候，乘积之和的最大值是：" + cutRope(target2));
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("解法二，当绳子的长度为：" + target + "的时候，乘积之和的最大值是：" + cutRope2(target));
        System.out.println("解法二，当绳子的长度为：" + target1 + "的时候，乘积之和的最大值是：" + cutRope2(target1));
        System.out.println("解法二，当绳子的长度为：" + target2 + "的时候，乘积之和的最大值是：" + cutRope2(target2));
    }
}

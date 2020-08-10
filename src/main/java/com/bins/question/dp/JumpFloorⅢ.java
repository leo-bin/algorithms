package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/5/25 20:24
 * @apiNote 三步问题
 * 来源：leetcode-08.01
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci/
 */
public class JumpFloorⅢ {

    /**
     * 题目描述：
     * 1.三步问题
     * 2.有个小孩正在上楼梯，楼梯有n阶台阶
     * 3.小孩一次可以上1阶、2阶或3阶
     * 4.实现一种方法，计算小孩有多少种上楼梯的方式
     * 5.结果可能很大，你需要对结果模1000000007
     * <p>
     * 示例1:
     * 输入：n = 3
     * 输出：4
     * 说明: 有四种走法
     * <p>
     * 示例2:
     * 输入：n = 5
     * 输出：13
     * <p>
     * 提示:n范围在[1, 1000000]之间
     *
     * @apiNote 思路：
     * 1.dp问题
     * 2.这题很那个跳台阶的问题很像，基本上一样,但是需要注意溢出的问题
     * 3.我们依旧是通过找规律来推出状态转移方程
     * 4.但是这里比较特殊，当n=1，2，3时需要提前计算
     * 5.也就是说，dp[0]=0,dp[1]=1,dp[2]=2,dp[3]=4
     * 6.经过那个跳台阶的问题我们可以很容易的联想到这个状态转移方程
     * 7.dp[i]=dp[i-3]+dp[i-2]+dp[i-1](i从4开始)
     * 8.时间复杂度：O(n)
     * 9.空间复杂度：O(n)
     */
    public static int waysToStep(int n) {
        //鲁棒
        if (n <= 2) {
            return n;
        }
        //1.定义dp数组
        int[] dp = new int[n + 1];
        //2.初始化dp数组
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int mod = 1000000007;
        //3.根据状态方程打表
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 3] + dp[i - 2]) % mod + dp[i - 1]) % mod;
        }
        return dp[n];
    }

    /**
     * 不用数组的做法
     *
     * @apiNote 思路：
     * 1.对于dp问题往往可以对空间复杂度进一步的优化
     * 2.就像这个题目一样，我们只需要找到某个数的前面三个数是多少就可以计算出自己是多少
     * 3.对于dp而已我们使用了一个数组来保存所有的记录
     * 4.但是其实每次计算我们只需要知道三个数是多少，其他的空间都浪费了
     * 5.所以我们使用三个数实时记录下每次的前面三个数就行啦
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(1)
     */
    public static int waysToStepV2(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int a = 1, b = 2, c = 4;
        int mod = 1000000007;
        int d = 0;
        for (int i = 4; i <= n; i++) {
            d = (a + (b + c) % mod) % mod;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }


    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i <= n; i++) {
            System.out.println(waysToStepV2(i));
        }
    }
}

package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/7/15 10:21
 * @apiNote 不同的二叉搜索树
 * 来源：leetcode-96
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class NumsTrees {

    /**
     * 题目描述：
     * 1.给定一个整数 n
     * 2.求以 1 ... n 为节点组成的二叉搜索树有多少种？
     * <p>
     * 示例:
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     * *    1         3     3      2      1
     * *     \       /     /      / \      \
     * *      3     2     1      1   3      2
     * *     /     /       \                 \
     * *    2     1         2                 3
     *
     * @apiNote 思路：
     * 1.这种题一看就是数学题，但是大部分数学题都可以用dp来解释
     * 2.比如我们要知道的是为了满足二叉搜索树的特点，当1作为根节点时
     * 3.此时1的左节点个数为0，右子树的节点个数为n-1
     * 4.同理，当2作为根节点时，它的左子树的节点个数为1，右子数节点个数为n-2
     * 5.所以可以推出，f(i)=G(i-1)*G(n-i),其中i为根节点，n是节点总数，f(i)表示当i作为根节点时所有二叉树的个数
     * 6.假设G(n)表示我们的最终结果，所以G(n)=f(0)+f(1)+f(2)+f(n)
     * 7.这里我们可以用dp来记录之前的值
     * 8.时间复杂度：O(n*n)
     * 9.空间复杂度：O(n)
     */
    public static int numsTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            System.out.println(numsTrees(i));
        }
    }
}

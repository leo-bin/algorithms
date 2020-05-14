package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/3/25 14:57
 * @apiNote 编辑距离
 */
public class MinDistance {


    /**
     * 编辑距离
     * 1.给定两个单词 word1 和 word2
     * 2.计算出将 word1 转换成 word2 所使用的最少操作数
     * 3.你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * 示例:
     * 输入: word1 = "horse", word2 = "ros"
     * 输出: 3
     * 解释:
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     *
     * @apiNote 思路：
     * 1.使用动态规划来解决
     * 2.第一步，先找到dp数组的含义
     * 3.这里我们假设dp[i][j]表示，当word1和word2的长度分别i，j时，从word1转换到word2需要的最小操作数
     * 4.第二步，找到dp数组之间的公式
     * 5.在这里可以有4中情况
     * 6.一，如果比较的字符相等，那么次数和上次一样，不变，也就是dp[i][j]=dp[i-1][j-1]
     * 7.二，不相等，那就替换，替换的情况，dp[i][j]=dp[i-1][j-1]+1(不需要改变原来的长度)
     * 8.三，不相等，那就删除，dp[i][j]=dp[i-1][j]+1,原来的字符串长度-1
     * 9.四，不相等，那增加，dp[i][j]=dp[i][j-1]+1,原来的字符长度+1
     * 10.时间复杂度：O(n*n)
     * 11.空间复杂度：O(n*n)
     */
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //1.创建dp数组
        int[][] dp = new int[len1 + 1][len2 + 1];
        //2.初始化dp数组(当i和j都为0时，这个题目没有任何含义，次数自然就是0)
        dp[0][0] = 0;
        //固定i=0，也就是说word1单词为空，这个时候，word1要想变为word2，只能不断的增加
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        //固定j=0，说明word2是空，word1要想变为word2，只能不断的删除
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        //3.循环填充dp数组(根据题目条件来选择最优操作)
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("单词：" + word1 + "变为单词：" + word2 + ",最少需要" + minDistance(word1, word2) + "次");
    }
}

package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/3/25 20:37
 * @apiNote 字符串匹配，求最少操作次数
 */
public class MinChange {


    /**
     * 字符串匹配，求最少操作次数
     * 1.给你两个字符串str1和str2
     * 2.要求通过最少的操作次数，将str1变成str2
     * 3.只有两种操作，一种是替换字符，一种是字符串内部交换字符
     * 例如：
     * str1=ATTTAA，str2=TTAATT
     * 最少交换次数就是3，通过交换两次+替换一个A来实现
     *
     * @apiNote 思路：
     * 1.使用动态规划
     * 2.设dp[i][j]为当str1和str2的长度分别为i和j的时候，由str1变为str2所需要的最少操作数
     * 3.dp[0][0-j]=0,dp[0-i][0]=0,dp[1][1]=1
     * 4.dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+1
     * 5.时间复杂度：O(n*n)
     * 6.空间复杂度：O(n*n)
     */
    public static int minChange(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 != len2) {
            return 0;
        }
        //1.创建dp数组
        int[][] dp = new int[len1 + 1][len1 + 1];
        //2.初始化dp数组
        for (int i = 0; i < len1; i++) {
            dp[0][i] = 0;
        }
        for (int j = 0; j < len1; j++) {
            dp[j][0] = 0;
        }
        //3.根据题目给出的条件和dp的公式填充dp数组
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        String str1 = "AT";
        String str2 = "TA";

        String str3 = "AAAAA";
        String str4 = "TTTTT";

        String str5 = "ATTTAA";
        String str6 = "TTAATT";

        System.out.println("字符串：" + str1 + "变成字符串：" + str2 + "最少需要操作" + minChange(str1, str2) + "次");
        System.out.println("字符串：" + str3 + "变成字符串：" + str4 + "最少需要操作" + minChange(str3, str4) + "次");
        System.out.println("字符串：" + str5 + "变成字符串：" + str6 + "最少需要操作" + minChange(str5, str6) + "次");
    }
}

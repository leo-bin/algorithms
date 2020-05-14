package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/3/25 23:34
 * @apiNote 判断是否是子序列
 */
public class IsSubSequence {


    /**
     * 判断是否是子序列 (解法一：dp)
     * 1.给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 2.你可以认为 s 和 t 中仅包含英文小写字母。
     * 3.字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     * 4.字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * 5.（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * 示例 1:
     * s = "abc", t = "ahbgdc"
     * 返回 true
     * <p>
     * 示例 2:
     * s = "axc", t = "ahbgdc"
     * <p>
     * 返回 false
     *
     * @apiNote 思路：
     * 1.dp思路
     * 2.假设dp[i][j]为当str1和str2的长度分别为i和j时，str1是否是str2的子序列
     * 3.当str1[i]==str2[j]时，dp[i][j]=dp[i-1][j-1]
     * 4.当str1[i]!=str2[j]时，dp[i][j]=dp[i][j-1]
     * 5.时间复杂度：O(n*n)
     * 6.空间复杂度：O(n*n)
     */
    public static boolean isSubSequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        //鲁棒
        if (len2 == 0) {
            return false;
        }
        //1.定义dp数组
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        //2.初始化dp(显然str1为空串时，不管str2是啥，str1都是str2的字串)
        for (int i = 0; i < len2; i++) {
            dp[0][i] = true;
        }
        //3.根据dp状态公式填充dp数组
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //j-1，说明这里的值取决于前面的位置的值
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }


    /**
     * 是否是子序列：解法二
     *
     * @apiNote 思路：
     * 1.巧妙利用api解题
     * 2.str2.indexOf(str1.charAt(i),j),表示从j开始寻找str1.charAt(i)
     * 3.如果找到则返回对应的索引下标，没有则返回-1
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static boolean isSubSequence2(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 > 0 && len2 == 0) {
            return false;
        }
        int j = -1;
        char[] chs = str1.toCharArray();
        for (int i = 0; i < len1; i++) {
            //寻找字符对应的索引下标
            j = str2.indexOf(chs[i], j + 1);
            if (j == -1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "bbabc";
        String str3 = "akkbiilc";
        System.out.println("dp解法：字符串：" + str1 + "是否是字符串：" + str2 + "的子序列：" + isSubSequence(str1, str2));
        System.out.println("dp解法：字符串：" + str1 + "是否是字符串：" + str3 + "的子序列：" + isSubSequence(str1, str3));
        System.out.println("api解法：字符串：" + str1 + "是否是字符串：" + str2 + "的子序列：" + isSubSequence2(str1, str2));
        System.out.println("api解法：字符串：" + str1 + "是否是字符串：" + str3 + "的子序列：" + isSubSequence2(str1, str3));
    }
}

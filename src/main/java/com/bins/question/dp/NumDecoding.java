package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/9/10 16:46
 * @apiNote 解码方法
 * 来源：leetcode-91
 * 链接：https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecoding {

    /**
     * 题目描述：
     * 1.一条包含字母 A-Z 的消息通过以下方式进行了编码：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数
     * <p>
     * 示例 1:
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）
     * <p>
     * 示例 2:
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
     *
     * @apiNote 思路：
     * 1.先考虑暴力递归
     * 2.我们只需考虑取当前的一位数和取连续的两位数往后面去递归就行
     * 3.这样确实可以通过 ，但是中间多了很多重复的计算，我们考虑用dp来优化
     */
    public static int numDecoding(String s) {
        return counter(s, 0);
    }

    /**
     * 统计个数
     */
    public static int counter(String s, int index) {
        //递归结束条件
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        //1.计算取一位的结果
        int ans1 = counter(s, index + 1);
        //2.计算取连续的两位的结果
        int ans2 = 0;
        if (index < s.length() - 1) {
            int ten = (s.charAt(index) - '0') * 10;
            int one = s.charAt(index + 1) - '0';
            //两位数的组合符合条件
            if (ten + one <= 26) {
                ans2 = counter(s, index + 2);
            }
        }
        return ans1 + ans2;
    }

    /**
     * 解法二，dp
     *
     * @apiNote 思路：
     * 1.对于这种由最右子结构的问题一般都能够用dp来解决
     * 2.假设dp[i]表示前s[i]个个数
     * 3.dp[0]=1,表示当s为空时的一种特殊情况
     * 4.如果s[0]!='0',说明第一个字符可以当都作为一种情况，那么dp[1]=1
     * 5.接下来我们就要考虑取一个字符的情况和取连续的两个字符的情况
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(n)
     */
    public static int numDecodingV2(String s) {
        //特判
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int ans1 = 0, ans2 = 0;
            if (s.charAt(i - 1) != '0') {
                ans1 = dp[i - 1];
            }
            if (s.charAt(i - 2) != '0') {
                int ten = (s.charAt(i - 2) - '0') * 10;
                int one = s.charAt(i - 1) - '0';
                if (ten + one <= 26) {
                    ans2 = dp[i - 2];
                }
            }
            dp[i] = ans1 + ans2;
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "101";
        System.out.println(numDecoding(s));
        System.out.println(numDecodingV2(s));
    }
}

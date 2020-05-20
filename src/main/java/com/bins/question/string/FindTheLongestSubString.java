package com.bins.question.string;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/5/20 22:04
 * @apiNote 每个元音包含偶数次的最长子字符串
 * 来源：leetcode-1371
 * 链接：https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 */
public class FindTheLongestSubString {


    /**
     * 题目描述：
     * 1.给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度
     * 2.每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
     * <p>
     * 示例 1：
     * 输入：s = "eleetminicoworoep"
     * 输出：13
     * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
     * <p>
     * 示例 2：
     * 输入：s = "leetcodeisgreat"
     * 输出：5
     * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
     * <p>
     * 示例 3：
     * 输入：s = "bcbcbc"
     * 输出：6
     * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次
     * <p>
     * 提示：
     * 1.1 <= s.length <= 5 x 10^5
     * 2.s 只包含小写英文字母
     *
     * @apiNote 思路：
     * 1.做不出来。。。
     * 2.
     */
    public static int findTheLongestSubString(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}

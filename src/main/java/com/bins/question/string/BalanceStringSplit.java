package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/4/13 11:47
 * @apiNote 平衡字符串的分割
 */
public class BalanceStringSplit {


    /**
     * 题目描述：
     * 1.在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的
     * 2.给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串
     * 3.返回可以通过分割得到的平衡字符串的最大数量
     * <p>
     * 示例 1：
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'
     * <p>
     * 示例 2：
     * 输入：s = "RLLLLRRRLR"
     * 输出：3
     * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'
     * <p>
     * 示例 3：
     * 输入：s = "LLLLRRRR"
     * 输出：1
     * 解释：s 只能保持原样 "LLLLRRRR"
     *
     * @apiNote 思路：
     * 1.设置两个标志位分别记录L和R出现的次数，countL，countR
     * 2.一次遍历字符串，遇到为L的，countL++，否则countR++
     * 3.当判断countL==countR的时候，说明出现了一对平衡字符串
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(1)
     */
    public static int balanceStringSplit(String s) {
        int len = s.length();
        //鲁棒
        if (len == 1) {
            return 0;
        }
        int count = 0;
        int countL = 0;
        int countR = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'L') {
                countL++;
            } else if (s.charAt(i) == 'R') {
                countR++;
            }
            if (countL == countR) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String str1 = "RLRRLLRLRL";
        String str2 = "RLLLLRRRLR";
        String str3 = "LLLLRRRR";
        System.out.println(balanceStringSplit(str1));
        System.out.println(balanceStringSplit(str2));
        System.out.println(balanceStringSplit(str3));
    }
}

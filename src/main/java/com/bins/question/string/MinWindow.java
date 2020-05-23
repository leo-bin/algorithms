package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/5/23 9:32
 * @apiNote 最小覆盖字串
 * 来源：leetcode-76
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinWindow {

    /**
     * 题目描述：
     * 1.给你一个字符串 S、一个字符串 T
     * 2.请在字符串 S 里面找出,包含 T 所有字符的最小子串
     * <p>
     * 示例：
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     * <p>
     * 说明：
     * 1.如果 S 中不存这样的子串，则返回空字符串 ""
     * 2.如果 S 中存在这样的子串，我们保证它是唯一的答案
     *
     * @apiNote 思路：
     * 1.滑动窗口的思想
     * 2.思路其实很简单，我们设置一个left和right指针分别指向第一个字符
     * 3.然后right不断往右移，直到此时[left,right)所表示的字串符合要求T的要求
     * 4.但是这个时候，我们求的是最优解，所以可能现在这个区间太大了，我们要从左开始缩小这个区间
     * 5.直到找到一个最优解(最短)为止，然后记录此时最短子串的起始和结束位置，并且更新最短长度
     * 6.然后right接着往右走，一直到最后一个元素。。。。
     * 7.这里我们可以通过记录字符出现次数的方法来判断是否找到符合T中字符
     * 8.因为出现的字符都是英文字母，所以这里可以直接使用一个数组来记录所有字符出现的次数，用char的ascii码实现
     * 9.时间复杂度：O(n)(实际上是最坏的情况也是2*n)
     * 10.空间复杂度：O(1)(数组的长度是常数级别的)
     */
    public static String minWindow(String s, String t) {
        if (s == null || "".equals(s) || t == null || "".equals(t)) {
            return "";
        }
        //纪录最终子串起始和结束下标
        int start = 0, end = 0;
        //左右双指针
        int left = 0, right = 0;
        //统计有效字符在s中出现的次数
        int valid = 0;
        //记录子串的最短长度
        int minLen = Integer.MAX_VALUE;
        //分别开俩数组来表示目标数组和窗口数组,因为英文字符的ascii码不超过128
        int[] needs = new int[128];
        int[] window = new int[128];
        //1.初始化needs数组，表示我们需要的字符以及需要的个数
        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }
        //2.开始滑动窗口
        while (right < s.length()) {
            char cur = s.charAt(right);
            window[cur]++;
            //cur需不需要？目前窗口中的cur的个数是否满足我的需求？
            if (needs[cur] > 0 && needs[cur] >= window[cur]) {
                valid++;
            }
            //往右滑
            right++;
            //窗口内找最优解！
            while (valid == t.length()) {
                //记录最优解
                if (right - left < minLen) {
                    start = left;
                    end = right;
                    minLen = right - left;
                }
                //缩小窗口
                char ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    valid--;
                }
                window[ch]--;
                left++;
            }
        }
        return s.substring(start, end);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}

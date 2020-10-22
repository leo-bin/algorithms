package com.bins.question.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/10/22 16:20
 * @apiNote 划分字母的区间
 * 来源：leetcode-763
 * 链接：https://leetcode-cn.com/problems/partition-labels/
 */
public class PartitionLabels {

    /**
     * 题目描述：
     * 1.字符串S由小写字母组成
     * 2.我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段
     * 3.返回一个表示每个字符串片段的长度的列表
     * <p>
     * 示例1：
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"
     * 每个字母最多出现在一个片段中
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少
     * <p>
     * 提示：
     * 1.S的长度在[1, 500]之间
     * 2.S只包含小写字母 'a' 到 'z'
     *
     * @apiNote 思路：
     * 1.没想出来，看了官方中的贪心题解才想到。贪心确实厉害
     * 2.关键理解：同一区间内的字母的起始位置和结束位置一定在一个区间内
     * 3.我们直接顺序统计所有字母的出现位置即可实现记录同一个字母出现的最后位置
     * 4.之后我们使用双指针遍历字符串start=0和end=0
     * 5.每次每次只要找统计字母出现位置的最大值就是某个区间的结束位置(具体看代码可秒懂)
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(1)
     */
    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        //记录每一个字母出现的最后位置
        int[] marked = new int[26];
        for (int i = 0; i < S.length(); i++) {
            marked[S.charAt(i) - 'a'] = i;
        }
        for (int start = 0, end = 0, i = 0; i < S.length(); i++) {
            //求结束位置的最大值
            end = Math.max(end, marked[S.charAt(i) - 'a']);
            //记录区间,重新开始
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(S);
        if (result != null && result.size() >= 1) {
            System.out.println(result.toString());
        }
    }
}

package com.bins.question.string;

import java.util.LinkedList;

/**
 * @author leo-bin
 * @date 2020/5/28 15:47
 * @apiNote 字符串解码
 * 来源：leetcode-394
 * 链接：https://leetcode-cn.com/problems/decode-string/
 */
public class DecodeString {


    /**
     * 题目描述：
     * 1.给定一个经过编码的字符串，返回它解码后的字符串
     * 2.编码规则:k[encoded_string]，表示其中方括号内部的 encoded_string正好重复k次
     * 3.注意 k 保证为正整数。
     * 4.你可以认为输入字符串总是有效的
     * 5.输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的
     * 6.此外，你可以认为原始数据不包含数字
     * 7.所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入
     * <p>
     * 示例:
     * s = "3[a]2[bc]", 返回 "aaabcbc".
     * s = "3[a2[c]]", 返回 "accaccacc".
     * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef"
     *
     * @apiNote 思路：
     * 1.对于这种括号匹配的问题一般都是用的栈来解决
     * 2.但是这里难的是如何在括号匹配的同时去计算字符串的拼接和重组
     * 3.说实话我一开始就想到了这种解法，但是当我动手的时候我发现自己却写不出来。。。
     * 4.很多需要考虑的地方，非常的考细节，leetcode每日一题出的真有水平！
     * 5.大概思路就是使用两个辅助栈分别存重复次数和临时的拼接结果
     * 6.还需要注意的是如果遇到了位数大于10的数比如11，你会发现你永远你不能直接取到这个11！
     * 7.只能利用'1'和'1'是一个连续的字符然后在第二次的时候多乘10加起来就行！
     * 8.时间复杂度：O(n)
     * 9.空间复杂度：O(n)
     */
    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> resStack = new LinkedList<>();
        //计算此时的重复次数
        int n = 0;
        for (Character c : s.toCharArray()) {
            //1.遇到 [ 括号就入栈，并重新计算n值和临时结果
            if (c == '[') {
                numStack.addLast(n);
                resStack.addLast(result.toString());
                n = 0;
                result = new StringBuilder();
            }
            //2.遇到 ] 括号
            else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curN = numStack.removeLast();
                //复制
                for (int i = 0; i < curN; i++) {
                    tmp.append(result);
                }
                //拼接
                result = new StringBuilder(resStack.removeLast() + tmp);
            }
            //3.遇到数字计算重复次数n
            else if (c >= '0' && c <= '9') {
                n = n * 10 + Integer.parseInt(c + "");
            }
            //4.遇到字符直接塞进去
            else {
                result.append(c);
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";
        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
        System.out.println(decodeString(s3));
    }
}

package com.bins.question.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/9/6 11:30
 * @apiNote z字形变换
 * 来源：leetcode-6
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/
 */
public class ZConvert {

    /**
     * 题目描述：
     * 1.将一个给定字符串根据给定的行数
     * 2.以从上往下、从左到右进行 Z 字形排列。
     * 3.比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     * <p>
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * <p>
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * @apiNote 思路：
     * 1.说实话一开始看到题目就想到用二维数组去模拟
     * 2.但是觉得太复杂了，吃力不讨好，但又没有好的思路，于是看了题解
     * 3.有一个题解非常的牛逼，有点贪心的味道在里面，作者的编码水平非常高，佩服
     * 4.总的来说我们可以观察下最后生成的Z字形
     * 5.每次都是在头或者尾开始换方向，从上面一直到最下面，然后开始换方向接着走
     * 6.我们可以把每一行当作一个当都的字符数组
     * 7.我们只要按照这个规律去移动添加字符，最后将所有数组按照顺序拼接起来就行
     * 8.其中在变换方向的时候用到了一个flag值，表示一直往某一个方向走，要么是上，要么是下
     * 9.时间复杂度：O(n)
     * 10.空间复杂度：O(n)
     */
    public static String convert(String s, int numRows) {
        //特判
        if (numRows <= 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            //判断是否改变移动方向
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : rows) {
            res.append(builder);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numsRows = 3;
        System.out.println(convert(s, numsRows));
    }
}

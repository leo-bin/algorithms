package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/10/6 11:13
 * @apiNote Excel表列序号
 * 来源：leetcode-171
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class TitleToNumber {

    /**
     * 题目描述：
     * 1.给定一个Excel表格中的列名称，返回其相应的列序号
     * 例如:
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * <p>
     * 示例 1:
     * 输入: "A"
     * 输出: 1
     * <p>
     * 示例 2:
     * 输入: "AB"
     * 输出: 28
     * <p>
     * 示例 3:
     * 输入: "ZY"
     * 输出: 701
     *
     * @apiNote 思路：
     * 1.我们可以写几组用例观察一下规律，之后根据规律来编码
     * 2.首先是：
     * A-26*0+1       B-26*0+2     C-26*0+3     ...Z-26*0+26
     * AA-26*1+1      AB-26*1+2    AC-26*1+3    ...AZ-26*1+26
     * AAA-26*26*1+1  AAB-26*26+2  AAC-26*26+3  ...ABZ-26*26+26
     * ...（以此类推）
     * 3.很明显，根据不同的位数可以知道每次需要乘多少个26
     * 4.至于单个字母本身的值，我们可以直接用大写字母的Assci码来解决，因为'A'-'A'+1=1，’B‘-‘A’+1=2。。。
     * 5.时间复杂度：O(n)(n代表字符的长度)
     * 6.空间复杂度：O(n)(n代表字符的长度)
     */
    public static int title2Number(String s) {
        char[] chs = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chs.length; i++) {
            result = result * 26 + (chs[i] - 'A') + 1;
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "ZY";
        System.out.println(title2Number(s));
    }
}

package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/9/12 12:41
 * @apiNote 罗马数转整数
 * 来源：leetcode-13
 * 链接：https://leetcode-cn.com/problems/roman-to-integer/
 */
public class RomeToInt {

    /**
     * 题目描述：
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如，罗马数字2写做II ，即为两个并列的 1
     * 12 写做 XII ，即为 X + II
     * 27 写做  XXVII, 即为 XX + V + II
     * 通常情况下，罗马数字中小的数字在大的数字的右边
     * 但也存在特例，例如 4 不写做 IIII，而是 IV
     * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4
     * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900
     * 给定一个罗马数字，将其转换成整数
     * 输入确保在 1 到 3999 的范围内
     * <p>
     * 示例 1:
     * 输入: "III"
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: "IV"
     * 输出: 4
     * <p>
     * 示例 3:
     * 输入: "IX"
     * 输出: 9
     * <p>
     * 示例 4:
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3
     * <p>
     * 示例 5:
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4
     * <p>
     * 提示：
     * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况
     * IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX。999 应该写作 CMXCIX
     * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics
     *
     * @apiNote 思路：
     * 1.暴力匹配就就行
     * 2.遇到右边的比左边的大就减，反之则加就行
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(1)
     */
    public static int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = getValue(s.charAt(i));
            if (i < s.length() - 1 && cur < getValue(s.charAt(i + 1))) {
                sum += getValue(s.charAt(i + 1)) - cur;
                i++;
            } else {
                sum += cur;
            }
        }
        return sum;
    }

    /**
     * 罗马数字映射表
     */
    public static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String s1 = "III";
        String s2 = "IV";
        String s3 = "LVIII";
        String s4 = "MCMXCIV";
        String s5 = "CMXCIX";
        String s6 = "XLIX";
        System.out.println(romanToInt(s1));
        System.out.println(romanToInt(s2));
        System.out.println(romanToInt(s3));
        System.out.println(romanToInt(s4));
        System.out.println(romanToInt(s5));
        System.out.println(romanToInt(s6));
    }
}

package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/4/8 10:49
 * @apiNote 把字符串转换成整数
 * 来源：leetcode-8
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Str2Int {

    /**
     * 题目描述：
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时
     * 则你的函数不需要进行转换，即无法进行有效转换
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0
     * <p>
     * 提示：
     * 本题中的空白字符只包括空格字符 ' '
     * 假设我们的环境只能存储 32 位大小的有符号整数
     * 那么其数值范围为 [−2^31,  2^31 − 1]
     * 如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31)
     * <p>
     * 示例 1:
     * 输入: "42"
     * 输出: 42
     * <p>
     * 示例 2:
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号
     * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42
     * <p>
     * 示例 3:
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字
     * <p>
     * 示例 4:
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号
     * 因此无法执行有效的转换
     * <p>
     * 示例 5:
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     * 因此返回 INT_MIN (−2^31)
     *
     * @apiNote 思路
     * 1.先判断符号位是+还是-，记录一下是正还是负
     * 2.字符串转字符数组
     * 3.遍历字符数组，分别-‘0’，判断结果是否大于等于10，大于10直接返回0，否则写入int数组
     * 4.遍历int数组，根据数组下标判断乘以10的多少次方，结果累加
     * 5.最终结果需要判断是否溢出，这里采用先使用long装结果，然后判断是否溢出
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(n)
     */
    public static int str2Int(String str) {
        //特判
        if (str.length() == 0) {
            return 0;
        }
        int result = 0;
        int flag = 1, index = 0;
        char[] chs = str.toCharArray();
        //去掉前导空格
        while (index < chs.length && chs[index] == ' ') {
            index++;
        }
        //特判
        if (index >= chs.length) {
            return 0;
        }
        if (chs[index] == '+') {
            index++;
        } else if (chs[index] == '-') {
            flag = -1;
            index++;
        } else if (!Character.isDigit(chs[index])) {
            return 0;
        }
        while (index < chs.length && Character.isDigit(chs[index])) {
            int n = chs[index++] - '0';
            //计算过程中溢出了
            if (result > (Integer.MAX_VALUE - n) / 10) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + n;
        }
        return flag == 1 ? result : -result;
    }

    public static void main(String[] args) {
        String str = "+2147483647";
        String str1 = "1a33";
        String str2 = "  -1234567";
        String str3 = "  12345678";
        String str4 = "";
        String str5 = "sn4d61ss1";
        String str6 = "-2147483648";
        String str7 = "4193 with words";
        String str8 = "words and 987";
        String str9 = "-91283472332";
        String str10 = "3.14159";
        String str11 = "18446744073709551617";
        System.out.println(str2Int(str));
        System.out.println(str2Int(str1));
        System.out.println(str2Int(str2));
        System.out.println(str2Int(str3));
        System.out.println(str2Int(str4));
        System.out.println(str2Int(str5));
        System.out.println(str2Int(str6));
        System.out.println(str2Int(str7));
        System.out.println(str2Int(str8));
        System.out.println(str2Int(str9));
        System.out.println(str2Int(str10));
        System.out.println(str2Int(str11));
    }
}

package com.bins.question.math;


/**
 * @author leo-bin
 * @date 2020/3/25 11:47
 * @apiNote 大整数相加
 * 来源 ：leetcode-415
 * 链接：https://leetcode-cn.com/problems/add-strings/comments/
 */
public class BigNumberSum {

    /**
     * 实现大整数相加，解决整数溢出的问题
     *
     * @apiNote 思路：
     * 1.首先int的最大值是:2147483647,10位（2^31-1）
     * 2.如果有两个大于int最大值的整数相加，显然，就会出现溢出的问题
     * 3.这里我们使用数组来存储大整数的每一个数字，然后数组的每一位相加存到另外一个数组里就行
     * 4.这个题目其实出的很好，关键就是要记住己点
     * 5.第一是如何将原来的字符串变成一个能够方便的进行竖式相加计算的形式，比如说如何实现低位补零
     * 6.第二就是在竖式相加的过程如何将进位也考虑进去
     * 7.其他的就是一些细节问题了
     * 8.时间复杂度：O(n)
     * 9.空间复杂度：O(n)
     */
    public static String bigNumberSum(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 && len2 > 0) {
            return num2;
        }
        if (len2 == 0 && len1 > 0) {
            return num1;
        }
        //找到数值比较大的作为数组的长度
        int maxLen = len1 > len2 ? len1 : len2;
        int[] array1 = new int[maxLen + 1];
        int[] array2 = new int[maxLen + 1];
        int[] arraySum = new int[maxLen + 1];
        //1.倒序入数组，因为是从低位开始相加的,同时也实现了低位补零
        for (int i = len1 - 1, j = 0; i >= 0 && j < maxLen + 1; i--, j++) {
            array1[j] = num1.charAt(i) - '0';
        }
        for (int i = len2 - 1, j = 0; i >= 0 && j < maxLen + 1; i--, j++) {
            array2[j] = num2.charAt(i) - '0';
        }
        //2.对应位数的数字相加，将结果存在临时数组中
        for (int i = 0; i < maxLen; i++) {
            int temp = array1[i] + array2[i] + arraySum[i];
            if (temp < 10) {
                arraySum[i] = temp;
            } else {
                arraySum[i] = temp % 10;
                arraySum[i + 1] = temp / 10;
            }
        }
        //3.将临时结果反序,不能使用reverse方法，要考虑相加之后的进位不为0的情况
        maxLen = arraySum[maxLen] == 0 ? maxLen - 1 : maxLen;
        for (int i = maxLen; i >= 0; i--) {
            result.append(arraySum[i]);
        }
        return result.toString();
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.这是在leetcode评论区看到的解法，差别呀！太nm牛逼了！
     * 2.其实仔细一看写的很简单，很优雅，其实就是暴力！
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(1)
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        //进位
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            //求余数
            result.append(carry % 10);
            //求进位
            carry /= 10;
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        String bigNumberA = "567895678956";
        String bigNumberB = "56789567895";
        System.out.println("两个大整数相加：" + bigNumberA + "+" + bigNumberB + "=" + bigNumberSum(bigNumberA, bigNumberB));

        String num1 = "584";
        String num2 = "18";
        System.out.println(bigNumberSum(num1, num2));

        System.out.println(addStrings(num1, num2));
    }
}

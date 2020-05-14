package com.bins.bishi.meituan;

/**
 * @author leo-bin
 * @date 2020/3/26 19:16
 * @apiNote 第一题
 */
public class code1 {


    /**
     * 数字交换：
     * 1.给你一个整数，和一串序列，要你按照序列的下标将整数的数字改成
     * 输入样例2
     * -12
     * 2 3 7 6 5 4 3 2 1
     * <p>
     * 输出样例2
     * -23
     * <p>
     * 输入样例3
     * 73598793378342493
     * 1 3 6 1 6 8 9 1 3
     * <p>
     * 输出样例3
     * 96631936691613136
     *
     * @apiNote 思路：
     * 1.时间复杂度：O(n)
     * 2.空间复杂度：O(n)
     */
    public static String numberExchange(String number1, String number2) {
        StringBuilder result = new StringBuilder();
        //判断正负
        char[] a = number1.toCharArray();
        String[] b = number2.split(" ");
        int lenA = a.length;
        int lenB = b.length;
        int len;
        len = lenA > lenB ? lenB : lenA;
        int flag = 0;
        if (a[0] == '-') {
            result.append('-');
            flag = 1;
            if (lenA < lenB) {
                len--;
            }
        }
        for (int i = 0; i < len; i++) {
            result.append(b[i]);
        }
        if (len < lenA) {
            if (flag == 1) {
                len++;
            }
            for (int j = len; j < lenA; j++) {
                result.append(a[j]);
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String number1 = "-12";
        String number2 = "2 3 7 6 5 4 3 2 1";
        String number3 = "73598793378342493";
        String number4 = "1 3 6 1 6 8 9 1 3";
        System.out.println(numberExchange(number1, number2));
        System.out.println(numberExchange(number3, number4));
    }
}

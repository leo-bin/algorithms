package com.bins.question.math;


/**
 * @author leo-bin
 * @date 2020/3/25 11:47
 * @apiNote 大整数相加
 */
public class BigNumberSum {

    /**
     * 实现大整数相加，解决整数溢出的问题
     *
     * @apiNote 思路：
     * 1.首先int的最大值是:2147483647,10位（2^31-1）
     * 2.如果有两个大于int最大值的整数相加，显然，就会出现溢出的问题
     * 3.这里我们使用数组来存储大整数的每一个数字，然后数组的每一位相加存到另外一个数组里就行
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        StringBuilder result = new StringBuilder();
        int lenA = bigNumberA.length();
        int lenB = bigNumberB.length();
        //鲁棒
        if (lenA == 0 && lenB > 0) {
            return bigNumberB;
        }
        if (lenB == 0 && lenA > 0) {
            return bigNumberA;
        }
        //找到数值比较大的作为数组的长度
        int maxLen = lenA > lenB ? lenA : lenB;
        //1.初始化
        int[] arrayA = new int[maxLen + 1];
        int[] arrayB = new int[maxLen + 1];
        //临时数组存放相加的结果
        int[] tmp = new int[maxLen + 1];
        //倒序入数组，因为是从低位开始相加的
        for (int i = lenA - 1, j = 0; i >= 0 && j < maxLen + 1; i--, j++) {
            arrayA[j] = bigNumberA.charAt(i) - 48;
        }
        for (int i = lenB - 1, j = 0; i >= 0 && j < maxLen + 1; i--, j++) {
            arrayB[j] = bigNumberB.charAt(i) - 48;
        }
        //2.对应位数的数字相加，将结果存在临时数组中
        for (int i = 0; i < maxLen; i++) {
            int temp = arrayA[i] + arrayB[i];
            if (temp < 10) {
                tmp[i] += temp;
            } else {
                tmp[i] += temp % 10;
                tmp[i + 1] += temp / 10;
            }
        }
        //3.将临时结果反序
        boolean flag = false;
        for (int i = maxLen; i >= 0; i--) {
            if (!flag) {
                if (tmp[maxLen] == 0) {
                    flag = true;
                    continue;
                }
            }
            result.append(tmp[i]);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String bigNumberA = "567895678956";
        String bigNumberB = "56789567895";
        System.out.println("两个大整数相加：" + bigNumberA + "+" + bigNumberB + "=" + bigNumberSum(bigNumberA, bigNumberB));
    }
}

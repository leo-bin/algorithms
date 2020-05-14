package com.bins.question.print;


/**
 * @author leo-bin
 * @date 2020/4/9 18:11
 * @apiNote 把数组排成最小的数
 */
public class PrintMinNumber {


    /**
     * 题目描述：
     * 1.输入一个正整数数组，把数组里所有数字拼接起来排成一个数
     * 2.打印能拼接出的所有数字中最小的一个
     * 3.例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
     *
     * @apiNote 思路：
     * 1.先将原数组排序，找到最大值
     * 2.记录下最大值的位数
     * 3.一次循环
     */
    public static String printMinNumber(int[] numbers) {
        StringBuilder result = new StringBuilder();
        int len = numbers.length;
        //鲁棒
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return result.append(numbers[0]).toString();
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = Integer.valueOf((numbers[i] + "" + numbers[j]));
                int b = Integer.valueOf((numbers[j] + "" + numbers[i]));
                //说明需要交换i和j的位置
                if (a > b) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            result.append(numbers[i]);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        int[] numbers1 = {27, 100, 5};
        System.out.println(printMinNumber(numbers));
        System.out.println(printMinNumber(numbers1));
    }
}

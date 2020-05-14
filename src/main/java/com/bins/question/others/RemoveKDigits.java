package com.bins.question.others;

/**
 * @author leo-bin
 * @date 2020/3/24 20:40
 * @apiNote 删去k个数之后的最小值
 */
public class RemoveKDigits {


    /**
     * 题目描述：
     * 一个整数删去k个数字之后的最小值（解法一：暴力循环）
     * 1.一个整数number，假设是654321，k=3，说明需要删3个数字
     * 2.删掉哪3个数才能保证剩下的数是最小值
     *
     * @apiNote 思路：
     * 1.我们一步一步的走
     * 2.不管要求删除几个，我们先一个一个的删除
     * 3.只要保证每次删除一个数字之后，剩下的整数是最小的就行
     * 4.所以我们要高位开始比较，也就是从左边开始遍历，每次都和临近的数字比较
     * 5.找到第一个比自己要小的数字，说明从这里开始，后面的序列开始递减了，然后把自己删掉
     * 6.比如说，654，6就是第一个开始递减的数字，那就先删除6
     * 7.再比如，7849，8是第一个开始递减的数字，那就先删除8
     * 8.时间复杂度：O(k*n)
     * 9.空间复杂度：O(1)
     */
    public static String removeKDigits(String number, int k) {
        //鲁棒
        if (number.length() == 0 || k <= 0) {
            return "";
        }
        int len = number.length();
        //外层循环控制删除次数
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < number.length() - 1; j++) {
                if (number.charAt(j) > number.charAt(j + 1)) {
                    number = number.substring(0, j) + number.substring(j + 1);
                    break;
                }
            }
        }
        //说明还剩下元素没有删，这种情况就直接从尾部删（1234）
        while (number.length() > len - k) {
            number = number.substring(0, number.length() - 1);
        }
        //删掉整数左侧的0（可能会出现这种情况：032）
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {
                break;
            }
            number = number.substring(1);
        }
        //如果整数的所有数字都被删掉了，那就直接返回""
        if (number.length() == 0) {
            return "";
        }
        return number;
    }


    public static void main(String[] args) {
        String str = "654321";
        String str1 = "123456";
        String str2 = "678549";
        String str3 = "654";
        String str4 = "605432";
        int k = 3;
        System.out.println("数字：" + str + "删掉" + k + "个数之后的最小值是：" + removeKDigits(str, k));
        System.out.println("数字：" + str1 + "删掉" + k + "个数之后的最小值是：" + removeKDigits(str1, k));
        System.out.println("数字：" + str2 + "删掉" + k + "个数之后的最小值是：" + removeKDigits(str2, k));
        System.out.println("数字：" + str3 + "删掉" + k + "个数之后的最小值是：" + removeKDigits(str3, k));
        System.out.println("数字：" + str4 + "删掉" + k + "个数之后的最小值是：" + removeKDigits(str4, k));
    }
}

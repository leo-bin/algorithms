package com.bins.question.array;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/4/26 17:38
 * @apiNote 数组中只出现1次的数
 */
public class FindNumberAppearOnce {


    /**
     * 题目描述：
     * 1.一个整型数组里除了1个数字之外，其他的数字都出现了两次
     * 2.请写程序找出这1个只出现一次的数字
     * 3.array={1,2,3,2,3}
     *
     * @apiNote 思路：
     * 1.异或思想
     * 2.1^2^3^2^3  => (2^2)^(3^3)^1  =>  0^0^1=1
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(1)
     */
    public static int findNumberAppearOnce(int[] array) {
        //鲁棒
        if (array.length == 0) {
            return -1;
        }
        if (array.length == 1) {
            return array[0];
        }
        int xorSum = 0;
        for (int i = 0; i < array.length; i++) {
            xorSum ^= array[i];
        }
        return xorSum;
    }


    /**
     * 题目描述：
     * 1.一个整型数组里除了两个数字之外，其他的数字都出现了两次
     * 2.请写程序找出这两个只出现一次的数字
     * 3.将num1[0],num2[0]设置为返回结果
     * <p>
     * 4.比如：{1，1，2，3，4，4}，我们要找的就是{2，3}
     *
     * @apiNote 思路：
     * 1.使用TreeSet这个外部存储
     * 2.连续的往列表里面添加元素
     * 3.如果列表中有某个元素了，那就直接删除，类似于抵消的思想
     * 4.实现过滤掉所有相同的数字，只剩下不相同的数字
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(n)
     */
    public static int[] findNumbersAppearOnce(int[] array) {
        if (array.length <= 1) {
            return null;
        }
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.remove(array[i]);
            } else {
                map.put(array[i], i);
            }
        }
        if (map.size() == 2) {
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                result[i++] = (Integer) entry.getValue();
            }
        }
        int first = result[0] < result[1] ? result[0] : result[1];
        int second = result[0] > result[1] ? result[0] : result[1];
        result[0] = array[first];
        result[1] = array[second];
        return result;
    }

    /**
     * 解法二，进一步对空间复杂度进行优化
     *
     * @apiNote 思路：
     * 1.使用异或的思想
     * 2.先通过一次异或求和得到的结果就是那两个不同的数字的异或的结果
     * 3.比如，1^1^2^3^4^4=2^3
     * 4.问题来了，我们怎么把这两个数分开呢？
     * 5.可以想到通过某种操作将原来的数组分成两个部分
     * 6.一部分只有其中一个出现次数为1，一部分包括其他所有出现次数为2次的以及另外一个出现次数为1的部分
     * 7.比如说，分成：{2}和{1，1，3，4，4}，这样一来只需要对后面的集合通过一次异或求和就可以得到另外一个数了
     * 8.那如何实现这个分组骚操作呢？答案是找到两个数字的第一个不同位的数字
     * 9.时间复杂度：O(n)
     * 10.空间复杂度：O(1)
     */
    public static void findNumbersAppearOnceV2(int[] array, int[] num1, int[] num2) {
        int sum = 0;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            //所有数异或，结果为不同的两个数字的异或
            sum ^= array[i];
        }
        //找异或之后的结果中第一个相同位置上不同数字的数字
        int mask = 1;
        while ((sum & mask) == 0) {
            mask = mask << 1;
        }
        //异或分组
        for (int i = 0; i < len; i++) {
            if ((array[i] & mask) != 0) {
                num1[0] = num1[0] ^ array[i];
            } else {
                num2[0] = num2[0] ^ array[i];
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 4, 4};
        int[] result = findNumbersAppearOnce(array);
        if (result != null && result.length > 0) {
            System.out.println(Arrays.toString(result));
        } else {
            System.out.println("没找到");
        }
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumbersAppearOnceV2(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}

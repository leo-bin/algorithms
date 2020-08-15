package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/28 10:33
 * @apiNote 数组中的逆序对
 */
public class InversePairs {


    private static long count = 0;

    /**
     * 题目描述：
     * 1.在数组中的两个数字
     * 2.如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
     * 3.输入一个数组,求出这个数组中的逆序对的总数P
     * 4.并将P对1000000007取模的结果输出
     * 5.即输出P%1000000007
     * <p>
     * 输入描述:
     * 题目保证输入的数组中没有的相同的数字
     * <p>
     * 输入
     * 1,2,3,4,5,6,7,0
     * <p>
     * 输出
     * 7
     *
     * @apiNote 思路：
     * 1.利用归并排序的思想，采用分治的思想！
     * 2.我们只需要先比较相邻的两个数，然后合并，继续比较
     * 3.时间复杂度：O(n*log(n))
     * 4.空间复杂度：O(n)
     */
    public static int inversePairs(int[] array) {
        //鲁棒
        if (array.length <= 1) {
            return 0;
        }
        merge(array);
        return (int) count;
    }



    /**
     * 归并
     */
    public static int[] merge(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return mergeHelper(merge(left), merge(right));
    }


    /**
     * 归并排序
     */
    public static int[] mergeHelper(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        long tmp = 0;
        for (int i = left.length - 1, j = right.length - 1, index = result.length - 1; index >= 0; index--) {
            if (i < 0) {
                result[index] = right[j--];
            } else if (j < 0) {
                result[index] = left[i--];
            } else if (left[i] > right[j]) {
                tmp += j + 1;
                result[index] = left[i--];
            } else {
                result[index] = right[j--];
            }
        }
        count += tmp % 1000000007;
        return result;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        int[] array1 = {7, 5, 6, 4};
        System.out.println(inversePairs(array));
        /* System.out.println(inversePairs(array1));*/
    }
}

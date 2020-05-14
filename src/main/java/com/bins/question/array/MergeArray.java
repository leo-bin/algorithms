package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/18 1:33
 * @apiNote 有序数组的重排序
 */
public class MergeArray {


    /**
     * 题目描述：
     * 1.实现一个函数把两个有序的int数组结合成新的有序数组
     * 2.输入{1，2，3}，{4，5，6}，输出{1，2，3，4，5，6}
     * 3.时间复杂度为：O（n）
     * 4.空间复杂度为：O（1）
     */
    public static int[] orderArrayReSort(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;
        int[] result = new int[len1 + len2];
        if (len1 == 0 || len2 == 0) {
            return result;
        }
        int i = 0, j = 0, z = 0;
        while (i < len1 || j < len2) {
            //判断是否有某个数组提前遍历完，如果这个数组遍历完了，那就循环把另一个数组写入就行
            if (i == len1) {
                while (j < len2) {
                    result[z] = array2[j];
                    z++;
                    j++;
                }
                break;
            } else if (j == len2) {
                while (i < len1) {
                    result[z] = array1[i];
                    z++;
                    i++;
                }
                break;
            }
            if (array1[i] <= array2[j]) {
                result[z] = array1[i];
                z++;
                i++;
            } else if (array1[i] >= array2[j]) {
                result[z] = array2[j];
                z++;
                j++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 3};
        int[] array2 = {1, 2, 3, 4};
        int[] result = orderArrayReSort(array1, array2);
        System.out.println("重排序的结果是：" + Arrays.toString(result));
    }
}

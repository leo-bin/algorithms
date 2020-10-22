package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/16 12:36
 * @apiNote 构建乘积数组
 * 来源：剑指offer
 * 链接：https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&&tqId=11204&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class ConstructMultiplyArr {

    /**
     * 题目描述：
     * 1.给定一个数组A[0,1,...,n-1]
     * 2.请构建一个数组B[0,1,...,n-1]
     * 3.其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
     * 4.不能使用除法
     * 5.规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2]
     *
     * @apiNote 思路：
     * 1.暴力连乘
     * 2.时间复杂度：O(n*n)
     * 3.空间复杂度：O(n)
     */
    public static int[] multiply(int[] A) {
        int len = A.length;
        if (len == 0) {
            return null;
        }
        int[] B = new int[len];
        for (int i = 0; i < len; i++) {
            int tmp = 1;
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    tmp *= A[j];
                }
            }
            B[i] = tmp;
        }
        return B;
    }


    /**
     * 题目描述：
     * 1.解法二
     *
     * @apiNote 思路：
     * 1.矩阵思想，将原来的计算分成了两个部分
     * 2.一个部分是矩阵的下三角
     * 3.一个部分是矩阵的上三角
     * 4.最终的结果，就只需要用下三角*上三角就行
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(n)
     */
    public static int[] multiplyV2(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        if (len > 0) {
            B[0] = 1;
            //1.先算下三角
            for (int i = 1; i < len; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            //2.反过来，算上三角
            int tmp = 1;
            for (int j = len - 2; j >= 0; j--) {
                tmp *= A[j + 1];
                B[j] *= tmp;
            }
        }
        return B;
    }

    /**
     * 解法三
     *
     * @apiNote 思路：
     * 1.
     */
    public static int[] constructArr(int[] a) {


        return a;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(Arrays.toString(multiply(A)));
        System.out.println(Arrays.toString(multiplyV2(A)));
    }
}

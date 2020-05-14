package com.bins.question.tree;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/15 9:13
 * @apiNote 验证二叉搜索树的后序遍历
 */
public class TreeSequenceVerify {


    /**
     * 题目描述：
     * 1.输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
     * 2.如果是则输出Yes,否则输出No
     * 3.假设输入的数组的任意两个数字都互不相同
     *
     * @apiNote 思路：
     * 1.一步一步找规律可解
     * 2.首先二叉搜索树的特点就是，左子树中的所有节点都要小于根节点，右子树中的所有节点都要大于根节点
     * 3.其次，后序遍历序列的最后一个元素就是根节点！
     * 4.所以第一步我们就先设定数组的最后一个元素是根节点
     * 5.然后遍历序列数组，找到第一个比根节点大的元素下标，记为i
     * 6.接着从i开始往后接着遍历，如果遇到了比根节点要小的元素，可以返回false了，否则一直遍历
     * 7.然后根据上面得到的i，j可以将找到的左子树和右子树继续递归调用，直到为最后一个元素结束
     */
    public static boolean verifySequenceOfBST(int[] sequence) {
        int len = sequence.length;
        //鲁棒
        if (len == 0) {
            return false;
        }
        //1.递归结束条件
        if (len == 1) {
            return true;
        }
        //2.最后一个元素作为根节点
        int root = sequence[len - 1];
        //3.根据根节点从头开始遍历，找到第一个比根节点大的元素，找到左子树的结束下标
        int i = 0;
        for (; i < len - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        //4.根据左子数的结束下标找右子树的结束下标
        int j = i;
        for (; j < len - 1; j++) {
            //如果在找右子树的过程中出现了比根节点还要小的元素，直接返回false
            if (sequence[j] < root) {
                return false;
            }
        }
        //5.递归左子树，判断是否满足条件
        boolean left = true;
        if (i > 0) {
            left = verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }
        //6.递归右子树，判断是否满足条件
        boolean right = true;
        if (i < len - 1) {
            right = verifySequenceOfBST(Arrays.copyOfRange(sequence, i, j));
        }
        //7.都满足，返回true
        return left && right;
    }


    public static void main(String[] args) {
        int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        int[] sequence1 = {7, 4, 6, 5};
        int[] sequence2 = {4, 6, 7, 5};
        int[] sequence3 = {1, 2, 3, 4, 5};
        System.out.println(verifySequenceOfBST(sequence));
        System.out.println(verifySequenceOfBST(sequence1));
        System.out.println(verifySequenceOfBST(sequence2));
        System.out.println(verifySequenceOfBST(sequence3));
    }
}

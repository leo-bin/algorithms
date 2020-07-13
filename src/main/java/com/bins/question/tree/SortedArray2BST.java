package com.bins.question.tree;


import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/7/12 11:40
 * @apiNote 将有序数组转换二叉搜索树
 * 来源：leetcode-108
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class SortedArray2BST {

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        private int data;
        private TreeNode left = null;
        private TreeNode right = null;

        public TreeNode(int data) {
            this.data = data;
        }
    }


    /**
     * 题目描述：
     * 1.将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
     * 2.一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
     * <p>
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     * *      0
     * *     / \
     * *   -3   9
     * *   /   /
     * * -10  5
     *
     * @apiNote 思路：
     * 1.首先如果没有那个平衡的限制的话，这个题目直接就用递归就能够过了
     * 2.但是为了保持平衡，我们只需要保证分治得到的两个区间的元素个数几乎相等就行
     * 3.怎么保证？数组吗，除以2呗！
     * 4.那你是如何保证BST特性的？简单，只要唯一确定一个根节点就行
     * 5.很显然，这里除以2之后得到的下标就很适合做根节点！
     * 6.因为根据题目有序的条件，这个mid下标所指向的值一定比左边的元素都要大！比右边的要小！
     * 7.时间复杂度：O(n)
     * 8.空间复杂度：O(log(n))
     */
    public static TreeNode sortedArray2BST(int[] nums) {
        //递归结束条件
        if (nums.length < 1) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArray2BST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArray2BST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }



    public static void main(String[] args) {

    }
}

package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/5/13 11:14
 * @apiNote 二叉树的下一个节点
 */
public class NextTreeNode {


    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


    /**
     * 题目描述：
     * 1.给定一个二叉树和其中的一个结点
     * 2.请找出中序遍历顺序的下一个结点并且返回
     * 3.注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
     * <p>
     * 示例：
     * *           A
     * *         /   \
     * *        B     C
     * *      /  \     \
     * *     D   E      F
     * *        /
     * *       G
     * <p>
     * 解释：
     * 1.如果给你的节点是B的话，那么结果就是G
     * 2.如果给你的节点是G的话，那么结果就是E
     * 3.如果给你的节点是E的话，那么结果就是A
     *
     * @apiNote 思路：
     * 1.找规律
     * 2.要想满足上面的情况，有三种情况
     * 3.第一，如果给我们的节点有右子树的话，那么结果就是右子树的最左节点
     * 4.第二，如果没有右子树的话，又可以分为两种情况讨论
     * 5.第一，如果给你的节点没有右子树，但是它有父节点，并且他是父节点的左子树，那么结果就是它的父节点
     * 6.第二，如果给你的节点没有右子树，他同样也有父节点，但是他不是父节点的左子树
     * 7.那么我们需要从它的父节点开始往上面查找，找到第一个满足：当前的节点有父节点并且是父节点的左子树
     * 8.时间复杂度：O(n)
     * 9.空间复杂度：O(1)
     */
    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //1.如果有右子树，那就满足第一种情况，找右子树的最左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //2.没有右子树
        while (pNode.next != null) {
            //2.1当前节点是父节点的左子树
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            //2.2当前节点是父节点的右子树
            pNode = pNode.next;
        }
        return null;
    }


    public static void main(String[] args) {

    }
}

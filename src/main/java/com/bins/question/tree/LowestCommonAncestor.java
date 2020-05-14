package com.bins.question.tree;

import java.util.LinkedList;


/**
 * @author leo-bin
 * @date 2020/5/10 16:18
 * @apiNote 二叉树的最近公共祖先
 * 来源：leetcode
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    private static LinkedList<TreeNode> track = new LinkedList<>();
    private static LinkedList<TreeNode> pAncestor = null;
    private static LinkedList<TreeNode> qAncestor = null;


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
     * 1.给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
     * 2.百度百科中最近公共祖先的定义为：
     * 3.“对于有根树 T 的两个结点 p、q
     * 4.最近公共祖先表示为一个结点x，满足x是p、q的祖先且x的深度尽可能大
     * 5.一个节点也可以是它自己的祖先
     * 6.例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * <p>
     * 示例 1:
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3
     * <p>
     * 示例 2:
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身
     * <p>
     * 注意：
     * 1.所有节点的值都是唯一的。
     * 2.p、q 为不同节点且均存在于给定的二叉树中
     *
     * @apiNote 思路：
     * 1.暴力+回溯的思想
     * 2.我可以先设3个list分别记录当前走过的路径喝p，q的祖先
     * 3.我们先通过前序遍历并且结合回溯的思想去递归二叉树并且将中间结果存list
     * 4.之所以采用先序是因为我们每次都需要记录当前的根节点，也就是回溯的作用
     * 5.当我们找到p和q的祖先list之后，只需要一次遍历这两个list并找到第一个不相等的下标，返回上一个下标的元素就行
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(n)
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p == root || q == root) {
            return root;
        }
        int i = 0;
        while (i < pAncestor.size() && i < qAncestor.size() && pAncestor.get(i) == qAncestor.get(i)) {
            i++;
        }
        return pAncestor.get(i - 1);
    }

    /**
     * 解法二，直接使用前序遍历不用其他的内存
     *
     * @apiNote 思路：
     * 1.优化之后的时间复杂度：O(n)
     * 2.空间复杂度：O(n)
     */
    public static TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        //先找左边
        TreeNode left = lowestCommonAncestorV2(root.left, p, q);
        //找右边
        TreeNode right = lowestCommonAncestorV2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }


    /**
     * 找祖先
     */
    public static void findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.递归结束条件
        if (root == null) {
            return;
        }
        //2.先记录当前的根节点
        track.add(root);
        //如果找到p的话就将之前走过的节点都作为p的祖先
        if (root == p) {
            pAncestor = new LinkedList<>(track);
        }
        //如果找到q的话就将之前走过的节点都作为q的祖先
        if (root == q) {
            qAncestor = new LinkedList<>(track);
        }
        //左边递归
        findAncestor(root.left, p, q);
        //右边递归
        findAncestor(root.right, p, q);
        //都不是的话就撤销当前节点
        track.pollLast();
    }

    public static void main(String[] args) {

    }
}

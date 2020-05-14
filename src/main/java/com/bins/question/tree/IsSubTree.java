package com.bins.question.tree;


/**
 * @author leo-bin
 * @date 2020/5/7 9:20
 * @apiNote 另一个树的子结构
 * 来源：leetcode-572
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 */
public class IsSubTree {

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
     * 1.给定两个非空二叉树s和t，检验s中是否包含和t具有相同结构和节点值的子树
     * 2.s的一个子树包括s的一个节点和这个节点的所有子孙
     * 3.s也可以看做它自身的一棵子树
     * <p>
     * 示例 1:
     * 给定的树 s:
     * *      3
     * *     / \
     * *    4   5
     * *   / \
     * *  1   2
     * *给定的树 t：
     * *    4
     * *   / \
     * *  1   2
     * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值
     * <p>
     * 示例 2:
     * 给定的树 s：
     * *      3
     * *     / \
     * *    4   5
     * *   / \
     * *  1   2
     * *     /
     * *    0
     * 给定的树 t：
     * *    4
     * *   / \
     * *  1   2
     * 返回 false
     *
     * @apiNote 思路：
     * 1.递归思想
     * 2.我们只需要判断三个方向是否相等即可
     * 3.第一是从当前的节点开始判断两者是否相等
     * 4.当前节点的左子树是否和t相等
     * 5.当前节点的右子树是否和t相等
     * 6.只要满足了这上面三个条件的一个就说明存在一个子结构是相等的
     */
    public static boolean isSubTree(TreeNode s, TreeNode t) {
        //1.递归结束条件
        if (s == null) {
            return false;
        }
        //2.判断当前的s或者当前s的左子树或者当前s的右子树是否和t相等
        return isSubTree(s.left, t) || isSubTree(s.right, t) || isSame(s, t);
    }

    /**
     * 判断两个子树是否相同
     */
    public static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.data != t.data) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        TreeNode root1 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(2);
        root1.left = node5;
        root1.right = node6;
        System.out.println(isSubTree(root, root1));
    }
}

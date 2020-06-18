package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/6/18 10:04
 * @apiNote 从先序遍历还原二叉树
 * 来源：leetcode-1028
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 */
public class RecoverFromPreorder {

    /**
     * 字符串索引
     */
    private static int index = 0;

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
     * 1.我们从二叉树的根节点 root 开始进行深度优先搜索
     * 2.在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度）
     * 3.然后输出该节点的值
     * 4.如果节点的深度为 D，则其直接子节点的深度为 D + 1
     * 5.根节点的深度为 0
     * 6.如果节点只有一个子节点，那么保证该子节点为左子节点
     * 7.给出遍历输出 S，还原树并返回其根节点 root
     * <p>
     * 实例1：
     * *                    1
     * *                   / \
     * *                 2    5
     * *                / \  / \
     * *               3  4 6  7
     * *
     * 输入："1-2--3--4-5--6--7"
     * 输出：[1,2,5,3,4,6,7]
     * <p>
     * 实例2：
     * *                    1
     * *                   / \
     * *                 2    5
     * *                /    /
     * *               3    6
     * *              /    /
     * *             4    7
     * *
     * 输入："1-2--3---4-5--6---7"
     * 输出：[1,2,5,3,null,6,null,4,null,7]
     * <p>
     * 提示：
     * 1.原始树中的节点数介于 1 和 1000 之间
     * 2.每个节点的值介于 1 和 10 ^ 9 之间
     *
     * @apiNote 思路：
     * 1.回溯
     * 2.此题的难点有两个
     * 3.一是如何解决在字符串中找到一个值为1到10^9的值，这个需要遍历一个字符字符的求
     * 4.二是如何找到当前节点是否有下一个节点，这点也要通过遍历实现
     * 5.事件复杂度：O()
     * 6.空间复杂度：O(n)
     */
    public static TreeNode recoverFromPreorder(String S) {
        if (S.isEmpty()) {
            return null;
        }
        return backtrace(S.toCharArray(), 0);
    }

    /**
     * 回溯
     */
    public static TreeNode backtrace(char[] chs, int depth) {
        //1.递归结束条件
        if (index + depth >= chs.length || hasNext(chs, depth)) {
            return null;
        }
        //index指针跳过depth个'-'，指向下一个节点的开始位置
        index += depth;
        //2.拿到当前的root节点的值，并开始左右递归
        TreeNode root = new TreeNode(getValue(chs));
        root.left = backtrace(chs, depth + 1);
        root.right = backtrace(chs, depth + 1);
        return root;
    }

    /**
     * 因为是字符，而且所代表的int值大于9，所以字符可能会连续，这里需要遍历求值
     */
    public static int getValue(char[] chs) {
        int value = 0;
        while (index < chs.length && chs[index] != '-') {
            value = value * 10 + (chs[index++] - '0');
        }
        return value;
    }

    /**
     * 判断当前节点是否有下一个节点
     */
    public static boolean hasNext(char[] chs, int depth) {
        for (int i = index; i < index + depth; i++) {
            if (chs[i] != '-') {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}

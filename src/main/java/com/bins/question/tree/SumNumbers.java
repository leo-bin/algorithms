package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/10/29 16:02
 * @apiNote 从根到叶子节点数字之和
 * 来源：leetcode-129
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class SumNumbers {

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
     * 1.给定一个二叉树，它的每个结点都存放一个0-9的数字
     * 2.每条从根到叶子节点的路径都代表一个数字
     * 3.例如，从根到叶子节点路径1->2->3代表数字123
     * 4.计算从根到叶子节点生成的所有数字之和
     * 5.说明: 叶子节点是指没有子节点的节点
     * <p>
     * 示例1:
     * 输入: [1,2,3]
     * *    1
     * *   / \
     * *  2   3
     * 输出: 25
     * 解释:
     * 从根到叶子节点路径 1->2 代表数字12
     * 从根到叶子节点路径 1->3 代表数字13
     * 因此，数字总和=12+13=25
     * <p>
     * 示例 2:
     * 输入: [4,9,0,5,1]
     * *     4
     * *    / \
     * *   9   0
     * *  / \
     * * 5   1
     * 输出: 1026
     * 解释:
     * 从根到叶子节点路径4->9->5代表数字495
     * 从根到叶子节点路径4->9->1代表数字491
     * 从根到叶子节点路径4->0代表数字40
     * 因此，数字总和=495+491+40=1026
     *
     * @apiNote 思路：
     * 1.递归累加结果就行
     * 2.不过这里一开始只想到了使用SringBuilder来封装临时结果，效率实在不行
     */
    private static int sum = 0;

    public static int sumNumbers(TreeNode root) {
        //特判
        if (root == null) {
            return 0;
        }
        backtrace(root, new StringBuilder());
        return sum;
    }

    /**
     * 回溯
     */
    public static void backtrace(TreeNode root, StringBuilder currentNum) {
        //递归结束条件
        if (root == null) {
            return;
        }
        currentNum.append(root.data);
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(currentNum.toString());
        }
        backtrace(root.left, currentNum);
        backtrace(root.right, currentNum);
        currentNum.deleteCharAt(currentNum.length() - 1);
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.其实临时结果只需要利用累乘就能实现了
     */

    public static int sumNumbersV2(TreeNode root) {
        //特判
        if (root == null) {
            return 0;
        }
        backtraceV2(root, 0);
        return sum;
    }

    /**
     * 回溯
     */
    public static void backtraceV2(TreeNode root, int currentNum) {
        //递归结束条件
        if (root == null) {
            return;
        }
        int tmp = currentNum * 10 + root.data;
        if (root.left == null && root.right == null) {
            sum += tmp;
        }
        backtraceV2(root.left, tmp);
        backtraceV2(root.right, tmp);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        System.out.println(sumNumbers(root));
    }
}

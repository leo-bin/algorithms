package com.bins.question.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/4/14 10:18
 * @apiNote 二叉树的镜像
 */
public class TreeMirror {


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
     * 1.操作给定的二叉树，将其变换为源二叉树的镜像
     * <p>
     * 输入描述:
     * 二叉树的镜像定义：
     * 源二叉树:
     * *       8
     * *     /   \
     * *    6    10
     * *   / \   / \
     * *  5  7  9  11
     * <p>
     * 镜像二叉树
     * *       8
     * *     /  \
     * *    10   6
     * *   / \  / \
     * *  11 9 7  5
     *
     * @apiNote 思路：
     * 1.采用二叉树的层次遍历
     * 2.在遍历到具体某一层时，交换当前节点的左右子树
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static void mirror(TreeNode root) {
        if (root != null) {
            TreeNode current;
            Queue<TreeNode> queue = new LinkedList<>();
            //计数
            int count;
            //当前层的节点个数，也就是当前层的宽度
            int width;
            queue.offer(root);
            while (!queue.isEmpty()) {
                width = queue.size();
                count = 0;
                while (count < width) {
                    current = queue.poll();
                    count++;
                    if (current != null) {
                        if (current.left != null) {
                            queue.offer(current.left);
                        }
                        if (current.right != null) {
                            queue.offer(current.right);
                        }
                        //交换
                        swap(current);
                    }
                }
            }
        }
    }


    /**
     * 交换当前节点的左右子树位置
     */
    public static void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }


    /**
     * 解法二，递归法
     *
     * @apiNote 思路：
     * 1.同样是利用左右节点交换的思想来解决
     * 2.只不过这一次我们是使用递归的方式来进行交换
     * 3.如何实现？利用递归的返回值实现！
     * 4.我们只要将每一次递归的结果分别反过来给当前根节点的左右节点就行
     * 5.比如说当前的节点是root,我们只要先递归root.right然后将返回结果给root.left,这样一来自然就是实现了交换！
     * 6.但是需要注意的是，因为root.left的值已经改变了，下一步我们不能直接写root.right=root.left
     * 7.很明显这样子的话相当于没做交换，解决办法就是设置一个tmp节点来保存交换之前的root.left!
     * 8.时间复杂度：O(n)
     * 9.空间复杂度：O(n)
     */
    public static void mirrorV2(TreeNode root) {
        mirrorHelper(root);
    }


    /**
     * 递归实现交换
     */
    public static TreeNode mirrorHelper(TreeNode root) {
        //1.递归结束条件
        if (root == null) {
            return null;
        }
        //2.先保存一下left节点
        TreeNode originalLeft = root.left;
        //root.left=root.right
        root.left = mirrorHelper(root.right);
        //root.right=root.originalLeft
        root.right = mirrorHelper(originalLeft);
        //3.返回当前节点
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
    }
}

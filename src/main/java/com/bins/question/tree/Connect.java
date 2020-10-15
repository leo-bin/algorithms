package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/10/15 11:17
 * @apiNote 填充每一个节点的下一个右侧节点指针
 * 来源：leetcode-116
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Connect {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    /**
     * 题目描述：
     * 1.给定一个完美二叉树，其所有叶子节点都在同一层
     * 2.每个父节点都有两个子节点。二叉树定义如下：
     * struct Node {
     * int val;
     * Node *left;
     * Node *right;
     * Node *next;
     * }
     * 填充它的每个next指针，让这个指针指向其下一个右侧节点
     * 3.如果找不到下一个右侧节点，则将next指针设置为 NULL
     * 4.初始状态下，所有next指针都被设置为 NULL
     * <p>
     * 解释：
     * 给定二叉树如图A所示，你的函数应该填充它的每个next指针
     * *图A：
     * *        1
     * *      /   \
     * *    2      3
     * *  / \    /   \
     * * 4  5   6     7
     * <p>
     * * 以指向其下一个右侧节点，如图B所示
     * *图B：
     * *           1->null
     * *        /     \
     * *      2   ->   3 ->null
     * *    /  \      /   \
     * *   4 -> 5 -> 6  -> 7 ->null
     * <p>
     * 提示：
     * 你只能使用常量级额外空间
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度
     *
     * @apiNote 思路：
     * 1.这题如果不限制空间的话，我们可以直接用层次遍历的方式去解题
     * 2.限制了空间，可以用栈，很明显是需要用递归
     * 3.我们不难想到可以通过root.left.next=root.right去填充左子树的指针
     * 4.但是右子树的指针呢？我们如何做到从左子树直接和右子树建立联系呢？
     * 5.其实答案在填充左子树的指针时就已经给出了，因为这个时候当前层的左右子树已经建立了连接
     * 6.所以可以直接通过root.right.next=root.next.left来连接连接
     */
    public static Node connect(Node root) {
        //递归结束条件(空节点或者叶子节点可以直接返回)
        if (root == null || root.left == null) {
            return root;
        }
        //直接建立下一层的左子树的联系
        root.left.next = root.right;
        //建立左右子树的关系
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }


    public static void main(String[] args) {

    }
}

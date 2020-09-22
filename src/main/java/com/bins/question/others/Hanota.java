package com.bins.question.others;

import java.util.List;

/**
 * @author leo-bin
 * @date 2020/9/22 20:06
 * @apiNote 汉诺塔问题
 * 来源：leetcode-面试题-08-06
 * 链接：https://leetcode-cn.com/problems/hanota-lcci/
 */
public class Hanota {

    /**
     * 题目描述：
     * 1.在经典汉诺塔问题中，有3根柱子及 N 个不同大小的穿孔圆盘
     * 2.盘子可以滑入任意一根柱子
     * 3.一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)
     * 4.移动圆盘时受到以下限制：
     * (1) 每次只能移动一个盘子
     * (2) 盘子只能从柱子顶端滑出移到下一根柱子
     * (3) 盘子只能叠在比它大的盘子上
     * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子
     * 你需要原地修改栈
     * <p>
     * 示例1:
     * 输入：A = [2, 1, 0], B = [], C = []
     * 输出：C = [2, 1, 0]
     * <p>
     * 示例2:
     * 输入：A = [1, 0], B = [], C = []
     * 输出：C = [1, 0]
     * <p>
     * 提示:A中盘子的数目不大于14个
     *
     * @apiNote 思路：
     * 1.递归
     * 2.个人认为如果不看题解的话，这题确实写不出来，实在是太经典了。思路非常的好
     * 3.你知道可以利用B来作为辅助空间，但是实际写递归的时候真的是难
     * 4.当n=1时，A中只有一个盘子，那就直接取出来存C
     * 5.当n=2时，我们可以先把第一个小盘子存B，然后再拿出第二个比较大的盘子存C，然后在将B中的盘子存C
     * 6.当n=3时。。。同理，这就一个子问题构成了一个大的完整的问题，这就是递归啦
     */
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    /**
     * 递归
     */
    public static void move(int i, List<Integer> A, List<Integer> B, List<Integer> C) {
        //递归结束条件
        if (i == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        //A->B
        move(i - 1, A, C, B);
        //A中此时最大的移到C中
        C.add(A.remove(A.size() - 1));
        //B->C
        move(i - 1, B, A, C);
    }

    public static void main(String[] args) {

    }
}

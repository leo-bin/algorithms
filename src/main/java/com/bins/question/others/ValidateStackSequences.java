package com.bins.question.others;

import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/8/25 23:54
 * @apiNote 验证栈序列
 * 来源：leetcode-946
 * 链接：https://leetcode-cn.com/problems/validate-stack-sequences/
 */
public class ValidateStackSequences {

    /**
     * 题目描述：
     * 1.给定 pushed和 popped 两个序列
     * 2.每个序列中的值都不重复
     * 3.只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true
     * 4.否则，返回 false
     * <p>
     * 示例 1：
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * <p>
     * 示例 2：
     * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     * 输出：false
     * 解释：1 不能在 2 之前弹出。
     * <p>
     * 提示：
     * 0 <= pushed.length == popped.length <= 1000
     * 0 <= pushed[i], popped[i] < 1000
     * pushed 是 popped 的排列
     *
     * @apiNote 思路：
     * 1.使用栈来模拟这一过程就行
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int n : pushed) {
            stack.push(n);
            while (i < popped.length && !stack.isEmpty() && stack.peek() == popped[i]) {
                i++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

    }
}

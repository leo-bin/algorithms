package com.bins.bishi.autumn2020.wanmeishijie;

import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/8/25 17:43
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述：
     * 小明最近遇到一个问题
     * 已知入栈序列 pushList 和 出栈序列popList （序列中不存在重复的值，两序列长度相同）
     * 如果popList 是pushList 的可行出栈序列返回 true；否则，返回 false
     * 请编写程序帮助小明解决问题。
     * <p>
     * 示例 1：
     * 输入：pushList  = [1,2,3,4,5], popList  = [4,5,3,2,1]
     * <p>
     * 输出：true
     * <p>
     * 解释：我们可以按以下顺序执行：
     * <p>
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * <p>
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * <p>
     * 示例 2：
     * 输入：pushList  = [1,2,3,4,5], popList  = [4,3,5,1,2]
     * 输出：false
     * <p>
     * 解释：1 不能在 2 之前弹出。
     * 输入描述
     * 入栈序列，出栈序列
     * <p>
     * 输出描述
     * 出栈序列是否入栈序列的合法出栈顺序是输出true,不是输出false
     * 样例输入
     * 5
     * 1
     * 2
     * 3
     * 4
     * 5
     * 5
     * 1
     * 2
     * 3
     * 4
     * 5
     * 样例输出
     * true
     *
     * @apiNote 思路：
     * 1.使用栈来模拟
     * 2.
     */
    public static void main(String[] args) {
        int[] pushList = {1, 2, 3, 4, 5};
        int[] popList = {4, 5, 3, 2, 1};

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int n : pushList) {
            stack.push(n);
            while (j < popList.length && !stack.isEmpty() && stack.peek() == popList[j]) {
                j++;
                stack.pop();
            }
        }
        System.out.println(stack.isEmpty());
    }
}

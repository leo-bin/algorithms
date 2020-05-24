package com.bins.question.others;

import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/5/12 11:26
 * @apiNote 最小栈
 * 来源：leetcode-155
 * 链接：https://leetcode-cn.com/problems/min-stack
 */
public class MinStack {

    /**
     * 题目描述：
     * 1.设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
     * 2.push(x) —— 将元素 x 推入栈中。
     * 3.pop() —— 删除栈顶的元素。
     * 4.top() —— 获取栈顶元素。
     * 5.getMin() —— 检索栈中的最小元素
     * <p>
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * <p>
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     * <p>
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     * <p>
     * 提示：pop、top 和 getMin 操作总是在 非空栈 上调用
     */


    /**
     * 主栈
     */
    private Stack<Integer> mainStack;
    /**
     * 辅助栈
     */
    private Stack<Integer> secondStack;
    /**
     * 存储最小值
     */
    private int minElement = Integer.MAX_VALUE;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        mainStack = new Stack<>();
        secondStack = new Stack<>();
    }


    public void push(int x) {
        mainStack.push(x);
        //如果当前的x比最小值要小那就存入辅助栈并更新最小值
        if (x <= minElement) {
            secondStack.push(x);
            minElement = x;
        } else {
            secondStack.push(minElement);
        }
    }


    public void pop() {
        if (!mainStack.isEmpty()) {
            mainStack.pop();
            secondStack.pop();
        }
        if (secondStack.isEmpty()) {
            minElement = Integer.MAX_VALUE;
        } else {
            minElement = secondStack.peek();
        }
    }


    public int getMin() {
        return minElement;
    }


    public static void main(String[] args) {

    }
}
package com.bins.bishi.autumn2020.tianyiyun;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/9/16 20:26
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述：
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈
     * push(x) -- 将元素 x 推入栈中
     * pop() -- 删除栈顶的元素
     * top() -- 获取栈顶元素
     * getMin() -- 检索栈中的最小元素
     * <p>
     * 输入描述:
     * 第一行输入一个数n，表示一共有n个操作
     * 接下来的n行，每一行表示push、pop、top、getMin中的一种
     * <p>
     * 输出描述:
     * 输出top和getMin的返回结果，每行一个
     * <p>
     * 示例1
     * 输入
     * 7
     * push -2
     * push 0
     * push -3
     * getMin
     * pop
     * top
     * getMin
     * <p>
     * 输出
     * -3
     * 0
     * -2
     *
     * @apiNote 思路：
     * 使用辅助栈来实现:只a了80%
     */

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    /**
     * push
     */
    public static void push(int x) {
        stack1.push(x);
        if (stack2.size() == 0) {
            stack2.push(x);
        } else {
            if (x < stack2.peek()) {
                stack2.push(x);
            } else {
                stack2.push(stack2.peek());
            }
        }
    }

    /**
     * pop
     */
    public static void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
            stack2.pop();
        }
    }

    /**
     * top
     */
    public static int top() {
        return stack1.peek();
    }

    /**
     * getMin
     */
    public static int getMin() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] strs = s.split(" ");
            String cur;
            int x = 0;
            if (strs.length >= 2) {
                cur = strs[0];
                x = Integer.parseInt(strs[1]);
            } else {
                cur = strs[0];
            }
            if (cur.equals("pop")) {
                pop();
            } else if (cur.equals("push")) {
                push(x);
            } else if (cur.equals("getMin")) {
                System.out.println(getMin());
            } else if (cur.equals("top")) {
                System.out.println(top());
            }
        }
    }
}

package com.bins.question.others;

import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/3/23 16:51
 * @apiNote 如何使用两个栈实现一个队列的pop和push
 * 1.我们要根据这两种数据结构的特点来分析这个题目
 * 2.首先是栈，它的特点就是所有的元素都是从栈顶出，栈顶进，也就是先进后出
 * 3.然后是队列，元素从队头出去，从队尾进去，先进先出
 * 4.根据这样的特点，我们可以设置两个栈，一个栈用来实现队列的pop（出队列），一个栈用来实现队列的push（入队列）
 */
public class Stack2Queue {

    /**
     * 用来实现出队列的栈A
     */
    private static Stack<Integer> STACK_A = new Stack<>();

    /**
     * 用来实现入队列的栈B
     */
    private static Stack<Integer> STACK_B = new Stack<>();


    /**
     * 入队列
     *
     * @apiNote 思路：
     * 1.新来元素直接入栈A
     */
    public static void push(int n) {
        //新来的元素直接入栈A
        STACK_A.push(n);
    }

    /**
     * 出队列
     *
     * @apiNote 思路：
     * 1.先判断栈B是否为空，为空说明没有元素可以出栈，不为空的话，说明，有元素，那就直接出栈
     * 2.接着判断栈A是否为空，如果栈A也为空的话说明实现的队列中没有任何元素，返回-1
     * 3.如果栈B为空，栈A不为空，那就将栈A中的元素依次入栈B（这里其实就是反序了）
     */
    public static int pop() {
        if (STACK_B.isEmpty()) {
            //两个栈都没有元素，直接返回-1
            if (STACK_A.isEmpty()) {
                return -1;
            }
            //将栈A中的元素转移到栈B中（根据栈的特点，这里就当与反序了）
            while (!STACK_A.isEmpty()) {
                STACK_B.push(STACK_A.pop());
            }
        }
        return STACK_B.pop();
    }


    public static void main(String[] args) {
        //构造测试用例
        //1.第一种情况：依次将元素（1，2，3）入队列，然后执行一次出队列操作,预测结果是输出：1
        /*for (int i = 1; i <= 3; i++) {
            push(i);
        }
        System.out.println("队列(1，2，3)，出队列的结果是：" + pop());*/

        //2.第二种情况：依次将元素（1，2，3）入队列，然后执行1次出队列操作，然后再将元素4入队列，再执行出队列操作，预测结果是：1，2,3,4
        /*for (int i = 1; i <= 3; i++) {
            push(i);
        }
        System.out.println("队列(1,2,3)，出队列的结果是：" + pop());
        push(4);
        System.out.println("队列(2,3,4)，出队列的结果是：" + pop());
        System.out.println("队列(3,4)，出队列的结果是：" + pop());
        System.out.println("队列(4)，出队列的结果是：" + pop());*/

        //第三种情况：直接执行出队列操作，预测输出：-1
        System.out.println("队列：（），出队列的结果是：" + pop());
    }
}

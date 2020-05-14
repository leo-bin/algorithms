package com.bins.question.others;

import java.util.Arrays;
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
     * 使用数组存储所有的元素
     */
    private Integer[] elementData;


    /**
     * 统计数组中存在的元素个数
     */
    private int count;

    /**
     * 栈的容量
     */
    private int capacity;


    /**
     * 默认的数组大小
     */
    private static final int DEFAULT_CAPACITY = 1024;


    //////////////////////自己实现一个普通的栈的基本方法/////////////////////////

    /**
     * 往数组中的最后一个位置增加数组
     */
    private void add(int e) {
        //先判断是否需要扩容
        ensureCapacityHelper(count + 1);
        elementData[count++] = e;
    }


    /**
     * 根据下标删除元素
     */
    private void removeElementAt(int index) {
        if (index < 0 || index > count) {
            return;
        }
        int j = count - index - 1;
        //
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        count--;
        //交给gc解决删除最后一个元素的问题
        elementData[count] = null;
    }


    /**
     * 判断当前栈的容量是否达到了初试的容量，达到了就进行扩容
     */
    private void ensureCapacityHelper(int minCapacity) {
        //大于成立则需要扩容
        if (minCapacity - capacity > 0) {
            grow();
        }
    }


    /**
     * 防止你无限的分配下去，万一到最后OOM了呢？，这里设置为int的最大数-8最为临界值
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    /**
     * 扩容，扩容为原来的2倍
     */
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = 2 * oldCapacity;
        //如果太大了，就用默认的最大容量值
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = MAX_ARRAY_SIZE;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
        capacity = newCapacity;
    }


    /////////////////////////还是使用现成的数据结构吧。。。。/////////////////////////////

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


    public int top() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法！");
    }


    public int getMin() {
        return minElement;
    }


    public static void main(String[] args) {

    }
}
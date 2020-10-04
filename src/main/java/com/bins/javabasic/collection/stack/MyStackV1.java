package com.bins.javabasic.collection.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author leo-bin
 * @date 2020/5/14 22:43
 * @apiNote 使用数组实现一个栈(这也是jdk中的具体实现)
 * 思路：
 * 1.其实数组非常的适合实现栈，这就是为什么jdk使用数组来作为栈的基本数据结构
 * 2.当我们要往栈中push一个元素时，只需要往数组的最后一个位置放就行
 * 3.同时还需要维护一个count变量，用来记录元素的个数
 * 4.当我们要peek一个元素的时候，只需要取数组的最后一个元素就行了
 * 5.当我们要pop时，只需要先通过peek拿到栈头元素，然后删除掉这个元素即可
 * 6.本实现的难点在于我们在push的时候还需要维护数组的扩容
 * 7.扩容其实也不难，判断下条件，使用Arrays.copyOf()就行
 */
public class MyStackV1 {

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
    private static final int DEFAULT_CAPACITY = 32 << 2;


    public MyStackV1(int capacity) {
        this.capacity = capacity;
        elementData = new Integer[capacity];
    }

    public MyStackV1() {
        //给默认的容量：1024
        this(DEFAULT_CAPACITY);
    }


    /**
     * push
     */
    public int push(int item) {
        add(item);
        return item;
    }


    /**
     * pop
     */
    public int pop() {
        //先拿出来然后再删掉
        int obj = peek();
        removeElementAt(count - 1);
        return obj;
    }

    /**
     * size
     */
    public int size() {
        return count;
    }


    /**
     * peek
     */
    public int peek() {
        //拿到当前数组的长度
        //判空
        if (count == 0) {
            throw new EmptyStackException();
        }
        //pop最后一个出去
        return elementData[count - 1];
    }


    /**
     * isEmpty
     */
    public boolean isEmpty() {
        return count == 0;
    }


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
        //移动数组(这里是使用了底层的一个库函数，大概就是将原来的数组复制到新的数组中来实现删除功能)
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
     * 防止你无限的分配下去，万一到最后OOM了呢？，这里设置为int的最大数-8作为临界值
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

    ///////////////////////////end////////////////////////////////////////////


    public static void main(String[] args) {
        MyStackV1 stack = new MyStackV1();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}

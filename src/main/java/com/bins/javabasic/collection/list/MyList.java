package com.bins.javabasic.collection.list;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/10/4 15:41
 * @apiNote 手写一个ArrayList
 */
public class MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private static int count = 0;
    private static final int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

    public MyList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("初始容量参数不正确！" + capacity);
        }
    }

    /**
     * 添加元素
     *
     * @param e 元素
     * @return 是否添加成功
     */
    public boolean add(E e) {
        //判断是否需要进行扩容
        if (count >= elements.length) {
            grow();
        }
        elements[count++] = e;
        return true;
    }

    /**
     * 根据元素下标查找具体的元素
     *
     * @param index 下标
     * @return 结果
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        //防止越界
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("下标错误！" + index);
        }
        return (E) elements[index];
    }

    /**
     * 根据元素来删除
     *
     * @param e 要删除的元素
     * @return 是否删除成功
     */
    public boolean remove(E e) {
        //寻找被删除元素
        for (int i = 0; i < count; i++) {
            if (e.equals(elements[i])) {
                //使用数组之间的复制实现删除具体的元素
                int numCopy = count - i - 1;
                if (numCopy > 0) {
                    System.arraycopy(elements, i + 1, elements, i, numCopy);
                }
                elements[--count] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * 扩容
     */
    private void grow() {
        int oldCapacity = elements.length;
        //1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //确保不超过最大数组分配长度
        if (newCapacity < MAX_ARRAY_LENGTH) {
            throw new IllegalArgumentException("已经达到数组的最大分配长度!" + MAX_ARRAY_LENGTH);
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }
}

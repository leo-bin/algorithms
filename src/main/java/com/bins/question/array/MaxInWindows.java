package com.bins.question.array;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author leo-bin
 * @date 2020/4/20 18:15
 * @apiNote 滑动窗口的最大值
 */
public class MaxInWindows {


    /**
     * 题目描述：
     * 1.给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
     * 2.例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口
     * 3.他们的最大值分别为{4,4,6,6,6,5}
     * 4.针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个
     * 5.{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}
     * 6.{2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
     *
     * @apiNote 思路：
     * 1.使用一个优先级队列存放每一个滑动窗口（大顶堆）
     * 2.这个时候的队头一定是最大值
     * 3.我们按照顺序以第一组滑动窗口的数据集构造一个大顶堆
     * 4.然后按顺序一个一个的往队列中加元素
     * 5.每加一次，先将堆顶元素存list，然后剔除掉队列中过期的元素，然后再加一个元素进去
     * 6.时间复杂度：O(n*k)(k为滑动窗口的数量)
     * 7.空间复杂度：O(n)
     */
    public static ArrayList<Integer> maxInWindows(int[] nums, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        if (size > nums.length || size <= 0) {
            return list;
        }
        //1.构造一个大顶堆
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int count = 0;
        //2.第一组滑动窗口入队列
        for (; count < size; count++) {
            maxQueue.offer(nums[count]);
        }
        //3.调整队列
        while (count < nums.length) {
            //先将堆顶（最大值）元素存list
            list.add(maxQueue.peek());
            //删掉过期的元素（就是已经不在当前的窗口中的元素）
            maxQueue.remove(nums[count - size]);
            //往队列中增加下一个元素
            maxQueue.add(nums[count]);
            count++;
        }
        //4.最后一个滑动窗口还没来得及出队列
        list.add(maxQueue.peek());
        return list;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> list = maxInWindows(nums, 3);
        System.out.println(list.toString());
    }
}

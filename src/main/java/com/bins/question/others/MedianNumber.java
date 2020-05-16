package com.bins.question.others;

import java.util.PriorityQueue;

/**
 * @author leo-bin
 * @date 2020/4/26 9:30
 * @apiNote 数据流中的中位数
 * 题目描述：
 * 1.如何得到一个数据流中的中位数？
 * 2.如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值
 * 3.如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
 * 4.我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
 * <p>
 * 思路：
 * 1.如何快速求一段序列的中位数，但是不是采用直接排序的方式？
 * 2.假设有这样一个序列：1，2，3，4，显然中位数是(2+3)/2，可以怎么求呢？
 * 3.我们把原序列分成两个部分，一个部分中的所有数要小于另外一个部分的所有数：1，2和3，4
 * 4.然后第一个部分按照从大到小来排
 * 2  3
 * 1  4
 * 5.显然中位数就等于两个序列的第一个数的平均值
 * 6.通过这个思想，我们可以用大顶堆和小顶堆来实现
 */
public class MedianNumber {


    /**
     * 小顶堆，存放序列中比较大的值
     */
    private static PriorityQueue<Integer> minQueue = new PriorityQueue<>();

    /**
     * 大顶堆，存放序列中比较小的值
     */
    private static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));

    /**
     * 统计序列的长度
     */
    private static int count = 0;


    /**
     * @apiNote 思路：
     * 1.我们使用奇数和偶数来控制存放的顺序，说白了就是一人一次
     * 2.但是在存小顶堆的时候，需要将自己堆顶的元素存大顶堆
     * 3.存大顶堆的时候需要将自己堆顶的元素存小顶堆
     * 4.时间复杂度：O(logn)
     * 5.空间复杂度：O(n)
     */
    public static void insert(Integer num) {
        if (num != null) {
            if ((count & 1) == 0) {
                maxQueue.add(num);
                Integer max = maxQueue.poll();
                minQueue.add(max);
            } else {
                minQueue.add(num);
                Integer min = minQueue.poll();
                maxQueue.add(min);
            }
            count++;
        }
    }


    /**
     * @apiNote 思路：
     * 1.根据目前的队列的大小，决定出对列的个数
     * 2.比如说现在队列是：1，2，3，4，5
     * 3.我们要求的中位数就是3
     * 4.len=5，所以出队列的个数：5/2=2，分别将1，2出队列
     * 5.剩下第一个元素就是中位数
     * 6.时间复杂度：O(1)
     */
    public static Double getMedian() {
        if ((count & 1) == 0 && !minQueue.isEmpty() && !maxQueue.isEmpty()) {
            return ((minQueue.peek() + maxQueue.peek()) * 1.0 / 2);
        } else if ((count & 1) == 1 && !minQueue.isEmpty()) {
            return minQueue.peek() * 1.0;
        }
        return null;
    }


    public static void main(String[] args) {
        int n = 5 + 1;
        for (int i = 1; i <= n; i++) {
            insert(i);
        }
        System.out.println(getMedian());
    }
}

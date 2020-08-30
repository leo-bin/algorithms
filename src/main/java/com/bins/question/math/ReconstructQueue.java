package com.bins.question.math;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author leo-bin
 * @date 2020/8/30 11:56
 * @apiNote 根据身高重建队列
 * 来源：leetcode-406
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 */
public class ReconstructQueue {

    /**
     * 题目描述：
     * 1.假设有打乱顺序的一群人站成一个队列。
     * 2.每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数
     * 3.编写一个算法来重建这个队列。
     * <p>
     * 注意：
     * 总人数少于1100人
     * <p>
     * 示例
     * 输入:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * <p>
     * 输出:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     *
     * @apiNote 思路：
     * 1.这道题太考思路了，贪心可解
     * 2.时间复杂度：O(n*n)
     * 3.空间复杂度：O(n)
     */
    public static int[][] reconstructQueue(int[][] people) {
        //先按照身高降序排，遇到身高相同的按照k升序排
        Arrays.sort(people, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
        //现在直接按照k来插入就行
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(people);
    }


    public static void main(String[] args) {

    }
}

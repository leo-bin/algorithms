package com.bins.question.others;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/7/16 8:37
 * @apiNote 合并区间
 * 来源：leetcode-56
 * 链接：https://leetcode-cn.com/problems/merge-intervals/
 */
public class Merge {

    /**
     * 题目描述：
     * 1.给出一个区间的集合
     * 2.请合并所有重叠的区间
     * <p>
     * 示例 1:
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
     * <p>
     * 示例 2:
     * <p>
     * <p>
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间
     *
     * @apiNote 思路：
     * 1.我觉得这个题目的难点不在于如何想到合并的条件
     * 2.我觉得对于我而言，难在如何进行合并。。。
     * 3.首先是最后的结果数组，需要提前生成，但是规格呢？
     * 4.而且，根据题目的提示，它说的是集合?不是区间？我能理解为一个区间的所有元素吗？
     * 5.但是这样一想你会发现运算过程极其困难！
     * 6.之后看了题解才知道，哦，原来说的就是区间！那列就可以确定是2了
     * 7.那行呢？难道只能先判断一遍，记录下合并之后的区间有多少？
     * 8.这样也太low了，之后看了题解才发现别人直接用的api来进行数组的复制？好吧，算我没想到！
     * 9.然后，最关键的就是，人家通过排序就去掉了一半的判断条件？我是真没想到还可以排序？
     * 10.最后的判断条件很简单了，这里就不多说了。
     * 11.时间复杂度：O(n*log(n))
     * 12.空间复杂度：O(1)
     */
    public static int[][] merge(int[][] intervals) {
        //先按照区间的起始位置进行排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] result = new int[intervals.length][2];
        int i = -1;
        for (int[] interval : intervals) {
            //如果结果数组为空或者当前区间的起始位置大于前一个区间的结束位置说明不需合并，直接记录
            if (i == -1 || interval[0] > result[i][1]) {
                result[++i] = interval;
            } else {
                result[i][1] = Math.max(interval[1], result[i][1]);
            }
        }
        //截取合并之后的数组
        return Arrays.copyOf(result, i + 1);
    }


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }
}

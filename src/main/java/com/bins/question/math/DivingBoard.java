package com.bins.question.math;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/7/8 10:42
 * @apiNote 跳水板
 * 来源：leetcode-面试题 16.11
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci/
 */
public class DivingBoard {

    /**
     * 题目描述：
     * 1.你正在使用一堆木板建造跳水板
     * 2.有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer
     * 3.你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度
     * 4.返回的长度需要从小到大排列
     * <p>
     * 输入：
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： {3,4,5,6}
     * <p>
     * 提示：
     * 0 < shorter <= longer
     * 0 <= k <= 100000
     *
     * @apiNote 思路：
     * 1.注意两种特殊测试用例就行
     * 2.其他的就是数学推导了，但是这里其实不用那么麻烦
     * 3.你可以自己去推导一下，最短的肯定是shorter*k,最长的就是longer*k
     * 4.而我们只需要从最短的开始，慢慢的加上一个longer就行
     * 5.写成公式就是：result[i]=(k-i)shorter+i*longer,其中i的范围是:[0,k]
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(1)
     */
    public static int[] divingBoard(int shorter, int longer, int k) {
        //特判
        if (k <= 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        //这里需要数学公式进行推导
        int[] result = new int[k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = (k - i) * shorter + i * longer;
        }
        return result;
    }


    public static void main(String[] args) {
        int shorter = 1;
        int longer = 2;
        int k = 3;
        int[] result = divingBoard(shorter, longer, k);
        System.out.println(Arrays.toString(result));
    }
}

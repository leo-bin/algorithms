package com.bins.question.others;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/8/17 10:23
 * @apiNote 颜色分类
 * 来源：leetcode-75
 * 链接：https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {

    /**
     * 题目描述：
     * 1.给定一个包含红色、白色和蓝色，一共 n 个元素的数组
     * 2.原地对它们进行排序，使得相同颜色的元素相邻
     * 3.并按照红色、白色、蓝色顺序排列
     * 4.此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
     * 5.不能使用代码库中的排序函数来解决这道题
     * <p>
     * 示例:
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * <p>
     * 进阶：
     * 一个直观的解决方案是使用计数排序的两趟扫描算法
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组
     * 你能想出一个仅使用常数空间的一趟扫描算法吗
     *
     * @apiNote 思路：
     * 1.一开始是想直接用排序的Arrays.sort
     * 2.但是看到不能用，那没事，我们自己写一个快排不就行了？
     * 3.但是呢，其实你仔细观察一下，总共就那么三个元素：0，1，2
     * 4.你统计一下出现次数然后按次数输出不就行了？
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(n)
     */
    public static void sortColors(int[] nums) {
        //统计0，1，2的出现次数
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //重写数组
        int index = 0;
        for (int i = 0; i <= 2; i++) {
            //按照顺序拿到颜色的出现次数
            if (map.containsKey(i)) {
                int colorCount = map.get(i);
                while (colorCount-- > 0) {
                    nums[index++] = i;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

package com.bins.algorithm.sort;

/**
 * @author leo-bin
 * @date 2020/4/26 17:18
 * @apiNote 选择排序
 */
public class SelectSort {

    /**
     * 选择排序
     *
     * @apiNote 思路：
     * 1.记住，选择排序，每一轮都是找到当前下标的最小值或者最大值
     * 2.时间复杂度：平均时间=最好情况=最差情况=O(n^2)
     * 3.不稳定排序
     */
    public static void selectSort(int[] target) {
        //第一层循环控制选择排序的轮次
        for (int i = 0; i < target.length - 1; i++) {
            //第二层循环控制每一轮循环比较的次数
            for (int j = i + 1; j < target.length; j++) {
                //默认是从小到大排序，如果是从大到小，这里应该改成小于
                if (target[i] > target[j]) {
                    int temp = target[i];
                    target[i] = target[j];
                    target[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {

    }
}

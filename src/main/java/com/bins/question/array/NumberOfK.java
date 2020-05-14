package com.bins.question.array;

/**
 * @author leo-bin
 * @date 2020/4/27 11:27
 * @apiNote 数字k出现的次数
 */
public class NumberOfK {


    /**
     * 题目描述:
     * 1.统计一个数字在排序数组中出现的次数
     * 元素      {1,2,2,2,3,4}
     * 对应下标： 0,1,2,3,4,5
     *
     * @apiNote 思路：
     * 1.因为数组是有序的，所以
     * 2.2出现的次数=(最后一个二出现的位置-第一个2出现的位置)+1=(3-1)+1=3
     * 3.如何实现快速查找呢？答案是二分！
     * 4.我们只要稍微改写一下二分查找算法
     * 5.分别找到这个数字出现的第一个位置和最后一个位置就行
     * 6.时间复杂度：O(log(n))
     * 7.空间复杂度：O(1)
     */
    public static int getNumberOfK(int[] array, int k) {
        //鲁棒
        if ((array.length == 0)) {
            return 0;
        }
        int firstIndex = getFirstK(array, k);
        int lastIndex = getLastK(array, k);
        return (lastIndex >= 0) && (firstIndex >= 0) ? (lastIndex - firstIndex) + 1 : 0;
    }


    /**
     * @apiNote 思路：
     * 1.二分查找，找第一个数字
     * 2.在找到这个数字的时候，从左边开始，依次比较，直到找到第一个不同的数，返回当前的下标
     * 3.时间复杂度：O(log(n))
     */
    public static int getFirstK(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (k == array[mid]) {
                //往左边找
                while (mid >= 0) {
                    if (mid - 1 >= 0 && k == array[mid - 1]) {
                        mid--;
                    } else {
                        return mid;
                    }
                }
            } else if (k > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * @apiNote 思路：
     * 1.二分查找，找最后一个数字
     * 2.在找到这个数字的时候，从右边开始，依次比较，直到找到最后一个不同的数，返回当前的下标
     * 3.时间复杂度：O(log(n))
     */
    public static int getLastK(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (k == array[mid]) {
                //从右边开始找
                while (mid < array.length) {
                    if (mid + 1 < array.length && k == array[mid + 1]) {
                        mid++;
                    } else {
                        return mid;
                    }
                }
            } else if (k > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3, 4};
        int k = 2;
        System.out.println(getNumberOfK(array, k));
    }
}

package com.bins.algorithm.sort;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/21 21:05
 * @apiNote 堆排序
 * 1.先构建一个二叉堆（看情况，如果是要按照从小到大那就构建大顶堆，反之则是小顶堆）
 * 2.循环整个数组，第i次循环将堆顶元素和数组的length-1-i交换
 * 3.交换完之后做一次下沉操作
 */
public class HeapSort {

    /**
     * 下沉操作(大顶堆)
     *
     * @param nums        下沉数组
     * @param parentIndex 下沉的第一个父节点
     * @param len         数组长度
     */
    public static void downAdjust(int[] nums, int parentIndex, int len) {
        //暂存这个父节点元素
        int tmp = nums[parentIndex];
        //找到该父节点的左孩子的下标
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < len) {
            if (childIndex + 1 < len && nums[childIndex + 1] > nums[childIndex]) {
                childIndex++;
            }
            if (tmp > nums[childIndex]) {
                break;
            }
            nums[parentIndex] = nums[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        nums[parentIndex] = tmp;
    }


    /**
     * 堆排序
     *
     * @apiNote 思路：
     * 1.先根据数组构建一个二叉堆
     * 2.遍历这个二叉堆，每次都把堆顶元素和数组的最后一个数组进行交换
     * 3.每交换一次，进行一次下沉操作，调整当前的二叉堆
     * 4.遍历完毕之后当前的数组就会是一个根据从小到大排序的数组
     * 5.这是因为每次交换下沉都把数组的最大的元素放在了数组的最后的位置（<-7，8，9，10）
     * 6.时间复杂度：O(n*logn)
     * 7.空间复杂度：O(1)
     */
    public static void heapSort(int[] nums) {
        //1.构建一个大顶堆
        for (int i = (nums.length - 2) / 2; i >= 0; i--) {
            downAdjust(nums, i, nums.length);
        }
        System.out.println("中途构建好的二叉堆为：" + Arrays.toString(nums));
        //2.循环构建好的二叉堆数组
        for (int i = nums.length - 1; i > 0; i--) {
            //交换
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            //下沉
            downAdjust(nums, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 5, 7, 6, 8, 3, 9};
        System.out.println("原来的数组为：" + Arrays.toString(nums));
        heapSort(nums);
        System.out.println("经过堆排序之后的数组为：" + Arrays.toString(nums));
    }
}

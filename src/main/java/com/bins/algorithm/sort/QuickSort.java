package com.bins.algorithm.sort;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/19 1:43
 * @apiNote 快速排序
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @apiNote 快速排序的基本思想就是：
     * 1.任意选取一个元素作为枢轴，（也就是中心轴，一般选取第一个元素）
     * 2.将所有比枢轴小的元素移到它的左边，将所有比它大的元素移到它的右边，得到一个左边序列都是小于枢轴，右边序列都是大于枢轴的序列
     * 3.这就是一趟快速排序
     * 4.接下来，在以递归的方式分别对左边的序列进行一趟快速排序，右边也是，最后得到一个有序表
     * <p>
     * 时间复杂度：
     * 情况最好：O(n*log(n))
     * 情况最差：O(n^2)
     * 空间复杂度：O(log(n))
     */
    public static void quickSort(int[] nums, int left, int right) {
        //1.递归结束条件
        if (left >= right) {
            return;
        }
        //2.进行分治，得到中轴
        int midIndex = partition(nums, left, right);
        //3.根据得到的中轴，分别对除中轴元素之外的两边区间进行递归
        quickSort(nums, left, midIndex - 1);
        quickSort(nums, midIndex + 1, right);
    }


    /**
     * 分治
     *
     * @apiNote 思路：
     * 1.对数组进行一次简单排序
     * 2.找到一个数，保证这个数的前面都是比它小的，它的后面都是比它大
     * 3.可以选此时的left指向的元素，也可以随机从[left,right]区间中随机选一个
     * 4.如果选择前者，可能会遇到某种极端的测试用例，比如说第一个[4,3,2,1,0]
     * 5.你会每次都选到了最大值！在分治的算法里，需要对所有元素都遍历一遍，时间复杂度从O(log(n)0上升到了O(n)
     * 6.如果选择后者，毕竟是随机吗，每次都选到最大值的几率肯定会小，所以快排的最坏情况下是不可避免的！
     */
    public static int partition(int[] nums, int left, int right) {
        //1.选择中轴元素
        int midValue = nums[left];
        int midIndex = left;
        while (left != right) {
            while (left < right && nums[right] > midValue) {
                right--;
            }
            while (left < right && nums[left] <= midValue) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        //之前需要把中轴和left指向的元素进行一次交换（因为之前第二个while循环中，中轴无条件跳过了，也就是说第一个元素没有比较）
        nums[midIndex] = nums[left];
        nums[left] = midValue;
        //将left返回就行（此时的left就是中轴所在的位置）
        return left;
    }

    /**
     * 交换
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 4, 1, 6, 5};
        quickSort(nums, 0, nums.length - 1);
        System.out.println("快速排序之后的数组为：" + Arrays.toString(nums));
    }
}

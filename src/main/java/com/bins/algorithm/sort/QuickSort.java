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
     * 情况最好：O(n*log^n)
     * 情况最差：O(n^2)
     * 平均：O(n*log^n)
     * 空间复杂度：O(1)
     */
    public static void quickSort(int[] nums, int left, int right) {
        //递归结束条件
        if (left >= right) {
            return;
        }
        //1.一次分治，找到一个中轴
        int pivot = partition(nums, left, right);
        //2.对中轴左边的元素进行一次分治
        quickSort(nums, left, pivot - 1);
        //3.对中轴右边的元素进行一次分治
        quickSort(nums, pivot + 1, right);
    }

    /**
     * 一次分治
     *
     * @apiNote 思路：
     * 1.对数组进行一次简单排序
     * 2.找到一个数，保证这个数的前面都是比它小的，它的后面都是比它大
     */
    public static int partition(int[] nums, int left, int right) {
        //以第一个元素作为中轴
        int pivot = nums[left];
        //记录中轴的下标
        int pivotIndex = left;
        while (left != right) {
            //right指针指向的元素比中轴要大，右指针左移，继续比较
            while (left < right && nums[right] > pivot) {
                right--;
            }
            //left指针指向的元素比中轴要小，左指针右移，继续比较
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            //跳出循环表示左指针和右指针指向的元素需要进行交换
            swap(nums, left, right);
        }
        //之前需要把中轴和left指向的元素进行一次交换（因为之前第二个while循环中，中轴无条件跳过了，也就是说第一个元素没有比较）
        nums[pivotIndex] = nums[left];
        nums[left] = pivot;
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

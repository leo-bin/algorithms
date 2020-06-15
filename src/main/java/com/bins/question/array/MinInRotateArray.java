package com.bins.question.array;

/**
 * @author leo-bin
 * @date 2020/6/15 9:57
 * @apiNote 旋转数组中的最小值
 * 来源：leetcode-153
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class MinInRotateArray {

    /**
     * 题目描述：
     * 1.假设按照升序排序的数组在预先未知的某个点上进行了旋转
     * 2.例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
     * 3.请找出其中最小的元素
     * 4.你可以假设数组中不存在重复元素
     * <p>
     * 示例 1:
     * 输入: [3,4,5,1,2]
     * 输出: 1
     * <p>
     * 示例 2:
     * 输入: [4,5,6,7,0,1,2]
     * 输出: 0
     *
     * @apiNote 思路：
     * 1.二分思想
     * 2.本题的难点就在于没有给出一个target值给我们去做二分查找
     * 3.也就是说我们需要自己找一个相对的元素去完成二分查找
     * 4.我们可以用mid值分别和low和high指向的值进行比较
     * 5.一个旋转数组无非就是两段有序数组，第一段的所有元素都要大于第二段
     * 6.我们只要找到第一段和第二段的临界点，这个临界点就是整个数组的最小值！
     * 7.时间复杂度：O(log(n))
     * 8.空间复杂度：O(1)
     */
    public static int findMin(int[] nums) {
        //特判
        if (nums.length <= 0) {
            return -1;
        }
        int low = 0, mid, high = nums.length - 1;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums1));
        System.out.println(findMin(nums2));
    }
}

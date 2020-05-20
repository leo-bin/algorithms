package com.bins.bishi.yuewen;


/**
 * @author leo-bin
 * @date 2020/5/19 18:58
 * @apiNote 第一题
 */
public class Main1 {


    /**
     * @param arr int整型一维数组
     * @param a   int整型 要查找的数字
     * @return int整型
     */
    public int binarySearch(int[] arr, int a) {
        StringBuilder strs = arr2String(arr);
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a == arr[mid]) {
                int index = strs.indexOf(String.valueOf(a));
                return index < mid ? index : mid;
            } else if (a > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }



    public static StringBuilder arr2String(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int n : arr) {
            builder.append(n);
        }
        return builder;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4};
    }

}

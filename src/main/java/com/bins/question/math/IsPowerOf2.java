package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/3/24 17:07
 * @apiNote 是否为2的整数幂
 */
public class IsPowerOf2 {

    /**
     * 判断一个数是否为2的整数幂（解法一）
     *
     * @apiNote 思路：
     * 1.设置一个变量tmp
     * 2.让这个tmp不断的*2并且和target比较
     * 3.相等说明是，反之说明不是
     * 4.时间复杂度：O(logn)
     * 5.空间复杂度：O(1)
     */
    public static boolean isPowerOf2(int target) {
        if (target == 0) {
            return false;
        }
        int tmp = 1;
        while (tmp <= target) {
            if (tmp == target) {
                return true;
            }
            tmp = 2 * tmp;
        }
        return false;
    }


    /**
     * 判断是否为2的整数幂（解法二）
     *
     * @apiNote 思路：
     * 1.这里有个小技巧
     * 2.任何2的幂次方的数的二进制都是：          10，100，1000这种形式
     * 3.所以我们再将这些二进制数-1，就会变成：    01，011，0111这种形式
     * 4.最后我们只要将这两种结果进行与运算，发现:  01&10 = 100&011 = 1000&0111 =0
     * 5.时间复杂度：O(1)
     * 6.空间复杂度：O(1)
     */
    public static boolean isPowerOf2V2(int target) {
        if (target == 0) {
            return false;
        }
        return (target & (target - 1)) == 0;
    }


    public static void main(String[] args) {
        int target1 = 16;
        int target2 = 32;
        int target3 = 24;
        System.out.println("///////////////////////解法一：///////////////////////////");
        System.out.println("数字" + target1 + "是否是2的整数幂：" + isPowerOf2(target1));
        System.out.println("数字" + target2 + "是否是2的整数幂：" + isPowerOf2(target2));
        System.out.println("数字" + target3 + "是否是2的整数幂：" + isPowerOf2(target3));
        System.out.println("\n");
        System.out.println("///////////////////////解法二：///////////////////////////");
        System.out.println("数字" + target1 + "是否是2的整数幂：" + isPowerOf2V2(target1));
        System.out.println("数字" + target2 + "是否是2的整数幂：" + isPowerOf2V2(target2));
        System.out.println("数字" + target3 + "是否是2的整数幂：" + isPowerOf2V2(target3));
    }
}

package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/9/29 15:15
 * @apiNote 数字1的个数
 * 来源：leetcode-233
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one/
 */
public class CountDigitOne {

    /**
     * 题目描述：
     * 1.给定一个整数 n
     * 2.计算所有小于等于n的非负整数中数字1出现的个数
     * <p>
     * 示例:
     * 输入: 13
     * 输出: 6
     * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.暴力超时了
     */
    public static int countDigitOne(int n) {
        //特判
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(i);
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.假设我们的数字是xyzdabc
     * 2.其中d可以是任意一位（个十白千。。。）
     * 3.假设目前是4560234
     * 4.那么我们先考虑千位，也就是d=0，那么这个时候xyz可以取：0-455(456个)，abc可以取：0-999（1000个数）
     * 5.假设是4551000-4551999（1000个数字）
     * 6.那么一共就有456*1000个可能
     * 7.假设d=1，那么其实xyz还可以取到456，那么此时的abc就可以取到：0-abc（abc+1个数）
     * 8.假设d>1,那么其实xyx还可以取到456，此时的abc可以取到：0-999（1000个数）
     * 9.所以我们只需要从低位到高位遍历一遍，根据具体的情况考虑就行
     * 10.时间复杂度：O(n)
     * 11.空间复杂度：O(1)
     */
    public static int countDigitOneV2(int n) {
        int count = 0;
        for (long k = 1; k <= n; k *= 10) {
            long abc = n % k;
            long xyzd = n / k;
            long d = xyzd % 10;
            long xyz = xyzd / 10;
            count += xyz * k;
            if (d > 1) {
                count += k;
            }
            if (d == 1) {
                count += abc + 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int n = 13;
        System.out.println(countDigitOne(n));
    }
}

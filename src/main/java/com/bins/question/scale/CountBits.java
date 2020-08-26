package com.bins.question.scale;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/8/26 11:25
 * @apiNote 比特位计数
 * 来源：leetcode-338
 * 链接：https://leetcode-cn.com/problems/counting-bits/
 */
public class CountBits {

    /**
     * 题目描述：
     * 1.给定一个非负整数 num
     * 2.对于 0 ≤ i ≤ num 范围中的每个数字 i
     * 3.计算其二进制数中的 1 的数目并将它们作为数组返回。
     * <p>
     * 示例 1:
     * 输入: 2
     * 输出: [0,1,1]
     * <p>
     * 示例 2:
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     * <p>
     * 进阶:
     * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
     * 要求算法的空间复杂度为O(n)
     * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作
     *
     * @apiNote 思路：
     * 1.先使用暴力解一下
     * 2.时间复杂度：O(32*n)
     * 3.空间复杂度：O(n)
     */
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = countOne(i);
        }
        return result;
    }

    /**
     * 通过移位运算统计二进制中1的个数
     */
    public static int countOne(int n) {
        int flag = 1, count = 0;
        while (flag > 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.除了上一个暴力解法之后确实想不到其他解法了
     * 2.看了评论的题解之后发现可以通过找规律来发现一个递推公式
     * 3.我们可以分奇数和偶数去看
     * 4.对于一个偶数而言，假设是4，那么它的1的个数一定会等于自己除以2之后的结果的1的个数
     * 5.因为4/2=2，而2是10，4是100
     * 6.对于奇数而言，假设是3，那么它的1的个数就等于前一个数的1的个数+1
     * 7.因为2是10，3是11
     * 8.这样一来我们就可以通过类似于动态规划的手段求每一个子解就行
     * 9.时间复杂度：O(n)
     * 10.空间复杂度：O(n)
     */
    public static int[] countBitsV2(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = (i & 1) == 0 ? result[i / 2] : result[i - 1] + 1;
        }
        return result;
    }


    public static void main(String[] args) {
        int num = 2;
        int[] result1 = countBits(num);
        System.out.println(Arrays.toString(result1));
        int[] result2 = countBitsV2(num);
        System.out.println(Arrays.toString(result2));
    }
}

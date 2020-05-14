package com.bins.bishi.duxiaoman;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/20 14:56
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.在机器学习中有一种流行的池化操作，而在池化操作中，3*3极大值池化应用十分广泛
     * 2.什么是3*3极大值池化呢？
     * 3.设原矩阵是n*m的，则3*3极大值池化就是枚举矩阵中的所有3*3的子矩阵
     * 4.分别求最大值并顺次拼接而成，处理过后的矩阵是(n-2)*(m-2)。
     * 5.例如，原矩阵是[[1,2,3,4],[5,6,7,8],[9,10,11,12]],经过池化之后就变成[[11,12]]。
     * 6.为了提高难度，选择的滑动窗口并不是3*3的，而是a*b的
     * 7.由于输入可能是非常大的，原n*m的矩阵权值由以下公式计算得到，h(i,j)=i*j mod 10。(1<=i<=n,1<=j<=m)
     * 8.由于输出矩阵也是一个很麻烦的事情，因此你只需输出经过a*b池化处理后的矩阵的元素之和即可。
     * <p>
     * 输入
     * 输入第一行包含四个正整数，n,m,a,b，分别表示原矩阵的行列数量和滑动窗口的行列数量。(1<=n,m,a,b<=1000)
     * <p>
     * 输出
     * 输出仅包含一个整数，即新矩阵的元素之和。
     * <p>
     * <p>
     * 样例输入
     * 4 5 3 3
     * 样例输出
     * 54
     *
     * @apiNote 思路：
     * 1.
     */
    public static int sum(int[][] nums, int a, int b) {
/*        int x = nums.length;
        int y = nums[0].length;
        int startLeft = 0;
        int endLeft = a;
        int startDown = 0;
        int endDown = b;
        int max;
        int sum = 0;
        Arrays.sort(nums);
        while (endX >= y && endY >= x) {
            //右滑
            if (endY < y) {
                max = Integer.MIN_VALUE;
                for (int i = start; i < endX; i++) {
                    max = Math.max(max, nums[i][endY - 1]);
                }
                sum += max;
                endY++;
            }
            //下滑
            if (endX < x) {
                start++;
                max = Integer.MIN_VALUE;
                for (int j = start; j < endX; j++) {
                    max = Math.max(max, nums[j][endX - 1]);
                }
                sum += max;
            }
        }
        return sum;*/
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                nums[i][j] = i * j % 10;
            }
        }
        System.out.println(sum(nums, a, b));
    }
}

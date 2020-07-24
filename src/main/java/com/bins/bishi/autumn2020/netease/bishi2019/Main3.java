package com.bins.bishi.autumn2020.netease.bishi2019;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/24 11:49
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述：
     * 1.又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
     * 2.牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
     * 3.在果园里有N堆苹果，每堆苹果的数量为ai
     * 4.小易希望知道从左往右数第x个苹果是属于哪一堆的。
     * 5.牛牛觉得这个问题太简单，所以希望你来替他回答。
     * <p>
     * 输入描述:
     * 第一行一个数n(1 <= n <= 10^5)。
     * 第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
     * 第三行一个数m(1 <= m <= 10^5)，表示有m次询问。
     * 第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
     * <p>
     * 输出描述:
     * m行，第i行输出第qi个苹果属于哪一堆。
     * <p>
     * 输入例子1:
     * 5
     * 2 7 3 4 9
     * 3
     * 1 25 11
     * <p>
     * 输出例子1:
     * 1
     * 5
     * 3
     *
     * @apiNote 思路：
     * 1.前缀和+二分查找
     * 2.
     */
    public static int code(int[] apples, int q) {
        int left = 1, right = apples.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (q == apples[mid]) {
                return mid;
            } else if (q > apples[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] apples = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            apples[i] = scanner.nextInt() + apples[i - 1];
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int q = scanner.nextInt();
            System.out.println(code(apples, q));
        }
    }
}

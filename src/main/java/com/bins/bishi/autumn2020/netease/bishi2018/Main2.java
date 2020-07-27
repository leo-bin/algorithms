package com.bins.bishi.autumn2020.netease.bishi2018;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/27 11:45
 * @apiNote
 */
public class Main2 {

    /**
     * 1.牛牛以前在老师那里得到了一个正整数数对(x, y)
     * 2.牛牛忘记他们具体是多少了
     * 3.但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
     * 4.牛牛希望你能帮他计算一共有多少个可能的数对。
     * <p>
     * 输入描述:
     * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
     * <p>
     * 输出描述:
     * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
     * <p>
     * 输入例子1:
     * 5 2
     * <p>
     * 输出例子1:
     * 7
     * <p>
     * 例子说明1:
     * 满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (k == 0) {
            System.out.println(n * n);
        }
        long count = 0;
        long temp;
        //思路：固定y，找x
        //  x/y>=k,说明y>k
        for (long y = k + 1; y <= n; y++) {
            // 假设n = a*y +b；在每个长度为y的区间里只有（y-k）个数模y余数>=k
            count += n / y * (y - k);
            temp = n % y;
            //再考虑余数b是否>=k
            if (temp >= k) {
                count += temp - k + 1;
            }
        }
        System.out.println(count);
    }
}

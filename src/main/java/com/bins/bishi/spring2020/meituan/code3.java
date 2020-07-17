package com.bins.bishi.spring2020.meituan;

import java.math.BigDecimal;

/**
 * @author leo-bin
 * @date 2020/3/26 19:16
 * @apiNote 第三题
 */
public class code3 {


    /**
     * 题目描述：
     * 1.有这么一个奇怪的符号：在一张正方形的纸上，有许多不同半径的圆。他们的圆心都在正方形的重心上（正方形的重心位于正方形两条对角线的交叉点上）。
     * 2.最大的圆的外面部分是白色的。最外层的圆环被涂成了黑色，接下来第二大的圆环被涂层白色，接下来第三大的圆环被涂层黑色。以此类推，例如下图。
     * 3.现在，给你这些圆的半径，请问黑色部分的面积是多少？精确到小数点后5位输出（四舍五入）。
     * 输入包含两行。第一行一个整数n，表示圆的个数。
     * 接下来n个整数，描述每个圆的半径ri。数据保证没有两个圆的半径是一样的。(1<=n<=100 , ri<=1000)
     * 输出
     * 输出包含一个数，代表黑色部分的面积。
     * 样例输入
     * 5
     * 1 2 3 4 5
     * 样例输出
     * 47.12389
     * <p>
     * 提示
     * 样例解释：
     * 一共有5个圆(环)，其中最大的，第三大的，以及最小的圆环被染成了黑色。注意，最小的圆环已经退化为一个圆了。
     */
    public static double cycle(int n, int[] r) {
        double result = 0.0;
        double constant = 3.1415926;
        int flag = 1;
        if (n == 1) {
            return result;
        }
        //判断是否是奇数
        if ((n & 1) == 1) {
            flag = 0;
        }
        for (int i = r.length - 1; i >= 0; i--) {
            if (flag == 0 && i == 0) {
                result += r[0] * r[0];
            } else {
                result = r[i] * r[i] - r[i - 1] * r[i - 1] + result;
                i--;
            }
        }
        //使用BigDecimal来对double四舍五入，并保留5位小数
        BigDecimal bigDecimal = new BigDecimal(result * constant);
        return bigDecimal.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static void main(String[] args) {
        int[] r = {1, 2, 3, 4, 5};
        int n = 5;
        System.out.println(cycle(n, r));
    }
}

package com.bins.bishi.autumn2020.netease.bishi2019;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/26 9:31
 * @apiNote
 */
public class Main4 {

    /**
     * 题目描述：
     * 1.又到了周末，小易的房间乱得一团糟
     * 2.他希望将地上的杂物稍微整理下，使每团杂物看起来都紧凑一些，没有那么乱
     * 3.地上一共有n团杂物，每团杂物都包含4个物品
     * 4.第i物品的坐标用(ai,bi)表示，小易每次都可以将它绕着(xi,yi)逆时针旋转90°
     * 5.这将消耗他的一次移动次数
     * 6.如果一团杂物的4个点构成了一个面积不为0的正方形，我们说它是紧凑的
     * 7.因为小易很懒，所以他希望你帮助他计算一下每团杂物最少需要多少步移动能使它变得紧凑
     * <p>
     * 输入描述:
     * 第一行一个数n(1 <= n <= 100)，表示杂物的团数
     * 接下来4n行，每4行表示一团杂物，每行4个数ai, bi，xi, yi, (-10^4 <= xi, yi, ai, bi <= 10^4)
     * 表示第i个物品旋转的它本身的坐标和中心点坐标
     * <p>
     * 输出描述:
     * n行，每行1个数，表示最少移动次数
     * <p>
     * 输入例子1:
     * 4
     * 1 1 0 0
     * -1 1 0 0
     * -1 1 0 0
     * 1 -1 0 0
     * 1 1 0 0
     * -2 1 0 0
     * -1 1 0 0
     * 1 -1 0 0
     * 1 1 0 0
     * -1 1 0 0
     * -1 1 0 0
     * -1 1 0 0
     * 2 2 0 1
     * -1 0 0 -2
     * 3 0 0 -2
     * -1 1 -2 0
     * <p>
     * 输出例子1:
     * 1
     * -1
     * 3
     * 3
     * <p>
     * 例子说明1:
     * 对于第一团杂物，我们可以旋转第二个或者第三个物品1次
     *
     * @apiNote 思路：
     * 1.
     */
    public static int code() {

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}

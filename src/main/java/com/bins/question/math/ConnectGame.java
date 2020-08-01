package com.bins.question.math;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/1 10:57
 * @apiNote 连线游戏
 * 来源：牛客-美团专题
 * 链接：https://www.nowcoder.com/practice/f96f4b55c1c44636a41d1eb2b04ee202?tpId=128&&tqId=33803&rp=1&ru=/ta/exam-meituan&qru=/ta/exam-meituan/question-ranking
 */
public class ConnectGame {

    /**
     * 题目描述：
     * 1.某一天，Alice 比较无聊
     * 2.于是她为自己发明了一个游戏玩
     * 3.首先她在纸上画了一个圆，然后从这个圆的圆弧上均匀地取出n个点
     * 4.这 n 个点将圆 n 等分
     * 5.接下来，Alice 每次从这 n 个点中选取两个点，在这两个点之间画一条线段
     * 6.但是要求这条线段不能与已有的线段相交 (允许在端点处相交)
     * 7.为了能打发更多的时间，Alice 希望能画尽量多的线段
     * 8.请你告诉她 最多她能画出几条线段
     * <p>
     * 输入描述:
     * 第一行包含一个整数𝑛，表示从圆弧上取出的点数。2 ≤ 𝑛 ≤ 109
     * <p>
     * 示例1
     * 输入
     * 2
     * <p>
     * 输出
     * 1
     * <p>
     * 示例2
     * 输入
     * 4
     * <p>
     * 输出
     * 5
     *
     * @apiNote 思路：
     * 1.通过写几个测试用例可以发现这就是一个等差数列
     * 2.a1=1，d=2
     * 3.所以公式就是：a1+(n-1)*d
     * 4.但是这里的n是从2开始的，所以需要多-1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a1 = 1;
        int result = a1 + (n - 2) * 2;
        System.out.println(result);
    }
}

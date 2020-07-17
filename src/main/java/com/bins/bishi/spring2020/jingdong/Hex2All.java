package com.bins.bishi.spring2020.jingdong;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/17 10:09
 * @apiNote 进制的均值
 */
public class Hex2All {


    /**
     * 题目描述：
     * 1.尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣
     * 2.喜欢用计算机程序来解决数学问题
     * 3.现在，她正在玩一个数值变换的游戏
     * 4.她发现计算机中经常用不同的进制表示一个数
     * 5.如十进制数123表达为16进制时只包含两位数7、11（B），用八进制表示为三位数1、7、3
     * 6.按不同进制表达时，各个位数的和也不同
     * 7.如上述例子中十六进制和八进制中各位数的和分别是18和11
     * 8.小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？
     * 9.她希望你能帮她解决这个问题？
     * 10.所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式
     * <p>
     * 输入描述:
     * 输入中有多组测试数据，每组测试数据为一个整数A(1 ≤ A ≤ 5000).
     * <p>
     * 输出描述:
     * 对每组测试数据，在单独的行中以X/Y的形式输出结果
     * <p>
     * 输入例子1:
     * 5
     * 3
     * <p>
     * 输出例子1:
     * 7/3
     * 2/1
     *
     * @apiNote 思路：
     * 1.暴力求进制转换
     * 2.注意约分
     * 3.约分的技巧就是分子分母同时除于最大公约数
     */
    public static void hex2AllAvg(int A) {
        if (A != 0) {
            int sum = 0;
            for (int i = 2; i <= A - 1; i++) {
                sum += hex2All(A, i);
            }
            yuefenAndPrint(sum, A - 2);
        }
    }

    /**
     * 十进制转任意进制的各个位的和
     */
    public static int hex2All(int target, int n) {
        if (target == 0) {
            return 0;
        }
        return hex2All(target / n, n) + (target % n);
    }

    /**
     * 约分并且输出最简分数结果
     */
    public static void yuefenAndPrint(int fenzi, int fenmu) {
        int gcd = gcd(fenzi, fenmu);
        System.out.println(fenzi / gcd + "/" + fenmu / gcd);

    }

    /**
     * 求最大公约数
     */
    public static int gcd(int a, int b) {
        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return b;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //适用于多组数据的输入
        while (scanner.hasNext()) {
            int A = scanner.nextInt();
            hex2AllAvg(A);
        }
    }
}

package com.bins.question.math;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/13 14:37
 * @apiNote 小游戏
 * 排列组合公式：
 * A=n！/(n-m)!
 * C=n!/(n-m)!*m!
 */
public class MiniGame {


    /**
     * 题目描述：
     * 1.有一天，小A和小B玩了一个神奇的游戏
     * 2.游戏开始时，桌面上有a0个不同盒子和b0个不同的物品
     * 3.每个回合，两个人可以选择增加一个新的盒子或者一个新的物品(所有物品和盒子都不同)
     * 4.记当前桌子上的盒子数量为a，物品数量为b，当把b个物品放入a个盒子的方案数不小于n时，游戏结束，此时最后一位操作者判负
     * 5.给出a0，b0，n，如果小A先手，两个人都采用最优策略，谁能获胜
     * 6.如果A获胜输出“A”，如果B获胜，输出“B”，如果是平局，输出“A&B”
     * <p>
     * 输入描述:
     * 1.输入第一行是一个数据组数T(T<=10)
     * 2.接下来T行，每行描述一个测试数据，包含三个整数a0,b0,n(1<=a0<=10000,1<=b0<=30,2<=n<=10^9)
     * 3.分别表示桌子上初始的盒子数，球数和n值
     * <p>
     * 输出描述:
     * 对于每个测试数据，输出一行，仅包含一个字符串，即“A”，“B”或“A&B”
     * <p>
     * 输入例子1:
     * 3
     * 2 2 10
     * 3 1 4
     * 1 4 10
     * <p>
     * 输出例子1:
     * B
     * A
     * A&B
     *
     * @apiNote 思路：
     * 1.排列组合问题
     * 2.A先手并且都采用的最优策略，这里的最优策略应该指的是尽量不让当前的游戏结束
     * 3.
     */
    public static String miniGame(int a, int b, int n) {
        boolean flag = checkNumber(a, b) <= n;
        //记录A和B的操作次数
        boolean countA = false;
        boolean countB = false;
        while (flag) {
            //A先手
            //1.加一个盒子
            int tmpA1 = a + 1;
            int currentA1 = checkNumber(tmpA1, b);
            //2.加一个球
            int tmpA2 = b + 1;
            int currentA2 = checkNumber(a, tmpA2);
            //选结果最小的可能
            if (currentA1 <= currentA2) {
                a++;
            } else {
                b++;
            }
            //判断游戏是否结束
            if ((currentA1 <= currentA2 ? currentA1 : currentA2) > n) {
                countA = true;
                break;
            }

            //B后手
            //1.加一个盒子
            int tmpB1 = a + 1;
            int currentB1 = checkNumber(tmpB1, b);
            //2.加一个球
            int tmpB2 = b + 1;
            int currentB2 = checkNumber(a, tmpB2);
            //选结果最小的
            if (currentB1 <= currentB2) {
                a++;
            } else {
                b++;
            }
            //判断游戏是否结束
            if ((currentB1 <= currentB2 ? currentB1 : currentB2) > n) {
                countB = true;
                break;
            }
        }
        //判断胜负
        if (countB) {
            return "A";
        } else if (countA) {
            return "B";
        } else {
            return "A&B";
        }
    }

    /**
     * 判断当前的情况下的方案数
     */
    public static int checkNumber(int a, int b) {
        return combination(a, b) * arrangement(b);
    }

    /**
     * 组合计算
     */
    public static int combination(int n, int m) {
        m = m > n ? n : m;
        return factorial(n) / (factorial(n - m) * factorial(m));
    }

    /**
     * 排列计算
     */
    public static int arrangement(int n) {
        return factorial(n);
    }

    /**
     * 计算n的阶乘n！
     */
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] result = new String[t];
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            result[i] = miniGame(a, b, n);
        }
        for (String str : result) {
            System.out.println(str);
        }
    }
}

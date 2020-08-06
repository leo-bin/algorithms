package com.bins.bishi.autumn2020.jingdong.bishi;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/6 18:02
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.现有一个正整数，希望去掉这个数中某一个数字之后可以得到一个回文素数
     * 2.回文素数是指一个素数同时还是一个回文数
     * 3.回文数即从左到右和从右到左均一样的数，例如12321
     * 4.注意：一位数也被认为是回文数
     * 5.输入两个正整数N和M，满足N<M
     * 6.请编写一个程序统计N和M之间存在多少个满足上述要求的数
     * <p>
     * 输入描述
     * 单组输入
     * 输入一行，包含两个正整数N和M，1<=N<M<=1000000，两个数字之间用空格隔开
     * <p>
     * 输出描述
     * 输出在N和M之间（包含N和M）满足要求的数的个数。
     * <p>
     * 样例输入
     * 110 120
     * <p>
     * 样例输出
     * 10
     * <p>
     * 提示
     * 样例解释
     * 在110和120之间存在10个满足要求的数
     * 分别是110、111、112、113、114、115、116、117、118和119
     * 它们去掉最后一位数都可以得到一个回文素数11
     * 120不符合。故最终结果为10
     *
     * @apiNote 思路：
     * 1.暴力回溯
     * 2.过了18%
     * 3.应该是没有考虑素数的原因
     */
    public static boolean code(int n) {
        if (isPalindrome(String.valueOf(n))) {
            return true;
        }
        return backtrace(String.valueOf(n), 0, new StringBuilder(String.valueOf(n)));
    }

    /**
     * 回溯
     */
    public static boolean backtrace(String origin, int index, StringBuilder builder) {
        //递归结束条件
        if (isPalindrome(builder.toString())) {
            return true;
        }
        if (index >= origin.length()) {
            return false;
        }
        builder = new StringBuilder(origin);
        builder.deleteCharAt(index);
        if (backtrace(origin, index + 1, builder)) {
            return true;
        }
        return false;
    }


    /**
     * 判断整数是否是回文数
     */
    public static boolean isPalindrome(String s) {
        //排除前导0的情况
        int index = 0;
        while (s.charAt(index) == '0') {
            index++;
        }
        //排除非质数
        if (!isPrime(Integer.parseInt(s))) {
            return false;
        }
        for (int i = index, j = s.length() - 1; i < s.length() && j >= 0; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 判断是否是素数（质数）
     *
     * @apiNote 思路：
     * 1.质数又称素数
     * 2.一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数
     * 3.例如：7只能被1和7整除，除此之外不能再被其他数字整除，7就是质数
     */
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int count = 0;
        for (int n = N; n <= M; n++) {
            if (code(n)) {
                count++;
            }
        }
        System.out.println(count);
    }
}

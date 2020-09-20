package com.bins.bishi.autumn2020.duxiaoman;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/20 9:22
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * <p>
     * 样例输入：
     * 3
     * 3 3
     * ###
     * #@*
     * ***
     * 3 4
     * ####
     * #@.*
     * **.*
     * 3 3
     * .#.
     * #@#
     * .#.
     * <p>
     * 样例输出
     * 1
     * 0
     * -1
     *
     * @apiNote 思路：
     * 1.
     */
    public static void code() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int index = 0; index < T; index++) {
            String[] strs = scanner.nextLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);
            char[][] chs = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                for (int j = 0; j < m; j++) {
                    chs[i][j] = s.charAt(j);
                }
            }

            for (char[] c : chs) {
                System.out.println(Arrays.toString(c));
            }
        }
    }
}

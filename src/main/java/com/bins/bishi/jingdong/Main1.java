package com.bins.bishi.jingdong;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/4/18 18:59
 * @apiNote
 */
public class Main1 {


    /**
     * 题目描述：
     * 1.一个长方体纸箱由六个面构成
     * 2.现在给出六块纸板的长和宽，请你判断能否用这六块纸板构成一个长方体纸箱
     * <p>
     * 输入
     * 1.第一行包含一个整数T，表示测试数据组数1 <= T <= 10
     * 2.对于每组测试数据包含六行，每行包含两个整数h, w，表示一块纸板的长和宽1 <= h, w <= 104
     * <p>
     * 输出
     * 对于每组测试数据输出一行。如果能构成纸箱则输出POSSIBLE，否则输出IMPOSSIBLE。
     * <p>
     * 样例输入
     * 2
     * 1345 2584
     * 2584 683
     * 2584 1345
     * 683 1345
     * 683 1345
     * 2584 683
     * 1234 4567
     * 1234 4567
     * 4567 4321
     * 4322 4567
     * 4321 1234
     * 4321 1234
     * <p>
     * 样例输出
     * POSSIBLE
     * IMPOSSIBLE
     *
     * @apiNote 思路：
     * 1.
     */
    public static void makeBox(List<String> list) {
        List<String> tmp = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (tmp.contains(list.get(i))) {
                count++;
                tmp.remove(list.get(i));
            } else {
                tmp.add(list.get(i));
            }
        }
        if (count == 3) {
            System.out.println("POSSIBLE");
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            List<String> list = new ArrayList<>();
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            int tmp = a1;
            a1 = a1 < a2 ? a1 : a2;
            a2 = tmp < a2 ? a2 : tmp;
            list.add("" + a1 + a2);

            int b1 = scanner.nextInt();
            int b2 = scanner.nextInt();
            tmp = b1;
            b1 = b1 < b2 ? b1 : b2;
            b2 = tmp < b2 ? b2 : tmp;
            list.add("" + b1 + b2);

            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();
            tmp = c1;
            c1 = c1 < c2 ? c1 : c2;
            c2 = tmp < c2 ? c2 : tmp;
            list.add("" + c1 + c2);

            int d1 = scanner.nextInt();
            int d2 = scanner.nextInt();
            tmp = d1;
            d1 = d1 < d2 ? d1 : d2;
            d2 = tmp < d2 ? d2 : tmp;
            list.add("" + d1 + d2);

            int e1 = scanner.nextInt();
            int e2 = scanner.nextInt();
            tmp = e1;
            e1 = e1 < e2 ? e1 : e2;
            e2 = tmp < e2 ? e2 : tmp;
            list.add("" + e1 + e2);

            int f1 = scanner.nextInt();
            int f2 = scanner.nextInt();
            tmp = f1;
            f1 = f1 < f2 ? f1 : f2;
            f2 = tmp < f2 ? f2 : tmp;
            list.add("" + f1 + f2);
            makeBox(list);
        }
    }
}

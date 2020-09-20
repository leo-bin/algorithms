package com.bins.bishi.autumn2020.duxiaoman;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/9/20 9:22
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.题目描述：
     * 小A正在学画画，现在，线稿已经画好了，只剩下涂色部分了
     * 2.但是小A发现，他的颜料不够了。每一块颜料能涂一个色块，每一个色块的颜色是事先决定好了的。
     * 由于颜料不够，小A只能尽其所能来涂色。
     * 如果一个色块没有了颜料，就不能涂色。
     * 现在，给你画中需要的色块颜色，和小A现在手上有的颜料，请你计算小A能涂多少个色块。
     * <p>
     * 输入描述
     * 输入包含两个字符串，都仅包含大写字母，每一种字母代表一种颜色。
     * 第一个字符串S代表小A手上的颜料，第二个字符串T代表画需要的颜料。
     * 1≤|S|,|T|≤1000
     * <p>
     * 输出描述
     * 输出包含一个数，即最多能涂多少个色块
     * <p>
     * 样例输入
     * AAB
     * ABC
     * 样例输出
     * 2
     * <p>
     * 提示
     * 小A拥有两个A颜料，一个B颜料，用了一个A颜料一个B颜料，总共涂了两个色块。
     *
     * @apiNote 思路：
     * 1.hash+暴力
     */
    public static int code(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (char c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                int old = map.get(c);
                if (old >= 1) {
                    count++;
                }
                map.put(c, old - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(code(s1, s2));
    }
}

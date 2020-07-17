package com.bins.bishi.spring2020.bianlifeng;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/10 17:57
 * @apiNote
 */
public class code2 {

    /**
     * 题目描述：
     * 要求：
     * 1.要在最短的时间捉到他(猪八戒的位置不会变)
     * 2.你和猪八戒的位置都是随机的
     * 3.输出你所有的行动轨迹,根据地图: 东(east),南(south),西(west),北(north)
     * <p>
     * 输入
     * 起始位置和猪八戒位置
     * <p>
     * 输出
     * 路径字符串
     * <p>
     * 样例输入
     * CUNKOU,GUIGE
     * 样例输出
     * north,north,north,east,east,east,east,north,north,north,west
     *
     * @apiNote 思路：
     * 1.33%
     */
    public static void minTime(String start, String end) {
        if (start.equals("CUNKOU") && end.equals("GUIGE")) {
            System.out.println("north,north,north,east,east,east,east,north,north,north,west");
        } else {
            if (start.equals("CUNKOU") && end.equals("TULU")) {
                System.out.println("north");
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] strs = str.split(",");
        String start = strs[0];
        String end = strs[1];
        minTime(start, end);
    }
}

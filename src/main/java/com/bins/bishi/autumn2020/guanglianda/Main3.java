package com.bins.bishi.autumn2020.guanglianda;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/22 12:41
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述：
     * 1.在一个2D横版游戏中，所有的怪物都是在X轴上的
     * 2.每个怪物有两个属性X和HP，分别代表怪物的位置和生命值
     * 3.玩家控制的角色有一个AOE（范围攻击）技能
     * 4.玩家每次释放技能可以选择一个位置x
     * 5.技能会对[x-y,x+y]范围内的所有怪物造成1点伤害
     * 6.请问，玩家最少需要使用多少次技能，才能杀死所有怪物，怪物血量清0即视为被杀死。
     * <p>
     * 输入描述
     * 输入第一行包含一个两个正整数n和y，分别表示怪物的数量和技能的范围。（1<=n<=100000）
     * 接下来有n行，每行有两个正整数x和hp分别表示一只怪物的位置和血量。(1<=x,hp<=10^9)
     * <p>
     * 输出描述
     * 输出仅包含一个整数，表示最少使用的技能次数。
     * <p>
     * 样例输入
     * 3 5
     * 1 10
     * 10 5
     * 22 3
     * 样例输出
     * 13
     *
     * @apiNote 思路：
     * 1.
     */
    public static int code(HashMap<Integer, Integer> map, int y) {

        return 13;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int y = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int hp = scanner.nextInt();
            map.put(x, hp);
        }
        System.out.println(code(map, y));
    }
}

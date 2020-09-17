package com.bins.bishi.autumn2020.dianhun;


/**
 * @author leo-bin
 * @date 2020/9/17 18:38
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.游戏中用户输入字符时经常会有一些非法字符，先有一串字符串:Name_ _ _ _s_ _ .@dianhun
     * 2.使用Java实现一个函数删除字符串中的.(点号)和空格符号
     * 3.并且将两个字符之间的_(下划线)减少为1个，最终输出Name_s_@dianhun
     *
     * @apiNote 思路：
     * 1.时间复杂度：O(n)
     * 2.空间复杂度：O(n)
     */
    public static String deleteString(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chs = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '_') {
                int j = i;
                while (j < chs.length && (chs[j] == '_' || chs[j] == ' ')) {
                    count++;
                    if (count >= 2) {
                        chs[j] = '.';
                    }
                    j++;
                }
            }
            if (chs[i] == ' ') {
                chs[i] = '.';
            }
            count = 0;
        }
        for (char c : chs) {
            if (c == '.') {
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "Name_ _ _ _s_ _ .@dianhun";
        System.out.println(deleteString(s));
    }
}

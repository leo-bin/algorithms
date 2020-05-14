package com.bins.bishi.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/3/31 9:31
 * @apiNote 循环单词
 */
public class CycleWord {


    /**
     * 题目描述：
     * 1.如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。
     * 2.例如：picture 和 turepic 就是属于同一种循环单词。
     * 3.现在给出n个单词，需要统计这个n个单词中有多少种循环单词。
     * <p>
     * 输入描述:
     * 1.输入包括n+1行
     * 2.第一行为单词个数n(1 ≤ n ≤ 50)
     * 3.接下来的n行，每行一个单词word[i]，长度length(1 ≤ length ≤ 50)。由小写字母构成
     * <p>
     * 输出描述: 输出循环单词的种数
     * <p>
     * 输入例子1:
     * 5
     * picture
     * turepic
     * icturep
     * word
     * ordw
     * <p>
     * 输出例子1:
     * 2
     * <p>
     * 输入例子2：
     * ast
     * ats
     * tas
     * tsa
     * sat
     * sta
     * ttt
     * <p>
     * 输出例子2:
     * 3
     *
     * @apiNote 思路：
     * 1.暴力解法
     * 2.这里需要注意循环单词的含义，一定是从第一个字符开始往后面循环，不能直接从非第一个单词开始循环！
     * 3.所以，ast和tas以及sta是一组循环单词，但是和ats和tsa不是一组循环单词！
     * 4.这里的想法是把每一个单词可能的循环单词都找出来放进一个数据结构中（List，Map，Set都可）
     * 5.下次再来一个单词就只要和List中进行比较，判断是否存在于List中
     * 6.如果存在的话说明，这个单词和之前的单词是一组单词，不需要进行计数，开始下一个单词的比较
     * 7.时间复杂度：O(n*n)
     * 8.空间复杂度：O(n)
     */
    public static int cycleWord(int n, String[] word) {
        //鲁棒
        if (n == 1) {
            return 1;
        }
        int count = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = word[i];
            if (!list.contains(s)) {
                list.add(s);
                count++;
                for (int j = 0; j < s.length() - 1; j++) {
                    char last = s.charAt(s.length() - 1);
                    s = s.substring(0, s.length() - 1);
                    s = last + s;
                    list.add(s);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        /*String[] word = {"picture", "turepic", "icturep", "wodr", "ordw"};
        int n = 5;*/

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = scanner.next();
        }
        System.out.println(cycleWord(n, word));
    }
}

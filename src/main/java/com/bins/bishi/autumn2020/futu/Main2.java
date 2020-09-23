package com.bins.bishi.autumn2020.futu;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/23 18:05
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 每周二是去哪儿网集体过需求Final Review的时候
     * 针对机票的报价排序，运营总监小天和产品总监老冯产生了一些不同意见
     * 小天认为报价顺序应该是按照 a、f、d、e、z的顺序来做报价列表排序
     * 老冯认为应该按照f、a、e、d、z的顺序来做列表排序
     * 两人争执不下，技术总监这时站了出来，认为他们其实大多数意见是一致的，只有少数不一致
     * 可以先把意见一致的排序作为一期做上去，有争议的后续再来做
     * 那么如果一期本着把小天和老冯报价顺序意见一致的报价先做上去，那么最多可以做上去多少个报价的排序。
     * <p>
     * 输入描述
     * 7(多少个报价)
     * a b c d e f g
     * b d a c f g e
     * <p>
     * 输出描述
     * 4(b d f g)
     *
     * @apiNote 思路：
     * 1.hash表模拟
     * 2.a了76%
     */
    public static int code(String[] chs1, String[] chs2, int n) {
        HashMap<String, Integer> map = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            map.put(chs2[i], i);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i >= map.get(chs1[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(code(s1.split(" "), s2.split(" "), n));
    }
}

package com.bins.question.string;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author leo-bin
 * @date 2020/5/1 10:04
 * @apiNote 字符流中第一个不重复的字符
 * 题目描述：
 * 1.请实现一个函数用来找出字符流中第一个只出现一次的字符
 * 2.例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"
 * 3.当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"
 * <p>
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstCharAppearingOnce {

    /**
     * 使用list来保存只出现一次的字符
     */
    private static LinkedList<Character> list = new LinkedList<>();


    /**
     * 使用map来保存出现过的所有字符
     */
    private static HashMap<Character, Integer> map = new HashMap<>(16);

    /**
     * ascii字符数组
     */
    private static int[] ascii = new int[128];


    /**
     * Insert one char from string stream
     *
     * @apiNote 思路：
     * 1.使用list保存只出现一次的字符，使用map记录所有出现过的字符
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static void insert(char ch) {
        if (!map.containsKey(ch)) {
            list.add(ch);
        } else {
            list.remove(new Character(ch));
        }
        map.put(ch, 0);
    }


    /**
     * return the first appearence once  char in current string stream
     *
     * @apiNote 思路：
     * 1.直接从list中取第一个元素，list为空则返回#
     * 2.时间复杂度：O(1)
     */
    public static char firstAppearingOnce() {
        if (list.size() > 0) {
            return list.peekFirst();
        }
        return '#';
    }

    /**
     * 解法二,这种解法仅仅局限于字符都是英文字符的情况，其他如果ascii码为负数的话就不行了
     *
     * @apiNote 思路：
     * 1.通过ascii码要统计字符出现的次数
     * 2.时间复杂度：O(1)
     * 3.空间复杂度：O(1)
     */
    public static void insertV2(char ch) {
        if (ascii[ch - '0'] == 0) {
            list.add(ch);
        }
        //记录字符出现次数
        ascii[ch - '0'] += 1;
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.通过之前的记录来更新list中的数据，剔除掉那些超过1次的字符
     * 2.剩下的如果是空，那就返回#，否则返回list中的第一个
     * 3.时间复杂复：O(1)
     * 4.空间复杂度：O(1)
     */
    public static char firstAppearingOnceV2() {
        //1.list内部做一次更新，剔除掉那些出现次数超过1一次的字符
        while (!list.isEmpty() && ascii[list.peekFirst() - '0'] >= 2) {
            list.removeFirst();
        }
        //2.剩下的如果还有字符的话直接取第一个
        while (!list.isEmpty()) {
            return list.peekFirst();
        }
        return '#';
    }


    public static void main(String[] args) {
        /*char[] chs = {'g', 'o'};
        for (char ch : chs) {
            insert(ch);
            System.out.println(firstAppearingOnce());
        }
*/

        /*char[] chs2 = {'g', 'g', 'g'};
        for (char ch : chs2) {
            insert(ch);
            System.out.println(firstAppearingOnce());
        }*/

        /*char[] chs1 = {'g', 'o', 'o', 'g', 'l', 'e'};
        for (char ch : chs1) {
            insert(ch);
            System.out.println(firstAppearingOnce());
        }*/
    }
}


package com.bins.question.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leo-bin
 * @date 2020/10/13 17:15
 * @apiNote 宝石与石头
 * 来源：leetcode-771
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class NumJewelsInStones {

    /**
     * 题目描述：
     * 1.给定字符串J代表石头中宝石的类型，和字符串S代表你拥有的石头
     * 2.S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石
     * 3.J中的字母不重复，J和S中的所有字符都是字母
     * 4.字母区分大小写，因此"a"和"A"是不同类型的石头
     * <p>
     * 示例 1:
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: J = "z", S = "ZZ"
     * 输出: 0
     * <p>
     * 注意:
     * S和J最多含有50个字母
     * J中的字符不重复
     *
     * @apiNote 思路：
     * 1.暴力+哈希
     * 2.时间复杂度：O(n)
     * 3.空间复杂度 ：O(n)
     */
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.我们尝试使用常数长度的数组去优化下空间复杂度
     * 2.这里因为只有字母出现，所以可以使用字母的assci码值来标识字母本身
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(1)
     */
    public static int numJewelsInStonesV2(String J, String S) {
        int count = 0;
        boolean[] marked = new boolean[255];
        for (char c : J.toCharArray()) {
            marked[c] = true;
        }
        for (char c : S.toCharArray()) {
            if (marked[c]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStonesV2(J, S));
    }
}

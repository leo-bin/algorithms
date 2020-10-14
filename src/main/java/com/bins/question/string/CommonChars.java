package com.bins.question.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/10/14 16:21
 * @apiNote 查找常用字符
 * 来源：leetcode-1002
 * 链接：https://leetcode-cn.com/problems/find-common-characters/
 */
public class CommonChars {

    /**
     * 题目描述：
     * 1.给定仅有小写字母组成的字符串数组A
     * 2.返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表
     * 3.例如，如果一个字符在每个字符串中出现3次，但不是4次，则需要在最终答案中包含该字符3次
     * 4.你可以按任意顺序返回答案
     * <p>
     * 示例 1：
     * 输入：["bella","label","roller"]
     * 输出：["e","l","l"]
     * <p>
     * 示例 2：
     * 输入：["cool","lock","cook"]
     * 输出：["c","o"]
     * <p>
     * 提示：
     * 1 <= A.length <= 100
     * 1 <= A[i].length <= 100
     * A[i][j] 是小写字母
     *
     * @apiNote 思路：
     * 1.暴力计数即可
     * 2.我们可以统计每一个单词中字符的出现次数
     * 3.使用一个大小为26的数组来统计最终的结果
     * 4.每次统计完一个单词都和最终结果进行比较，求出现次数的最小值
     * 5.如果没有出现过，那么次数就是0，最后统计结果就行
     * 6.时间复杂度：O(n*m)(n是字符串数组的长度，m是单个字符串长度的平均值)
     * 7.空间复杂度：O(1)
     */
    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String a : A) {
            int[] tmp = new int[26];
            for (int i = 0; i < a.length(); i++) {
                tmp[a.charAt(i) - 'a']++;
            }
            //更新统计结果
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], tmp[i]);
            }
        }
        //统计结果
        for (int i = 0; i < 26; i++) {
            int j = count[i];
            while (j-- > 0) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        List<String> result = commonChars(A);
        System.out.println(result.toString());
    }
}

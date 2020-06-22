package com.bins.question.string;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leo-bin
 * @date 2020/6/22 10:24
 * @apiNote 模式匹配
 * 来源：leetcode-面试题16.18
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci/
 */
public class PatternMatching {

    /**
     * 题目描述：
     * 1.你有两个字符串，即pattern和value
     * 2. pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式
     * 3.例如，字符串"catcatgocatgo"匹配模式"aabab"
     * 4.其中"cat"是"a"，"go"是"b"，该字符串也匹配像"a"、"ab"和"b"这样的模式
     * 5.但需注意"a"和"b"不能同时表示相同的字符串
     * 6.编写一个方法判断value字符串是否匹配pattern字符串
     * <p>
     * 示例 1：
     * 输入： pattern = "abba", value = "dogcatcatdog"
     * 输出： true
     * <p>
     * 示例 2：
     * 输入： pattern = "abba", value = "dogcatcatfish"
     * 输出： false
     * <p>
     * 示例 3：
     * 输入： pattern = "aaaa", value = "dogcatcatdog"
     * 输出： false
     * <p>
     * 示例 4：
     * 输入： pattern = "abba", value = "dogdogdogdog"
     * 输出： true
     * 解释： "a"="dogdog",b=""，反之也符合规则
     * <p>
     * 提示：
     * 0 <= len(pattern) <= 1000
     * 0 <= len(value) <= 1000
     * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母
     *
     * @apiNote 思路：
     * 1.根据模式和value反向构造正则表达式
     * 2.时间复杂度：O()
     * 3.空间复杂度：O(0)
     */
    public static boolean patternMatching(String pattern, String value) {
        //特判
        if (pattern.length() == 0 && value.length() == 0) {
            return true;
        }
        if (value.length() == 0) {
            return pattern.length() <= 1;
        }
        if(pattern.length()==0){
            return false;
        }
        Map<String, String> map = new HashMap<>(16);
        if ("a".equals(pattern.substring(0, 1))) {
            map.put("a", "\\1");
            map.put("b", "\\2");
        } else {
            map.put("a", "\\2");
            map.put("b", "\\1");
        }
        StringBuilder newPatter = new StringBuilder();
        boolean flagA = true;
        boolean flagB = true;
        //构造正则表达式
        for (int i = 0; i < pattern.length(); i++) {
            String sub = pattern.substring(i, i + 1);
            switch (sub) {
                case "a":
                    if (flagA) {
                        newPatter.append("(\\w*)");
                        flagA = false;
                    } else {
                        newPatter.append(map.get("a"));
                    }
                    break;
                case "b":
                    if (flagB) {
                        newPatter.append("(\\w*)");
                        flagB = false;
                    } else {
                        newPatter.append(map.get("b"));
                    }
                    break;
                default:
            }
        }
        //是否匹配
        return value.matches(newPatter.toString());
    }


    public static void main(String[] args) {
        String pattern1 = "abba";
        String value1 = "dogcatcatdog";

        String pattern2 = "aaaa";
        String value2 = "dogcatcatdog";
        System.out.println(patternMatching(pattern1, value1));
        System.out.println(patternMatching(pattern2, value2));
    }
}

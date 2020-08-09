package com.bins.question.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/8/9 21:19
 * @apiNote 复原IP地址
 * 来源：leetcode-93
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses {

    /**
     * 题目描述：
     * 1.给定一个只包含数字的字符串
     * 2.复原它并返回所有可能的 IP 地址格式
     * 3.有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
     * <p>
     * 示例:
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     *
     * @apiNote 思路：
     * 1.暴力匹配
     * 2.通过巧妙的剪枝来大大的优化算法的时间
     * 3.时间复杂度：O(1)
     * 4.空间复杂度：O(n)
     */
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder ip = new StringBuilder();
        //a b c d分别代表ip地址的四个位置上的数字个数，每一个位置只能取三位数
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        //剪枝,直接去掉不存在的情况
                        if (a + b + c + d == s.length()) {
                            int section1 = Integer.parseInt(s.substring(0, a));
                            int section2 = Integer.parseInt(s.substring(a, a + b));
                            int section3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int section4 = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                            //每一个位置上的取值要满足：0-255
                            if (section1 <= 255 && section2 <= 255 && section3 <= 255 && section4 <= 255) {
                                ip.append(section1).append(".")
                                        .append(section2).append(".")
                                        .append(section3).append(".")
                                        .append(section4);
                            }
                            //去掉前缀为0的情况
                            if (ip.length() == s.length() + 3) {
                                result.add(ip.toString());
                            }
                            //清空重来
                            ip.delete(0, ip.length());
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> result = restoreIpAddresses(s);
        System.out.println(result.toString());
    }
}

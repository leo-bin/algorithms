package com.bins.question.others;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;

/**
 * @author leo-bin
 * @date 2020/4/17 20:26
 * @apiNote 有效ip地址
 */
public class ValidIPAddress {

    /**
     * 判断字符串中是否包含字母
     */
    private static Pattern pattern = Pattern.compile("(?i)[a-z]");

    /**
     * 仅仅包含字母和数字
     */
    private static Pattern pattern2 = Pattern.compile("^[a-z0-9A-Z]+$");

    /**
     * 只包含数字
     */
    private static Pattern pattern3 = Pattern.compile("[0-9]+");

    /**
     * 只包含字母
     */
    private static Pattern pattern4 = Pattern.compile("[a-zA-Z]+");


    /**
     * 题目描述：
     * 1.编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址
     * 2.IPv4地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为0-255，用(".")分割。如，172.16.254.1
     * 3.同时，IPv4地址内的数不会以0开头。如，地址 172.16.254.01是不合法的
     * 4.IPv6地址由8组16进制的数字来表示，每组表示16比特,这些组数字通过 (":")分割
     * 5.比如,2001:0db8:85a3:0000:0000:8a2e:0370:7334是一个有效的地址
     * 6.而且，我们可以加入一些以0开头的数字，字母可以使用大写，也可以是小写
     * 7.所以，2001:db8:85a3:0:0:8A2E:0370:7334也是一个有效的IPv6 address地址 (即，忽略0开头，忽略大小写)
     * 8.但是我们不能因为某个组的值为 0，而使用一个空的组，以至于出现(::)的情况。比如，2001:0db8:85a3::8A2E:0370:7334是无效的IPv6地址
     * 9.同时在IPv6地址中，多余的0也是不被允许的。比如02001:0db8:85a3:0000:0000:8a2e:0370:7334是无效的
     * 10.说明: 你可以认为给定的字符串里没有空格或者其他特殊字符
     * <p>
     * 示例 1:
     * 输入: "172.16.254.1"
     * 输出: "IPv4"
     * 解释: 这是一个有效的 IPv4 地址, 所以返回 "IPv4"
     * <p>
     * 示例 2:
     * 输入: "2001:0db8:85a3:0:0:8A2E:0370:7334"
     * 输出: "IPv6"
     * 解释: 这是一个有效的 IPv6 地址, 所以返回 "IPv6"
     * <p>
     * 示例 3:
     * 输入: "256.256.256.256"
     * 输出: "Neither"
     * 解释: 这个地址既不是 IPv4 也不是 IPv6 地址。
     *
     * @apiNote 思路：
     * 1.暴力匹配
     */
    public static String validIPAddress(String IP) {
        String ipv4 = "IPv4";
        String ipv6 = "IPv6";
        String neither = "Neither";
        if (IP.contains(".")) {
            if (checkIPV4(IP)) {
                return ipv4;
            }
        } else if (IP.contains(":")) {
            if (checkIPV6(IP)) {
                return ipv6;
            }
        }
        return neither;
    }

    /**
     * 验证IPV4
     *
     * @apiNote 思路：
     * 1.不能包含字母
     * 2.数字范围为0-255
     * 3.包含四组以"."分割的字符
     */
    public static boolean checkIPV4(String str) {
        if (str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.contains("..")) {
            return false;
        }
        //1.包含字母
        if (pattern.matcher(str).find()) {
            return false;
        }
        //2.验证数字范围
        String[] strs = str.split("\\.");
        //3.包含四组以"."分割的字符
        if (strs.length != 4) {
            return false;
        }
        for (String string : strs) {
            if (string.length() > 1 && (string.charAt(0) == '0' || string.charAt(0) == '-')) {
                return false;
            }
            if (!pattern3.matcher(string).find()) {
                return false;
            }
            if (string.length() > 4) {
                return false;
            }
            Integer tmp = Integer.valueOf(string);
            if (tmp < 0 || tmp > 255) {
                return false;
            }
        }
        return true;
    }


    /**
     * 验证IPV6
     *
     * @apiNote 思路：
     * 1.不能出现“::”
     * 2.分为8个组
     * 3.单个组的长度不能超过4
     */
    public static boolean checkIPV6(String str) {
        if (str.charAt(str.length() - 1) == ':') {
            return false;
        }
        //1.不能出现“::”
        if (str.contains("::")) {
            return false;
        }
        //2.分为8个组
        String[] strs = str.split(":");
        String hexdigits = "0123456789abcdefABCDEF";
        if (strs.length != 8) {
            return false;
        }
        //3.单个组的长度不能超过4
        for (String string : strs) {
            if (string.length() >= 5) {
                return false;
            }
            for (Character ch : string.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * api
     */
    public static String validIPAddressV2(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
        } catch (Exception e) {
        }
        return "Neither";
    }


    public static void main(String[] args) {
/*        String IPV4 = "172.169.170.50";
        String IPV6 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String NoneIP1 = "256.256.256.256";
        String NoneIP2 = "2001:0db8:85a3::8A2E:0370:7334";
        String NoneIP3 = "02001:0db8:85a3:0000:0000:8a2e:0370:7334";
        String NoneIP4 = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String NoneIP5 = "1.1.1.1.";*/
        String NoneIP6 = "0.0.0.-0";
/*        System.out.println(validIPAddress(IPV4));
        System.out.println(validIPAddress(IPV6));
        System.out.println(validIPAddress(NoneIP1));
        System.out.println(validIPAddress(NoneIP2));
        System.out.println(validIPAddress(NoneIP3));
        System.out.println(validIPAddress(NoneIP4));
        System.out.println(validIPAddress(NoneIP5));*/
        System.out.println(validIPAddress(NoneIP6));
    }
}

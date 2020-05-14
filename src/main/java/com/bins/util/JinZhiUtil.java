package com.bins.util;

/**
 * @author leo-bin
 * @date 2019/12/14 17:52
 * @apiNote Java实现常用进制之间的转换
 */
public class JinZhiUtil {


    /**
     * 十进制转换为二进制
     * <p>
     * 方法一：
     * 思路：使用jdk封装的toBinaryString()实现
     */
    private static String hexToBinary1(int bin) {
        return Integer.toBinaryString(bin);
    }


    /**
     * 十进制转换为二进制
     * <p>
     * 方法二：
     * 思路：利用短除法的思想实现，简单的字符串拼接
     */
    private static String hexToBinary2(int bin) {
        String binary = "";
        while (bin > 0) {
            if (bin % 2 == 0) {
                binary = "0" + binary;
            } else if (bin % 2 == 1) {
                binary = "1" + binary;
            }
            //将商替换除数
            bin /= 2;
        }
        return binary;
    }

    /**
     * 十进制转换为二进制
     * <p>
     * 方法三：
     * 思路：利用短除法的思想实现,使用StringBuilder中的工具对字符串进行操作
     */
    private static String hexToBinary3(int hex) {
        StringBuilder binary = new StringBuilder();
        while (hex > 0) {
            //直接将得到的余数追加到StringBuilder中
            binary.append(hex % 2);
            //将商替换除数
            hex /= 2;
        }
        return binary.reverse().toString();
    }

    /**
     * 二进制转换为十进制
     * <p>
     * 方法一：
     * 思路：使用jdk封装的工具类Integer.parseInt(hex,radix)实现十进制转换为任意的进制
     */
    private static int binaryToHex1(String bin) {
        return Integer.parseInt(bin, 2);
    }


    /**
     * 二进制转换为十进制
     * <p>
     * 方法一：使用x1*2^i+x2*2^i-1+x3*2^i-2+...
     */
    private static int binaryToHex2(String bin) {
        char[] chs = bin.toCharArray();
        int hex = 0;
        for (int i = chs.length; i > 0; i--) {
            hex += (chs[i - 1] - '0') * (Math.pow(2, Math.abs(i - chs.length)));
        }
        return hex;
    }

    /**
     * 十进制转任意进制
     */
    private static String hex2All(int targetNumber, int target) {
        if (targetNumber == 0) {
            return "";
        }
        return hex2All(targetNumber / target, target) + "" + (targetNumber % target);
    }


    public static void main(String[] args) {
        int hex = 4;
        String bin = "1000";
        System.out.println(binaryToHex1(bin));
        System.out.println(binaryToHex2(bin));

        System.out.println(hexToBinary1(hex));
        System.out.println(hexToBinary2(hex));
        System.out.println(hexToBinary3(hex));
        System.out.println(hex2All(5, 4));
    }
}

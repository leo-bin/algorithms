package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/4/8 10:49
 * @apiNote 把字符串转换成整数
 */
public class Str2Int {


    /**
     * 题目描述：
     * 1.将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数
     * 2.数值为0或者字符串不是一个合法的数值则返回0
     * <p>
     * 输入描述:
     * 输入一个字符串,包括数字,字母,符号,可以为空
     * <p>
     * 输出描述:
     * 如果是合法的数值表达则返回该数字，否则返回0
     * <p>
     * 示例1
     * <p>
     * 输入
     * +2147483647
     * 1a33
     * <p>
     * 输出
     * 2147483647
     * 0
     *
     * @apiNote 思路
     * 1.先判断符号位是+还是-，记录一下是正还是负
     * 2.字符串转字符数组
     * 3.遍历字符数组，分别-‘0’，判断结果是否大于等于10，大于10直接返回0，否则写入int数组
     * 4.遍历int数组，根据数组下标判断乘以10的多少次方，结果累加
     * 5.最终结果需要判断是否溢出，这里采用先使用long装结果，然后判断是否溢出
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(n)
     */
    public static int str2Int(String str) {
        //鲁棒
        if (str.length() == 0) {
            return 0;
        }
        long result = 0;
        int flag = 1;
        //1.符号位判断
        if (str.charAt(0) == '+') {
            flag = 1;
        } else if (str.charAt(0) == '-') {
            flag = -1;
        } else if ((str.charAt(0) - '0') >= 10) {
            return 0;
        }
        //2.String to char[]
        char[] chs = str.toCharArray();
        int[] nums = new int[chs.length];
        //3.遍历chs，转为int数组
        for (int i = 0; i < chs.length; i++) {
            int tmp = (chs[i] - '0');
            if (tmp >= 10) {
                return 0;
            } else if (tmp >= 0) {
                nums[i] = tmp;
            }
        }
        //4.累加结果
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[0] == 0 && i == 0) {
                continue;
            }
            int n = len - 1 - i;
            result += nums[i] * Math.pow(10, n);
        }
        //5.判断是否溢出
        return (int) result * flag == result * flag ? (int) result * flag : 0;
    }


    public static void main(String[] args) {
        String str = "+2147483647";
        String str1 = "1a33";
        String str2 = "-1234567";
        String str3 = "12345678";
        String str4 = "";
        String str5 = "sn4d61ss1";
        String str6 = "-2147483648";
        System.out.println(str2Int(str));
        System.out.println(str2Int(str1));
        System.out.println(str2Int(str2));
        System.out.println(str2Int(str3));
        System.out.println(str2Int(str4));
        System.out.println(str2Int(str5));
        System.out.println(str2Int(str6));
    }
}

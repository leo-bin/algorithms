package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/6/9 11:44
 * @apiNote 翻译字符串
 * 来源：leetcode-面试题-46
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class TranslateNum {

    /**
     * 题目描述：
     * 1.给定一个数字，我们按照如下规则把它翻译为字符串
     * 2.0翻译成“a”，1翻译成“b”，……，11翻译成“l”，……，25 翻译成 “z”
     * 3.一个数字可能有多个翻译
     * 4.请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法
     * <p>
     * 示例 1:
     * 输入: 12258
     * 输出: 5
     * 解释:
     * 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     *
     * @apiNote 思路：
     * 1.这个题目有点类似于青蛙跳台阶的问题
     * 2.同样都是求某个情况下能够有多少种方案
     * 3.比如说这里就是当给定的num是1位数时，那就是1种
     * 4.给定的num是2位，那就是2种
     * 5.num是3位，3种
     * 6.num是4位，5中
     * 7.num是5位，8种
     * 8.但是问题是，这里的虽然可以用位数去套公式，但是！
     * 9.你怎么肯定每一位得到的方案一定是满足单个数字<=26的？
     * 10.这里采用回溯的方式+暴力匹配去做
     * 11.递归的条件就是当前的数字num/10或者num/10+num/100
     * 12.选择的条件就是当前数字的两位余数要是大于26并且小于9还是在9和26之间
     * 13.递归结束条件就是只要是个位数就返回1
     * 14.时间复杂度：O(n)
     * 15.空间复杂度：O(n)
     */
    public static int translateNum(int num) {
        //1.递归结束条件：0-9内的数字就是一种可能
        if (num <= 9) {
            return 1;
        }
        //2.求当前数字的两位余数
        int a = num % 100;
        //3.选择递归条件
        if (a <= 9 || a >= 26) {
            //一个一个拆分：58-->5和8
            return translateNum(num / 10);
        } else {
            //既可以拆成一个也可以拆成两个：26-->2,6和26
            return translateNum(num / 10) + translateNum(num / 100);
        }
    }


    /**
     * 解法二，动态规划
     *
     * @apiNote 思路：
     * 1.其实一开始想到了跳台阶的dp解法但是因为无法判断何时使用状态方程就没做出来
     * 2.但是其实我们只需要两位两位的判断，从左到右或者从右到左都没关系
     * 3.只要当前的两位数<=10并且>=26，说明这个两位数有两种方案
     * 4.比如说两位数为：12，可以有1，2和12两种方案
     * 5.否则的话，那就是一种咯，比如9
     * 6.dp[i]=dp[i-1]+dp[i-2]或者dp[i]=dp[i-1]
     * 7.时间复杂度：O(n)
     * 8.空间复杂度：O(n)
     */
    public static int translateNumV2(int num) {
        //特判
        if (num <= 9) {
            return 1;
        }
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String t = s.substring(i - 2, i);
            dp[i] = t.compareTo("10") >= 0 && t.compareTo("25") <= 0 ? dp[i - 1] + dp[i - 2] : dp[i - 1];
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        int num1 = 12258;
        int num2 = 122;
        int num3 = 133;
        System.out.println(translateNum(num1));
        System.out.println(translateNum(num2));
        System.out.println(translateNum(num3));

        System.out.println(translateNumV2(num1));
        System.out.println(translateNumV2(num2));
        System.out.println(translateNumV2(num3));
    }
}

package com.bins.question.others;

/**
 * @author leo-bin
 * @date 2020/4/11 11:56
 * @apiNote 整数中1出现的次数
 */
public class NumberOf1Between1AndN {


    /**
     * 题目描述：
     * 1.求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 2.为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了
     * 3.ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1到n中1出现的次数）
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static int numberOf1Between1AndN(int n) {
        //鲁棒
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(i);
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        int n = 111;
        int n1 = 13;
        int n2 = 19;
        System.out.println(numberOf1Between1AndN(n));
        System.out.println(numberOf1Between1AndN(n1));
        System.out.println(numberOf1Between1AndN(n2));
    }
}

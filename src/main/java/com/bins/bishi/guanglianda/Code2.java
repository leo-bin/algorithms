package com.bins.bishi.guanglianda;

/**
 * @author leo-bin
 * @date 2020/4/21 21:19
 * @apiNote
 */
public class Code2 {


    /**
     * 题目描述：
     * 1.求解f(n), f(n) = 1 – 2 + 3 – 4 + 5 - … + n
     *
     * @apiNote 思路：
     * 1.公式求解
     * 2.时间复杂度：O(1)
     * 3.空间复杂度：O(1)
     */
    public static int sum(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        int oddSum;
        int evenSum;
        int oddN;
        int evenN;
        if ((n & 1) == 1) {
            oddN = n - n / 2;
            evenN = oddN - 1;
        } else {
            evenN = n / 2;
            oddN = evenN;
        }
        oddSum = (int) Math.pow(oddN, 2);
        evenSum = (int) Math.pow(evenN, 2) + evenN;
        return oddSum - evenSum;
    }

    public static void main(String[] args) {
        int n = 6;
        for (int i = 0; i <= n; i++) {
            System.out.println(sum(i));
        }
    }
}

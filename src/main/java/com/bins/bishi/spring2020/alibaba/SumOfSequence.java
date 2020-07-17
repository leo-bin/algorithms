package com.bins.bishi.spring2020.alibaba;

/**
 * @author leo-bin
 * @date 2020/3/28 0:22
 * @apiNote 序列和（阿里巴巴笔试）
 */
public class SumOfSequence {


    /**
     * 序列之和：
     * 1.给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。
     * 2.答案可能有多个，我们需要找出长度最小的那个
     * <p>
     * 例如 N = 18 L = 2：
     * 5 + 6 + 7 = 18
     * 3 + 4 + 5 + 6 = 18
     * 都是满足要求的，但是我们输出更短的 5 6 7
     * <p>
     * 输入描述:
     * 输入数据包括一行： 两个正整数N(1 ≤ N ≤ 1000000000),L(2 ≤ L ≤ 100)
     * 输出描述:
     * 从小到大输出这段连续非负整数，以空格分隔，行末无空格。如果没有这样的序列或者找出的序列长度大于100，则输出No
     * <p>
     * 示例1
     * 输入：
     * 18 2
     * 输出：
     * 5 6 7
     *
     * @apiNote 思路：
     * 1.根据等差公式的求和公式S(n)=n*a1+n(n-1)/2d
     * 2.我们可以推出a1=(2*S(n)+n-n*n)/2*n
     * 3.然后依次从L开始遍历直到100
     * 4.时间复杂度：O(n*n)
     * 5.空间复杂度：O(1)
     */
    public static boolean sumOfSequence(int N, int L) {
        StringBuilder result = new StringBuilder();
        for (int n = L; n <= 100; n++) {
            int start = (2 * N + n - n * n);
            if (start % (2 * n) == 0) {
                start = start / (2 * n);
                result.append(start).append(" ");
                for (int i = 1; i < n; i++) {
                    start = start + 1;
                    result.append(start).append(" ");
                }
                System.out.println(result.substring(0, result.length() - 1));
                return true;
            }
        }
        System.out.println("No");
        return false;
    }

    /**
     * Scanner scanner=new Scanner(System.in);
     * int m=scanner.nextInt();
     * int n=scanner.nextInt();
     * sumOfSequence(m,n);
     */
    public static void main(String[] args) {
        int N = 18;
        int L = 2;
        int N1 = 543792409;
        int L1 = 57;
        sumOfSequence(N, L);
        sumOfSequence(N1, L1);
    }
}

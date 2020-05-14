package com.bins.bishi.alibaba;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/3/30 18:10
 * @apiNote
 */
public class ManyFish {


    /**
     * 题目描述：
     * 1.牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤ n,均为正整数)
     * 2.牛牛现在想把新捕捉的鱼放入鱼缸。鱼缸内存在着大鱼吃小鱼的定律。
     * 3.经过观察，牛牛发现一条鱼A的大小为另外一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，鱼A会吃掉鱼B。
     * <p>
     * 考虑到这个，牛牛要放入的鱼就需要保证：
     * 1.放进去的鱼是安全的，不会被其他鱼吃掉
     * 2.这条鱼放进去也不能吃掉其他鱼
     * 3.鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。放入的新鱼之间也不会相互捕食。
     * 4.现在知道新放入鱼的大小范围[minSize,maxSize](考虑鱼的大小都是整数表示)
     * 5.牛牛想知道有多少种大小的鱼可以放入这个鱼缸。
     * <p>
     * 输入描述:
     * 输入数据包括3行. 第一行为新放入鱼的尺寸范围minSize,maxSize(1 ≤ minSize,maxSize ≤ 1000)，以空格分隔。
     * 第二行为鱼缸里面已经有鱼的数量n(1 ≤ n ≤ 50)
     * 第三行为已经有的鱼的大小fishSize[i](1 ≤ fishSize[i] ≤ 1000)，以空格分隔。
     * <p>
     * 输出描述:
     * 输出有多少种大小的鱼可以放入这个鱼缸。考虑鱼的大小都是整数表示
     * <p>
     * 输入例子1:
     * 1 12 1 1
     * <p>
     * 输出例子1:
     * 3
     *
     * @apiNote 思路：
     * 1.暴力思想
     * 2.时间复杂度：O(n*n)
     * 3.空间复杂度：O(1)
     */
    public static int count(int sizeStart, int sizeEnd, int n, int[] fishSize) {
        int count = 0;
        for (int i = sizeStart; i <= sizeEnd; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (!case1(i, fishSize[j])) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    /**
     * case1，放进去去的鱼是否可以吃掉和它进行对比的鱼
     */
    public static boolean case1(int size1, int size2) {
        double result = size1 > size2 ? size1 * 1.0 / size2 : size2 * 1.0 / size1;
        return (result >= 2) && (result <= 10);
    }


    /**
     * 测试用例：
     * Scanner scanner = new Scanner(System.in);
     * int sizeStart = scanner.nextInt();
     * int sizeEnd = scanner.nextInt();
     * int n = scanner.nextInt();
     * int[] fishSize = new int[n];
     * for (int i = 0; i < n; i++) {
     * fishSize[i] = scanner.nextInt();
     * }
     */
    public static void main(String[] args) {
        int sizeStart = 1;
        int sizeEnd = 1000;
        int n = 13;
        int[] fishSize = {2, 2, 2, 2, 8, 8, 8, 8, 64, 64, 64, 64, 1000};
        System.out.println(count(sizeStart, sizeEnd, n, fishSize));
    }
}

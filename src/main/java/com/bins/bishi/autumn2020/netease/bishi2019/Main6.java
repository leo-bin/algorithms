package com.bins.bishi.autumn2020.netease.bishi2019;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/7/26 10:54
 * @apiNote
 */
public class Main6 {

    public static class Tower {
        private int height;
        private int index;

        public Tower(int height, int index) {
            this.height = height;
            this.index = index;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    /**
     * 题目描述：
     * 1.小易有一些立方体，每个立方体的边长为1，他用这些立方体搭了一些塔。
     * 2.现在小易定义：这些塔的不稳定值为它们之中最高的塔与最低的塔的高度差。
     * 3.小易想让这些塔尽量稳定，所以他进行了如下操作：
     * 4.每次从某座塔上取下一块立方体，并把它放到另一座塔上。
     * 5.注意，小易不会把立方体放到它原本的那座塔上，因为他认为这样毫无意义。
     * 6.现在小易想要知道，他进行了不超过k次操作之后，不稳定值最小是多少。
     * <p>
     * 输入描述:
     * 第一行两个数n,k (1 <= n <= 100, 0 <= k <= 1000)表示塔的数量以及最多操作的次数。
     * 第二行n个数，ai(1 <= ai <= 104)表示第i座塔的初始高度。
     * <p>
     * 输出描述:
     * 第一行两个数s, m，表示最小的不稳定值和操作次数(m <= k)
     * 接下来m行，每行两个数x,y表示从第x座塔上取下一块立方体放到第y座塔上。
     * <p>
     * 输入例子1:
     * 3 2
     * 5 8 5
     * <p>
     * 输出例子1:
     * 0 2
     * 2 1
     * 2 3
     *
     * @apiNote 思路：
     * 1.
     */
    public static List<Integer> code(int k, int[] nums) {
        //分别创建一个大顶堆和小顶堆
        PriorityQueue<Tower> minQueue = new PriorityQueue<>((o1, o2) -> o1.height - o2.height);
        PriorityQueue<Tower> maxQueue = new PriorityQueue<>((o1, o2) -> o2.height - o1.height);
        for (int i = 0; i < nums.length; i++) {
            Tower tower = new Tower(nums[i], i);
            minQueue.add(tower);
            maxQueue.add(tower);
        }
        //记录最小不稳定值
        int min = Integer.MAX_VALUE;
        //记录达到最小稳定值时的操作次数
        int z = 0;
        //记录实际操作行为
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int t = maxQueue.peek().height - minQueue.peek().height;
            if (t > 0) {
                z++;
                min = Math.min(min, t);
                Tower maxTower = maxQueue.poll();
                Tower minTower = minQueue.poll();

                list.add(maxTower.index + 1);
                list.add(minTower.index + 1);

                maxTower.setHeight(maxTower.height - 1);
                minTower.setHeight(minTower.height + 1);
                maxQueue.add(maxTower);
                minQueue.add(minTower);
            }
        }
        min = Math.min(min, maxQueue.peek().height - minQueue.peek().height);
        System.out.println(min + " " + z);
        return list;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        List<Integer> list = code(k, nums);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i++) + " " + list.get(i));
        }
    }
}

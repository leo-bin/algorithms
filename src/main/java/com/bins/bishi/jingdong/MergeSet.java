package com.bins.bishi.jingdong;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/4/17 11:58
 * @apiNote 集合
 */
public class MergeSet {


    /**
     * 题目描述：
     * 1.给你两个集合，要求{A} + {B}
     * 2.注：同一个集合中不会有两个相同的元素
     * <p>
     * 输入描述:
     * 1.每组输入数据分为三行
     * 2.第一行有两个数字n,m(0 ≤ n,m ≤ 10000)，分别表示集合A和集合B的元素个数
     * 3.后两行分别表示集合A和集合B
     * 4.每个元素为不超过int范围的整数,每个元素之间有个空格隔开
     * <p>
     * 输出描述:
     * 针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，每个元素之间有一个空格隔开,行末无空格。
     * <p>
     * 输入例子1:
     * 3 3
     * 1 3 5
     * 2 4 6
     * <p>
     * 输出例子1:
     * 1 2 3 4 5 6
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.使用list去重并排序
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static void mergeSet(int len1, int[] set1, int len2, int[] set2) {
        //鲁棒
        if (len1 == 0 && len2 == 0) {
            System.out.println("");
        }
        List<Integer> list = new ArrayList<>();
        //1.set1全部进list
        for (int i = 0; i < len1; i++) {
            if (!list.contains(set1[i])) {
                list.add(set1[i]);
            }
        }
        //2.set2也进list，但是利用contains方法去重
        for (int j = 0; j < len2; j++) {
            if (!list.contains(set2[j])) {
                list.add(set2[j]);
            }
        }
        //3.重写一个比较器，对list排序

        ///////////////1.通过重写匿名类实现升序排序/////////////////
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        ///////////////2.通过lambda表达式实现升序排序/////////////////
        list.sort((o1, o2) -> o1 - o2);

        ///////////////3.通过比较器内部的静态api实现升序排序/////////////////
        list.sort(Comparator.naturalOrder());

        //4.循环输出
        for (int k = 0; k < list.size() - 1; k++) {
            System.out.print(list.get(k) + " ");
        }
        System.out.print(list.get(list.size() - 1));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] set1 = new int[n];
        int[] set2 = new int[m];
        for (int i = 0; i < n; i++) {
            set1[i] = scanner.nextInt();
        }
        for (int j = 0; j < m; j++) {
            set2[j] = scanner.nextInt();
        }
        mergeSet(n, set1, m, set2);
    }
}

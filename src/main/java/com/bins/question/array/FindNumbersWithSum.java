package com.bins.question.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/4/17 15:14
 * @apiNote 和为S的两个数字
 */
public class FindNumbersWithSum {


    /**
     * 题目描述：
     * 1.输入一个递增排序的数组和一个数字S
     * 2.在数组中查找两个数，使得他们的和正好是S
     * 3.如果有多对数字的和等于S，输出两个数的乘积最小的
     * <p>
     * 输出描述:
     * 对应每个测试案例，输出两个数，小的先输出
     *
     * @apiNote 思路：
     * 1.根据S=a+b，得出，b=S-a
     * 2.一次遍历，遍历同时将S-array[i]和array[i]作为key-value存map
     * 3.同时只需通过contains判断b是否存在于map中即可
     * 4.如果存在，说明可以组成一对，先存到map中，然后将乘积记录一下，因为可能会有多对
     * 5.下次如果还找到一对的话，先判断乘积是否比上次的要小，满足的话替换掉上次的结果，min也更新下
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(n)
     */
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = array.length;
        //鲁棒
        if (len <= 1) {
            return list;
        }
        HashMap<Integer, Integer> map = new HashMap<>(16);
        //以整形的最大值作为初始值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(array[i])) {
                int a = map.get(array[i]);
                int tmp = a * array[i];
                if (tmp < min) {
                    min = tmp;
                    //先清空，再接着放
                    list.clear();
                    list.add(a);
                    list.add(array[i]);
                }
            }
            map.put(sum - array[i], array[i]);
        }
        return list;
    }



    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 5};
        int sum = 4;
        List<Integer> list = findNumbersWithSum(array, sum);
        if (list != null) {
            System.out.println(list.toString());
        }
    }
}

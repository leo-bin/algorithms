package com.bins.question.array;

import java.util.ArrayList;

/**
 * @author leo-bin
 * @date 2020/4/19 12:15
 * @apiNote
 */
public class FindContinuousSequence {

    /**
     * 题目描述：
     * 1.小明很喜欢数学
     * 2.有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100
     * 3.但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)
     * 4.没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22
     * 5.现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     * <p>
     * 输出描述:
     * 1.输出所有和为S的连续正数序列
     * 2.序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     *
     * @apiNote 思路：
     * 1.滑动窗口，双指针，暴力
     * 2.设置两个指针low和high，low指向当前序列的最小值，high指向最大值
     * 3.根节题意可以得出任意序列的求和公式为：S(n)=(a0+an)*n/2
     * 4.接下来我们只要从1到2开始，根据求的和判断窗口应该怎么滑动，是往low走，还是往high走
     * 5.当low大于等于high时，说明此时的序列值永远都比目标值要大，退出循环
     */
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        //low从1开始，high从2开始
        int low = 1, high = 2;
        while (low < high) {
            int currentSum = (low + high) * (high - low + 1) / 2;
            if (currentSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                lists.add(list);
                low++;
            } else if (currentSum > sum) {
                low++;
            } else {
                high++;
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        int sum = 100;
        ArrayList<ArrayList<Integer>> lists = findContinuousSequence(sum);
        if (lists != null && lists.size() > 0) {
            System.out.println(lists.toString());
        } else {
            System.out.println("没找到");
        }
    }
}

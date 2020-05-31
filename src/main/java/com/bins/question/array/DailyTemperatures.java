package com.bins.question.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/5/31 11:53
 * @apiNote 每日温度
 * 来源：leetcode-739
 * 链接：https://leetcode-cn.com/problems/daily-temperatures/
 */
public class DailyTemperatures {


    /**
     * 题目描述：
     * 1.根据每日气温列表，请重新生成一个列表
     * 2.对应位置的输出是需要再等待多久温度才会升高超过该日的天数
     * 3.如果之后都不会升高，请在该位置用 0 来代替
     * 4.例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
     * 5.你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]
     * <p>
     * 提示：
     * 1.气温 列表长度的范围是 [1, 30000]
     * 2.每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.时间复杂度：O(m*n)
     * 3.空间复杂度：O(1)
     */
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        if (T.length <= 1) {
            return result;
        }
        for (int i = 0; i < T.length - 1; i++) {
            int j = i, count = 0;
            while (T[i] >= T[j]) {
                if (j == (T.length - 1)) {
                    count = 0;
                    break;
                }
                j++;
                count++;
            }
            result[i] = count;
        }
        return result;
    }


    /**
     * 解法二，使用单调栈来进一步的优化时间
     *
     * @apiNote 思路：
     * 1.单调栈的思想
     * 2.我们可以维护一个单调递减的栈（这里的递减指的是出栈的元素大小一定是递减的）
     * 3.也就是说只要当前的元素比栈顶的元素要大，那就把栈顶的元素拿出来计算此时的两个元素的相对位置
     * 4.这个相对位置就是栈顶元素所在位置的天数
     * 5.如果要小的话，那就直接将元素压栈
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(n)
     */
    public static int[] dailyTemperaturesV2(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int pre = stack.pop();
                result[pre] = i - pre;
            }
            stack.push(i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperaturesV2(T);
        System.out.println(Arrays.toString(result));
    }
}

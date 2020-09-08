package com.bins.question.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/9/8 14:23
 * @apiNote 杨辉三角
 * 来源：leetcode-118
 * 链接：https://leetcode-cn.com/problems/pascals-triangle/
 */
public class PascalTriangle {

    /**
     * 题目描述：
     * 1.给定一个非负整数numRows
     * 2.生成杨辉三角的前numRows行
     * 3.在杨辉三角中，每个数是它左上方和右上方的数的和
     * <p>
     * 示例:
     * 输入: 5
     * 输出:
     * [
     * *      [1],
     * *     [1,1],
     * *    [1,2,1],
     * *   [1,3,3,1],
     * *  [1,4,6,4,1]
     * ]
     *
     * @apiNote 思路：
     * 1.暴力模拟就行
     * 2.时间复杂度 ：O(n*n)
     * 3.空间复杂度：O(1)
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        //特判
        if (numRows <= 0) {
            return result;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int up1 = j - 1 >= 0 ? result.get(i - 1).get(j - 1) : 0;
                int up2 = j < result.get(i - 1).size() ? result.get(i - 1).get(j) : 0;
                row.add(up1 + up2);
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        int numsRows = 1;
        List<List<Integer>> result = generate(numsRows);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}

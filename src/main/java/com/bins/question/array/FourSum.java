package com.bins.question.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/10/5 10:51
 * @apiNote 四数之和
 * 来源：leetcode-18
 * 链接：https://leetcode-cn.com/problems/4sum/
 */
public class FourSum {

    /**
     * 题目描述：
     * 1.给定一个包含n个整数的数组nums和一个目标值target
     * 2.判断nums中是否存在四个元素a，b，c和d
     * 3.使得 a + b + c + d 的值与 target 相等
     * 4.找出所有满足条件且不重复的四元组
     * 5.答案中不可以包含重复的四元组
     * <p>
     * 示例：
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     *
     * @apiNote 思路：
     * 1.可以参考三数之和的解法，先排序，然后使用双指针不断的逼近最终的结果
     * 2.首先是有a+b+c+d=target，那么就有target-a-b=c+d
     * 3.我们设定两个外层循环，第一层循环我们确定一个a，第二层循环我们确定一个b
     * 4.接下来我们就可以使用双指针i和j来确定c和d
     * 5.剩下的就是一些剪枝和去重的操作了，我们在三数之和中写过了，这里就当重温了
     * 6.时间复杂度：O(n^3)
     * 7.空间复杂度：O(1)
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //特判
        if (nums == null || nums.length <= 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 3; a++) {
            //剪枝
            if (a >= 1 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length - 2; b++) {
                //剪枝
                if (b >= a + 2 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int newTarget = target - nums[a] - nums[b];
                int i = b + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int cd = nums[i] + nums[j];
                    if (cd == newTarget) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[i], nums[j]));
                        //去重
                        i++;
                        while (i < j && nums[i] == nums[i - 1]) {
                            i++;
                        }
                        j--;
                        while (i < j && b < j && nums[j] == nums[j + 1]) {
                            j--;
                        }
                    } else if (cd > newTarget) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        for (List<Integer> r : result) {
            System.out.println(r.toString());
        }
    }
}

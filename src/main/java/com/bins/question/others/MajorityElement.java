package com.bins.question.others;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/7/18 11:28
 * @apiNote 多数元素
 * 来源：leetcode-169
 * 链接：https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {

    /**
     * 题目描述：
     * 1.给定一个大小为 n 的数组，找到其中的多数元素
     * 2.多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素
     * 3.你可以假设数组是非空的，并且给定的数组总是存在多数元素
     * <p>
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     *
     * @apiNote 思路：
     * 1.哈希表直接contains判断
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        int element = nums[0];
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
                if (map.get(n) > (nums.length / 2)) {
                    element = n;
                    break;
                }
            } else {
                map.put(n, 1);
            }
        }
        return element;
    }


    /**
     * 解法二，贪心
     *
     * @apiNote 思路：
     * 1.根据题目的要求，首先是一定会有一个数超过元素总和的一半
     * 2.那我们就直接数组进行排序，比如：{2，2，1，1，1，2，2}
     * 3.排序之后的结果就是：{1，1，1，2，2，2，2}
     * 4.因为某个元素占了数组的一半以上！所以如果对排序之后的数组对半切分一下
     * 5.于是就得到了：{1，1，1，2}和{2，2，2}，可以看到下标为：{nums.length/2}的元素就是我们要找的数！
     * 6.时间复杂度：O(n*log(n))
     * 7.空间复杂度：O(1)
     */
    public static int majorityElementV2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 解法三，摩尔抵消法
     *
     * @apiNote 思路：
     * 1.通过设置一个count变量和element变量记录当前元素的出现次数和元素
     * 2.遇到相同的次数+1，不相同的就-1，类似于抵消
     * 3.全部抵消之后剩下的就一定是多数元素！
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(1)
     */
    public static int majorityElementV3(int[] nums) {
        int element = nums[0];
        int count = 0;
        for (int n : nums) {
            //count归零了那就重新找一个元素开始
            if (count == 0) {
                element = n;
                count = 1;
            }
            //进行抵消，相同的+1，不相同的-1
            if (element != n) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement(nums1));
        System.out.println(majorityElement(nums2));
    }
}

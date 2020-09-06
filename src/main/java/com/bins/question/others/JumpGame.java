package com.bins.question.others;

/**
 * @author leo-bin
 * @date 2020/5/4 12:16
 * @apiNote 跳跃游戏
 */
public class JumpGame {

    /**
     * 题目描述：
     * 1.给定一个非负整数数组，你最初位于数组的第一个位置
     * 2.数组中的每个元素代表你在该位置可以跳跃的最大长度
     * 3.你的目标是使用最少的跳跃次数到达数组的最后一个位置
     * <p>
     * 示例:
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * <p>
     * 解释:
     * 1.跳到最后一个位置的最小跳跃数是 2
     * 2.从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置
     * 3.假设你总是可以到达数组的最后一个位置
     *
     * @apiNote 思路：
     * 1.贪心
     * 2.我们只要从第一个位置开始，每次找到某个范围的能够跳的最远的位置最为下一个位置
     * 3.时间复杂度：O(n)(平均)
     * 4.空间复杂度：O(1)
     */
    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        //记录最少跳跃次数
        int count = 0;
        //跳跃窗口起始位置，从第一个元素开始
        int start = 0;
        //跳跃窗口结束位置
        int end = 0;
        //下一次跳跃的位置
        int nextJumpIndex = 0;
        while (end < nums.length - 1) {
            //在当前窗口内寻找下一个跳跃点
            for (int i = start; i <= end; i++) {
                //这里是关键，一定要弄明白为什么是要额外+i
                nextJumpIndex = Math.max(nextJumpIndex, nums[i] + i);
            }
            //更新窗口位置和跳跃次数
            start = end + 1;
            end = nextJumpIndex;
            count++;
        }
        return count;
    }


    /**
     * 解法二，进一步优化
     *
     * @apiNote 思路：
     * 1.还是之前的思路，我们可以分析一下
     * 2.while内部的for循环需要寻找某个范围内的最大跳跃次数
     * 3.这个for其实可以去掉，我们只需要遍历一次数组
     * 4.首先只要设置一个结束点end代表当前范围的最大的位置
     * 5.我们在遍历的同时就可以去寻找这个最大跳跃点
     * 6.只有当前遍历的下标等于之前设定的结束位置时我们去更新下一个结束位置和跳跃次数
     * 7.因为某个范围内的所有跳跃点我们都找了，结束的同时下一个跳跃点的位置也找出来了
     * 8.时间复杂复：O(n)
     * 9.空间复杂度：O(1)
     */
    public static int jumpV2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jumpCount = 0;
        int end = 0;
        int nextJumpIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextJumpIndex = Math.max(nextJumpIndex, nums[i] + i);
            if (i == end) {
                end = nextJumpIndex;
                jumpCount++;
            }
        }
        return jumpCount;
    }


    public static void main(String[] args) {

    }
}

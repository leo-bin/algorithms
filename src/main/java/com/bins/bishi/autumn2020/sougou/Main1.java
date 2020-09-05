package com.bins.bishi.autumn2020.sougou;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/9/5 17:55
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.汪仔最近在玩一款游戏，正值暑假游戏出了夏日活动
     * 2.可以通过打副本来获得汪仔很喜欢的奖品。
     * 游戏的副本里会掉落三种不同的道具（分别是A道具，B道具，C道具）
     * 在活动结束后可以使用三种不同的道具各一个来换取一件奖品。
     * 虽然这三种道具在游戏中掉落的概率是相同的
     * 但是可能会出现有一些玩家因为运气不佳某一类道具掉落的极少导致最后能获得的奖品数量也很少
     * 良心的游戏策划为了减少这种悲剧发生
     * 规定可以用任意两个道具（这两个道具可以是同一种也可以不是同一种）
     * 来交换一个任意指定的道具（比如可以用两个A道具换一个C道具，或者用一个B道具和一个C道具换一个A道具）。
     * 现在汪仔有A道具a个，B道具b个，C道具c个
     * 汪仔想知道他最多能交换多少个奖品，你能告诉汪仔吗？
     * <p>
     * 示例1
     * 输入
     * 4,4,2
     * 输出
     * 3
     * 说明
     * 可以拿一个A道具和一个B道具换一个C道具，这样最后每种道具都有3个，最后可以换3个奖品
     * <p>
     * 示例2
     * 输入
     * 9,3,3
     * 输出
     * 4
     * 说明
     * 可以拿两个A道具换一个B道具，再拿两个A道具换一个C道具，这样最后有5个A道具4个B道具4个C道具，最后可以换4个奖品
     *
     * @apiNote 思路：
     * 1.贪心
     */
    public static int code(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        int max = nums[0];
        nums[0] -= max;
        nums[1] -= max;
        nums[2] -= max;
        //考虑两种情况：
        //1.当a=b=0并且c不等于0，剩下的就是c给a，b进行分配，一共需要分2+2+1=5
        if (nums[1] == 0) {
            return max + nums[2] / 5;
        }
        //2.当a=0但是b和c不等于0，剩下的就是b和c给a进行分配，一共需要分2+1+1=4
        return max + (nums[1] + nums[2]) / 4;
    }

    public static void main(String[] args) {
        int a = 2, b = 4, c = 4;
        System.out.println(code(a, b, c));
    }
}

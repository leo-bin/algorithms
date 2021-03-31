package com.bins.question.dp;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/10/24 16:23
 * @apiNote 视频拼接
 * 来源：leetcode-1024(刚好是10.24)
 * 链接：https://leetcode-cn.com/problems/video-stitching/
 */
public class VideoStitching {

    /**
     * 题目描述：
     * 1.你将会获得一系列视频片段，这些片段来自于一项持续时长为T秒的体育赛事
     * 2.这些片段可能有所重叠，也可能长度不一
     * 3.视频片段clips[i]都用区间进行表示：开始于clips[i][0]并于clips[i][1]结束
     * 4.我们甚至可以对这些片段自由地再剪辑，例如片段 [0,7]可以剪切成[0,1]+[1,3]+[3,7]三部分
     * 5.我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）
     * 6.返回所需片段的最小数目，如果无法完成该任务，则返回-1
     * <p>
     * 示例 1：
     * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
     * 输出：3
     * 解释：
     * 我们选中 [0,2], [8,10], [1,9] 这三个片段
     * 然后，按下面的方案重制比赛片段：
     * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9]
     * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]
     * <p>
     * 示例 2：
     * 输入：clips = [[0,1],[1,2]], T = 5
     * 输出：-1
     * 解释：
     * 我们无法只用[0,1]和[1,2]覆盖[0,5]的整个过程
     * <p>
     * 示例 3：
     * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]],
     * T = 9
     * 输出：3
     * 解释：
     * 我们选取片段[0,4],[4,7]和[6,9]
     * <p>
     * 示例 4：
     * 输入：clips = [[0,4],[2,8]], T = 5
     * 输出：2
     * 解释：
     * 注意，你可能录制超过比赛结束时间的视频
     *
     * @apiNote 思路：
     * 1.最优解，考虑使用dp来解题
     * 2.我们可以假设dp[i]为0-i片段所需要的最小段落数
     * 3.剩下的就只要枚举所有的片段进行判断是否满足覆盖当前的0-i，并且统计片段数
     * 4.base case是dp[0]=0,因为时间段为0-0肯定不需要任何片段
     * 5.此时的状态方程是:dp[i]=min(dp[i],dp[(当前片段的开始时间)]+1)
     * 6.时间复杂度：O(m*n)(m表示整个周期T，n就是所有片段数目)
     * 7.空间复杂度：O(m)
     */
    public static int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int t = 1; t <= T; t++) {
            for (int[] clip : clips) {
                //当前片段需要覆盖住当前所在的周期
                if (clip[0] < t && clip[1] >= t) {
                    //更新所需要的片段数
                    dp[t] = Math.min(dp[t], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }


    public static void main(String[] args) {

    }
}
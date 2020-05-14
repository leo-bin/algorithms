package com.bins.question.others;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/25 11:12
 * @apiNote 扑克牌顺子
 */
public class IsContinuous {


    /**
     * 题目描述：
     * 1.LL今天心情特别好,因为他去买了一副扑克牌
     * 2.发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)
     * 3.他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子
     * 4.如果抽到的话,他决定去买体育彩票,嘿嘿！！
     * 5.“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了
     * 6.他想了想,决定大\小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13
     * 7.上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”
     * 8.LL决定去买体育彩票啦
     * 9.现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何
     * 10.如果牌能组成顺子就输出true，否则就输出false
     * 11.为了方便起见,你可以认为大小王是0
     * <p>
     * 测试用例：
     * 输入：{1, 1, 3, 5, 4}
     * 输出：false
     * <p>
     * 输入：{1, 3, 2, 5, 4}
     * 输出：false
     * <p>
     * 输入：{0, 3, 2, 6, 4}
     * 输出：true
     * <p>
     * 输入：{0, 3, 1, 6, 4}
     * 输出：false
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.先排序
     * 3.然后一次遍历，统计0的个数记为count
     * 4.下一次遍历从count开始，判断numbers[i+1]-numbers[i]是否等于1，等于1不用管，跳过
     * 5.不等于1，接着判断是否==0或者大于count+1，成立的话直接返回false
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(1)
     */
    public static boolean isContinuous(int[] numbers) {
        int len = numbers.length;
        //鲁棒
        if (len == 0) {
            return false;
        }
        //1.排序
        Arrays.sort(numbers);
        //2.统计0的个数
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (0 == numbers[i]) {
                count++;
            } else {
                break;
            }
        }
        //3.判断
        for (int i = count; i < len - 1; i++) {
            int tmp = numbers[i + 1] - numbers[i];
            if (tmp == 1) {
                continue;
            }
            if (tmp == 0 || tmp > count + 1) {
                return false;
            } else if (tmp == 2) {
                count--;
            }
        }
        //大王小王都用完了，但是依旧缺牌
        if (count < 0) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums9 = {1, 1, 3, 4, 5};
        int[] nums10 = {1, 3, 2, 5, 4};
        int[] nums11 = {0, 3, 2, 6, 4};
        int[] nums12 = {0, 3, 1, 6, 4};
        System.out.println(isContinuous(nums9));
        System.out.println(isContinuous(nums10));
        System.out.println(isContinuous(nums11));
        System.out.println(isContinuous(nums12));
    }

}

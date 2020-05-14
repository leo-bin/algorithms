package com.bins.question.math;

import java.util.LinkedList;

/**
 * @author leo-bin
 * @date 2020/4/20 10:05
 * @apiNote 最后剩下的编号。。。，约瑟夫环的问题
 */
public class LastRemaining {

    /**
     * 题目描述：
     * 1.每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此
     * 2.HF作为牛客的资深元老,自然也准备了一些小游戏
     * 3.其中,有个游戏是这样的:首先,让小朋友们围成一个大圈
     * 4.然后,他随机指定一个数m,让编号为0的小朋友开始报数
     * 5.每次喊到m-1的那个小朋友要出列唱首歌
     * 6.然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中
     * 7.从他的下一个小朋友开始,继续0...m-1报数...这样下去...直到剩下最后一个小朋友,可以不用表演
     * 8.并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)
     * 9.请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     * 10.如果没有小朋友，请返回-1
     *
     * @apiNote 思路：
     * 1.数组暴力模拟
     * 2.通过数组来模拟的话，由于我们无法将数组中的元素删除，只能设计标记位
     * 3.所以这种方式，会造成大量的重复无用的循环
     */
    public static int lastRemaining(int n, int m) {
        //鲁棒
        if (n <= 0 || m <= 0) {
            return -1;
        }
        //1.构造一个数组
        int[] nums = new int[n];
        //2.初始化数组，初始全都设为1
        for (int i = 0; i < n; i++) {
            nums[i] = 1;
        }
        //3.通过循环模拟游戏过程，记录标记次数
        //统计报数
        int count = -1;
        //统计标记次数
        int flag = 0;
        //控制循环
        int i = 0;
        while (true) {
            if (nums[i] != -1) {
                //报数
                count++;
            }
            if (count == (m - 1)) {
                //标记一次
                flag++;
                //置为-1，代表出圈
                nums[i] = -1;
                //重新报数
                count = -1;
                if (flag == n) {
                    break;
                }
            }
            //控制循环
            if (i == (n - 1)) {
                i = 0;
            } else {
                i++;
            }
        }
        return i;
    }


    /**
     * @apiNote 思路：
     * 1.解法二，我们使用链表代替数组来模拟游戏
     * 2.而且可以根据题意，推导出，每次要删除的元素的下标为，currrent=(current+(m-1))%list.size()
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static int lastRemainingV2(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        //1.将所有小朋友的下标写入list
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //2.模拟游戏的过程，根据公式求要删除的节点的下标
        int pre = 0;
        //只剩下一个元素的时候退出
        while (list.size() > 1) {
            //每次从上一个标记位开始，因为考虑到长度会越界，所以做一下取余
            int current = (pre + (m - 1)) % list.size();
            //删掉当前找到的下标
            list.remove(current);
            //更新pre
            pre = current;
        }
        return list.size() == 1 ? list.get(0) : -1;
    }


    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        System.out.println(lastRemaining(n, m));
    }

}

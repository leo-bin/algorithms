package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/10/21 15:30
 * @apiNote 长按键入
 * 来源：leetcode-925
 * 链接：https://leetcode-cn.com/problems/long-pressed-name/
 */
public class IsLongPressedName {

    /**
     * 题目描述：
     * 1.你的朋友正在使用键盘输入他的名字 name
     * 2.偶尔，在键入字符c时，按键可能会被长按，而字符可能被输入1次或多次
     * 3.你将会检查键盘输入的字符 typed
     * 4.如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True
     * <p>
     * 示例 1：
     * 输入：name = "alex", typed = "aaleex"
     * 输出：true
     * 解释：'alex' 中的 'a' 和 'e' 被长按
     * <p>
     * 示例 2：
     * 输入：name = "saeed", typed = "ssaaedd"
     * 输出：false
     * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
     * <p>
     * 示例 3：
     * 输入：name = "leelee", typed = "lleeelee"
     * 输出：true
     * <p>
     * 示例 4：
     * 输入：name = "laiden", typed = "laiden"
     * 输出：true
     * 解释：长按名字中的字符并不是必要的。
     * <p>
     * 提示：
     * name.length <= 1000
     * typed.length <= 1000
     * name 和 typed 的字符都是小写字母
     *
     * @apiNote 思路：
     * 1.这题思路不难想到，但是在理解题意上面需要下功夫
     * 2.其实就是对输入的typed字符串进行检查，要求输入的字符串中每一个字符的出现次数大于等于原字符串中的
     * 3.模拟键入的过程就行，按照名字name进行遍历，统计当前字符出现次数和键入字符进行比较即可
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static boolean isLongPressedName(String name, String typed) {
        char[] names = name.toCharArray();
        char[] types = typed.toCharArray();
        int i = 0, j = 0;
        for (; i < names.length && j < types.length; i++, j++) {
            //不同字符直接结束
            if (names[i] != types[j]) {
                return false;
            }
            int target = 1;
            while (i < names.length - 1 && names[i] == names[i + 1]) {
                i++;
                target++;
            }
            int count = 1;
            while (j < types.length - 1 && types[j] == types[j + 1]) {
                j++;
                count++;
            }
            if (count < target) {
                return false;
            }
        }
        return i == names.length && j == types.length;
    }


    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";
        System.out.println(isLongPressedName(name, typed));
    }
}

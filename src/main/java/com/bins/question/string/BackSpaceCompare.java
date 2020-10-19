package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/10/19 16:05
 * @apiNote 比较含退格的字符串
 * 来源：leetcode-844
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class BackSpaceCompare {

    /**
     * 题目描述：
     * 1.给定S和T两个字符串
     * 2.当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果
     * 3.#代表退格字符
     * 4.注意：如果对空文本输入退格字符，文本继续为空
     * <p>
     * 示例 1：
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S和T都会变成“ac”
     * <p>
     * 示例 2：
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S和T都会变成“”。
     * <p>
     * 示例 3：
     * 输入：S="a##c", T="#a#c"
     * 输出：true
     * 解释：S和T都会变成“c”
     * <p>
     * 示例 4：
     * 输入：S="a#c", T="b"
     * 输出：false
     * 解释：S会变成“c”，但T仍然是“b”
     * <p>
     * 提示：
     * 1<=S.length<=200
     * 1<=T.length<=200
     * S和T只含有小写字母以及字符 '#'
     * <p>
     * 进阶：
     * 你可以用O(N)的时间复杂度和O(1)的空间复杂度解决该问题吗
     *
     * @apiNote 思路：
     * 1.非常简单的思路，我们模拟键盘读取输入就行
     * 2.遇到字符就存在缓存区，遇到#就删掉缓存中的最后一个字符即可
     * 2.时间复杂度 ：O(n)
     * 3.空间复杂度：O(n)
     */
    public static boolean backSpaceCompare(String S, String T) {
        return make(S).equals(make(T));
    }

    /**
     * 构造完整的字符串
     */
    public static String make(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                builder.append(s.charAt(i));
            } else {
                if (builder.length() >= 1) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String S = "a#c";
        String T = "b";
        System.out.println(backSpaceCompare(S, T));
    }
}

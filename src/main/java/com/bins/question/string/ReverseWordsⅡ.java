package com.bins.question.string;

import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/9/17 10:30
 * @apiNote 反转单词 Ⅱ
 * 来源：leetcode-151，剑指offer-58-Ⅰ
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsⅡ {

    /**
     * 题目描述：
     * 1.牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上
     * 2.同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思
     * 3.例如，“student. a am I”
     * 4.后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”
     * 5.Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * <p>
     * 示例 1：
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * <p>
     * 示例 2：
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * <p>
     * 示例 3：
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * <p>
     * 说明：
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个
     *
     * @apiNote 思路：
     * 1.使用栈来保存所有的单词
     * 2.出栈就是反序好的单词序列了
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static String reverserSentence(String s) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        //1.以空格分割成单词数组
        String[] words = s.split(" ");
        //2.每一个单词按照顺序进栈
        for (String word : words) {
            if (!word.equals("")) {
                stack.push(word);
            }
        }
        //3.再次出栈就反序了
        while (!stack.isEmpty()) {
            result.append(stack.pop() + " ");
        }
        return result.toString().trim();
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.通过仔细分析我们可以知道，其实可以通过对每一个单词两次反转来实现整体的反序
     * 2.假设我们要反转的句子是：“student a am I”(先忽略句号)
     * 3.正确的答案应该是：“I am a student”
     * 4.首先第一次整体反转得到：“I ma a tneduts”
     * 5.现在只要对每一个单词再次反序，就可得到正确序列
     * 6.I不用反转，ma反转为am，a不用反转，tneduts反转为student
     * 7.时间复杂复：O(n*logn)
     * 8.空间复杂度：O(1)
     */
    public static String reverseSentenceV2(String str) {
        char[] chs = str.toCharArray();
        int len = chs.length;
        //记录空格所在的位置
        int blankPosition = -1;
        //1.整体反转一次
        reverseHelper(chs, 0, len - 1);
        //2.遍历原数组，根据空格的位置找到所有单词进行二次反转
        for (int i = 0; i < len; i++) {
            if (chs[i] == ' ') {
                int nextPosition = i;
                reverseHelper(chs, blankPosition + 1, nextPosition - 1);
                blankPosition = nextPosition;
            }
        }
        //3.因为最后一个单词没有空格，这里需要对最后一个单词单独反转
        reverseHelper(chs, blankPosition + 1, len - 1);
        return new String(chs);
    }


    /**
     * 根据起始位和结束位反转原数组
     */
    public static void reverseHelper(char[] chs, int start, int end) {
        while (start < end) {
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "student. a am I";
        String str1 = " ";
        String str2 = "";
        String str3 = "   ";
        String str4 = "  hello world!  ";
        String str5 = "a good   example";
        System.out.println(reverserSentence(str));
        System.out.println(reverserSentence(str1));
        System.out.println(reverserSentence(str2));
        System.out.println(reverserSentence(str3));
        System.out.println(reverserSentence(str4));
        System.out.println(reverserSentence(str5));
    }
}

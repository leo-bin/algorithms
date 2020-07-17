package com.bins.bishi.spring2020.alibaba;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/1 11:42
 * @apiNote DNA匹配问题
 */
public class DNAMatching {


    /**
     * 题目描述:
     * 1.DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。
     * 2.碱基互补配对原则：A和T是配对的，C和G是配对的。
     * 3.如果两条碱基链长度是相同的并且每个位置的碱基是配对的，那么他们就可以配对合成为DNA的双螺旋结构
     * 4.现在给出两条碱基链，允许在其中一条上做替换操作：把序列上的某个位置的碱基更换为另外一种碱基
     * 5.问最少需要多少次让两条碱基链配对成功
     * <p>
     * 输入描述:
     * 输入包括一行： 包括两个字符串,分别表示两条链,两个字符串长度相同且长度均小于等于50。
     * <p>
     * 输出描述:
     * 输出一个整数，即最少需要多少次让两条碱基链配对成功
     * <p>
     * 输入例子1:
     * ACGT TGCA
     * <p>
     * 输出例子1:
     * 0
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static int dnaMatching(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int count = 0;
        for (int i = 0; i < ch1.length; i++) {
            if (!isMatching(ch1[i], ch2[i])) {
                count++;
            }
        }
        return count;
    }

    public static boolean isMatching(char ch1, char ch2) {
        //A是否和C匹配
        if (ch1 == 'A') {
            return ch2 == 'T';
        } else if (ch1 == 'T') {
            return ch2 == 'A';
        }
        //C是否和G匹配
        if (ch1 == 'C') {
            return ch2 == 'G';
        } else if (ch1 == 'G') {
            return ch2 == 'C';
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        System.out.println(dnaMatching(str1, str2));
    }

}

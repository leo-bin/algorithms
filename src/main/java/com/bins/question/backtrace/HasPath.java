package com.bins.question.backtrace;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/21 12:01
 * @apiNote 矩阵中的路径，经典回溯
 */
public class HasPath {


    /**
     * 题目描述：
     * 1.请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
     * 2.路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子
     * 3.如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子
     * 4.例如：
     * a  b  c  e
     * s  f  c  s
     * a  d  e  e
     * ​5.矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径
     * 6.因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
     *
     * @apiNote 思路：
     * 1.回溯经典题
     * 2.本题首先要解决的就是如何去理解这个输入，按道理来说是矩阵的，但是给了一维数组
     * 3.一开始也没有头绪，但是我们可以看到输入同时还给了行和列
     * 4.但是一维数组为什么要给行和列讷？很明显是要我们自己构建二维数组
     * 5.比如输入的是，martix={a,b,c,e,s,f,c,s,a,d,e,e},rows=3,cols=4
     * 6.那么构建的二维数组就是：{{a,b,c,e},{s,f,c,s},{a,d,e,e}}
     * 7.理解了这一点的话，我们现在有两种做法，一是我们自己创建这个二维数组
     * 8.或者我们就使用原来的一维数组，通过公式index=i*cols+j，来计算元素的下标
     * 9.我们知道回溯大部分都会使用递归来解决问题
     * 10.我们首先找到递归的结束条件
     * 11.根据题目可以知道，我们每次递归可以走四个方向，而且每次都需要判断是否等于我们要找的字符，而且规定不能使用重复的字符
     * 12.所以递归的结束条件就是，不能越界，要满足字符相等，不能重复使用
     * 13.然后我们找递归的公式，很显然，就是分别走四个方向，每个方向都是一次递归
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //鲁棒
        if (matrix.length < str.length || rows > matrix.length || cols > matrix.length) {
            return false;
        }
        //构建一个和原一维数组大小相同的boolean数组，记录字符是否被使用过
        boolean[] flag = new boolean[matrix.length];
        //设置一个字符匹配数
        int k = 0;
        //间接的构建二维数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //找到一组直接返回true
                if (pathHelper(matrix, i, j, rows, cols, str, flag, k)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 通过不断的递归来寻路
     */
    public static boolean pathHelper(char[] matrix, int i, int j, int rows, int cols
            , char[] str, boolean[] flag, int k) {
        //通过公式计算出二维数组在一维数组中的位置
        int index = i * cols + j;
        //1.递归结束条件
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }
        //如果刚好匹配完的话，直接返回true
        if (k == str.length - 1) {
            return true;
        }
        //开始回溯之前将本次回溯的字符标记位置为true，表示已经使用过了
        flag[index] = true;
        //开始回溯，上下左右分别回溯
        if (pathHelper(matrix, i - 1, j, rows, cols, str, flag, k + 1) ||
                pathHelper(matrix, i + 1, j, rows, cols, str, flag, k + 1) ||
                pathHelper(matrix, i, j - 1, rows, cols, str, flag, k + 1) ||
                pathHelper(matrix, i, j + 1, rows, cols, str, flag, k + 1)) {
            return true;
        }
        //四个方向都没找到的话，说明当前字符不行,我们往回走，恢复flag
        flag[index] = false;
        return false;
    }


    /**
     * 标准IO：
     * Scanner scanner = new Scanner(System.in);
     * char[] matrix = scanner.next().toCharArray();
     * int rows = scanner.nextInt();
     * int cols = scanner.nextInt();
     * char[] str = scanner.next().toCharArray();
     * System.out.println(hasPath(matrix,rows,cols,str));
     */
    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        int rows = 3;
        int cols = 4;
        char[] str = {'b', 'c', 'c', 'e', 'd'};
        System.out.println(hasPath(matrix, rows, cols, str));
    }
}

package com.bins.bishi.yuewen;

/**
 * @author leo-bin
 * @date 2020/5/19 20:20
 * @apiNote 压轴题
 */
public class Main4 {

    /**
     * 题目描述：
     * 1.假设有N个用户，其中有些人是朋友，有些则不是
     * 2.A和B是朋友，B和C是朋友，这样ABC就是一个朋友圈
     * 3.请计算给定的朋友关系的朋友圈数
     * 4.给定一个 N * N 的矩阵 M，表示用户之间的朋友关系
     * 5.如果M[i][j] = 1，表示已知第 i 个和 j 个人互为朋友关系，否则为不知道
     * 6.你必须输出所有用户中的已知的朋友圈总数
     * <p>
     * 输入描述:
     * 1.第一行输入为表示用户数N
     * 2.第2到1+N行表示朋友之间关系，如果值为1表示有朋友关系
     * <p>
     * 输出描述:
     * 1.输出朋友圈数
     * <p>
     * 输入
     * 3
     * 1,1,0
     * 1,1,0
     * 0,0,1
     * <p>
     * 输出
     * 2
     * 说明:
     * 1.第0个用户和第1个用户组成一个朋友圈，第2个用户组成一个朋友圈
     * 2.示例2输入输出示例仅供调试，后台判题数据一般不包含示例
     * <p>
     * 输入
     * 3
     * 1,1,0
     * 1,1,1
     * 0,1,1
     * <p>
     * 输出
     * 1
     * <p>
     * 说明:第0，1，2个用户组成了一个朋友圈
     * 备注:
     * 如果M[i][j] = 1 那么 如果M[j][i] = 1，用户自己和自己肯定是朋友关系即M[i][i]=1
     * 用户数量不超过10000
     *
     * @apiNote 思路：
     * 1.回溯+bfs
     * 2.这道题抽象出现的话就是求一个正方形矩阵中有多少个连在一起的1的部分
     * 3.比如说第一个例子：
     * 1 1 0
     * 1 1 0
     * 0 0 1
     * 4.很显然有两个全为1的部分连在一起：
     * 1 1  和 1
     * 1 1
     * 5.这里不能走对角线，根据题目的规定其实就能想到这一点了
     */
    public static int firend(int n, int[][] relations) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //只有还没变成2的并且本身是1的位置才能进行回溯
                if (relations[i][j] == 1) {
                    find(relations, i, j, n);
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * bfs查找
     */
    public static void find(int[][] relations, int i, int j, int n) {
        //1.递归结束条件
        if (i < 0 || i >= n || j < 0 || j >= n || relations[i][j] != 1) {
            return;
        }
        //2.开始查找，找到一个置为2
        relations[i][j] = 2;
        //2.只能从上下左右两个方向开始回溯
        find(relations, i + 1, j, n);
        find(relations, i - 1, j, n);
        find(relations, i, j + 1, n);
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] relations1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] relations2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(firend(n, relations1));
        System.out.println(firend(n, relations2));
    }
}

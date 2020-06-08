package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/6/8 10:39
 * @apiNote 等式方程的可满足性
 * 来源：leetcode-980
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 */
public class EquationsPossible {

    /**
     * 题目描述：
     * 1.给定一个由表示变量之间关系的字符串方程组成的数组
     * 2.每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一：
     * 3."a==b" 或 "a!=b"
     * 4.在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名
     * 5.只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
     * <p>
     * 示例 1：
     * 输入：["a==b","b!=a"]
     * 输出：false
     * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
     * <p>
     * 示例 2：
     * 输出：["b==a","a==b"]
     * 输入：true
     * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
     * <p>
     * 示例 3：
     * 输入：["a==b","b==c","a==c"]
     * 输出：true
     * <p>
     * 示例 4：
     * 输入：["a==b","b!=c","c==a"]
     * 输出：false
     * <p>
     * 示例 5：
     * 输入：["c==c","b==d","x!=z"]
     * 输出：true
     * <p>
     * 提示：
     * 1 <= equations.length <= 500
     * equations[i].length == 4
     * equations[i][0] 和 equations[i][3] 是小写字母
     * equations[i][1] 要么是 '='，要么是 '!'
     * equations[i][2] 是 '='
     *
     * @apiNote 思路：
     * 1.并查集的思想
     * 2.我们将所有的等式关系都变成一个有向图
     * 3.比如说：a==b,b==c,a==c,它表示的图就是:a->b->c
     * 4.只要这个有向图是连通的那就说明等式都成立，否则false
     * 5.所以接下来就是要合并所有相等关系的等式，用这些等式生成一个有向图
     * 6.然后判断那些非相等关系的等式是否在有向图中，如果在的话，说明矛盾了吗
     * 7.时间复杂度：O(n)
     * 8.空间复杂度：O(1)
     */
    public static boolean equationsPossible(String[] equations) {
        //因为变量是26个字母
        int[] parent = new int[26];
        //一开始，所有变量都是根节点，没有任何关系
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        //1.通过相等关系的等式构建有向图
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                int index1 = s.charAt(0) - 'a';
                int index2 = s.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        //2.通过构建好的图和不相等的等式找不符合的等式
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                int index1 = s.charAt(0) - 'a';
                int index2 = s.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 将两个节点合并，这里就是将节点1的根节点指向节点2
     */
    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = parent[find(parent, index2)];
    }

    /**
     * 查找给定节点的根节点
     */
    public static int find(int[] parent, int index) {
        //只要找到的节点不是此节点
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }


    public static void main(String[] args) {
        String[] equations1 = {"a==b", "b!=a"};
        String[] equations2 = {"b==a", "a==b"};
        String[] equations3 = {"a==b", "b==c", "a==c"};
        String[] equations4 = {"a==b", "b!=c", "c==a"};
        String[] equations5 = {"c==c", "b==d", "x!=z"};
        System.out.println(equationsPossible(equations1));
        System.out.println(equationsPossible(equations2));
        System.out.println(equationsPossible(equations3));
        System.out.println(equationsPossible(equations4));
        System.out.println(equationsPossible(equations5));
    }
}

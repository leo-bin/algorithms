package com.bins.question.others;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/5/17 12:06
 * @apiNote 课程表 Ⅰ
 * 来源：leetcode-207
 * 链接：https://leetcode-cn.com/problems/course-schedule/
 */
public class CanFinish {


    /**
     * 题目描述：
     * 1.你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1
     * 2.在选修某些课程之前需要一些先修课程
     * 3.例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     * 4.给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     * <p>
     * 示例 1:
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     * <p>
     * 示例 2:
     * 输入: 2, [[1,0],[0,1]]
     * 输出: false
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
     * <p>
     * 提示：
     * 1.输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
     * 2.你可以假定输入的先决条件中没有重复的边。
     * 3.1 <= numCourses <= 10^5
     *
     * @apiNote 思路：
     * 1.拓扑排序的思想
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //所有课程的初始入度数组
        int[] indegree = new int[numCourses];
        //存放所有课程的依赖关系的map，key=课程号，value=依赖key的课程号
        HashMap<Integer, List<Integer>> map = new HashMap<>(16);
        //bfs队列
        Queue<Integer> queue = new LinkedList<>();
        //拓扑排序结果
        List<Integer> topResult = new ArrayList<>();
        //1.初始化入度和依赖关系
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            if (map.containsKey(prerequisites[i][1])) {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }
        //2.将所有入度为0的课程入队列
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        //3.bfs搜索
        while (!queue.isEmpty()) {
            int course = queue.poll();
            topResult.add(course);
            if (map.containsKey(course) && map.get(course).size() != 0) {
                for (int sub : map.get(course)) {
                    indegree[sub]--;
                    if (indegree[sub] == 0) {
                        queue.offer(sub);
                    }
                }
            }
        }
        return topResult.size() == numCourses;
    }

    public static void main(String[] args) {

    }
}

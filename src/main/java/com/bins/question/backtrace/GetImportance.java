package com.bins.question.backtrace;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/4/12 18:42
 * @apiNote 员工的重要性
 */
public class GetImportance {

    /**
     * 员工内部类
     */
    class Employee {
        /**
         * It's the unique id of each node;
         * unique id of this employee
         */
        public int id;

        /**
         * the importance value of this employee
         */
        public int importance;

        /**
         * the id of direct subordinates
         */
        public List<Integer> subordinates;
    }


    /**
     * 题目描述：
     * 1.给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id
     * 2.比如，员工1是员工2的领导，员工2是员工3的领导
     * 3.他们相应的重要度为15, 10, 5
     * 4.那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]
     * 5.注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中
     * 6.现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和
     * <p>
     * 示例:
     * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     * 输出: 11
     * 解释:
     * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11
     * <p>
     * 注意:
     * 1.一个员工最多有一个直系领导，但是可以有多个直系下属
     * 2.员工数量不超过2000
     *
     * @apiNote 思路：
     * 1.BFS深度优先搜索
     * 2.时间复杂度：O(n*n)
     * 3.空间复杂度：O(n)
     */
    public static int getImportance(List<Employee> employees, int id) {
        int importance = 0;
        if (employees == null || employees.size() <= 0) {
            return 0;
        }
        Employee current;
        List<Integer> ids;
        Queue<Employee> queue = new LinkedList<>();
        //map存对应的员工的重要度
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            if (employee.id == id) {
                queue.offer(employee);
                importance += employee.importance;
            }
            employeeMap.put(employee.id, employee);
        }
        while (!queue.isEmpty()) {
            current = queue.poll();
            ids = current.subordinates;
            if (ids != null && ids.size() > 0) {
                for (int subId : ids) {
                    Employee tmp = employeeMap.get(subId);
                    queue.offer(tmp);
                    importance += tmp.importance;
                }
            }
        }
        return importance;
    }

    public static void main(String[] args) {

    }
}

package com.bins.question.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/8/31 11:10
 * @apiNote 钥匙和房间
 * 来源：leetcode-841
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms/
 */
public class CanVisitAllRooms {

    /**
     * 题目描述：
     * 1.有 N 个房间，开始时你位于 0 号房间
     * 2.每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间
     * 3.在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示
     * 4.其中 N = rooms.length
     * 5.钥匙 rooms[i][j] = v 可以打开编号为 v 的房间
     * 6.最初，除 0 号房间外的其余所有房间都被锁住
     * 7.你可以自由地在房间之间来回走动
     * 8.如果能进入每个房间返回 true，否则返回 false
     * <p>
     * 示例 1：
     * 输入: [[1],[2],[3],[]]
     * 输出: true
     * 解释:
     * 我们从 0 号房间开始，拿到钥匙 1。
     * 之后我们去 1 号房间，拿到钥匙 2。
     * 然后我们去 2 号房间，拿到钥匙 3。
     * 最后我们去了 3 号房间。
     * 由于我们能够进入每个房间，我们返回 true。
     * <p>
     * 示例 2：
     * 输入：[[1,3],[3,0,1],[2],[0]]
     * 输出：false
     * 解释：我们不能进入 2 号房间。
     * <p>
     * 提示：
     * 1 <= rooms.length <= 1000
     * 0 <= rooms[i].length <= 1000
     * 所有房间中的钥匙数量总计不超过 3000
     *
     * @apiNote 思路：
     * 1.dfs直接深搜就行
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] marked = new boolean[rooms.size()];
        dfs(rooms, 0, marked);
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * dfs
     */
    public static void dfs(List<List<Integer>> rooms, int currentKey, boolean[] marked) {
        //递归结束条件
        if (marked[currentKey]) {
            return;
        }
        List<Integer> room = rooms.get(currentKey);
        marked[currentKey] = true;
        for (int key : room) {
            dfs(rooms, key, marked);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        room0.add(1);
        List<Integer> room1 = new ArrayList<>();
        room1.add(2);
        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        List<Integer> room3 = new ArrayList<>();
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        System.out.println(canVisitAllRooms(rooms));
    }
}

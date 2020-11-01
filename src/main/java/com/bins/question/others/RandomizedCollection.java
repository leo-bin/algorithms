package com.bins.question.others;


import java.util.*;

/**
 * @author leo-bin
 * @date 2020/11/1 10:55
 * @apiNote 实现O(1)时间插入、删除和获取随机元素,允许重复
 * 来源：leetcode-381
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
public class RandomizedCollection {

    private Map<Integer, Set<Integer>> elements;
    private List<Integer> nums;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        elements = new HashMap<>(16);
        nums = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the collection.
     * Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = elements.getOrDefault(val, new HashSet<>());
        set.add(nums.size() - 1);
        elements.put(val, set);
        //个数是1代表插入成功，其他都表示重复插入
        return set.size() == 1;
    }

    /**
     * Removes a value from the collection
     * Returns true if the collection contained the specified element
     */
    public boolean remove(int val) {
        //特判
        if (!elements.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = elements.get(val).iterator();
        //拿到set中的任意一个元素（就是索引值）和列表中的最后一个元素
        int i = it.next();
        int lastNum = nums.get(nums.size() - 1);
        //删除原始元素
        elements.get(val).remove(i);
        nums.set(i, lastNum);
        elements.get(lastNum).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            elements.get(lastNum).add(i);
        }
        if (elements.get(val).size() == 0) {
            elements.remove(val);
        }
        //最终删除列表中的元素(本质上是通过复制数组来实现的)
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    /**
     * 题目描述：
     * 1.设计一个支持在平均时间复杂度 O(1)下， 执行以下操作的数据结构
     * 2.允许出现重复元素
     * 3.insert(val)：向集合中插入元素val
     * 4.remove(val)：当val存在时，从集合中移除一个val
     * 5.getRandom：从现有集合中随机获取一个元素
     * 6.每个元素被返回的概率应该与其在集合中的数量呈线性相关
     * <p>
     * 示例:
     * //初始化一个空的集合
     * RandomizedCollection collection = new RandomizedCollection();
     * <p>
     * //向集合中插入1。返回 true表示集合不包含1
     * collection.insert(1);
     * <p>
     * //向集合中插入另一个1。返回false表示集合包含 1。集合现在包含[1,1]
     * collection.insert(1);
     * <p>
     * //向集合中插入2 ，返回true。集合现在包含[1,1,2]
     * collection.insert(2);
     * <p>
     * //getRandom应当有 2/3 的概率返回 1 ，1/3 的概率返回 2
     * collection.getRandom();
     * <p>
     * //从集合中删除 1 ，返回 true。集合现在包含 [1,2]
     * collection.remove(1);
     * <p>
     * //getRandom应有相同概率返回1和2
     * collection.getRandom();
     *
     * @apiNote 思路：
     * 1.首先我们看前面两个条件：插入和删除都是O(1)，这一点通过hash表很容易实现
     * 2.然后我们再看最后一个条件，也要在O(1)的时间下完成随机获取任意一个元素（元素可以重复）
     * 3.这一点要实现其实也很简单，将所有元素存在数组中以便能通过索引访问
     * 4.然后利用随机种子Random随机获取0-索引的最大值之间的任意一个数即可
     * 5.可是一旦用了数组，那么在删除元素的时候就无法实现O(1)
     * 6.所以我们可以想到将这两种方法结合起来，使用hash表+数组来实现
     * 7.首先可以使用一个Map来存所有的元素（不可重复），然后使用一个List来存储所有的元素（可重复）
     * 8.考虑到需要通过索引来访问元素，所以Map中的value需要存储相同元素的不同索引，这个用Set就可
     * 9.这样一来insert和getRandom很容易就可以实现
     * 10.关键是remove就有点麻烦了，设计到两个存储容器之间的数据一致性，一些细节额外需要重视
     * 11.时间复杂度：O(1)
     * 12.空间复杂度：O(m)
     */
    public static void main(String[] args) {
        Random random1 = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random1.nextInt(1));
        }
    }
}

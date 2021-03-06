package com.bins;


import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int srcPos = 2;
        int desPos = 2;
        System.arraycopy(nums, srcPos + 1, nums, desPos, 2);
        nums[nums.length - 1] = -1;
        System.out.println(Arrays.toString(nums));


        HashMap<Character, Integer> map = new HashMap<>(16);
        map.put('a', 1);
    }


 /*
 jdk1.7时的HashMap扩容关键代码：

 void transfer(Map.Entry[] newTable) {
        //遍历旧的Entry数组
        for (int j = 0; j < src.length; j++) {
            //取得旧Entry数组的每个元素
            Entry<K, V> e = src[j];
            if (e != null) {
                //释放旧Entry数组的对象引用（for循环后，旧的Entry数组不再引用任何对象）
                src[j] = null;
                do {
                    Entry<K, V> next = e.next;
                    //！！重新计算每个元素在数组中的位置
                    int i = indexFor(e.hash, newCapacity);
                    //标记[1]
                    e.next = newTable[i];
                    //将元素放在数组上
                    newTable[i] = e;
                    //访问下一个Entry链上的元素
                    e = next;
                } while (e != null);
            }
        }
    }*/
}

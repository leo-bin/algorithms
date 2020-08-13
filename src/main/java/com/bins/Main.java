package com.bins;


import java.util.HashMap;

public class Main {


    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(10, 10);
        Object result = map.get(new Long(10));
        if (result == null) {
            System.out.println("没找到！");
        } else {
            System.out.println("找到了，value是;" + result.toString());
        }
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

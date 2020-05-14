package com.bins.javabasic.collection.list.arraylist;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author leo-bin
 * @date 2020/3/6 20:15
 * @apiNote
 */
@Data
@AllArgsConstructor
public class PersonComparable implements Comparable<PersonComparable> {


    private String name;

    private Integer age;

    /**
     * 重写比较方法，按照age属性进行排序
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(PersonComparable o) {
        //两个对象进行比较，通过比较的结果，指定升序还是降序

        //升序
        /*return this.age - o.age;*/

        //降序
        return o.age-this.age;
    }
}

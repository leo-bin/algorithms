package com.bins.javabasic.collection.list.arraylist;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/3/6 20:14
 * @apiNote
 */
public class MainTest {


    public static void main(String[] args) {
        ArrayList<PersonComparable> arrayList = new ArrayList<>();
        ArrayList<PersonComparator> arrayList1 = new ArrayList<>();
        PersonComparable person1 = null;
        PersonComparator person2 = null;
        //随机生成数值，乱序
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            String name = "name" + i;
            int age = i + random.nextInt();

            person1 = new PersonComparable(name, age);
            arrayList.add(person1);

            person2 = new PersonComparator(name, age);
            arrayList1.add(person2);
        }

        //排序前
        System.out.println("/////////////排序前/////////////////////////////");
        display1(arrayList);


        testComparable(arrayList);
        testComparator(arrayList1);
    }

    /**
     * 测试Comparable
     *
     * @param list
     * @apiNote 排序方法已经排序规则写死了，不灵活
     */
    private static void testComparable(ArrayList<PersonComparable> list) {
        //按照age升序排序
        Collections.sort(list);

        //排序后
        System.out.println("/////////////使用Comparable排序后/////////////////////////////");
        display1(list);
    }

    /**
     * 测试Comparator
     *
     * @param list
     * @api 排序方法在运行期自动生成，能非常灵活的实现用户自定义排序
     */
    private static void testComparator(ArrayList<PersonComparator> list) {
        Comparator<PersonComparator> comparator = new Comparator<PersonComparator>() {
            //重写比较器
            @Override
            public int compare(PersonComparator o1, PersonComparator o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        //将比较器传入
        Collections.sort(list, comparator);

        //也可以这样写
        /*list.sort(comparator);*/

        //排序后
        System.out.println("/////////////使用Comparator排序后/////////////////////////////");
        display2(list);
    }


    private static void display1(ArrayList<PersonComparable> personComparables) {
        for (PersonComparable personComparable : personComparables) {
            System.out.println(personComparable.toString());
        }
    }

    private static void display2(ArrayList<PersonComparator> personComparators) {
        for (PersonComparator personComparator : personComparators) {
            System.out.println(personComparator.toString());
        }
    }

}

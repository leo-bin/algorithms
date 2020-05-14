package com.bins.javabasic.string;

import com.bins.util.MethodMonitorUtil;

/**
 * @author leo-bin
 * @date 2020/2/15 17:48
 * @apiNote String测试
 */
public class StringTest {


    private static String d = "甜甜";

    private static String e = new String("甜甜");

    public static void main(String[] args) {
        //String对象：线程安全，因为String是不可变对象，对象一旦生成，不可改变
        String str1 = new String("这是String对象");
        //StringBuffer:线程安全，方法中大量的使用了synchronized锁实现
        StringBuffer stringBuffer = new StringBuffer("这是StringBuffer对象");
        //StringBuilder：线程不安全，
        StringBuilder stringBuilder = new StringBuilder("这是StringBuilder对象");
        //使用new生成一个字符串对象，就是在堆中分配一个对象
        String a = new String("甜甜");
        //使用intern方法，从堆中拿到对应的字符串的内容，在常量池中分配一个一摸一样的字符，并返回常量池中该字符串的引用
        String b = a.intern();
        //直接在常量池中生成一个字符串，返回对象的引用
        String c = "甜甜";

        String e1 = e.intern();

        //结果时false，常量池中的地址不等于堆中的地址
        System.out.println(a == b);
        //结果时true，因为都指的是常量池中的地址
        System.out.println(b == c);
        //结果是false，常量池中的地址和堆内存中的地址
        System.out.println(a == c);

        System.out.println(a == d);
        System.out.println(b == d);
        System.out.println(c == d);

        System.out.println(a == e);
        System.out.println(b == e1);
        System.out.println(c == e1);
        testString();
    }


    public static void testString() {
        //测试String
        MethodMonitorUtil.start();
        String i = "";
        for (int j = 0; j < 100000; j++) {
            i += j;
        }
        MethodMonitorUtil.finish("String测试");

        //测试StringBuilder
        MethodMonitorUtil.start();
        String k = "";
        StringBuilder stringBuilder = new StringBuilder(k);
        for (int j = 0; j < 100000; j++) {
            stringBuilder.append(j);
        }
        MethodMonitorUtil.finish("StringBuilder测试");
    }
}

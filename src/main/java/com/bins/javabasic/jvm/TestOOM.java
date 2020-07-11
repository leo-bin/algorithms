package com.bins.javabasic.jvm;

import java.util.ArrayList;

/**
 * @author leo-bin
 * @date 2020/7/10 21:11
 * @apiNote
 */
public class TestOOM {


    public static void main(String[] args) {
        ArrayList<BigObject> bigObjects = new ArrayList<>();
        while (true) {
            bigObjects.add(new BigObject());
        }
    }
}

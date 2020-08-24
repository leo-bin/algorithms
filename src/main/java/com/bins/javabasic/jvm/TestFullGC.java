package com.bins.javabasic.jvm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author leo-bin
 * @date 2020/7/10 21:29
 * @apiNote
 */
@Slf4j
public class TestFullGC {

    public static void main(String[] args) {
        try {
            log.info("线程正在等待中。。。", Thread.currentThread().getName());
            Thread.sleep(15000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("正在执行程序。。。");
        ArrayList<BigObject> bigObjects = new ArrayList<>();
        int count = 0;
        while (true) {
            if (count == 10000) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count = 0;
            }
            bigObjects.add(new BigObject());
            count++;
        }
    }
}

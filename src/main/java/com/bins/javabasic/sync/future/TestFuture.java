package com.bins.javabasic.sync.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author leo-bin
 * @date 2020/7/27 19:04
 * @apiNote
 */
public class TestFuture {


    public static void main(String[] args) {
        Integer number = 2;
        Future<Integer> future = new SquareCalculator().calculator(number);
        try {
            while (!future.isDone()) {
                System.out.println("正在计算中。。。");
                Thread.sleep(1000L);
            }
            System.out.println(number + "*" + number + "的结果是：" + future.get());
            System.out.println(future.isCancelled());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

package com.bins.javabasic.sync.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author leo-bin
 * @date 2020/7/27 19:01
 * @apiNote
 */
public class SquareCalculator {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Future<Integer> calculator(Integer number) {
        return executorService.submit(() -> {
            Thread.sleep(2000L);
            return number * number;
        });
    }
}

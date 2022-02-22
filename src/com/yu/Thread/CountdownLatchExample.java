package com.yu.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 20:38 2022/2/21
 * @Modified By:
 */
public class CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < totalThread; i++) {
            executorService.execute(()-> {
                System.out.println("run..");
                countDownLatch.countDown();
            });
            countDownLatch.await();
            System.out.println("end..");
            executorService.shutdown();
        }
    }
}

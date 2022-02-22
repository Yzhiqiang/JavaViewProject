package com.yu.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 14:39 2022/2/22
 * @Modified By:
 */
public class WaitAndSleep {
    public void Sleep() {
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch cdLatch = new CountDownLatch(5);
        for(int i = 0; i < 5; i++) {
            service.execute(()->{
                try {
                    synchronized(this) {
                        cdLatch.countDown();
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName());
            });
        }
        service.shutdown();
        try {
            cdLatch.await();
            synchronized(this) {
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        WaitAndSleep sleep = new WaitAndSleep();
        sleep.Sleep();
    }
}

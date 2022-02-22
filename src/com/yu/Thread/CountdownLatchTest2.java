package com.yu.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 9:56 2022/2/22
 * @Modified By:
 */
public class CountdownLatchTest2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(4);

        for(int i = 0; i < 4; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("选手"+Thread.currentThread().getName()+"等待裁判口令");
                    try {
                        cdOrder.await();
                        System.out.println("选手"+Thread.currentThread().getName()+"已接受裁判发布口令");
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("选手"+Thread.currentThread().getName()+"已到达终点");
                        cdAnswer.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        try {
            Thread.sleep((long)(Math.random()*10000));
            System.out.println("裁判"+Thread.currentThread().getName()+"即将发布口令");
            cdOrder.countDown();
            System.out.println("裁判"+Thread.currentThread().getName()+"已发布口令，正在等待选手到达终点");
            cdAnswer.await();
            System.out.println("所有选手到达终点");
            System.out.println("裁判"+Thread.currentThread().getName()+"汇总成绩");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

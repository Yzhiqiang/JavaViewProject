package com.yu.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 21:15 2022/2/21
 * @Modified By:
 */
public class FutureTashExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for(int i = 0; i < 100; i++) {   //由于这个任务的时间太长，所以采用异步的方式，使用FutrueTask来执行，之后再取结果
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });
        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        Thread otherThread = new Thread(()->{
            System.out.println("other task is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
    }

}

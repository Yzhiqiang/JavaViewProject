package com.yu.Thread;

import java.util.concurrent.*;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 22:38 2022/2/15
 * @Modified By:
 */
public class ThreeWays {
    public static void main(String[] args) {
        /**
         * 实现callable的接口
         */
//        Callable<Object> oneCallable = new Tickets<>();
//        FutureTask<Object> onTask = new FutureTask<Object>(oneCallable);
//        Thread t = new Thread(onTask);
//        t.start();

        /**
         * 创建线程池创建线程
         */
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.schedule(new Runnable(){
            @Override
            public void run() {
                System.out.println("delay 3 second");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
//class Tickets<Objecta> implements Callable<Object> {
//    @Override
//    public Object call() throws Exception {
//        System.out.println(Thread.currentThread().getName()+"-->我是通过实现Callable接口通过FutureTask包装器来实现的线程");
//        return null;
//    }
//}

class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("通过线程池方式创建的线程：" + Thread.currentThread().getName() + " ");
    }
}
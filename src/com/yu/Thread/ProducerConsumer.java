package com.yu.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 21:23 2022/2/24
 * @Modified By:
 */
public class ProducerConsumer {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
    private static class Producer extends Thread {
        @Override
        public void run() {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("produce..");
        }
    }
    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consume..");
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }
        for(int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for(int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }
}

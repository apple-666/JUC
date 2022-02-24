package com.apple.demo_18_CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Double_apple
 * @Date 2022/2/24 21:21
 * @Version 1.0
 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        // 计数器
        // 让一线程阻塞直到另一些线程完成一系列操作才被唤醒。
        // 为0时唤醒
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "\t 班长最后关门");
    }
}

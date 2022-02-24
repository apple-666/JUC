package com.apple.demo_20_Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author Double_apple
 * @Date 2022/2/24 21:45
 * @Version 1.0
 */
@SuppressWarnings("all")
public class SemaphoreDemo {
    public static void main(String[] args) {
        /**
         * 初始化Semaphore（信号量 相当于一个停车场）的容量
         * 常用acquire() 获得一个信号量
         *     release() 释放一个信号量
         */
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 9; i++) {

            new Thread(()->{

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢占了车位");
                    TimeUnit.SECONDS.sleep(3);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"走了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            },String.valueOf(i)).start();
        }
    }
}

package com.apple.demo_6_辅助类;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Double_apple
 * @Date 2022/1/31 12:55
 * @Version 1.0
 */
//这是一个计数器  减法
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" Go out");
                countDownLatch.countDown(); //每个线程都数量-1
            },String.valueOf(i)).start();
        }

        countDownLatch.await();  //只有计数器归零 下面的语句才会打印
        System.out.println("close door");

    }

}

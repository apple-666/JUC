package com.apple.demo_6_辅助类;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author Double_apple
 * @Date 2022/1/31 13:03
 * @Version 1.0
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //停车位为3个
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    semaphore.acquire(); //得到
                    //抢到车位
                    System.out.println(Thread.currentThread().getName()+" 抢到了车位{"+ finalI +"}");
                    TimeUnit.SECONDS.sleep(2); //停车2s
                    System.out.println(Thread.currentThread().getName()+" 离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放
                }
            },String.valueOf(i)).start();
        }
    }
}

package com.apple.demo_17_各种锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Double_apple
 * @Date 2022/2/1 19:04
 * @Version 1.0
 */

@SuppressWarnings("all")
public class 自旋锁2 {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        //使用CAS实现自旋锁
        自旋锁1 自旋锁1=new 自旋锁1();
        new Thread(()->{
            自旋锁1.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                自旋锁1.myunlock();
            }
        },"t1").start();

        TimeUnit.SECONDS.sleep(1);


        new Thread(()->{
            自旋锁1.myLock();
            try {
//                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                自旋锁1.myunlock();
            }
        },"t2").start();
    }
}


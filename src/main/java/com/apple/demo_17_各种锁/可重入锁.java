package com.apple.demo_17_各种锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Double_apple
 * @Date 2022/2/1 18:57
 * @Version 1.0
 */
@SuppressWarnings("all")
public class 可重入锁 {
    public static void main(String[] args) {

        /**
         *
         * 拿到一把锁后，锁里面的锁也会拿到（synchronized,lock都是）
         */

        //synchronized
        Phone phone = new Phone();
        new Thread(()->{
            phone.sms();
        },"A").start();
        new Thread(()->{
            phone.sms();
        },"B").start();


        //lock
        Phone2 phone2 = new Phone2();
        new Thread(()->{
            phone2.sms();
        },"A").start();
        new Thread(()->{
            phone2.sms();
        },"B").start();
    }

}

class Phone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+"=> sms");
        call();//这里也有一把锁
    }
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"=> call");
    }
}

class Phone2 {

    Lock lock = new ReentrantLock();

    public void sms() {
        lock.lock(); //细节：这个是两把锁，两个钥匙
        //lock锁必须配对，否则就会死锁在里面
        try {
            System.out.println(Thread.currentThread().getName() + "=> sms");
            call();//这里也有一把锁
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void call() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "=> call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

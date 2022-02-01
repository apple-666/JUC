package com.apple.demo_3_8锁问题;

import java.util.concurrent.TimeUnit;

/**
 * @Author Double_apple
 * @Date 2022/1/31 11:15
 * @Version 1.0
 */
//先执行 A 再是B
   //这里锁的是 对象
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone =new Phone();
        new Thread(()->{
            try {
                phone.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"apple1").start();



        new Thread(()->{
            phone.call();
        },"apple2").start();
    }
}


class Phone{
    public synchronized void sendSms() throws InterruptedException {

        TimeUnit.SECONDS.sleep(2);
        System.out.println("发送短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

}

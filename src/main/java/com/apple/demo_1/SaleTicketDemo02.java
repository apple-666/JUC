package com.apple.demo_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Double_apple
 * @Date 2022/1/31 10:23
 * @Version 1.0
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(()->{
            for(int i=0;i<50;i++) ticket.sale();
        },"apple1").start();
        new Thread(()->{
            for(int i=0;i<50;i++) ticket.sale();
        },"apple2").start();
        new Thread(()->{
            for(int i=0;i<50;i++) ticket.sale();
        },"apple3").start();
    }
}

class Ticket2{
    private int num = 100;

    //可重入锁
//    Lock lock = new ReentrantLock(true);//公平锁
    Lock lock = new ReentrantLock();//默认为非公平锁
    public void sale(){
        lock.lock();
        try {
            if(num>0){
                System.out.println(Thread.currentThread().getName()+" 卖出了票,剩余："+(--num)+" 张票");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

    }
}



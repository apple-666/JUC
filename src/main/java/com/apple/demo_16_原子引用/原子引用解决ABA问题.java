package com.apple.demo_16_原子引用;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author Double_apple
 * @Date 2022/2/1 18:24
 * @Version 1.0
 */
@SuppressWarnings("all")
public class 原子引用解决ABA问题 {
    //ABA 问题:因为CAS是乐观锁，中途参数可能会被修改多次，造成ABA问题
    //solution: 使用原子引用,让CAS中的参数带上版本号

    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(10,1);
        //a线程会去修改atomicInteger(模拟ABA操作)     造成b线程中CAS失败。 这样就能防止ABA问题

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int stamp = atomicStampedReference.getStamp();
            System.out.println("apple1.1:"+atomicStampedReference.getStamp());
            System.out.println("----------------------------------------------");

            System.out.println(atomicStampedReference.compareAndSet(10, 20, stamp, stamp + 1));

            stamp = atomicStampedReference.getStamp();
            System.out.println("apple1.2:"+atomicStampedReference.getStamp());
            System.out.println("----------------------------------------------");

            System.out.println(atomicStampedReference.compareAndSet(20, 10, stamp, stamp + 1));

            stamp = atomicStampedReference.getStamp();
            System.out.println("apple1.3:"+atomicStampedReference.getStamp());
            System.out.println("----------------------------------------------");

        },"apple1").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("apple2.1:"+atomicStampedReference.getStamp());
            System.out.println("----------------------------------------------");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicStampedReference.compareAndSet(10, 100, stamp, stamp + 1));

            stamp = atomicStampedReference.getStamp();
            System.out.println("apple2.2:"+atomicStampedReference.getStamp());
            System.out.println("----------------------------------------------");
        },"apple2").start();
    }


}

package com.apple.demo_17_各种锁;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Double_apple
 * @Date 2022/2/1 19:04
 * @Version 1.0
 */
public class 自旋锁1 {

    //int 0
    //thread null
    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    //加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"===> mylock");

        //自旋锁
        // 如果当前有锁就自旋
        while (!atomicReference.compareAndSet(null,thread)){
//            System.out.println(Thread.currentThread().getName()+" ==> 自旋中~");
        }
    }


    //解锁
    public void myunlock(){
        Thread thread=Thread.currentThread();
        System.out.println(thread.getName()+"===> myUnlock");
        atomicReference.compareAndSet(thread,null);
    }

}

package com.apple.demo_5_Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;
/**
 * @Author Double_apple
 * @Date 2022/1/31 11:48
 * @Version 1.0
 */
public class Callable1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 1; i < 10; i++) {
//            new Thread(new Runnable()).start();
//            new Thread(new FutureTask<>( Callable)).start();
            MyThread thread= new MyThread();
            //适配类：FutureTask
            FutureTask<String> futureTask = new FutureTask<>(thread);
            //放入Thread使用

            new Thread(futureTask,"apple1").start();
            new Thread(futureTask,"apple2").start();

            //获取返回值
            String s = futureTask.get();
            System.out.println("返回值："+ s);
        }
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Call:"+Thread.currentThread().getName());
        return "String"+Thread.currentThread().getName();
    }
}
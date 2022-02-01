package com.apple.demo_13_Future异步回调;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author Double_apple
 * @Date 2022/2/1 14:55
 * @Version 1.0
 */
public class FutureAppleTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 发起 一个 请求
        //------------------一，无返回值的异步回调runAsync--------------------
//        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
//            //发起一个异步任务
//            try {
//                TimeUnit.SECONDS.sleep(0);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("-------------task1变成了后执行---"+Thread.currentThread().getName()+"----------");
//        });
//        System.out.println("----------task2--------------------");
//        //输出执行结果
//        System.out.println(future.get());  //获取执行结果


        //------------------二，有返回值的异步回调supplyAsync--------------------
        CompletableFuture<Integer> completableFuture=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("----------执行了task1,之后要异步回调出对应的返回值-----------");
                int i=1/0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-------之后会有返回值，对应的supplyasync（正确的返回值）和exceptionally（错误的返回值）的返回值-------------");
            return 1024;
        });
        System.out.println(completableFuture.whenComplete((t, u) -> {
            //success 回调
            System.out.println("-----task2：t=>" + t); //正常的返回结果
            System.out.println("-----task2：u=>" + u); //抛出异常的 错误信息
        }).exceptionally((e) -> {
            //error回调
            System.out.println(e.getMessage());
            return 404;
        }).get());
    }
}

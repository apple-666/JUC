package com.apple.demo_9_线程池;

import java.util.concurrent.*;

/**
 * @Author Double_apple
 * @Date 2022/1/31 13:38
 * @Version 1.0
 */


//工具类 Executors 创建线程池的三大方法；
//@SuppressWarnings("all")
public class Demo01 {
    public static void main(String[] args) {

//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5); //创建一个固定的线程池的大小
//        ExecutorService threadPool = Executors.newCachedThreadPool(); //可伸缩的

        // 建议手动创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                4,
                8,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()          //超出最大承载，就会抛出异常
//                new ThreadPoolExecutor.CallerRunsPolicy()     //哪来的去哪里 main线程进行处理
                new ThreadPoolExecutor.DiscardOldestPolicy()  //队列满了,丢掉异常，不会抛出异常。
//                new ThreadPoolExecutor.DiscardPolicy()          //队列满了，尝试去和最早的进程竞争，不会抛出异常

                );


        //线程池用完必须要关闭线程池

        // cpu密集型：  cpu数量=maximumpoolsize
        //I/O密集型： 程序中执行I/O数的一倍到两倍=maximumpoolsize
        try {

            for (int i = 1; i <=19 ; i++) {
                //通过线程池创建线程
                threadPool.execute(()->{
                    Integer maxCpu = Runtime.getRuntime().availableProcessors();
                    System.out.println("maxCPU:"+maxCpu);
                    System.out.println(Thread.currentThread().getName()+ " rebushu_ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

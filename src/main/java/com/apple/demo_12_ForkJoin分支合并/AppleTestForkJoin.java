package com.apple.demo_12_ForkJoin分支合并;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @Author Double_apple
 * @Date 2022/2/1 14:05
 * @Version 1.0
 */
public class AppleTestForkJoin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();
        test2();
//        test3();
    }

    /**
     * 普通计算
     */
    public static void test1(){
        long star = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 1; i < 20_0000_0000; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+"时间："+(end-star));
        System.out.println(sum);
    }

    /**
     * 使用ForkJoin
     * 1、通过ForkJoinPool来执行
     * 2、计算任务 execute(ForkJoinTask<?> task)
     * 3、计算类要去继承ForkJoinTask；
     */
    public static void test2() throws ExecutionException, InterruptedException {
        long star = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        java.util.concurrent.ForkJoinTask task = new ForkJoinAppleTask(0L, 20_0000_0000L);
        java.util.concurrent.ForkJoinTask submit = forkJoinPool.submit(task);
        Long aLong = (Long) submit.get();
        System.out.println(aLong);
        long end = System.currentTimeMillis();
        System.out.println("sum="+"时间："+(end-star));
    }


    /**
     * 使用Stream 并行流
     */
    public static void test3(){
        long star = System.currentTimeMillis();
        //Stream并行流()
        long sum = LongStream.range(0L, 20_0000_0000L).parallel().reduce(0, Long::sum);
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+"时间："+(end-star));
    }
}

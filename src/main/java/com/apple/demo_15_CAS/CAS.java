package com.apple.demo_15_CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Double_apple
 * @Date 2022/2/1 17:43
 * @Version 1.0
 */
//boolean compareAndSet(int expect, int update)
//期望值、更新值
//如果实际值 和 我的期望值相同，那么就更新
//如果实际值 和 我的期望值不同，那么就不更新

public class CAS {

    public static void main(String[] args) {
        //compareandset 介绍，num是2020就更新成2021
        AtomicInteger num = new AtomicInteger(2020);
        System.out.println(num.compareAndSet(2020, 2021));
        System.out.println(num.get());


        //因为期望值是2020  实际值却变成了2021  所以会修改失败
        //CAS 是CPU的并发原语
        num.getAndIncrement(); //++操作
        System.out.println(num.compareAndSet(2020, 2021));
        System.out.println(num.get());


    }
}

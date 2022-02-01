package com.apple.demo_14_JMM和Volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Double_apple
 * @Date 2022/2/1 16:38
 * @Version 1.0
 */
public class JMMDemo3_Volatile不保证原子性_CAS保证原子性 {

    // 使用了Volatile之后：以下是 无原子性例子 = 得不到正确结果
    // 但是又使用了
    private static volatile AtomicInteger num = new AtomicInteger();

    public static void add(){
//        num++;//++ 有3个操作：1get到值 2加1  3put写回到num
        //使用atomicInteger 的incrementandget
        num.incrementAndGet();
    }

    public static void main(String[] args) {

        System.out.println("现在num为："+num);
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                for (int j = 0; j < 100 ; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount()>2) //jc + main
        {
            Thread.yield();//换线程执行
        }

        System.out.println(num);
    }
}

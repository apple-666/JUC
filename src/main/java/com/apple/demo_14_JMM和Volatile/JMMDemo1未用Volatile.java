package com.apple.demo_14_JMM和Volatile;

import java.util.concurrent.TimeUnit;

/**
 * @Author Double_apple
 * @Date 2022/2/1 16:02
 * @Version 1.0
 */
//@SuppressWarnings("all")
public class JMMDemo1未用Volatile {

    private static int num = 0;

    public static void main(String[] args) {
        // JMM（java内存模型）为一种java中的概念和约定
        // 以下程序，没有保证可见性，就会一直死循环，之后会使用Volatile，就不会了
        new Thread(()->{
            while (num==0){
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                    System.out.println("死循环中");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
        System.out.println("main线程：num="+num);


    }
}

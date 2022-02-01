package com.apple.demo_14_JMM和Volatile;

import java.util.concurrent.TimeUnit;

/**
 * @Author Double_apple
 * @Date 2022/2/1 16:15
 * @Version 1.0
 */
@SuppressWarnings("all")
public class JMMDemo2_Volatile保证可见性 {

    //使用了volatile了 保证了可见性就不会发生死循环了
    private volatile static int num = 0;

    public static void main(String[] args) {
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

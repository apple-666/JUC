package com.apple.demo_17_各种锁;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Double_apple
 * @Date 2022/2/1 18:56
 * @Version 1.0
 */
public class 公平与非公平锁 {
    public static void main(String[] args) {
//        非常不公平，允许插队的，可以改变顺序。
//        公平锁：非常公平；不能插队的，必须先来后到；
        ReentrantLock reentrantLock = new ReentrantLock();  //默认为非公平锁
        ReentrantLock reentrantLock1 = new ReentrantLock(true);//true为公平锁
    }
}

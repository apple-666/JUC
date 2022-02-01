package com.apple.demo_2_生产者消费者;


/**
 * @Author Double_apple
 * @Date 2022/1/31 10:46
 * @Version 1.0
 */
public class ASynchronized {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{for(int i=0;i<10;i++) {
            try {
                data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"A").start();
        new Thread(()->{for(int i=0;i<10;i++) {
            try {
                data.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }},"B").start();
        new Thread(()->{for(int i=0;i<10;i++) {
            try {
                data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"C").start();
        new Thread(()->{for(int i=0;i<10;i++) {
            try {
                data.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }},"D").start();
    }
}
class Data{
    //数字  资源类
    private int number = 0;

    //+1
    public synchronized void increment() throws InterruptedException {
        while (number!=0){
            //等待操作
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程 我+1完毕了
        this.notifyAll();
    }

    //-1
    public synchronized void decrement() throws InterruptedException {
        while (number==0){
            //等待操作
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程  我-1完毕了
        this.notifyAll();
    }

}
package com.apple.demo_7_读写锁;

/**
 * @Author Double_apple
 * @Date 2022/1/31 13:07
 * @Version 1.0
 */
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
//        MyCache_ReadWriteLock mycache = new MyCache_ReadWriteLock();
        MyCache_ReadWriteLock2 mycache = new MyCache_ReadWriteLock2();
        //开启5个线程 写入数据
        for (int i = 1; i <=5 ; i++) {
            int finalI = i;
            new Thread(()->{
                mycache.put(String.valueOf(finalI),String.valueOf(finalI));
            }).start();
        }
        //开启10个线程去读取数据
        for (int i = 1; i <=10 ; i++) {
            int finalI = i;
            new Thread(()->{
                String o = mycache.get(String.valueOf(finalI));
            }).start();
        }
    }
}

// 加锁的
class MyCache_ReadWriteLock2{
    private volatile Map<String,String> map=new HashMap<>();

    //使用读写锁
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    //普通锁
    private Lock lock=new ReentrantLock();

    public void put(String key,String value){
        //加锁
        readWriteLock.writeLock().lock();
        try {
            //写入
            //业务流程
            System.out.println(Thread.currentThread().getName()+" 线程 开始写入");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+" 线程 写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock(); //解锁
        }
    }

    public String get(String key){
        //加锁
        String o="";
        readWriteLock.readLock().lock();
        try {
            //得到
            System.out.println(Thread.currentThread().getName()+" 线程 开始读取");
            o = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 线程 读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return o;
    }
}

//无加锁的
class MyCache_ReadWriteLock{
    private volatile Map<String,String> map=new HashMap<>();


    //普通锁
//    private Lock lock=new ReentrantLock();

    public void put(String key,String value){
        //写入
        System.out.println(Thread.currentThread().getName()+" 线程 开始写入");
        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+" 线程 写入OK");
    }

    public String get(String key){
        //得到
        System.out.println(Thread.currentThread().getName()+" 线程 开始读取");
        String o = map.get(key);
        System.out.println(Thread.currentThread().getName()+" 线程 读取OK");
        return o;
    }
}

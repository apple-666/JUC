package com.apple.demo_4_集合类;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author Double_apple
 * @Date 2022/1/31 11:35
 * @Version 1.0
 */
//同理：java.util.ConcurrentModificationException
// 解决方案：
public class Set1 {
    public static void main(String[] args) {
//        Set<String> hashSet = Collections.synchronizedSet(new HashSet<>()); //解决方案1
        Set<String> hashSet = new CopyOnWriteArraySet<>();//解决方案2
        for (int i = 1; i < 100; i++) {
            new Thread(()->{
                hashSet.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(hashSet);
            },String.valueOf(i)).start();
        }
    }
}

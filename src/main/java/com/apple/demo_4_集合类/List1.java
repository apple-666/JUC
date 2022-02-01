package com.apple.demo_4_集合类;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author Double_apple
 * @Date 2022/1/31 11:29
 * @Version 1.0
 */
public class List1 {
    public static void main(String[] args) {
//        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        List<Object> list=new CopyOnWriteArrayList<>();
        for(int i=1;i<=10;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}


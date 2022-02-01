package com.apple.demo_10_四大函数式接口;

import java.util.function.Consumer;

/**
 * @Author Double_apple
 * @Date 2022/2/1 13:00
 * @Version 1.0
 */
public class Consumer1 {
    public static void main(String[] args) {
        Consumer<String> consumer = (apple)->{
            System.out.println(apple);
        };
        consumer.accept("apple come to");
    }
}

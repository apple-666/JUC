package com.apple.demo_10_四大函数式接口;

import java.util.function.Supplier;

/**
 * @Author Double_apple
 * @Date 2022/2/1 13:01
 * @Version 1.0
 */
public class Supplier1 {
    public static void main(String[] args) {
        Supplier<String> supplier = ()->{return "生产者生产的产品";};
        System.out.println(supplier.get());
    }
}

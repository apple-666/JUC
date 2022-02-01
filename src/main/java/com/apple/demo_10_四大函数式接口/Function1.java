package com.apple.demo_10_四大函数式接口;

import java.util.function.Function;

/**
 * @Author Double_apple
 * @Date 2022/2/1 12:46
 * @Version 1.0
 */
public class Function1 {

    public static void main(String[] args) {

        //用 function 可自编工具类
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String o) {
//                return o;
//            }
//        };

        //可以用 lambda表达式简化

        Function<String,String> function =(apple) -> {return apple;};
        System.out.println(function.apply("apple come to"));


    }
}

package com.apple.demo_10_四大函数式接口;

import java.util.function.Predicate;

/**
 * @Author Double_apple
 * @Date 2022/2/1 12:53
 * @Version 1.0
 */
public class Predicate1 {
    public static void main(String[] args) {
//        Predicate predicate = new Predicate<String>(){
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };

        Predicate<String> predicate = (apple) -> {return  apple.isEmpty();};
        System.out.println(predicate.test("apple"));
    }
}

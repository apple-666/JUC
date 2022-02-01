package com.apple.demo_11_Stream流式计算;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Double_apple
 * @Date 2022/2/1 13:32
 * @Version 1.0
 */
public class Stream1 {
    public static void main(String[] args) {
        User user1 = new User(1,"a",21);
        User user2 = new User(2,"b",22);
        User user3 = new User(3,"c",23);
        User user4 = new User(4,"d",24);
        User user5 = new User(5,"e",25);
        User user6 = new User(6,"f",26);
        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6);

        //计算交给流
        //链式编程！！！！
        list.stream()
                //stream()的方法 用于计算
                //filter为断定式接口
                .filter((u)->{ return u.getId()%2==0; })        // id为偶数的
                .filter((u)->{return u.getAge()>23;})           // age>23
                //map为函数式接口
                .map((u)->{return u.getName().toUpperCase();})  // name转换为大写
                //sorted为比较类接口
                .sorted((uu1,uu2)->{                            //  降序排列
                    return uu2.compareTo(uu1);
                })
                .limit(1)                                       // 只显示一个
                //foreach为消费者接口
                .forEach(System.out::println);
    }
}

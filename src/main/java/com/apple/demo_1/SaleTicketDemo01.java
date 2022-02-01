package com.apple.demo_1;

/**
 * @Author Double_apple
 * @Date 2022/1/31 10:09
 * @Version 1.0
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for(int i=0;i<50;i++) ticket.sale();
        },"apple1").start();
        new Thread(()->{
            for(int i=0;i<50;i++) ticket.sale();
        },"apple2").start();
        new Thread(()->{
            for(int i=0;i<50;i++) ticket.sale();
        },"apple3").start();
    }
}

class Ticket{
    private int number = 88;
    public synchronized void sale(){
        if(number>0){
            //???
            System.out.println(Thread.currentThread().getName()+"买了票"+"剩余："+(number-1)+" 张票");
            number--;
        }
    }
}

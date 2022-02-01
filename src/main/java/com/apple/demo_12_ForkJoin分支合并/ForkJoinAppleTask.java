package com.apple.demo_12_ForkJoin分支合并;

import java.util.concurrent.RecursiveTask;

/**
 * @Author Double_apple
 * @Date 2022/2/1 14:02
 * @Version 1.0
 */
/*1，继承recursiveTask
* 2，实现compute方法
* 3，在compute中 用fork方法   return （join+join）
*
*
* */
public class ForkJoinAppleTask extends RecursiveTask<Long> {

    private long star;
    private long end;

    //临界值
    private long temp=1000000000L;

    public ForkJoinAppleTask(long star, long end) {
        this.star = star;
        this.end = end;
    }

    /**
     * 计算方法
     * @return Long
     */
    @Override
    protected Long compute() {
        if((end-star)<temp){
            Long sum = 0L;
            for (Long i = star; i < end; i++) {
                sum+=i;
            }
//            System.out.println(sum);
            return sum;
        }else {
            //使用forkJoin 分而治之 计算
            //计算平均值
            long middle = (star+ end)/2;
            ForkJoinAppleTask forkJoinDemoTask1 = new ForkJoinAppleTask(star, middle);
            forkJoinDemoTask1.fork();  //拆分任务，把线程任务压入线程队列
            ForkJoinAppleTask forkJoinDemoTask2 = new ForkJoinAppleTask(middle, end);
            forkJoinDemoTask2.fork();  //拆分任务，把线程任务压入线程队列
            long taskSum = forkJoinDemoTask1.join() + forkJoinDemoTask2.join();
            return taskSum;
        }
    }
}
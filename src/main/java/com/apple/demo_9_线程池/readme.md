自动创建线程池：
重点 Executors.newSingleThreadExecutor() 

手动创建线程池最好：
new ThreadPoolExecutors(
        corepoolsize 
        maximumpoolsize    
        keepalivetime  
        timeunit.seconds, 
        BlockinQueeu 
        ThreadFactory 
        拒绝策略
)
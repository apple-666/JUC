实现生产者消费者有三种方法：

1，Synchronize
2，Lock
3，BlockingQueue   （使用valatile flag标志是否可以生产或消费；
                    使用atomicinteger i 表示第i个产品）

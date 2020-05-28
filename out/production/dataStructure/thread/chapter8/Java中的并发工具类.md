## 并发工具类
在JDK的并发包里提供了几个非常有用的并发工具类。CountDownLatch、CyclicBarrier和
Semaphore工具类提供了一种并发流程控制的手段，Exchanger工具类则提供了在线程间交换数
据的一种手段。本章会配合一些应用场景来介绍如何使用这些工具类。
### CountDownLatch 
CountDownLatch 允许一个或者多个线程等待其他线程完成操作。

假如有这样一个需求：我们需要解析一个Excel里多个sheet的数据，此时可以考虑使用多
线程，每个线程解析一个sheet里的数据，等到所有的sheet都解析完之后，程序需要提示解析完
成。在这个需求中，要实现主线程等待所有线程完成sheet的解析操作，最简单的做法是使用
join()方法.

CountDownLatch的构造函数接收一个int类型的参数作为计数器，如果你想等待N个点完
成，这里就传入N。
当我们调用CountDownLatch的countDown方法时，N就会减1，CountDownLatch的await方法
会阻塞当前线程，直到N变成零。由于countDown方法可以用在任何地方，所以这里说的N个
点，可以是N个线程，也可以是1个线程里的N个执行步骤。用在多个线程时，只需要把这个
CountDownLatch的引用传递到线程里即可。

### CyclicBarrier

字面意思就是可循环使用的屏障。他主要的功能是，让一组线程到达一个屏障（同步点）时
被阻塞，知道最后一个线程到达屏障点，然后屏障开门，所有被拦截的线程继续运行。

CyclicBarrier默认的构造方法是CyclicBarrier（int parties），其参数表示屏障拦截的线程数
量，每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞。

#### 应用场景
CyclicBarrier可以用于多线程计算数据，最后合并计算结果的场景。例如，用一个Excel保
存了用户所有银行流水，每个Sheet保存一个账户近一年的每笔银行流水，现在需要统计用户
的日均银行流水，先用多线程处理每个sheet里的银行流水，都执行完之后，得到每个sheet的日
均银行流水，最后，再用barrierAction用这些线程的计算结果，计算出整个Excel的日均银行流
水。如 BankWaterService所示。

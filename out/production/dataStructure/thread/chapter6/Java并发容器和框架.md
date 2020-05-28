## Java并发容器和框架
### ConcurrentHashMap
ConcurrentHashMap是由Segment数组结构和HashEntry数组结构组成。Segment是一种可重
入锁（ReentrantLock），在ConcurrentHashMap里扮演锁的角色；HashEntry则用于存储键值对数
据。一个ConcurrentHashMap里包含一个Segment数组。Segment的结构和HashMap类似，是一种
数组和链表结构。一个Segment里包含一个HashEntry数组，每个HashEntry是一个链表结构的元
素，每个Segment守护着一个HashEntry数组里的元素，当对HashEntry数组的数据进行修改时，
必须首先获得与它对应的Segment锁

#### get()
ConcurrentHashMap的get方法是没有加锁的,除非读取到null值才会加锁重读,在HashTable中get方法
是加锁的,至于ConcurrentHashMap的get方法为什么没加锁,原因是get方法里面使用到的共享变量都
定义成了volatile类型,保证了多线程之间的可见性.

#### put()
由于put方法需要对共享变量进行写入操作,所以为了线程安全,在操作变量时是必须加锁的.put方法
首先定位到Segment.然后进行插入操作,插入需要两个步骤,先判断是否需要对Segment里的HashEntry
数组进行扩容,第二步定位添加元素的位置,然后插入数据.

- 是否需要扩容
在插入元素前会先判断Segment里的HashEntry数组是否超过容量（threshold），如果超过阈
值，则对数组进行扩容。值得一提的是，Segment的扩容判断比HashMap更恰当，因为HashMap
是在插入元素后判断元素是否已经到达容量的，如果到达了就进行扩容，但是很有可能扩容
之后没有新元素插入，这时HashMap就进行了一次无效的扩容。

- 如何扩容
在扩容时候，首先会创建一个容量是原来两倍的数组，然后将原数组的元素进行再散列后插入到新的
数组中去，为了高效，ConcurrentHashMap不会对整个容器进行扩容，而只对某个segment进行扩容。

#### size()

如果要统计整个ConcurrentHashMap里元素的大小，就必须统计所有Segment里元素的大小
后求和。Segment里的全局变量count是一个volatile变量，那么在多线程场景下，是不是直接把
所有Segment的count相加就可以得到整个ConcurrentHashMap大小了呢？不是的，虽然相加时
可以获取每个Segment的count的最新值，但是可能累加前使用的count发生了变化，那么统计结
果就不准了。所以，最安全的做法是在统计size的时候把所有Segment的put、remove和clean方法
全部锁住，但是这种做法显然非常低效。
因为在累加count操作过程中，之前累加过的count发生变化的几率非常小，所以
ConcurrentHashMap的做法是先尝试2次通过不锁住Segment的方式来统计各个Segment大小，如
果统计的过程中，容器的count发生了变化，则再采用加锁的方式来统计所有Segment的大小。
那么ConcurrentHashMap是如何判断在统计的时候容器是否发生了变化呢？使用modCount
变量，在put、remove和clean方法里操作元素前都会将变量modCount进行加1，那么在统计size
前后比较modCount是否发生变化，从而得知容器的大小是否发生变化。

### ConcurrentLinkedQueue

在并发编程中，有时候需要使用线程安全的队列。如果要实现一个线程安全的队列有两
种方式：一种是使用阻塞算法，另一种是使用非阻塞算法。使用阻塞算法的队列可以用一个锁
（入队和出队用同一把锁）或两个锁（入队和出队用不同的锁）等方式来实现。非阻塞的实现方
式则可以使用循环CAS的方式来实现。本节让我们一起来研究一下Doug Lea是如何使用非阻
塞的方式来实现线程安全队列ConcurrentLinkedQueue的，相信从大师身上我们能学到不少并
发编程的技巧。
ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列，它采用先进先出的规
则对节点进行排序，当我们添加一个元素的时候，它会添加到队列的尾部；当我们获取一个元
素时，它会返回队列头部的元素。它采用了“wait-free”算法（即CAS算法）来实现，该算法在
Michael&Scott算法上进行了一些修改.

ConcurrentLinkedQueue由head节点和tail节点组成，每个节点（Node）由节点元素（item）和
指向下一个节点（next）的引用组成，节点与节点之间就是通过这个next关联起来，从而组成一
张链表结构的队列。默认情况下head节点存储的元素为空，tail节点等于head节点。

```java
private transient volatile Node<E> tail = head;
```

#### 入队列

队列都是先进先出，所以第一个加入的就在head头位置，后续加入的都往尾部逐一插入。

ConcurrentLinkedQueue的插入与基础的队列插入有些许的不同，一般情况下，queue的插入操作是，
将现在的tail.next指定为插入的数据，然后将插入的数据再指定为tail。

而ConcurrentLinkedQueue的tail是有可能为空的。

- 初始化ConcurrentLinkedQueue时候，head = tail = null，当插入第一个元素时，head，tail依然为空，
head.next插入元素1,又因为tail默认等于head,所以tail.next也为元素1(这时候head,tail为null,head.next,tail.next为元素1);
- 插入第二个元素时候队列先设置元素1的节点next为元素2,然后更新tail指向元素2节点,(这时候head为空,tail为元素2);
- 添加元素3,设置tail节点的next节点为元素3;
- 添加元素4,设置元素3的next节点为元素4,然后将tail指向元素4

总结:
就是每次在入队的时候先判断tail的next值,如果为null,那直接插入该元素到tail.next,如果不为空,那么插入元素到tail.next.next,
然后将tail设置为现在插入的这个元素.

#### 出队列
跟上面入队列的味道相同,
- 刚开始head为空的,判断head为空,判断head.next,还为null的话,那就是空队列;
- 如果head为null,head.next不为null,那就将head.next出队列,然后设置head为head.next.next;
- 如果head不为空,直接出队列head,然后设置head为null.

### BlockingQueue
阻塞队列是一个支持两个附加操作的队列,这两个附加的操作支持阻塞的插入和移除方法.

1. 支持阻塞的插入方法,意思当队列满了的时候,队列会阻塞插入元素的线程,知道队列不满;
2. 支持阻塞的移除方法,当队列为空时,获取元素的线程会等待队列变为非空.

阻塞队列常用于生产者消费者的场景,生产者向队列里添加元素的线程,消费者从队列中取元素的线程. 阻塞队列是生产者存放元素,消费者
获取元素的容器

在阻塞队列不可用时,这两个附加操作提供了四种处理方式.
分别为:
1. 抛出异常

add(e),remove,element
2. 返回特殊值

- offer(e) 返回true/false
- poll 元素/null
- peek 元素/null

3. 一直阻塞
- put(e)
- 移除-take

当阻塞队列满时，如果生产者线程往队列里put元素，队列会一直阻塞生产者
线程，直到队列可用或者响应中断退出。当队列空时，如果消费者线程从队列里take元素，队
列会阻塞住消费者线程，直到队列不为空。

4. 超时退出
- offer(e,time,unit)
- poll(time,unit)
当阻塞队列满时，如果生产者线程往队列里插入元素，队列会阻塞生产者线程
一段时间，如果超过了指定的时间，生产者线程就会退出。

当然如果是无界阻塞队列,那么在插入的时候是不会出现异常或者false等情况

#### 7种阻塞队列
jdk7提供了7种阻塞队列,分别为:

- ArrayBlockingQueue: 一个由数组结构组成的有界队列;
- LinkedBlockingQueue: 链表组成的有界队列;
- PriorityBlockingQueue: 一个支持优先级排序的无界阻塞队列;
- DelayQueue: 使用优先级队列实现的无界阻塞队列;
- SynchronousQueue: 一个不存储元素的阻塞队列;
- LinkedTransferQueue: 链表组成的无界队列;
- LinkedBlockingDeque: 链表组成的双向阻塞队列.

1. ArrayBlockingQueue
此队列按照先进先出的原则对元素进行排序,默认情况下,ArrayBlockingQueue不保证线程公平的访问队列

所谓公平访问队列是指阻塞的线程，可以按照
阻塞的先后顺序访问队列，即先阻塞线程先访问队列。非公平性是对先等待的线程是非公平
的，当队列可用时，阻塞的线程都可以争夺访问队列的资格，有可能先阻塞的线程最后才访问
队列。为了保证公平性，通常会降低吞吐量。

下面的代码可以创建一个公平的阻塞队列
```java
    ArrayBlockingQueue queue = new ArrayBlockingQueue<>(1000,true);
```
访问者的公平性是使用可重入锁实现的
```java
public ArrayBlockingQueue(int capacity, boolean fair) {
    if (capacity <= 0)
        throw new IllegalArgumentException();
    this.items = new Object[capacity];
    lock = new ReentrantLock(fair);
    notEmpty = lock.newCondition();
    notFull = lock.newCondition();
}
```
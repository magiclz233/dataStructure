# Selector

Selector 是Java NIO中的一个组件，用于检查一个或者多个NIO Channel的状态是否可以读写。这样可以实现单线程管理多个channels,
也就是管理多个网络链接。

## 为什么使用Selector

用单线程操作多个channel,减少了多线程操作channel时线程创建，切换的开销。并且每个线程都会占用系统资源，同样的问题，线程越少，
还能保持效率，那就最优。

但是现在的电脑，都是多核cpu，如果在工作室偏执于单线程优化，也是不对的，避免出现一核拉满，多核围观的情况，该应多线程还是得用。

简而言之：Selector可以让我们实现单线程操作多个Channels。

## Selector简单使用

1. 创建Selector
  
```java
Selector selector = Selector.open();
```

2. 注册Channel到Selector上

Selector操作多个Channel的前提是，你必须把要操作的channel注册到同一个Selector上,这个操作使用SelectableChannel.register()方法。

```java
channel.configureBlocking(false);
SelectionKey key = channel.register(selector,SelectionKey.OP_READ);
```

注意：

只有非阻塞的Channel,才能被Selector管理，所以FileChannel是不能使用Selector的。因为FileChannel不能切换为非阻塞模式。
SocketChannel可以正常使用。

注意register()方法的第二个参数，这个参数是一个“关注集合”，代表我们关注的channel状态，有四种基础可供监听。

- Connect --SelectionKey.OP_CONNECT  连接就绪状态
- Accept --SelectionKey.OP_ACCEPT  可连接就绪状态
- Read  --SelectionKey.OP_READ  读
- Write  --SelectionKey.OP_WRITE 写

一个channel触发了一个事件也可视作该事件处于就绪状态。因此当channel与server连接成功后，那么就是“连接就绪”状态。
server channel接收请求连接时处于“可连接就绪”状态。channel有数据可读时处于“读就绪”状态。channel可以进行数据
写入时处于“写就绪”状态。

如果对多个时间感兴趣，可以利用位的或运算结合多个常量，比如：

```java
    int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
```
## SelectionKeys

上面的register方法把channel注册到Selectors上，这个方法的返回值是SelectionKeys，这个返回的对象包含了一些比较有价值的属性：

- The interest set
- The ready set
- The Channel
- The Selector
- An attached object(optional)

这五个属性的含义下面会一一介绍。

### Interest Set

这个“关注集合”实际上就是我们希望处理的事件的集合，它的值就是注册时传入的参数，我们可以用按为与运算把每个事件取出来：

```java
int interestSet = selectionKey.interestOps();

boolean isInterestedInAccept  = interestSet & SelectionKey.OP_ACCEPT;
boolean isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
boolean isInterestedInRead    = interestSet & SelectionKey.OP_READ;
boolean isInterestedInWrite   = interestSet & SelectionKey.OP_WRITE;
```

### Ready Set

"就绪集合" 中的值是当前channel处于就绪的值，一般来说在调用select方法后都会到就绪状态，select的介绍在后续文章。

```java
int readySet = selectionKey.readyOps();
```

从 “就绪集合” 中取值的操作类似月 "关注集合" 的操作， 当然还有更简单的方法， SelectionKey提供了一系列返回值为boolean的方法：

```java
selectionKey.isAcceptable();
selectionKey.isConnectable();
selectionKey.isReadable();
selectionKey.isWritable();
```

### Channel + Selector

从 SelectionKey 操作 Channel 和 Selector 非常简单：

```java
Channel channel = selectionKey.channel();
Selector selector = selectionKey.selector();
```

### Attaching Objects

我们可以给一个 SelectionKey 附加一个 Object, 这样做一方面可以方便我们识别某个特定的channel,同时也增加了channel相关
的附加信息。例如，可以把用于channel的buffer附加到SelectionKey上：

```java
selectionKey.attach(theObject);
Object attachedObj = selectionKey.attachment();
```

附加对象的操作也可以在register的时候就执行：

```java
SelectionKey key = channel.register(selector, SelectionKey.OP_READ, theObject);
```

## 从 Selector 中选择 channel

一旦我们向 Selector 注册了一个或多个channel后，就可以调用select来获取channel。 select方法会返回所有处于
就绪状态的channel。

select 方法具体如下：

- int select()
- int select(long timeout)
- int selectNow()

select()方法在返回channel之前处于阻塞状态。

select(long timeout)和select做的事一样，不过他的阻塞有一个超时限制。

selectNow()不会阻塞，根据当前状态立刻返回合适的channel。

select()方法的返回是一个int整型， 代表有多少channel处于就绪了。 也就是自上一次select后有多少channel进入就绪。
举例来说，假设第一次调用select时正好有一个channel就绪，那么返回值是1，并且对这个channel做任何处理，接着再次调用
select，此时恰好又有一个新的channel就绪，那么返回值还是1，现在我们一共有两个channel处于就绪，但是在每次调用select
时只有一个channel是就绪的。

## selectionKeys()

在调用select并返回了有channel就绪之后，可以通过选中的key集合来获取channel，这个操作通过调用selectionKey()方法：

```java
Set<SelectionKey> selectedKeys = selector.selectionKeys();
```

还记得在register时的操作吧，我们register后的返回值就是SelectionKey实例，也就是我们现在通过selectedKeys()
方法所返回的SelectionKey。

遍历这些SelectionKey可以通过如下方法：

```java
Set<SelectionKey> selectedKeys = selector.selectedKeys();
Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
while(keyIterator.hasNext()) {
    SelectionKey key = keyIterator.next();
    if(key.isAcceptable()) {
        // a connection was accepted by a ServerSocketChannel.
    } else if (key.isConnectable()) {
        // a connection was established with a remote server.
    } else if (key.isReadable()) {
        // a channel is ready for reading
    } else if (key.isWritable()) {
        // a channel is ready for writing
    }
    keyIterator.remove();
}
```

上述循环会迭代key集合，针对每个key我们单独判断他是处于何种就绪状态。

注意keyIterater.remove()方法的调用，Selector本身并不会移除SelectionKey对象，这个操作需要我们收到执行。
当下次channel处于就绪是，Selector任然会吧这些key再次加入进来。

SelectionKey.channel返回的channel实例需要强转为我们实际使用的具体的channel类型，例如ServerSocketChannel
或SocketChannel.

## wakeUp()

由于调用select而被阻塞的线程，可以通过调用Selector.wakeup()来唤醒即便此时已然没有channel处于就绪状态。
具体操作是，在另外一个线程调用wakeup，被阻塞与select方法的线程就会立刻返回。

## close()

当操作Selector完毕后，需要调用close方法。close的调用会关闭Selector并使相关的SelectionKey都无效。
channel本身不管被关闭。

# Scatter和Gather

Scatter和Gather是通过通道读写数据的两个概念。

Scattering read指的是从通道读取的操作能把数据写入多个Buffer,也就是代表数据从一个channel到多个Buffer的过程。

Gathering writer则正好相反，表示的是从多个buffer把数据写入到一个channel里。

Scatter和Gather在一些场景中很有用，比如需要多里多份分开传输的数据。举例来说，假设一个消息包含了header和
body,那么我们可以把header和body保存到独立的buffer里面，这样分开进行处理的做法更简明。

## Scatter Reads

把数据从单个channel写入到多个buffer中。

代码表示：

```java
ByteBuffer header = ByteBuffer.allocate(128);
ByteBuffer body = ByteBuffer.allocate(1024);

ByteBuffer[] bufferArray = {header, body};

channel.read(bufferArray);
```

观察代码可以发现，我们把多个buffer写在了一个数组中，然后把数组传递给channel.read()方法。
read()方法内部会负责把数据按顺序写进传入的buffer数组内。一个buffer写满后，接着写到下一个buffer中。

实际上，scattering read内部必须写满一个buffer后才会向后移动到下一个buffer，
这种数组形式的多个Buffer，必须前面的header有一个固定的大小(如128字节),这种形式是可以正常工作，如果是动态的
header，不是固定长度，可能会出现问题。

## Gathering Writers

把多个buffer的数据写入到一个channel中。

代码表示：

```java
ByteBuffer header = ByteBuffer.allocate(128);
ByteBuffer body = ByteBuffer.allocate(1024);

ByteBuffer[] bufferArray = {header, body};

channel.write(bufferArray);
```

类似的传入一个buffer数组给write，将多个缓冲区的数据按顺序将数组内的内容写进channel，
这里需要注意，写入的时候针对的是buffer中position到limit之间的数据。
也就是如果buffer的容量是128字节，但它只包含了58字节数据，那么写入的时候只
有58字节会真正写入。因此gathering write是可以适用于可变大小的message的，
这和scattering reads不同。
channel 通道

buffer 缓冲区

selector 选择器

## Channel的基本应用

example1 -FileChannel

## Buffer基本用法

- 把数据写入buffer
- 调用flip方法
- 从buffer中读取数据
- 调用buffer.clear() 或者 buffer.compact()

当写入数据时，buffer会记录已经写入数据的大小，当需要读取数据时，flip()方法把buffer从写模式调整为读模式。
在读模式下，可以读取所有已经写入的数据。

当读取完成之后，需要清空buffer，来满足后续的写入操作，清空有两种方式，clear(),compact()方法。clear()
会清空整个buffer，compact只清空已经读取的数据。未被读取的数据则会移动到buffer的开始位置，写入位置则紧跟着
未读数据之后。

例子：example1 -FileBufferTest

### Buffer的容量，位置，极限位置

buffer缓冲区实质上就是一块内存，用于写入数据，也供后续再出读取数据。这块内存被NIO Buffer管理,并提供一系列的
方法用于更简单的操作这块内存。

一个Buffer有三个属性是必须掌握的，分别是：

- capacity 容量
- position 位置
- limit 限制

position和limit的具体含义取决于当前buffer的模式，capacity在两种模式下都是容量的意思。
#### capacity

指定了 生成的缓冲区的底层数组大小

#### position

position 指定了下一个将要被写入或者读取的元素的元素索引，它的值由get(),put()方法自动更新。在新创建的缓冲区中，
position初始化为0。

#### limit
limit: 

- 写入数据时：limit表示可对Buffer最多写入多少数据；
- 读取数据时： 表示Buffer里面有多少可读数据。limit被设置成已写入数据的数量，这个值在写模式下就是position.

#### mark 

标记，调用mark()来设置mark等于当前的position，再调用reset()可以让position恢复到mark的位置。

**总结**

以上四个个属性的大小关系，0 <= mark <= position <= limit <= capacity

举例说明：

创建一个ByteBuffer，初始化capacity = 10，则这个ByteBuffer的容量为10.

当前缓冲区为写入状态

position = 0, limit = capacity = 10

写入数据后，例如写入4个字节的数据，此时：

position = 4,limit = capacity = 10

转变状态，flip(),在读取时，limit表示可读取数据最大值(就是写入时的position值)，
position表示当前读取数据的起始位置

position = 0, limit = 4，capacity = 10.

### Buffer的类型

Java NIO有以下的Buffer类型：
- ByteBuffer
- MappedByteBuffer
- CharBuffer
- DoubleBuffer
- FloatBuffer
- IntBuffer
- LongBuffer
- ShortBuffer

除了MappedByteBuffer外，其他都是代表了不同的基本数据类型。MappedByteBuffer等会单独介绍
test data test data
# FileChannel

Java NIO中，FileChannel是用来操作文件的通道。 通过文件通道可以进行文件的读，写等操作。
Java NIO的FileChannel是相对标准的Java IO API的可选接口。

FileChannel不可以设置为非阻塞模式，他只能在阻塞模式下运行。

## 打开文件通道

使用FileChannel之前必须先打开一个文件通道，打开文件通道用输入/输出流或者RandomAccessFile,举例：

```java
RandomAccessFile aFile = new RandomAccessFile("c:\\example.txt","r");

FileChannel channel = aFile.getChannel();
```

## 从文件通道内读取数据

读取文件通道的数据可以通过 read 方法

```java
ByteBuffer buf = ByteBuffer.allocate(1024);
int read = channel.read(buf);
```

首先开辟一个字符缓冲区，capacity为1024，接着调用read方法，read的返回值代表有多少字节被写入了Buffer,返回-1则表示
读取完成。

## 向文件通道写入数据

写数据用 write 方法，入参是Buffer:

```java
String newData = "New String to write to file..." + System.currentTimeMillis();
ByteBuffer buf = ByteBuffer.allocate(48);

buf.clear();
buf.put(newData.getBytes());
buf.flip();
while(buf.hasRemaining()) {
    channel.write(buf);
}
```

## 关闭通道

操作完毕之后，需要把通道关闭。

```java
channel.close();
```

## 常用方法

### position

当操作FileChannel的时候读和写都是基于特定起始位置的（position），获取当前的位置可以用
FileChannel的position()方法，设置当前位置可以用带参数的position(long pos)方法。

```java
long pos = channel.position();

channel.position(pos + 123)；
```

假设我们把当前位置设置为文件结尾之后，那么读取数据时就会返回-1，表示已经到达结尾了。

如果把当前位置设置为文件结尾之后，在想通道中写入数据，文件会自动扩展以便写入数据，但是这样会导致文件中出
现类似空洞，即文件的一些位置是没有数据的。

### size

size() 方法可以返回FileChannel对应的文件大小：

```java
long fileSize = channel.size();
```

### truncate

利用truncate()方法可以截取指定长度的文件：

```java
channel.truncate(1024);
```

### force

force()方法会把所有未写磁盘的数据都强制写入磁盘。这是因为在操作系统中出于性能的考虑会把数据放入缓冲区，所以不能保证数据在调用
write写入文件通道后就及时的写到磁盘上去了。除非手动调用force()方法。

force()方法需要一个boolean参数，代表是否把meta data也一并强制写入。

```java
channel.force(true);
```


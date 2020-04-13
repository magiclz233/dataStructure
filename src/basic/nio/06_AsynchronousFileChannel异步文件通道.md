# AsynchronousFileChannel

Java 7 中nio新增的异步非阻塞通道，使得数据可以进行异步操作。

## 创建

```java
Path path = Paths.get("data/test.xml");

AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
```
在Java NIO中如果一个channel是FileChannel类型的，那么他可以直接把数据传输到领一个channel。
逐个特性得益于FileChannel包含的transferTo和transferFrom两个方法。

## transferFrom()

FileChannel.transferFrom方法把数据从通道源传输到FileChannel:

示例代码：
example1 -TransferTest.java
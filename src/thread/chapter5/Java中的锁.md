## Java中的锁
### Lock接口
```java
Lock lock = new ReentrantLock();
lock.lock();
try {
}catch (Exception e){

}finally{
    lock.unlock();
}
```
在finally中释放锁是为了保证锁可以肯定被释放

不要在try中获取锁,因为如果在获取锁的时候出现异常,异常抛出的同时也会释放掉锁.

### ReentrantReadWriteLock
我们刚刚接触到的ReentrantLock（排他锁）具有完全互斥排他的效果，即同一时刻只允许一个线程访问，
这样做虽然虽然保证了实例变量的线程安全性，但效率非常低下。ReadWriteLock接口的实现
类-ReentrantReadWriteLock读写锁就是为了解决这个问题。读写锁维护了两个锁，一个是读操作相关
的锁也成为共享锁，一个是写操作相关的锁 也称为排他锁。通过分离读锁和写锁，其并发性比一般排
他锁有了很大提升。多个读锁之间不互斥，读锁与写锁互斥，写锁与写锁互斥（只要出现写操作的过程
就是互斥的。）。在没有线程Thread进行写入操作时，进行读取操作的多个Thread都可以获取读锁，
而进行写入操作的Thread只有在获取写锁后才能进行写入操作。即多个Thread可以同时进行读取操作，
但是同一时刻只允许一个Thread进行写入操作。
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

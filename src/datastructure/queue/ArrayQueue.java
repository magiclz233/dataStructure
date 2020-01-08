package datastructure.queue;

/**
 * 数组实现队列
 * 队列：先进先出
 * 可扩展长度的队列
 * 缺点：无法使用到队头提取之后的位置
 * @author magic_罗璋
 * @date 2019/12/19 22:24
 */

public class ArrayQueue<T> {
    /*
     * 同样需要一个头指针，一个尾指针  当头指针=尾指针=0时候为空
     * 需要实现分配一个固定大小的数组
     * 正常情况下下，尾指针永远指向队尾元素的下一个位置，比如说队尾元素在0 尾指针则在1
     * <p>
     * 注意！：数组型队列有很大的劣势，容易造成存储空间浪费，而且不易扩容。
     * 比如说，最大空间为6的数组队列， 进去了6个了元素，然后从队头出去了5个元素，此时，仍然不能插入新的元素
     * 因为队尾指针仍然指向第6个元素，其仍然占据了最后一个位置，而队头是不允许插入的。这样造成前面5个位置浪费。
     * <p>
     * 解决方法：1.元素移动位置，出队一个 后面的元素往前挪。   缺点：每次出队都需要移动位置 很麻烦 效率也低
     * 2.动态扩容，  缺点：浪费了前面的空间
     * 3.最佳解决方案：构造环形队列
     */

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(2);
        System.out.println(arrayQueue.length);
        arrayQueue.EnQueue(1);
        arrayQueue.EnQueue(2);
        System.out.println(arrayQueue.length);

        Integer integer = arrayQueue.DeQueue();
        System.out.println(integer);
        System.out.println(arrayQueue.DeQueue());
        System.out.println(arrayQueue.length);

    }

    private Integer size;
    private Integer header;
    private Integer tail;
    private Integer length;
    private final Integer DEFAULT_LENGTH = 6;
    private Object[] o;

    public ArrayQueue(){
        this.length = DEFAULT_LENGTH;
        o = new Object[length];
        tail = header = size = 0;
    }

    public ArrayQueue(int length){
        this.length = length;
        o = new Object[this.length];
        tail = header = size = 0;
    }

    /**
     * //获取队列中的头元素
     * @return T
     */
    public T getHead(){
        return (T) o[header];
    }

    /**
     * 入队
     * @param t 传入的数据类型
     */
    public boolean EnQueue(T t){
        if(size >= length-1){
            length = length*2;
            Object[] temp = new Object[length];
            for (int i=0;i<length/2;i++){
                temp[i] = o[i];
            }
            o = temp;
        }
        if(header.equals(tail)){
            header = 0;
            o[header] = t;
            tail = 1;
        }else {
            o[tail] = t;
            tail = tail + 1;
        }
        size++;
        return Boolean.TRUE;
    }

    /**
     * 出队
     * @return T
     */
    public T DeQueue(){
        if(header.equals(tail)){
            return null;
        }
        T t = (T) o[header];
        header = header + 1;
        size --;
        return t;
    }

    public boolean isNull(){
        if(tail.equals(header)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public int size(){
        return size;
    }
}

package datastructure.queue;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName ArrayQueue2
 * @date 2019/12/20 10:32
 */
public class ArrayQueue2<T> {
    /*
    使用数组实现的不可扩展的循环队列
     */
    public static void main(String[] args){
      ArrayQueue2<Integer> queue = new ArrayQueue2<>(4);
      queue.add(1);
      queue.add(2);
      System.out.println(queue.size);
        Integer header = queue.getHeader();
        System.out.println(header);
        Integer remove = queue.remove();
        System.out.println(remove);
        System.out.println(queue.size+"``");
        Integer remove1 = queue.remove();
        System.out.println(remove1);
        System.out.println(queue.size);
    }
    private Object[] o;
    private int capacity; //数组的长度
    private int size = 0;
    private int header = 0;
    private int tail = 0;
    private int DEFAULT_SIZE = 10;

    public ArrayQueue2(){
        capacity = DEFAULT_SIZE;
        o = new Object[capacity];
    }

    public ArrayQueue2(int capacity){
        this.capacity = capacity;
        o = new Object[this.capacity];
    }

    //插入
    public void add(T t){
        if(header == tail && size>0){
            throw new IndexOutOfBoundsException("队列已满");
        }
        o[tail] = t;
        size++;
        tail = (tail+1)%capacity;
    }

    //移除
    public T remove(){
       if(isNull()){
           throw new NullPointerException("队列为空");
       }
       T t = (T) o[header];
       size--;
       header = (header+1) % capacity;
       return t;
    }

    public boolean isNull(){
        return size == 0;
    }

    //获取头元素
    public T getHeader(){
        if(!isNull()){
            return (T) o[header];
        }
        return null;
    }
}

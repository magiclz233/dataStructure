package basic.queue;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName LinkQueue
 * @date 2019/12/20 10:58
 */
public class LinkQueue<T> {
    /*
    链表实现的循环队列
     */

    public static void main(String[] args) {
        LinkQueue<Integer> queue = new LinkQueue<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
        System.out.println(queue.remove() + "~~~~" + queue.size);
        System.out.println(queue.remove()+"@"+queue.size);
    }

    private Node header;
    private Node tail;
    private int size = 0;

    private class Node {
        private T t;
        private Node next;
    }



    //入队
    public void add(T t) {
        Node temp = new Node();
        temp.t = t;
        if (header == null) {
            header = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;

    }

    public T peek() {
        if (isNull()) {
            throw new NullPointerException("队列为空");
        }
        return header.t;
    }

    public T remove() {
        if (isNull()) {
            throw new NullPointerException("队列为空");
        }
        T t = header.t;
        header = header.next;
        size--;
        return t;
    }

    public boolean isNull() {
        return size == 0;
    }
}

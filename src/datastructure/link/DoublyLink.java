package datastructure.link;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author 罗璋||magiclz233@163.com
 * Description TODO
 * @version 1.0
 * @ClassName DoublyLink
 * @date 2019/12/23 17:44
 */
public class DoublyLink<T> {
    public static void main(String[] args){
      LinkedList<Integer> list = new LinkedList<>();
      list.add(1);
      list.add(2);
        Integer integer = list.get(1);
        System.out.println(integer);
        System.out.println(list.toString());
        System.out.println("----------------------");
        DoublyLink<Integer> link = new DoublyLink<>();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        for (int i = 0;i<link.size;i++){
            System.out.println(link.get(i).toString());
        }
        link.remove(1);
        link.removeFirst();
        link.removeLast();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0;i<link.size;i++){
            System.out.println(link.get(i).toString());
        }
    }
    public int size;
    public Node first;
    public Node last;

    public void add(T t){
       Node la = last;
       Node newNode = new Node(t,la,null);
       last = newNode;
       if(la == null){
           first = newNode;
       }else {
           la.next = newNode;
       }
       size++;
    }

    public T remove(){
        return removeFirst();
    }
    public T removeLast(){
        final Node x = last;
        if(x == null){
            throw new NoSuchElementException("集合为空");
        }
        return unlinkLast(x);
    }

    private T unlinkLast(Node x){
        final Node pre = x.pre;
        final T t = x.t;
        x.t = null;
        //help GC
        x.pre = null;
        last = pre;
        if(pre == null){
            first = null;
        }else {
            pre.next = null;
        }
        size--;
        return t;
    }
    public T removeFirst(){
        final Node x = first;
        if(x == null){
            throw new NoSuchElementException("该集合为空");
        }
        return unlinkFirst(x);
    }
    private T unlinkFirst(Node x){
        final Node next = x.next;
        final T t = x.t;
        x.t = null;
        x.next = null;
        first = next;
        if(next == null){
            last = null;
        }else {
            next.pre = null;
        }
        size--;
        return t;
    }

    public T remove(int index){
        indexOut(index);
        return delete(node(index));
    }

    T delete(Node x){
        T t = x.t;
        Node pre = x.pre;
        Node next = x.next;

        if(pre == null){
            first = next;
        }else {
            pre.next = next;
            x.pre = null;
        }

        if(next == null){
            last = pre;
        }else {
            next.pre = pre;
            x.next = null;
        }
        x.t = null;
        size--;
        return t;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    void indexOut(int index){
        if(index < 0 && index > size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    /**
     * 查询给定位置的数据
     * @param index 给定的位置
     * @return T
     */
    public T get(int index){
        indexOut(index);
        return node(index).t;
    }


    Node node(int index){
        //size >> 1 size右移一位,相当于除2 意识就是当index小于size/2时,从first开始遍历,大于等于时从last开始遍历
        if(index <(size >> 1)){
            Node x = first;
            for (int i= 0;i<index;i++){
                x = x.next;
            }
            return x;
        }else {
            Node x = last;
            for (int i = size-1;i>index;i--){
                x = x.pre;
            }
            return x;
        }
    }
    private class Node{
        private T t;
        private Node pre;
        private Node next;

        public Node(T t){
            this.t = t;
        }

        public Node(){
        }

        public Node(T t,Node pre,Node next){
            this.t = t;
            this.pre = pre;
            this.next = next;
        }


        public void setPre(Node pre){
            this.pre = pre;
        }

        public Node getPre(){
            return this.pre;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public Node getNext(){
            return this.next;
        }
    }
}

package datastructure.link;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 罗璋||magiclz233@163.com
 * Description TODO 单向链表
 * @version 1.0
 * @ClassName SingleLink
 * @date 2019/12/20 11:40
 */
public class SingleLink<T> {
    /*
    单向链表
     */


public static void main(String[] args){
    SingleLink<Integer> singleLink = new SingleLink<>();
    singleLink.add(0);
    singleLink.add(1);
    singleLink.add(3);
    singleLink.add(4);

    singleLink.insertNode(2,2);
    singleLink.remove(1);
    System.out.println(singleLink.size);
    for (int i = 0;i<singleLink.size;i++){
        Integer search = singleLink.search(i);
        System.out.println(search);
    }
    System.out.println("~~~~~~");
    List<Integer> traverse = singleLink.traverse();
    System.out.println(traverse.toString());
}
    private int size = 0;
    private Node first;
    private Node last;



    public boolean isNull(){
        return size == 0;
    }

    public void add(T t){
       Node temp = new Node(t);
       if(first == null){
           first = temp;
           last = temp;
       }else {
           last.next = temp;
           last = temp;
       }
        size++;
    }

    /**
     * 删除
     * @param index 要删除的位置
     * @return T
     */
    public void remove(int index){
        int z = 0;
        if(isNull()){
            throw new NullPointerException("链表为空");
        }
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("查询位置越界");
        }else{
            Node temp = first;
            while (temp.next != null){
                if(z == index-1){
                    Node deleteNode = temp.next;
                    temp.next = deleteNode.next;
                    deleteNode = null;
                    size--;
                    return;
                }
                z++;
                temp = temp.next;
            }
        }
    }

    /**
     * 反转
     * @return List<T>
     */
    public List<T> traverse(){
        List<T> t = new ArrayList<>(size);
        Node node = traverseNode(first);
        while (node != null){
            t.add(node.t);
            node = node.next;
        }
        return t;
    }

    /**
     * 反转链表
     * @return Node
     */
     Node traverseNode(Node first){

        if(first == null) {
            return null;
        }
        Node pre = null;
        Node next;

        /*
        整体流程：
        反转，因为是单向链表，所以头节点有他的next节点，pre是他的前节点，next是临时的后节点
        next等于头节点的后节点，现在pre为空，设置头节点的后节点为pre，再设置前节点为头节点，最后设置头节点位置为头节点的后节点
        原来是 pre(null自定义的) -> first -> next
        修改完之后是          first.next(原来的first位置) -> pre(first在pre位置)
        ps：这块可能有点绕，具体不动了直接debug一步步走一下就知道了
         */
        while (first != null){
            //下一个等一头节点的下一个节点
            next = first.next;
            //头节点的后一个节点变成前一个节点
            first.next = pre;
            //头节点的前一个节点变成头节点
            pre = first;
            //头节点变成头节点的下一个节点
            first = next;
        }
        return pre;
    }
    public T search(int index){
        int z = 1;
        if(isNull()){
            throw new NullPointerException("链表为空");
        }
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("查询位置越界");
        }else {
            Node temp = first;
            while (temp.next != null){
                if(index == 0){
                    return temp.t;
                }else if(index == z){
                    Node search = temp.next;
                    return search.t;
                }
                z++;
                temp = temp.next;
            }
        }
        return null;
    }

    /**
     * 插入
     * @param index 要插入的位置
     * @param t 要插入的值
     */
    public void insertNode(int index,T t){
        if(index > size){
            throw new IndexOutOfBoundsException("传入的位置越界");
        }
        if(index < 0){
            throw new IndexOutOfBoundsException("传入的位置越界");
        }
        Node temp = first;
        //记录遍历的位置
        int z = 0;
        Node newNode = new Node(t);
        while (temp.next != null){
            if(index -1 == z){
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return;
            }
            z++;
            temp = temp.next;
        }
    }

    private class Node{
        private T t;
        private Node next;

        public Node(){
        }

        public Node(T t){
            this.t = t;
        }

        public Node(T t,Node next){
            this.t = t;
            this.next = next;
        }
    }
}

package datastructure.stack;

/**
 * 链表实现栈
 * @author magic_罗璋
 * @date 2019/12/19 22:06
 */

public class LinkStack<T> {

    public static void main(String[] args) {
        LinkStack<Integer> stack = new LinkStack<Integer>();
        stack.push(1);
        stack.push(2);
        Integer pop = stack.pop();
        System.out.println(pop);
        Integer pop1 = stack.pop();
        System.out.println(pop1);
    }
    private Node root;
    private int num;

    public void push(T t){
        if(t == null){
            throw new NullPointerException("传入的参数不能为空");
        }
        if(root == null){
            root = new Node();
            root.t = t;
            root.next = root;
        }else {
            Node temp = root;
            root = new Node();
            root.t = t;
            root.next = temp;
        }
        num++;
    }

    public T pop(){
        if(num == 0){
            throw new NullPointerException("栈中元素为空！");
        }
        T t = root.t;
        root = root.next;
        num--;
        return t;
    }

    public int size(){
        return num;
    }
    //定义节点
    private class Node{
        private T t;
        private Node next;
    }
}

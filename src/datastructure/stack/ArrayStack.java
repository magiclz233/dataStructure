package datastructure.stack;

/**
 * 自己实现一个栈  利用数组实现
 * @author magic_罗璋
 * @date 2019/12/19 21:38
 */

public class ArrayStack<T> {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(2);

        stack.push(1);
        stack.push(2);

        int pop = stack.pop();
        System.out.println(stack.capacity);
        System.out.println(pop);
        int pop1 = stack.pop();
        System.out.println(pop1);
    }

    private Object[] stack = null;
    private int num = 0; //个数
    private int capacity = 0; //容量

    public ArrayStack(){
        capacity = 10;
        stack = new Object[10];
    }

    public ArrayStack(int capacity){
        this.capacity = capacity;
        stack = new Object[capacity];
    }

    //入栈
    public void push(T t){
        if(num >= capacity-1){
            capacity *= 2;
            Object[] temp = new Object[capacity];
            System.arraycopy(stack, 0, temp, 0, capacity / 2);
            stack = temp;

        }
        stack[num++] = t;
    }

    //获取栈值
    public Object peek(){
        if(num ==0) {
            return null;
        }
        Object o = stack[num - 1];
        return o;
    }

    //出栈
    public T pop(){
        if(num == 0){
            throw new NullPointerException();
        }
        T t = (T) stack[--num];
        stack[num] = null;
        return t;
    }

    public int size(){
        return num;
    }

    public boolean isNull(){
        return num == 0;
    }
}

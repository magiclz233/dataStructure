package algorithm.offer.Topic_0030_包含min函数的栈;

import java.util.Stack;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/21 : 17:48
 */
public class MinStack {
    private Stack<Integer> A,B;

    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if(B.isEmpty() || B.peek() >= x){
            B.add(x);
        }
    }


    public void pop() {
        if(A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}

package algorithm.offer;

import java.util.Stack;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName DoubleStackToQueue
 * @date 2020/4/9 15:29
 */
public class DoubleStackToQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args){

    }

    public void push(int n){
        stack1.push(n);
    }

    public int pop(){
        if(stack1.isEmpty()&&stack2.isEmpty()){
           throw new NullPointerException("无数据");
        }
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

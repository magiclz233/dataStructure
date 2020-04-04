package algorithm.offer.Topic_0006_从尾到头打印链表;

import java.util.Stack;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/4/5 0:13
 */
public class Main {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    /*
        输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */

    /*
    思路:

    从尾到头打印,就是要把链表中的数据反向打印,可以使用栈,先进后出,全部保存进栈 然后再全部取出即可
     */

    public static void main(String[] args) {

    }


    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode tmp = head;

        while (tmp != null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }

        int size = stack.size();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

}

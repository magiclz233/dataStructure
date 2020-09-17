package algorithm.offer.Topic_0022_链表中倒数第K个点;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/17 : 15:26
 */
public class Main {

    /*
        输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
        即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
        它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     */

    public static void main(String[] args) {

    }

    /*
        方法: 双指针, a,b a先走k步, 然后a,b一块走  因为a先走的,当a走到最后一位n时,b走到倒数n-k位置
     */

    public static ListNode getKthFromEnd(ListNode head, int k){
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            a = a.next;
        }
        while (a !=null){
            a = a.next;
            b = b.next;
        }
        return b;
    }

    public class ListNode {
        int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}

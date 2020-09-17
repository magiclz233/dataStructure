package algorithm.offer.Topic_0024_反转链表;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/17 : 15:49
 */
public class Main {

    public static void main(String[] args) {

    }

    /*
        双指针  cur是头结点  pre是头结点之前的节点  temp是之后的节点
        循环的时候  temp cur pre依次向前  然后cur.next一直等于cur的前节点 pre
        最终循环完成时 返回pre 反转完成
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null,cur = head,temp = null;

        while (cur != null){
            // 当前节点下一节点
            temp = cur.next;
            // 当前节点指向pre
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

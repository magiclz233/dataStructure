package algorithm.offer.Topic_0025_合并两个排序链表;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/17 : 16:03
 */
public class Main {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 必须要有协助 ListNode 因为你在返回的时候, 得返回头结点 即 dum.next
        // 但是在将两个链表排序合并至dum时候,需要一个协助的ListNode -> cur 来进行逐步添加
        ListNode dum = new ListNode(0), cur = dum;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

}

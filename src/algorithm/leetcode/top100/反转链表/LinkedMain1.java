package algorithm.leetcode.top100.反转链表;

public class LinkedMain1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    //迭代法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // 保存下一个节点
            curr.next = prev;             // 反转当前节点的指针
            prev = curr;                  // prev移动到当前节点
            curr = nextTemp;             // curr移动到下一个节点
        }
        
        return prev; // 最后prev就是新的头节点
    }

    // 头插法
    public ListNode reverseList1(ListNode head) {
        ListNode newHead = null;
        
        while (head != null) {
            ListNode nextNode = head.next; // 保存下一个节点
            head.next = newHead;          // 当前节点插入到新链表头部
            newHead = head;               // 更新新链表头
            head = nextNode;              // 移动到原链表下一个节点
        }
        
        return newHead;
    }
}

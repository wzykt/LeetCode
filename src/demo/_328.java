package demo;

import util.ListNode;

/**
 * @date 2021/11/23 2021/11/23完成
 * @description 328. 奇偶链表
 */
public class _328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }

        //奇数链表
        ListNode odd = head;
        //偶数链表
        ListNode even = head.next;
        //记录偶数项链表的起始位置
        ListNode evenNext = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenNext;
        return head;
    }
}

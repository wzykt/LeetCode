package list.leetcode;

import util.ListNode;

/**
 * @date 2021-12-16 2021-12-16完成
 * @description 203. 移除链表元素
 */
public class _203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode slow = new ListNode(0,head);
        ListNode fast = head;
        ListNode res = slow;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
                fast = fast.next;
                continue;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return res;
    }
}

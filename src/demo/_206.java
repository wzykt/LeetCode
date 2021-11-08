package demo;

import util.ListNode;

/**
 * @date 2021/11/7
 * @description 206. 反转链表
 * 借鉴视频完成：https://www.bilibili.com/video/BV1wA411b7qZ?p=34
 */
public class _206 {
    //不借助额外的空间，来完成
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode next = head;
        ListNode curr = head;

        while (next != null) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}

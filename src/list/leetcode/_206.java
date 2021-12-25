package list.leetcode;

import util.ListNode;

/**
 * @date 2021/11/7
 * @description 206. 反转链表
 * 借鉴视频完成：https://www.bilibili.com/video/BV1wA411b7qZ?p=34
 */
public class _206 {
    //不借助额外的空间，来完成
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        //三个节点是关键
        ListNode pre= null;
        ListNode next = head;
        ListNode cur = head;

        while(cur!=null){
            next = next.next;
            cur.next = pre;
            pre=cur;
            cur = next;
        }
        return cur;
    }
}

package demo;

import util.ListNode;

/**
 * @date 2021/11/14
 * @description 160. 相交链表
 * 记得相交节点后面的链表一定是相同的
 * 1.能想到的就是借助其他数据结构来完成
 * <p>
 * 2.参考视频：https://www.bilibili.com/video/BV1wA411b7qZ?p=30
 * 链表长度相同，从头开始遍历即可
 * 链表长度不同，n1指针走完A链表之后，开始走B链表，n2指针走完B链表之后，开始走A链表，如果有相交，返回相交节点，如果n1和n2指针走完A和B两个链表走没有找打相同的
 * 的节点，返回null即可
 * 两节点走完的路程是相同的0
 */
public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
            if (n1 == null && n2 == null) {
                return null;
            }
            if (n1 == null) {
                n1 = headB;
            }
            if (n2 == null) {
                n2 = headA;
            }
        }
        return n1;
    }

}

package demo;

import util.ListNode;

import java.util.*;
import java.util.ArrayList;

/**
 * 24. 两两交换链表中的节点
 *
 * @date 2021/9/2 2021/9/2完成  2021-12-17再次完成
 * @description 将链表换一种数据结构存储，交换位置之后再从新构建新的链表
 */
public class _24 {
    //笔试用
    public ListNode swapPairs(ListNode head) {
        //2021-12-17
        //依靠三个节点完成
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = new ListNode();
        ListNode curr = head;
        ListNode next = head.next;
        ListNode res = new ListNode(0, next);
        while (next != null) {
            curr.next = next.next;
            next.next = curr;
            p.next = next;
            p = curr;
            curr = curr.next;
            if (curr != null) {
                next = curr.next;
            } else {
                break;
            }
        }
        return res.next;

        //2021/9/2
        //借助其他数据结构完成
        /*List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        swap(list);
        ListNode res = new ListNode();
        ListNode T = res;
        for (int i = 0; i < list.size(); i++) {
            ListNode listNode = new ListNode(list.get(i));
            T.next = listNode;
            T = T.next;
        }
        return res.next;*/
    }

    public static void swap(List<Integer> list) {
        int i = 1;
        while (i < list.size()) {
            int t = list.get(i - 1);
            list.set(i - 1, list.get(i));
            list.set(i, t);
            i = i + 2;
        }
    }

    //参考答案
    //完全想不到
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = head.next;
//        head.next = swapPairs(newHead.next);
//        newHead.next = head;
//        return newHead;
//    }
}

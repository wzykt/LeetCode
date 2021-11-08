package demo;

import util.ArrayToList;
import util.ListNode;

import java.util.*;
import java.util.ArrayList;

/**
 * @date 2021/11/7  2021/11/8结束
 * @description 92. 反转链表 II
 * 可以参考leetcode的206题反转链表
 */
public class _92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode next = head;
        ListNode curr = head;
        //记住要交换位置的节点的位置
        ListNode t = null;
        //首先确定prev，next，curr三个节点的位置
        int index = 1;
        while (index < left) {
            next = next.next;
            prev = curr;
            curr = next;
            t = prev;
            index++;
        }
        //记住要交换位置的节点的位置
        ListNode t2 = curr;
        while (index <= right) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            index++;
        }
        //这一步是想的最久的一步，也是比较重要的一步
        if (t != null) {
            t.next = prev;
        } else {
            head = prev;
        }
        t2.next = curr;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5};
        ListNode to = ArrayToList.to(arr);
        ListNode listNode = reverseBetween(to, 1, 2);
        System.out.println(ArrayToList.toString(listNode));
    }
}

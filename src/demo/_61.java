package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 61. 旋转链表
 *
 * @date 2021/9/5
 * @description 刚开始思路还是使用其他的数据结构完成
 */
public class _61 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


//    public static ListNode rotateRight(ListNode head, int k) {
//        if (head == null) {
//            return null;
//        }
//    }

//    public static void main(String[] args) {
//        ListNode l5 = new ListNode(5, null);
//        ListNode l4 = new ListNode(4, l5);
//        ListNode l3 = new ListNode(3, l4);
//        ListNode l2 = new ListNode(2, l3);
//        ListNode l1 = new ListNode(1, l2);
//        ListNode listNode = rotateRight(l1, 2);
//
//        System.out.println(listNode.val);
//    }

}

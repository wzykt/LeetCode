package demo;

import java.util.*;
import java.util.ArrayList;

/**
 * 86. 分隔链表
 * @date 2021/9/13
 * @description 转成其他数据结构无法得到想要的结果
 */
public class _86 {
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

    public ListNode partition(ListNode head, int x) {
        //维护两个链表，大于x的一个链表，小于等于x的一个链表
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;

        //用数组得不到想要的答案
        /*
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }

        int len = list.size();

        if (len == 1) {
            return head;
        }
        int begin = 0;
        int end = len;
        int index = begin;

        while (index < end) {
            if (list.get(index) < x) {
                swap(list, begin, index);
                index++;
                begin++;
            } else if (list.get(index) == x) {
                index++;
            } else {
                end--;
                swap(list, end, index);
            }
        }

        ListNode res = new ListNode(0,new ListNode(list.get(0)));
        ListNode node = res;
        for (int i = 1; i < len; i++) {
            node.next=new ListNode(list.get(i));
            node = node.next;
        }
        return res;
    }

    private static void swap(List<Integer> nums, int index1, int index2) {
        int temp = nums.get(index1);
        nums.set(index1, nums.get(index2));
        nums.set(index2,temp);
    }*/
    }
}

package demo;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;

/**
 * 25. K 个一组翻转链表
 *
 * @date 2021/9/2
 * @description 思路1快慢指针，思路2，就放在数组中做数据变换
 * @result 2021/9/5完成
 */
public class _25 {
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size(); i++) {
            if ((i + 1) % k == 0) {
                //swap
                swap(list, i + 1, k);
            }
        }

        ListNode res = new ListNode();
        ListNode t=res;
        for (int i = 0; i < list.size(); i++) {
            t.next = new ListNode(list.get(i));
            t = t.next;
        }
        return res.next;
    }

    public static void swap(ArrayList<Integer> list, int end, int k) {
        for (int i = end - k; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                int t = list.get(i);
                list.set(i, list.get(j));
                list.set(j, t);
            }
        }
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode listNode = reverseKGroup(l1, 2);

        System.out.println(listNode.val);
    }

    //        ListNode slow = new ListNode();
//        ListNode fast = new ListNode();
//        slow = head;
//        fast = head;
//
//        ListNode res = new ListNode(0,head);
//        for (int i = 0; i < k; i++) {
//            res = res.next;
//        }
//
//        while (fast != null) {
//            int i = 1;
//            while (i <= k) {
//                if (i == k) {
//                    //swap
//                    //目前判断这里有问题
//                    ListNode t = slow;
//                    ListNode tSlow = slow.next;
//                    slow.next = fast;
//                    while (t != fast) {
//                        tSlow = t;
//                        t = t.next;
//                    }
//                }
//                if (fast == null && i < k) {
//                    break;
//                }
//                fast = fast.next;
//                i++;
//            }
//            i = 1;
//            slow = fast;
//        }
//        return res;
}

package demo;

import util.ListNode;

import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @date 2021/11/4
 * @description
 */
public class _83 {
    public ListNode deleteDuplicates(ListNode head) {
       /* 笔试这样写，比较麻烦，但是好想*/
        TreeSet<Integer> tem = new TreeSet<>();
        while (head != null) {
            tem.add(head.val);
            head = head.next;
        }

        ListNode node = new ListNode();
        ListNode res = node;

        while (!tem.isEmpty()) {
            Integer integer = tem.pollFirst();
            node.next = new ListNode(integer);
            node = node.next;
        }
        return res.next;
    }
}

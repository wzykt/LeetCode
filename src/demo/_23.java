package demo;

import util.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 *
 * @date 2021/10/15完成
 * @description 优先队列
 */
public class _23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue queue = new PriorityQueue();

        for (int i = 0; i < lists.length; i++) {
            ListNode h = lists[i];
            while (h != null) {
                queue.add(h.val);
                h = h.next;
            }

        }
        System.out.println(queue);
        ListNode t = new ListNode();
        ListNode res = t;
        while (!queue.isEmpty()) {
            ListNode node = new ListNode((Integer) queue.poll());
            t.next = node;
            t = t.next;
        }
        return res;
    }
}

package demo;

import java.util.HashSet;
import java.util.Set;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @date 2021/9/6
 * @description 参考答案完成
 */
public class _82 {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        //头节点也可能重复，所以创建一个哑节点
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        //因为cur也是指向哑节点，所以1->1的情况也能处理
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

package util;

/**
 * 节点工具类
 * 仅维持链表之间的连接关系，并不是真正的队列
 */
public class ArrayToList {

    //数字转为链表
    public static ListNode to(int[] arr) {
        ListNode node = new ListNode();
        ListNode head = node;

        for (int i = 0; i < arr.length; i++) {
            ListNode t = new ListNode(arr[i]);
            node.next = t;
            node = node.next;
        }
        return head.next;
    }

    public static String toString(ListNode head) {
        StringBuffer sb = new StringBuffer();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return sb.toString();
    }
}

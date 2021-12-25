package list.leetcode;

import util.ListNode;

import java.util.HashSet;

/**
 * @date 2021-12-17 2021-12-17完成
 * @description 142. 环形链表 II
 * 自己像没有思路
 * 参考：https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 * 记住本题的结论
 */
public class _142 {
    public ListNode detectCycle(ListNode head) {
        /*
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;*/

        //哈希表的解法
        if(head==null || head.next==null){
            return null;
        }
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode node = head;
        while(!listNodes.contains(node) && node!=null){
            listNodes.add(node);
            node = node.next;
        }
        return node;
    }
}

package demo;

import util.ListNode;

import java.util.Stack;

/**
 * @date 2021/11/25 2021/11/25完成
 * @description 445. 两数相加 II
 * <p>
 * 想法一：链表反转，进行两数相加，再反转
 * 想法二：借助栈
 *
 * 这里还用到了头插法来构建链表
 */
public class _445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode n1 = l1;
        ListNode n2 = l2;

        while (n1 != null) {
            stack1.push(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            stack2.push(n2);
            n2 = n2.next;
        }
        int index = 0;
        ListNode header = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ListNode t1 = new ListNode();
            ListNode t2 = new ListNode();
            int v1 = 0;
            int v2 = 0;
            if (!stack1.isEmpty()) {
                t1 = stack1.pop();
                v1 = t1.val;
            }
            if (!stack2.isEmpty()) {
                t2 = stack2.pop();
                v2 = t2.val;
            }
            int sum = index + v1 + +v2;
            if (sum >= 10) {
                sum = sum % 10;
                index = 1;
            } else {
                index = 0;
            }
            ListNode node = new ListNode(sum);
            node.next = header;
            header = node;
        }
        if(index ==1){
            ListNode node = new ListNode(index);
            node.next = header;
            header = node;
        }
        return header;
    }
}

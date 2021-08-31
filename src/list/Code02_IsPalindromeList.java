package list;

import java.util.Stack;

/**
 * 给定一个单链表的头节点head，请判断该链表是否为回文结构。
 * 1）哈希表方法特别简单（笔试用)
 * 2）改原链表的方法就需要注意边界了(面试用)
 */
public class Code02_IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    //笔试用，使用栈，每次弹出就比较
    // need n extra space
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    // need o(1) extra space
    // 50分钟左右
    //利用快慢指针，找到中点或者上中点，将中点或者上中点之后的链表反转，此时中点或者上中点的下一个节点为null，从列表的左右开始遍历，看链表是否对应相同
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) { // find mid node
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }
        n2 = n1.next;// n2 -> right part first nod
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while (n2 != null) { // right part convert
            n3 = n2.next; // n3 -> save next node
            n2.next = n1; // next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }
        n3 = n1; // n3 -> save last node
        n2 = head; // n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) { //check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;  // left to mid
            n2 = n2.next;// right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}




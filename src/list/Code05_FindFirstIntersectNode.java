package list;

/**
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2
 * 请实现一个函数,如果两个链表相交，请返回相交的第一个节点。如果不相交，返回null
 * 【要求】
 * 如果两个链表长度之和为N，时间复杂度请达到U(N)，欲外全问复杂度请达到O(1)。
 */
public class Code05_FindFirstIntersectNode {
    public static class Node {
        int value;
        Node next;

        Node(int val) {
            value = val;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //两个无环链表和两个有环链表，不存在一个无环一个有环的情况
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }

        return null;
    }

    //找到链表第一个入环节点，如果无环，返回null
    //追击问题
    //慢指针一次一步，快指针一次两步，在循环中总会在某个地方相遇
    //此时快指针从头结点开始，慢指针从相遇的地方开始，最终快慢指针会在入环出相遇，返回响应的节点即可
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        // 快慢指针，n1慢n2快
        Node n1 = head.next; // n1 -> slow
        Node n2 = head.next.next; // n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }

        n2 = head;
        //n2-> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //如果两个链表都无环，返回第一个相交节点，如果不相交，返回null
    //如果两个链表相交，就不会再出现分叉的情况
    //那就可以先找到两个链表的最后一个节点，如果有相同节点则表示有相交，否则没有相交
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        // n : 链表1长度减去 链表2长度的值
        cur1 = n > 0 ? head1 : head2;//谁长，谁的头变成cur1
        cur2 = cur1 == head1 ? head2 : head1; //谁短，谁的头变成cur2
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //两个有环链表，返回第一个相交节点，如果不想交返回null
    //这边建议画图，一共三种情况，有环但是不相交，有环但是不在环上相交，有环在环上相交
    //1.有环但是不在环上相交，方法同noLoop()，只不过终止节点是loop1或者loop2
    //2.有环但是不相交：以loop1（环）遍历，看loop2是否在loop1上，如果不在，则表示两个链表不相交
    //3.有环在环上相交：和上面情况刚好相反，如果存在，返回loop1或者loop2都可以
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }


}

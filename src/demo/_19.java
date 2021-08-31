package demo;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @date 2021/8/31
 * @description 先算出链表长度，再进行删除
 * @result 未解决，最开始想不明白头节点，把头节点当成头指针了，头节点是data域为空的，next域指向头节点
 */
public class _19 {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode t = new ListNode(0,head);
        while (t.next != null) {
            len++;
            t = t.next;
        }
        if(len == n){
            return head.next;
        }
        ListNode res = new ListNode(0,head);
        for (int i = 1; i <= len; i++) {
            if(i == (len - n + 1)){
                res.next = res.next.next;
                break;
            }
            res = res.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
        ListNode node1 = removeNthFromEnd(node, 1);
        System.out.println(node1.val);
    }
}
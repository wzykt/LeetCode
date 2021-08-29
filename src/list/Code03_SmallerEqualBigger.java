package list;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 1)把链表放入数组里，在数组上做partition(笔试用)
 * 2）分成小、中、大三部分，再把各个部分之间串起来（面试用)
 */
public class Code03_SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    //数组的划分
    //1)把链表放入数组里，在数组上做partition(笔试用)
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }

        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    //荷兰国旗问题
    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    //2）分成小、中、大三部分，再把各个部分之间串起来（面试用)
    //面试时候装b用
    //使用六个节点，依次记录大于区，等于区，大于区的链表
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;// small head
        Node sT = null;// small tail
        Node eH = null;//  equal head
        Node eT = null;// equal tail
        Node mH = null;//big head
        Node mT = null;// big tail
        Node next = null;// save next node
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        //小于区域的尾巴，连等于区域的头，等于区域的尾巴连大于区域的头
        if (sT != null) { //如果有小于区域
            sT.next = eH;
            eT = eT == null ? sT : eT;// 下一步，谁去连大于区域的头，谁就变成eT
        }
        //上面的if，不管跑了没有，et
        // all reconnect
        if (eT != null) { //如果小于区域和等于区域，不是都没有
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + "");
            node = node.next;
        }
        System.out.println();
    }

}


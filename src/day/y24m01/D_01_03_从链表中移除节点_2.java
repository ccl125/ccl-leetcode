package day.y24m01;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/3 8:46
 * @Description 递归
 */
public class D_01_03_从链表中移除节点_2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode node = removeNodes(head.next);
        if (head.val < node.val) {
            return node;
        } else {
            head.next = node;
            return head;
        }
    }

    public static void main(String[] args) {
        D_01_03_从链表中移除节点_2 d = new D_01_03_从链表中移除节点_2();
        ListNode node = d.new ListNode(5);
        node.next = d.new ListNode(2);
        node.next.next = d.new ListNode(13);
        node.next.next.next = d.new ListNode(3);
        node.next.next.next.next = d.new ListNode(8);

//        ListNode node = d.new ListNode(1);
//        node.next = d.new ListNode(1);
//        node.next.next = d.new ListNode(1);
//        node.next.next.next = d.new ListNode(1);

        d.removeNodes(node);
    }


}

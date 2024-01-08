package hot100.h7_链表;

import hot100.ListNode;

import java.math.BigInteger;

/**
 * @Author CuiChengLong
 * @Date 2024/1/7 18:19
 * @Description
 */

public class H_两数相加 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while (l1 != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }
        s1.reverse();
        s2.reverse();
        BigInteger b1 = new BigInteger(s1.toString());
        BigInteger b2 = new BigInteger(s2.toString());
        BigInteger add = b1.add(b2);
        char[] c = String.valueOf(add).toCharArray();
        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        for (char value : c) {
            int i = value - 48;
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return reverseListNode(res.next);
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode d = new ListNode(2);
        d.next = new ListNode(4);
        d.next.next = new ListNode(3);

        ListNode d2 = new ListNode(5);
        d2.next = new ListNode(6);
        d2.next.next = new ListNode(4);
        addTwoNumbers(d, d2);
    }

}

package hot100.h7_链表;

import hot100.ListNode;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/8 11:23
 * @Description
 */
public class H_删除链表的倒数第N个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null) {
            if (n > 0) {
                fast = fast.next;
                n--;
                if (fast == null) return slow.next;
            } else {
                pre = slow;
                slow = slow.next;
                fast = fast.next;
                if (fast == null) {
                    pre.next = slow.next;
                    break;
                }
            }
        }
        return head;
    }

}

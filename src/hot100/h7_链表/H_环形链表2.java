package hot100.h7_链表;

import java.util.HashSet;

/**
 * @Author CuiChengLong
 * @Date 2024/1/6 0:04
 * @Description
 */

public class H_环形链表2 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }


}

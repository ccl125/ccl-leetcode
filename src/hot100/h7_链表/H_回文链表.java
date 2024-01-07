package hot100.h7_链表;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/4 19:01
 * @Description
 */
public class H_回文链表 {

    public class ListNode{
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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode listNode = reverseList(slow);
        while (listNode != null) {
            if (listNode.val != temp.val) {
                return false;
            }
            listNode = listNode.next;
            temp = temp.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        H_回文链表 t = new H_回文链表();
        ListNode d = t.new ListNode(1);
        d.next = t.new ListNode(2);
        d.next.next = t.new ListNode(2);
        d.next.next.next = t.new ListNode(1);
        t.isPalindrome(d);
    }

}

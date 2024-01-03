package hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/3 11:46
 * @Description
 */
public class H_相交链表 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        Stack<ListNode> a = new Stack<>();
        Stack<ListNode> b = new Stack<>();
        while (headA != null) {
            a.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            b.push(headB);
            headB = headB.next;
        }
        while (a.size() > 0 && b.size() > 0) {
            ListNode aPop = a.pop();
            ListNode bPop = b.pop();
            if (aPop.equals(bPop)) {
                if (a.size() == 0 || b.size() == 0) {
                    return aPop;
                }
            } else {
                return aPop.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        H_相交链表 test = new H_相交链表();
        ListNode d = test.new ListNode(4);
        d.next = test.new ListNode(1);
        d.next.next = test.new ListNode(8);
        d.next.next.next = test.new ListNode(4);
        d.next.next.next.next = test.new ListNode(5);

        ListNode d2 = test.new ListNode(5);
        d2.next = test.new ListNode(6);
        d2.next.next = test.new ListNode(1);
        d2.next.next.next = test.new ListNode(8);
        d2.next.next.next.next = test.new ListNode(4);
        d2.next.next.next.next.next = test.new ListNode(5);
        ListNode intersectionNode = test.getIntersectionNode(d, d2);
        System.out.println(intersectionNode);

    }

}

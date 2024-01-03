package day.m1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/3 8:46
 * @Description 单调栈
 */
public class D_01_03_从链表中移除节点 {

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
        Deque<Integer> stack = new LinkedList<>();
        ListNode temp = head;
        while (head != null) {
            while (stack.size() > 0 && stack.peekLast() < head.val) {
                stack.pollLast();
            }
            if (stack.size() == 0 || stack.peekLast() >= head.val) {
                stack.addLast(head.val);
            }
            head = head.next;
        }
        if (stack.size() == 0) {
            return temp;
        }
        ListNode node = new ListNode(stack.pollFirst());
        ListNode res = node;
        while (stack.size() != 0) {
            node.next = new ListNode(stack.pollFirst());
            node = node.next;
        }
        return res;
    }

    public static void main(String[] args) {
        D_01_03_从链表中移除节点 d = new D_01_03_从链表中移除节点();
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

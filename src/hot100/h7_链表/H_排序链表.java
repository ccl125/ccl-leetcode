package hot100.h7_链表;

import hot100.ListNode;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/9 19:00
 * @Description
 */
public class H_排序链表 {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }


    // 合并两个有序链表
    public static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // 如果某个链表未遍历完，直接连接剩余部分
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
    }

    // 对链表进行归并排序
    public static ListNode mergeSort(ListNode head) {
        // 如果链表为空或只有一个节点，已经有序，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 断开链表，分成两个子链表
        prev.next = null;

        // 递归对左右两个子链表进行归并排序
        ListNode leftSorted = mergeSort(head);
        ListNode rightSorted = mergeSort(slow);

        // 合并两个有序链表
        return merge(leftSorted, rightSorted);
    }

}

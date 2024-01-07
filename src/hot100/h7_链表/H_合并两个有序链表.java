package hot100.h7_链表;

import hot100.ListNode;

/**
 * @Author CuiChengLong
 * @Date 2024/1/7 17:36
 * @Description 巧妙的递归
 */

public class H_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list2.val <= list1.val) {
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;
                } else {
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;
                }

            } else if (list1 == null) {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            temp = temp.next;
        }
        return res.next;
    }

    //巧妙的递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        H_合并两个有序链表 test = new H_合并两个有序链表();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        test.mergeTwoLists(l1, l2);
    }


}

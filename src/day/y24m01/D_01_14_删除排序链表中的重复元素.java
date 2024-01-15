package day.y24m01;

/**
 * @Author CuiChengLong
 * @Date 2024/1/14 19:33
 * @Description
 */

public class D_01_14_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode res = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }

}

package hot100.h7_链表;

import hot100.ListNode;

/**
 * @Author CuiChengLong
 * @Date 2024/1/8 20:48
 * @Description
 */

public class H_K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (head != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 开始反转的链表起点
            ListNode start = pre.next;
            // 记录反转后要连接的链表
            ListNode restNode = end.next;
            // 不是反转整个后面链表，将后面链表切断
            end.next = null;
            ListNode reverseList = reverseList(start);
            //反转后的放在pre后
            pre.next = reverseList;
            //start 指向原本的next；
            start.next = restNode;
            //下一次循环的前驱指针变成了start，(start被翻转到了后面，所以正好变成pre)
            pre = start;
            end = pre;//等价end = start,同时更新两个指针

        }
        return dummy.next;
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

}

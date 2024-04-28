package hot100.h7_链表;

import hot100.ListNode;

/**
 * @Author CuiChengLong
 * @Date 2024/4/27 18:02
 * @Description https://www.nowcoder.com/share/jump/496611171714212903122
 *
 * preListNode 需要用到preTail
 * midListNode 需要用到midHead（反转） midTail
 * lastListNode 需要用到lastHead
 */
public class N_链表内指定区间反转 {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preTail = dummy;
        //前面的链表位置
        for (int i = 0; i < m - 1; i++) {
            preTail = preTail.next;
        }
        //反转列表结束的地方
        ListNode midTail = preTail;
        for (int i = 0; i < n - m + 1; i++) {
            midTail = midTail.next;
        }


        //中间段段子链表头left
        ListNode midHead = preTail.next;
        //后面的子链表头
        ListNode lastHead = midTail.next;

        //将截到链表前后制为null
        preTail.next = null;
        midTail.next = null;


        //反转中间段段子链表
        reverse(midHead);

        //第一段的next指向right节点
        preTail.next = midTail;

        midHead.next = lastHead;

        return dummy.next;
    }

    //链表反转
    public void reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }


}

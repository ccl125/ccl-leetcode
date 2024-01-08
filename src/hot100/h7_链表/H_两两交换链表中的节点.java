package hot100.h7_链表;

import hot100.ListNode;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/8 16:39
 * @Description 巧妙的递归
 */
public class H_两两交换链表中的节点 {


    /**
     * 链表迭代写不出来，递归比迭代简单
     * 迭代写出来了
     * 官方的题解，用伪头节点实现遍历。最后return dummyHead.next为答案
     * 然后迭代的终止条件是next和next.next不为null，就一直迭代（因为就是交换next和next.next）
     * 最终交换完，更新temp为next.next,前面两个已经交换过了，后面直接到next.next
     * 迭代我写不出来，是用pre = null这种方式，然后终止条件是head != null,但是这样维护pre节点不好操作后面的
     * 因为一开始pre是null，每次需要根据pre去维护前面后面的指针，直接把我绕晕了
     * 这种迭代，还是要 【画出图】，变一次指针就擦掉，更新新的指针，画出来，擦掉，这样才不会晕
     * 这个题目应该是递归比迭代简单点。
     * 看题解还有一种开栈的做法
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode n1 = temp.next;
            ListNode n2 = temp.next.next;
            temp.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            temp = n1;
        }
        return dummyHead.next;
    }

    //巧妙的递归
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode n1 = head.next;
        ListNode n2 = head.next.next;
        head.next = swapPairs(n2);
        n1.next = head;
        return n1;
    }

    public static void main(String[] args) {
        ListNode d = new ListNode(1);
        d.next = new ListNode(2);
        d.next.next = new ListNode(3);
        d.next.next.next = new ListNode(4);
        swapPairs(d);
    }


}

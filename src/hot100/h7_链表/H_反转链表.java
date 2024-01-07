package hot100.h7_链表;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/4 8:54
 * @Description
 */
public class H_反转链表 {

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

    /**
     * cur保持不变，一直是5，在递归回去的过程中，每次进的node不同，回去的时候变换node
     * @param head
     * @return 巧妙的递归
     */
    public ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    //巧妙的递归
    public ListNode studyRecursion (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;//防止循环
        return tail;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        return pre;
    }

    public static void main(String[] args) {
        H_反转链表 test = new H_反转链表();
        ListNode d = test.new ListNode(1);
        d.next = test.new ListNode(2);
        d.next.next = test.new ListNode(3);
        d.next.next.next = test.new ListNode(4);
        d.next.next.next.next = test.new ListNode(5);
        test.reverseList2(d);
    }

}

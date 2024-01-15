package day.y24m01;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/15 9:08
 * @Description good question
 */
public class D_01_15_删除排序链表中的重复元素 {

    //迭代 删除链表中重复节点，并且是全部删除
    // dummy节点，然后判断cur和cur.next是否相等，如果相等，移动cur指针，最后将pre.next指向cur指针。
    // cur在不断向后移动
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    //递归
    //1、终止条件：当head为null或者一个的时候，直接返回head
    //2、内部细节：和迭代类似：但是递归关注方法本身的作用，就是去删除重复的元素
    //           如果head和head.next 不相等，head肯定会留下，接着对head.next后面的链表做处理，去删除后面的重复的
    //           就是head.next = deleteDuplicates(head.next);这样维护关系，
    //           如果head和head.next 相等，和迭代类似，需要把中间重复的移除掉就是while循环的部分，找到的head.next就是类似迭代中的cur.next.
    //           所以删除重复后的第一个不重复的元素就是head.next. return deleteDuplicates(head.next)就是最终的答案，
    //           至于后续的链表中是否还有重复的，我们不关心，因为当前的递归内，答案就是deleteDuplicates(head.next)，只关心最小的子问题.
    //3、返回：    最后返回head就是答案。整个方法都是对head去做删除，最终栈帧出去的时候，head也是原先的head，只不过中间的指针被修改掉了. return is answer

    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            return deleteDuplicates3(head.next);
        }
        return head;
    }

    //和上面的区别是：通过Flag来判断是要继续右移pre指针，还是直接将pre指针指到cur.next的位置，跳过中间重复的元素
    //不需要这个flag是因为可以直接通过判断pre.next是否等于cur来判断cur是否右移了
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            boolean flag = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                flag = true;
            }
            if (!flag) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
        deleteDuplicates(head);
    }

}

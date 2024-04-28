package hot100.h7_链表;

import hot100.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/12 17:33
 * @Description
 */
public class H_合并K个升序链表 {

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode dummyNode = new ListNode(-1);
        List<Integer> temp = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                temp.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(temp);
        ListNode res = dummyNode;
        for (Integer val : temp) {
            dummyNode.next = new ListNode(val);
            dummyNode = dummyNode.next;
        }
        return res.next;
    }
    //合并K个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return merge2Lists(l1, l2);
    }
    //合并两个有序链表
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val >= l2.val) {
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        } else {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }
    }


}

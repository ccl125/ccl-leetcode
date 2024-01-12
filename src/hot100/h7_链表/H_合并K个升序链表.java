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

    public ListNode mergeKLists(ListNode[] lists) {
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

}

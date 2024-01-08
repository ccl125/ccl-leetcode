package hot100.h7_链表;

import java.util.HashMap;

/**
 * @Author CuiChengLong
 * @Date 2024/1/8 21:52
 * @Description Hash 哈希
 */

public class H_随机链表的复制 {

    class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }


}

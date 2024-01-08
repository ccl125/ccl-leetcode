package day.y24m01;

/**
 * @Author CuiChengLong
 * @Date 2024/1/7 15:42
 * @Description
 */

public class D_01_06_在链表中插入最大公约数 {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode res = head;
        while (head.next != null) {
            ListNode next = head.next;
            int gcd = gcd(next.val, head.val);
            ListNode gcdNode = new ListNode(gcd);
            head.next = gcdNode;
            gcdNode.next = next;
            head = gcdNode.next;
        }
        return res;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        D_01_06_在链表中插入最大公约数 test = new D_01_06_在链表中插入最大公约数();
        test.gcd(6,10);
    }


}

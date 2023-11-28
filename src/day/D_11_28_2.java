package day;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: CuiChengLong
 * @Date: 2023/11/28 14:03
 * @Description
 */
public class D_11_28_2 {

    private final Deque<Integer> left = new ArrayDeque<>();
    private final Deque<Integer> right = new ArrayDeque<>();

    private void balance() {
        if (left.size() > right.size()) {
            right.addFirst(left.pollLast());
        } else if (right.size() > left.size() +1) {
            left.addLast(right.pollFirst());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() < right.size()) {
            left.addLast(val);
        } else {
            right.addFirst(val);
        }
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (right.isEmpty()) {
            return -1;
        }
        int val = left.isEmpty() ? right.pollFirst() : left.pollFirst();
        balance();
        return val;
    }

    public int popMiddle() {
        if (right.isEmpty()) {
            return -1;
        }
        if (left.size() == right.size()) {
            return left.pollLast();
        }
        return right.pollFirst();
    }

    public int popBack() {
        if (right.isEmpty()) {
            return -1;
        }
        int val = right.pollLast();
        balance();
        return val;
    }

}

package day.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/11/28 9:48
 * @Description https://leetcode.cn/problems/design-front-middle-back-queue/?envType=daily-question&envId=2023-11-28
 * 链表List实现
 */
public class D_11_28_设计前中后队列 {

    public D_11_28_设计前中后队列() {

    }

    List<Integer> queue = new ArrayList<>();

    public void pushFront(int val) {
        queue.add(0, val);
    }

    public void pushMiddle(int val) {
        int mid = queue.size() / 2;
        queue.add(mid, val);
    }

    public void pushBack(int val) {
        queue.add(val);
    }

    public int popFront() {
        if (queue.size() == 0) {
            return -1;
        }
        return queue.remove(0);
    }

    public int popMiddle() {
        if (queue.size() == 0) {
            return -1;
        }
        int mid = (queue.size() - 1) / 2;
        return queue.remove(mid);
    }

    public int popBack() {
        if (queue.size() == 0) {
            return -1;
        }
        return queue.remove(queue.size() - 1);
    }

}

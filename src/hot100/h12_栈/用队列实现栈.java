package hot100.h12_栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author CuiChengLong
 * @Date 2024/5/16 15:14
 * @Description
 */
public class 用队列实现栈 {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public 用队列实现栈() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}

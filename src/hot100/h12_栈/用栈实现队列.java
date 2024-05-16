package hot100.h12_栈;

import java.util.Stack;

/**
 * @Author CuiChengLong
 * @Date 2024/5/16 15:11
 * @Description
 */
public class 用栈实现队列 {

    private Stack<Integer> A;
    private Stack<Integer> B;

    public 用栈实现队列() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
    }

    public int pop() {
        int peek = peek();
        B.pop();
        return peek;
    }

    public int peek() {
        if (!B.isEmpty()) return B.peek();
        if (A.isEmpty()) return -1;
        while (!A.isEmpty()){
            B.push(A.pop());
        }
        return B.peek();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }

}

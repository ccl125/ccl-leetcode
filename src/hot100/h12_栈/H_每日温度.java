package hot100.h12_栈;

import java.util.Stack;

/**
 * @Author CuiChengLong
 * @Date 2023/11/29 22:43
 * @Description 单调栈
 */

public class H_每日温度 {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int temp = stack.pop();
                result[temp] = i - temp;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        H_每日温度 test = new H_每日温度();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 69, 72, 76, 73};
        int[] result = test.dailyTemperatures(temperatures);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}

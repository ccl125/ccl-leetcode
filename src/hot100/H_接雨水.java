package hot100;

import java.util.Stack;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/4 13:38
 * @Description
 */
public class H_接雨水 {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= height[i]) {
                int cur = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int h = Math.min(height[left], height[cur]) - height[i];
                int w = i - stack.peek() - 1;
                res += h * w;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        H_接雨水 h = new H_接雨水();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = h.trap(height);
        System.out.println(res);
    }

}

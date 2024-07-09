package day.y24m05;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author CuiChengLong
 * @Date 2024/5/24 16:53
 * @Description
 */
public class D_05_24_找出最具竞争力的子序列 {

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + nums.length - i > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(0, stack.pop());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

}

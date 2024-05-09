package hot100.h17_动态规划;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author CuiChengLong
 * @Date 2024/5/8 21:01
 * @Description
 */
public class t_最长有效括号 {

    public int longestValidParentheses(String s) {
        //用栈模拟，把所有匹配的置为1，然后，寻找连续为1的最大长度
        int[] flags = new int[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    int index = stack.pop();
                    flags[index] = 1;
                    flags[i] = 1;
                }
            }
        }

        // 寻找连续为1的最大长度
        int maxTotal = 0;
        int total = 0;
        System.out.println(Arrays.toString(flags));
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == 1) {
                total++;
            } else {
                maxTotal = Math.max(maxTotal, total);
                total = 0;
            }
        }
        maxTotal = Math.max(maxTotal, total);
        return maxTotal;
    }

}

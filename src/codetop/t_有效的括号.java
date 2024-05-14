package codetop;

import java.util.LinkedList;

/**
 * @Author CuiChengLong
 * @Date 2024/5/7 18:07
 * @Description
 */

public class t_有效的括号 {

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

}

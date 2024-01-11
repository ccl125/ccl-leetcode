package day.y24m01;

import java.util.Stack;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/10 9:07
 * @Description
 */
public class D_01_10_删除子串后的字符串最小长度 {

    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            if (s.contains("AB")) {
                s = s.replace("AB", "");
            } else {
                s = s.replace("CD", "");
            }
        }
        return s.length();
    }

    public static int minLength2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!stack.isEmpty() && (c == 'B' || c == 'D')) {
                String s1 = stack.peek() + String.valueOf(c);
                if ("AB".equals(s1) || "CD".equals(s1)) {
                    stack.pop();
                }
            }
            stack.push(c);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(minLength2("ACBBD"));
    }

}

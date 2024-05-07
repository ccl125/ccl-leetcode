package codetop;

import java.util.HashMap;

/**
 * @Author CuiChengLong
 * @Date 2024/5/6 18:23
 * @Description
 */
public class t_无重复字符的最大子串 {

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            res = Math.max(res, i - left + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}

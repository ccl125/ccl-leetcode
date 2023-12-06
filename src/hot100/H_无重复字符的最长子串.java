package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CuiChengLong
 * @Date 2023/12/6 21:44
 * @Description
 */

public class H_无重复字符的最长子串 {


    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                left = Math.max(map.get(chars[i]) + 1,left);
            }
            map.put(chars[i], i);
            max = Math.max(max,i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        H_无重复字符的最长子串 h = new H_无重复字符的最长子串();
        String s = "abba";
        int res = h.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

}

package exam.leetcode380周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/1/14 11:18
 * @Description
 */

public class t_2_2 {


    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> beautifulIndices = new ArrayList<>();
        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (s.startsWith(a, i)) {
                for (int j = Math.max(0, i - k); j <= Math.min(s.length() - b.length(), i + k); j++) {
                    if (s.startsWith(b, j)) {
                        beautifulIndices.add(i);
                        break;
                    }
                }
            }
        }
        return beautifulIndices;
    }

    public static List<Integer> beautifulIndices2(String s, String a, String b, int k) {
        if (a.length() > s.length() || b.length() > s.length()) return new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (s.startsWith(a, i)) {
                for (int j = 0; j <= s.length() - b.length(); j++) {
                    if (s.startsWith(b, j) && Math.abs(j - i) <= k) {
                        set.add(i);
                        break;
                    }
                }
            }
        }
        return set;
    }


    public static void main(String[] args) {
        String s = "isawsquirrelnearmysquirrelhouseohmy";
        String a = "my";
        String b = "squirrel";
        int k = 15;

//        String s = "abcd";
//        String a = "a";
//        String b = "a";
//        int k = 4;
//        System.out.println(findStringIndex(s, a));
        System.out.println(beautifulIndices(s, a, b, k));
    }

}

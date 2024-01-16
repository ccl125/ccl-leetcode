package exam.leetcode380周赛;

import java.util.*;

/**
 * @Author CuiChengLong
 * @Date 2024/1/14 10:26
 * @Description
 */

public class t_2 {

    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> i = findStringIndex(s, a);
        List<Integer> j = findStringIndex(s, b);
        Set<Integer> res = new HashSet<>();
        for (Integer integer : i) {
            for (Integer value : j) {
                if (Math.abs(integer - value) <= k) {
                    res.add(integer);
                }
            }
        }
        List<Integer> temp = new ArrayList<>(res);
        Collections.sort(temp);
        return temp;
    }

    public static List<Integer> findStringIndex(String s, String a) {
        List<Integer> indices = new ArrayList<>();

        int index = s.indexOf(a);
        while (index != -1) {
            indices.add(index);
            index = s.indexOf(a, index + 1);
        }

        return indices;
    }

    public static void main(String[] args) {
//        String s = "isawsquirrelnearmysquirrelhouseohmy";
//        String a = "my";
//        String b = "squirrel";
//        int k = 15;

        String s = "abcd";
        String a = "a";
        String b = "a";
        int k = 4;
        System.out.println(findStringIndex(s, a));
        System.out.println(beautifulIndices2(s, a, b, k));
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







}

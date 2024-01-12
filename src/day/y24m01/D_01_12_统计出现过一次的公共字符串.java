package day.y24m01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/12 10:41
 * @Description
 */
public class D_01_12_统计出现过一次的公共字符串 {

    public static int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();
        for (String s : words1) {
            if (map1.containsKey(s)) {
                map1.put(s, map1.get(s) + 1);
            } else {
                map1.put(s, 1);
            }

            if (map3.containsKey(s)) {
                map3.put(s, map3.get(s) + 1);
            } else {
                map3.put(s, 1);
            }

        }
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String s : words2) {
            if (map2.containsKey((s))) {
                map2.put(s, map2.get(s) +1);
            } else {
                map2.put(s, 1);
            }

            if (map3.containsKey(s)) {
                map3.put(s, map3.get(s) + 1);
            } else {
                map3.put(s, 1);
            }

        }
        int res = 0;
        for (Map.Entry<String, Integer> map3kv : map3.entrySet()) {
            if (map3kv.getValue() == 2) {
                if (map1.containsKey(map3kv.getKey()) && map2.containsKey(map3kv.getKey())) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] word1 = new String[]{"leetcode","is","amazing","as","is"};
        String[] word2 = new String[]{"amazing","leetcode","is"};
        System.out.println(countWords(word1, word2));
    }

}

package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2023/12/6 23:15
 * @Description
 */

public class H_找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length()>s.length()) return new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < m; i++) {
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (Arrays.equals(need,window)) {
            res.add(0);
        }
        for (int i = m; i < n; i++) {
            window[s.charAt(i-m) - 'a']--;
            window[s.charAt(i) - 'a']++;
            if (Arrays.equals(need, window)) {
                res.add(i-m+1);
            }
        }
        return res;
    }

}
